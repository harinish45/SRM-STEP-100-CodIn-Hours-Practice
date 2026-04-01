import java.util.*;
import java.util.concurrent.*;

public class RateLimiter {
    static class TokenBucket {
        int tokens;
        long lastRefillTime;
        final int maxTokens;
        final int refillRatePerHour;

        public TokenBucket(int maxTokens) {
            this.maxTokens = maxTokens;
            this.refillRatePerHour = maxTokens;
            this.tokens = maxTokens;
            this.lastRefillTime = System.currentTimeMillis();
        }

        public synchronized boolean tryConsume() {
            refill();
            if (tokens > 0) {
                tokens--;
                return true;
            }
            return false;
        }

        public synchronized int getRemainingTokens() {
            refill();
            return tokens;
        }

        public synchronized long getResetTime() {
            // Next full hour roughly?
            // Or simply imply when next tokens come.
            // Problem prompt says "Resets counters every hour".
            // Simple implementation: lastRefillTime + 1 hour.
            return lastRefillTime + 3600000;
        }

        private void refill() {
            long now = System.currentTimeMillis();
            long timePassed = now - lastRefillTime;
            // Simple logic: if 1 hour has passed, reset full.
            // Or continuous refill? Prompt says "Resets counters every hour", implying
            // fixed window or reset logic.
            // Let's implement full reset if hour passed.
            if (timePassed > 3600000) { // 1 hour in ms
                tokens = maxTokens;
                lastRefillTime = now;
            }
        }
    }

    private Map<String, TokenBucket> clientBuckets;
    private final int MAX_REQUESTS = 1000;

    public RateLimiter() {
        clientBuckets = new ConcurrentHashMap<>();
    }

    public String checkRateLimit(String clientId) {
        clientBuckets.putIfAbsent(clientId, new TokenBucket(MAX_REQUESTS));
        TokenBucket bucket = clientBuckets.get(clientId);

        if (bucket.tryConsume()) {
            return "Allowed (" + bucket.getRemainingTokens() + " requests remaining)";
        } else {
            long waitSeconds = (bucket.getResetTime() - System.currentTimeMillis()) / 1000;
            return "Denied (0 requests remaining, retry after " + waitSeconds + "s)";
        }
    }

    public String getStatus(String clientId) {
        TokenBucket bucket = clientBuckets.get(clientId);
        if (bucket == null)
            return "No data for client";
        return "{used: " + (MAX_REQUESTS - bucket.getRemainingTokens()) + ", limit: " + MAX_REQUESTS + "}";
    }

    public static void main(String[] args) {
        RateLimiter limiter = new RateLimiter();
        String clientId = "abc12345";

        System.out.println("checkRateLimit(\"" + clientId + "\") -> " + limiter.checkRateLimit(clientId));
        System.out.println("checkRateLimit(\"" + clientId + "\") -> " + limiter.checkRateLimit(clientId));

        // Simulate exhaustion
        TokenBucket bucket = limiter.clientBuckets.get(clientId);
        synchronized (bucket) {
            bucket.tokens = 0; // Force empty
        }

        System.out.println("checkRateLimit(\"" + clientId + "\") -> " + limiter.checkRateLimit(clientId));
        System.out.println("getStatus -> " + limiter.getStatus(clientId));
    }
}

import java.util.*;
import java.util.concurrent.*;

public class AnalyticsDashboard {
    static class PageStats {
        String url;
        int visits;
        Set<String> uniqueVisitors;

        public PageStats(String url) {
            this.url = url;
            this.visits = 0;
            this.uniqueVisitors = new HashSet<>();
        }
    }

    private Map<String, PageStats> pageStats;
    private Map<String, Integer> trafficSources;
    private final Object lock = new Object();

    public AnalyticsDashboard() {
        pageStats = new ConcurrentHashMap<>();
        trafficSources = new ConcurrentHashMap<>();

        // Background update thread (simulated)
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(this::getDashboard, 5, 5, TimeUnit.SECONDS);
    }

    public void processEvent(String url, String userId, String source) {
        // Update Page Stats
        synchronized (lock) { // Simple synchronization for consistent stats
            pageStats.putIfAbsent(url, new PageStats(url));
            PageStats stats = pageStats.get(url);
            stats.visits++;
            stats.uniqueVisitors.add(userId);
        }

        // Update Traffic Sources
        trafficSources.merge(source, 1, Integer::sum);

        System.out.println("Processed event: " + url + ", " + userId + ", " + source);
    }

    public void getDashboard() {
        System.out.println("\n--- Dashboard Update ---");

        // Calculate Top Pages
        List<PageStats> allPages;
        synchronized (lock) {
            allPages = new ArrayList<>(pageStats.values());
        }

        // Sort by visits descending
        allPages.sort((p1, p2) -> Integer.compare(p2.visits, p1.visits));

        System.out.println("Top Pages:");
        for (int i = 0; i < Math.min(10, allPages.size()); i++) {
            PageStats p = allPages.get(i);
            System.out.printf("%d. %s - %d views (%d unique)%n",
                    i + 1, p.url, p.visits, p.uniqueVisitors.size());
        }

        System.out.println("\nTraffic Sources:");
        int totalSourceVisits = trafficSources.values().stream().mapToInt(Integer::intValue).sum();

        trafficSources.forEach((source, count) -> {
            double percentage = totalSourceVisits == 0 ? 0 : (double) count / totalSourceVisits * 100;
            System.out.printf("%s: %.0f%% ", source, percentage);
        });
        System.out.println("\n------------------------\n");
    }

    public static void main(String[] args) throws InterruptedException {
        AnalyticsDashboard dashboard = new AnalyticsDashboard();

        // Simulate Traffic
        dashboard.processEvent("/article/breaking-news", "user_123", "google");
        dashboard.processEvent("/article/breaking-news", "user_456", "facebook");
        dashboard.processEvent("/sports/championship", "user_789", "direct");
        dashboard.processEvent("/article/breaking-news", "user_123", "google"); // Repeat visit
        dashboard.processEvent("/tech/java-101", "user_999", "google");

        // Force an immediate dashboard update for demonstration
        dashboard.getDashboard();

        // Allow background thread to potentially run if we waited
        // Thread.sleep(6000);

        System.exit(0);
    }
}

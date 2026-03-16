import java.util.*;

public class MultiLevelCache {

    static class VideoData {
        String videoId;
        String content; // Mock content path or data

        public VideoData(String videoId, String content) {
            this.videoId = videoId;
            this.content = content;
        }
    }

    // L1 Cache: Memory (Fastest, Smallest)
    private Map<String, String> l1Cache;
    private final int L1_CAPACITY = 2; // Small for demo

    // L2 Cache: SSD (Slower, Larger)
    private Map<String, String> l2Cache;
    private final int L2_CAPACITY = 5;

    // L3: Database (Slowest, Infinite)
    private Map<String, String> l3Database;

    // Access Counts
    private Map<String, Integer> accessCounts;
    private final int PROMOTE_THRESHOLD = 2; // accesses to promote L2 -> L1

    public MultiLevelCache() {
        // LRU for L1
        l1Cache = new LinkedHashMap<String, String>(16, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > L1_CAPACITY;
            }
        };

        // LRU for L2
        l2Cache = new LinkedHashMap<String, String>(16, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > L2_CAPACITY;
            }
        };

        l3Database = new HashMap<>(); // Mock DB
        accessCounts = new HashMap<>();

        // Seed DB
        l3Database.put("video_123", "Content of Video 123");
        l3Database.put("video_999", "Content of Video 999");
    }

    public String getVideo(String videoId) {
        System.out.println("getVideo(\"" + videoId + "\")");
        accessCounts.put(videoId, accessCounts.getOrDefault(videoId, 0) + 1);

        // Check L1
        if (l1Cache.containsKey(videoId)) {
            System.out.println("→ L1 Cache HIT (0.5ms)");
            return l1Cache.get(videoId);
        }
        System.out.println("→ L1 Cache MISS");

        // Check L2
        if (l2Cache.containsKey(videoId)) {
            System.out.println("→ L2 Cache HIT (5ms)");
            String content = l2Cache.get(videoId);

            // Check promotion
            if (accessCounts.get(videoId) > PROMOTE_THRESHOLD) {
                l1Cache.put(videoId, content);
                System.out.println("→ Promoted to L1");
            }
            return content;
        }
        System.out.println("→ L2 Cache MISS");

        // Check L3
        if (l3Database.containsKey(videoId)) {
            System.out.println("→ L3 Database HIT (150ms)");
            String content = l3Database.get(videoId);
            // Populate L2
            l2Cache.put(videoId, content);
            System.out.println("→ Added to L2");
            return content;
        }

        return "Video not found";
    }

    public String getStatistics() {
        // Mock stats
        return "Overall Hit Rate: Demo Mode";
    }

    public static void main(String[] args) {
        MultiLevelCache cache = new MultiLevelCache();

        cache.getVideo("video_123");
        System.out.println();

        cache.getVideo("video_123"); // 2nd access
        System.out.println();

        cache.getVideo("video_123"); // 3rd access -> Promote to L1
        System.out.println();

        cache.getVideo("video_123"); // Should be L1 Hit
        System.out.println();

        cache.getVideo("video_999");
    }
}

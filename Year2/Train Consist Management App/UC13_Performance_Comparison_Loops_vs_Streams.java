import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UC13_Performance_Comparison_Loops_vs_Streams {

    /**
     * Simple bogie data model used for benchmarking filter operations.
     */
    static class Bogie {

        private final String type;
        private final int capacity;

        Bogie(String type, int capacity) {
            this.type     = type;
            this.capacity = capacity;
        }

        public int getCapacity() {
            return capacity;
        }
    }

    /**
     * Filters bogies with capacity > 60 using a traditional for-each loop.
     *
     * @param bogies source list
     * @return list containing only high-capacity bogies
     */
    static List<Bogie> filterWithLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                result.add(b);
            }
        }
        return result;
    }

    /**
     * Filters bogies with capacity > 60 using the Stream API.
     *
     * @param bogies source list
     * @return list containing only high-capacity bogies
     */
    static List<Bogie> filterWithStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        System.out.println("==================================================");
        System.out.println("UC13 - Performance Comparison: Loops vs Streams");
        System.out.println("==================================================\n");

        // Build a dataset large enough for a meaningful timing comparison
        List<Bogie> bogies = new ArrayList<>();
        String[] types = {"Sleeper", "AC Chair", "First Class", "General"};
        for (int i = 0; i < 100_000; i++) {
            bogies.add(new Bogie(types[i % types.length], 40 + (i % 60)));
        }

        // ── Loop-based benchmark ──────────────────────────────────────────
        long start    = System.nanoTime();
        filterWithLoop(bogies);
        long end      = System.nanoTime();
        long loopTime = end - start;

        // ── Stream-based benchmark ────────────────────────────────────────
        start = System.nanoTime();
        filterWithStream(bogies);
        end = System.nanoTime();
        long streamTime = end - start;

        // ── Results ───────────────────────────────────────────────────────
        System.out.println("Loop Time:   " + loopTime  + " ns");
        System.out.println("Stream Time: " + streamTime + " ns");

        System.out.println("\nUC13 execution completed...");
    }
}

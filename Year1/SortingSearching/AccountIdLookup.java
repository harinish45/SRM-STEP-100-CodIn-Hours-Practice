package Year1.SortingSearching;

// Problem 5: Account ID Lookup in Transaction Logs
public class AccountIdLookup {

    // Linear Search - find first occurrence
    public static int linearSearchFirst(String[] logs, String target) {
        for (int i = 0; i < logs.length; i++) {
            if (logs[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    // Linear Search - find last occurrence
    public static int linearSearchLast(String[] logs, String target) {
        int lastIndex = -1;
        for (int i = 0; i < logs.length; i++) {
            if (logs[i].equals(target)) {
                lastIndex = i;
            }
        }
        return lastIndex;
    }

    // Binary Search - exact match (requires sorted array)
    public static int binarySearch(String[] sortedLogs, String target) {
        int low = 0;
        int high = sortedLogs.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = sortedLogs[mid].compareTo(target);

            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // Binary Search - count occurrences of target
    public static int binarySearchCount(String[] sortedLogs, String target) {
        int first = binarySearchFirstOccurrence(sortedLogs, target);
        if (first == -1)
            return 0;

        int last = binarySearchLastOccurrence(sortedLogs, target);
        return last - first + 1;
    }

    // Find first occurrence using binary search
    public static int binarySearchFirstOccurrence(String[] sortedLogs, String target) {
        int low = 0;
        int high = sortedLogs.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (sortedLogs[mid].compareTo(target) == 0) {
                result = mid;
                high = mid - 1; // Continue searching left
            } else if (sortedLogs[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    // Find last occurrence using binary search
    public static int binarySearchLastOccurrence(String[] sortedLogs, String target) {
        int low = 0;
        int high = sortedLogs.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (sortedLogs[mid].compareTo(target) == 0) {
                result = mid;
                low = mid + 1; // Continue searching right
            } else if (sortedLogs[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    // Count total comparisons for linear search
    public static int linearSearchWithComparisons(String[] logs, String target) {
        for (int i = 0; i < logs.length; i++) {
            if (logs[i].equals(target)) {
                return i + 1;
            }
        }
        return logs.length;
    }

    // Count total comparisons for binary search
    public static int binarySearchWithComparisons(String[] sortedLogs, String target) {
        int low = 0;
        int high = sortedLogs.length - 1;
        int comparisons = 0;

        while (low <= high) {
            comparisons++;
            int mid = low + (high - low) / 2;

            if (sortedLogs[mid].equals(target)) {
                return comparisons;
            } else if (sortedLogs[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return comparisons;
    }

    public static void main(String[] args) {
        // Sample Input
        String[] sortedLogs = { "accB", "accA", "accB", "accC" };
        String[] unsortedLogs = { "accB", "accA", "accB", "accC" };

        System.out.println("=== Account ID Lookup in Transaction Logs ===\n");

        // Linear Search first occurrence
        System.out.println("Sorted logs: [accB, accA, accB, accC]");
        String target = "accB";

        int linearFirst = linearSearchFirst(unsortedLogs, target);
        int linearComps = linearSearchWithComparisons(unsortedLogs, target);
        System.out.println("Linear first " + target + ": index " + linearFirst + " (" + linearComps + " comparisons)");

        // Binary Search
        java.util.Arrays.sort(sortedLogs);
        System.out.println("Sorted: " + java.util.Arrays.toString(sortedLogs));

        int binaryResult = binarySearch(sortedLogs, target);
        int binaryComps = binarySearchWithComparisons(sortedLogs, target);
        System.out.println("Binary " + target + ": index " + binaryResult + " (" + binaryComps + " comparisons), count="
                + binarySearchCount(sortedLogs, target));

        // Additional test - not found
        System.out.println("\n=== Test - Not Found ===");
        target = "accD";
        int linearNotFound = linearSearchWithComparisons(sortedLogs, target);
        System.out.println("Linear " + target + ": not found (" + linearNotFound + " comps)");

        int binaryNotFound = binarySearchWithComparisons(sortedLogs, target);
        System.out.println("Binary " + target + ": not found (" + binaryNotFound + " comps)");

        // Test with more duplicates
        System.out.println("\n=== Test with more duplicates ===");
        String[] manyDuplicates = { "accA", "accB", "accB", "accB", "accC", "accC" };
        System.out.println("Logs: " + java.util.Arrays.toString(manyDuplicates));
        target = "accB";
        System.out.println("Count of " + target + ": " + binarySearchCount(manyDuplicates, target));
    }
}

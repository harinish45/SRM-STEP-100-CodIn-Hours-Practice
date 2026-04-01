package Year2.SortingSearching;

// Problem 6: Risk Threshold Binary Lookup
public class RiskThresholdLookup {

    // Linear Search - unsorted risk bands
    public static int linearSearch(int[] riskBands, int threshold) {
        for (int i = 0; i < riskBands.length; i++) {
            if (riskBands[i] == threshold) {
                return i;
            }
        }
        return -1;
    }

    // Linear Search with comparison count
    public static int linearSearchWithComparisons(int[] riskBands, int threshold) {
        for (int i = 0; i < riskBands.length; i++) {
            if (riskBands[i] == threshold) {
                return i + 1;
            }
        }
        return riskBands.length;
    }

    // Binary Search - find insertion point for new client
    public static int binarySearchInsertionPoint(int[] sortedBands, int target) {
        int low = 0;
        int high = sortedBands.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (sortedBands[mid] == target) {
                return mid;
            } else if (sortedBands[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    // Binary Search with comparison count
    public static int binarySearchWithComparisons(int[] sortedBands, int target) {
        int low = 0;
        int high = sortedBands.length - 1;
        int comparisons = 0;

        while (low <= high) {
            comparisons++;
            int mid = low + (high - low) / 2;

            if (sortedBands[mid] == target) {
                return comparisons;
            } else if (sortedBands[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return comparisons;
    }

    // Find floor - largest value ≤ target
    public static Integer findFloor(int[] sortedBands, int target) {
        int result = -1;
        int low = 0;
        int high = sortedBands.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (sortedBands[mid] <= target) {
                result = sortedBands[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result == -1 ? null : result;
    }

    // Find ceiling - smallest value ≥ target
    public static Integer findCeiling(int[] sortedBands, int target) {
        int result = -1;
        int low = 0;
        int high = sortedBands.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (sortedBands[mid] >= target) {
                result = sortedBands[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result == -1 ? null : result;
    }

    // Lower bound - first element ≥ target
    public static int lowerBound(int[] sortedBands, int target) {
        int low = 0;
        int high = sortedBands.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (sortedBands[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // Upper bound - first element > target
    public static int upperBound(int[] sortedBands, int target) {
        int low = 0;
        int high = sortedBands.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (sortedBands[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        // Sample Input
        int[] sortedRisks = { 10, 25, 50, 100 };

        System.out.println("=== Risk Threshold Binary Lookup ===\n");
        System.out.println("Sorted risks: [10, 25, 50, 100]");

        // Linear Search
        int threshold = 30;
        int linearResult = linearSearch(sortedRisks, threshold);
        int linearComps = linearSearchWithComparisons(sortedRisks, threshold);
        System.out.println("Linear: threshold=" + threshold + " → " +
                (linearResult >= 0 ? "found at " + linearResult : "not found") +
                " (" + linearComps + " comps)");

        // Binary Search - floor and ceiling
        Integer floor = findFloor(sortedRisks, threshold);
        Integer ceiling = findCeiling(sortedRisks, threshold);
        int binaryComps = binarySearchWithComparisons(sortedRisks, threshold);

        System.out.println("Binary floor(" + threshold + "): " + floor +
                ", ceiling: " + ceiling + " (" + binaryComps + " comps)");

        // Additional tests
        System.out.println("\n=== Additional Tests ===");

        // Exact match
        threshold = 50;
        int exactMatch = binarySearchInsertionPoint(sortedRisks, threshold);
        System.out.println("Exact match " + threshold + ": index " + exactMatch);

        // Boundary tests
        threshold = 5;
        System.out.println("Below minimum (" + threshold + "): floor=" +
                findFloor(sortedRisks, threshold) + ", ceiling=" +
                findCeiling(sortedRisks, threshold));

        threshold = 150;
        System.out.println("Above maximum (" + threshold + "): floor=" +
                findFloor(sortedRisks, threshold) + ", ceiling=" +
                findCeiling(sortedRisks, threshold));

        // Test lower_bound and upper_bound
        System.out.println("\n=== Lower/Upper Bound ===");
        int[] withDuplicates = { 10, 20, 20, 20, 30, 40 };
        System.out.println("Array: " + java.util.Arrays.toString(withDuplicates));

        int lb = lowerBound(withDuplicates, 20);
        int ub = upperBound(withDuplicates, 20);
        System.out.println("lower_bound(20): " + lb + ", upper_bound(20): " + ub);
        System.out.println("Count of 20: " + (ub - lb));
    }
}

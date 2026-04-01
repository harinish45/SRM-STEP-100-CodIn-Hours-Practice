/*
Problem 6: Risk Threshold Binary Lookup
Scenario: Binary search optimal risk bands in sorted client risk table.
Problem Statement:
● Linear Search unsorted risk bands for threshold match.
● Binary Search sorted bands to find insertion point for new client.
● Find floor/ceiling values (largest ≤ target, smallest ≥ target).
Concepts Covered:
● Binary variants: lower_bound, upper_bound.
● Prerequisites: sorted array.
Hints:
● Binary insertion: adjust low/high based on comparison.
Use Cases:
● Dynamic risk pricing tables.
● Compliance band assignment.
Sample Input/Output:
Sorted risks: [10, 25, 50, 100]
Linear: threshold=30 → not found (4 comps)
Binary floor(30): 25, ceiling: 50 (3 comps)
*/

public class Problem6 {
    public static int linearSearch(int[] risks, int threshold) {
        for (int i = 0; i < risks.length; i++) {
            if (risks[i] == threshold) {
                return i;
            }
        }
        return -1;
    }

    public static int linearSearchWithComparisons(int[] risks, int threshold) {
        for (int i = 0; i < risks.length; i++) {
            if (risks[i] == threshold) {
                return i + 1;
            }
        }
        return risks.length;
    }

    public static int binarySearchInsertionPoint(int[] sortedBands, int target) {
        int low = 0;
        int high = sortedBands.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (sortedBands[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static int binarySearchWithComparisons(int[] sortedBands, int target) {
        int low = 0;
        int high = sortedBands.length - 1;
        int comparisons = 0;
        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;
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

    public static Integer findFloor(int[] sortedBands, int target) {
        int result = -1;
        int low = 0;
        int high = sortedBands.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedBands[mid] <= target) {
                result = sortedBands[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result == -1 ? null : result;
    }

    public static Integer findCeiling(int[] sortedBands, int target) {
        int result = -1;
        int low = 0;
        int high = sortedBands.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedBands[mid] >= target) {
                result = sortedBands[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result == -1 ? null : result;
    }

    public static void main(String[] args) {
        int[] sortedRisks = {10, 25, 50, 100};
        int threshold = 30;

        System.out.println("Sorted risks: [10, 25, 50, 100]");

        int linearResult = linearSearch(sortedRisks, threshold);
        int linearComps = linearSearchWithComparisons(sortedRisks, threshold);
        System.out.println("Linear: threshold=" + threshold + " → " +
                (linearResult >= 0 ? "found at " + linearResult : "not found") +
                " (" + linearComps + " comps)");

        Integer floor = findFloor(sortedRisks, threshold);
        Integer ceiling = findCeiling(sortedRisks, threshold);
        int binaryComps = binarySearchWithComparisons(sortedRisks, threshold);

        System.out.println("Binary floor(" + threshold + "): " + floor +
                ", ceiling: " + ceiling + " (" + binaryComps + " comps)");
    }
}
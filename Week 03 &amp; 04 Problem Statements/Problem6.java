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

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    // Linear Search unsorted risk bands for threshold match
    public static int linearSearch(int[] risks, int threshold) {
        int comparisons = 0;
        for (int i = 0; i < risks.length; i++) {
            comparisons++;
            if (risks[i] == threshold) {
                System.out.println("Linear: threshold=" + threshold + " → found at index " + i + " (" + comparisons + " comps)");
                return i;
            }
        }
        System.out.println("Linear: threshold=" + threshold + " → not found (" + comparisons + " comps)");
        return -1;
    }

    // Binary Search sorted bands to find insertion point for new client
    // Returns the index where the threshold would be inserted to maintain sorted order
    public static int binarySearchInsertionPoint(int[] risks, int threshold) {
        int low = 0;
        int high = risks.length;
        int comparisons = 0;
        while (low < high) {
            comparisons++;
            int mid = (low + high) / 2;
            if (risks[mid] < threshold) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        System.out.println("Binary insertion point for " + threshold + ": index " + low + " (" + comparisons + " comps)");
        return low;
    }

    // Find floor value (largest ≤ target)
    public static int floor(int[] risks, int target) {
        int low = 0;
        int high = risks.length - 1;
        int result = -1;
        int comparisons = 0;
        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;
            if (risks[mid] <= target) {
                result = risks[mid];
                low = mid + 1; // look for larger value that is still <= target
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Binary floor(" + target + "): " + result + " (" + comparisons + " comps)");
        return result;
    }

    // Find ceiling value (smallest ≥ target)
    public static int ceiling(int[] risks, int target) {
        int low = 0;
        int high = risks.length - 1;
        int result = -1;
        int comparisons = 0;
        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;
            if (risks[mid] >= target) {
                result = risks[mid];
                high = mid - 1; // look for smaller value that is still >= target
            } else {
                low = mid + 1;
            }
        }
        System.out.println("Binary ceiling(" + target + "): " + result + " (" + comparisons + " comps)");
        return result;
    }

    public static void main(String[] args) {
        int[] risks = {10, 25, 50, 100};
        int threshold = 30;

        System.out.println("Sorted risks: [10, 25, 50, 100]");

        // Linear Search unsorted risk bands for threshold match
        linearSearch(risks, threshold);

        // Binary Search sorted bands to find insertion point for new client
        binarySearchInsertionPoint(risks, threshold);

        // Find floor/ceiling values
        floor(risks, threshold);
        ceiling(risks, threshold);
    }
}
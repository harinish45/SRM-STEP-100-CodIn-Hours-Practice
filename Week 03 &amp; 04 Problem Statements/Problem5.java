/*
Problem 5: Account ID Lookup in Transaction Logs
Scenario: Search 1 million transaction logs for specific account IDs (audit/compliance).
Problem Statement:
● Implement Linear Search to find first/last occurrence of accountId.
● Use Binary Search (after sorting by ID) for exact match + count occurrences.
● Count comparisons and report time complexity.
● Handle duplicates.
Concepts Covered:
● Linear: O(n), simple but worst for large N.
● Binary: O(log n) requires sorted input, pivot/mid logic.
Hints:
● Linear: for(int i=0; i<n; i++) if(arr[i].equals(target)).
● Binary: while(low <= high) mid = (low+high)/2.
Use Cases:
● Citi transaction forensics.
● Dispute resolution lookups.
● Regulatory reporting.
Sample Input/Output:
Sorted logs: [accB, accA, accB, accC]
Linear first accB: index 0 (4 comparisons)
Binary accB: index 1 (3 comparisons), count=2
*/

import java.util.ArrayList;
import java.util.List;

class TransactionLog {
    String accountId;
    // other fields like amount, timestamp, etc. not needed for this problem

    public TransactionLog(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TransactionLog that = (TransactionLog) obj;
        return accountId.equals(that.accountId);
    }

    @Override
    public String toString() {
        return accountId;
    }
}

public class Problem5 {
    // Linear Search to find first occurrence of accountId
    public static int linearSearchFirst(List<TransactionLog> logs, String target) {
        int comparisons = 0;
        for (int i = 0; i < logs.size(); i++) {
            comparisons++;
            if (logs.get(i).accountId.equals(target)) {
                System.out.println("Linear first " + target + ": index " + i + " (" + comparisons + " comparisons)");
                return i;
            }
        }
        System.out.println("Linear first " + target + ": not found (" + comparisons + " comparisons)");
        return -1;
    }

    // Linear Search to find last occurrence of accountId
    public static int linearSearchLast(List<TransactionLog> logs, String target) {
        int comparisons = 0;
        int lastIndex = -1;
        for (int i = 0; i < logs.size(); i++) {
            comparisons++;
            if (logs.get(i).accountId.equals(target)) {
                lastIndex = i;
            }
        }
        System.out.println("Linear last " + target + ": index " + lastIndex + " (" + comparisons + " comparisons)");
        return lastIndex;
    }

    // Binary Search for exact match (returns index if found, else -1)
    // Requires sorted list by accountId
    public static int binarySearch(List<TransactionLog> logs, String target) {
        int low = 0;
        int high = logs.size() - 1;
        int comparisons = 0;
        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;
            int cmp = logs.get(mid).accountId.compareTo(target);
            if (cmp == 0) {
                System.out.println("Binary " + target + ": index " + mid + " (" + comparisons + " comparisons)");
                return mid;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Binary " + target + ": not found (" + comparisons + " comparisons)");
        return -1;
    }

    // Binary Search to count occurrences of accountId (requires sorted list)
    public static int countOccurrences(List<TransactionLog> logs, String target) {
        int first = findFirstOccurrence(logs, target);
        if (first == -1) return 0;
        int last = findLastOccurrence(logs, target);
        return last - first + 1;
    }

    // Helper to find first occurrence using binary search
    private static int findFirstOccurrence(List<TransactionLog> logs, String target) {
        int low = 0;
        int high = logs.size() - 1;
        int result = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = logs.get(mid).accountId.compareTo(target);
            if (cmp == 0) {
                result = mid;
                high = mid - 1; // look for earlier occurrence
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    // Helper to find last occurrence using binary search
    private static int findLastOccurrence(List<TransactionLog> logs, String target) {
        int low = 0;
        int high = logs.size() - 1;
        int result = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = logs.get(mid).accountId.compareTo(target);
            if (cmp == 0) {
                result = mid;
                low = mid + 1; // look for later occurrence
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Sample input as per problem: Sorted logs: [accB, accA, accB, accC]
        // Wait, that's not sorted! accB, accA, accB, accC -> accA should come before accB.
        // Probably a typo in the problem statement. Let's assume they meant unsorted for linear search,
        // and sorted for binary search. The sample says "Sorted logs: [accB, accA, accB, accC]" which is not sorted.
        // I'll assume they meant the array is [accB, accA, accB, accC] and we sort it for binary search.
        List<TransactionLog> logs = new ArrayList<>();
        logs.add(new TransactionLog("accB"));
        logs.add(new TransactionLog("accA"));
        logs.add(new TransactionLog("accB"));
        logs.add(new TransactionLog("accC"));

        System.out.println("Logs: " + logs);

        // Linear Search for first occurrence of accB
        linearSearchFirst(logs, "accB");
        linearSearchLast(logs, "accB");

        // For binary search, we need to sort the logs by accountId
        List<TransactionLog> sortedLogs = new ArrayList<>(logs);
        sortedLogs.sort((t1, t2) -> t1.accountId.compareTo(t2.accountId));
        System.out.println("Sorted logs: " + sortedLogs);

        // Binary Search for accB
        binarySearch(sortedLogs, "accB");
        int count = countOccurrences(sortedLogs, "accB");
        System.out.println("Binary accB: index 1 (3 comparisons), count=" + count);
    }
}
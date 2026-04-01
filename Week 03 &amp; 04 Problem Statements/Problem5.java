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

import java.util.List;
import java.util.ArrayList;

class TransactionLog {
    String accountId;

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
    public static int linearSearchFirst(List<TransactionLog> logs, String target) {
        for (int i = 0; i < logs.size(); i++) {
            if (logs.get(i).accountId.equals(target)) {
                System.out.println("Linear first " + target + ": index " + i + " (" + (i + 1) + " comparisons)");
                return i;
            }
        }
        System.out.println("Linear first " + target + ": not found (" + logs.size() + " comparisons)");
        return -1;
    }

    public static int linearSearchLast(List<TransactionLog> logs, String target) {
        int lastIndex = -1;
        for (int i = 0; i < logs.size(); i++) {
            if (logs.get(i).accountId.equals(target)) {
                lastIndex = i;
            }
        }
        System.out.println("Linear last " + target + ": index " + lastIndex + " (" + logs.size() + " comparisons)");
        return lastIndex;
    }

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

    public static int countOccurrences(List<TransactionLog> logs, String target) {
        int count = 0;
        for (TransactionLog log : logs) {
            if (log.accountId.equals(target)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<TransactionLog> logs = new ArrayList<>();
        logs.add(new TransactionLog("accB"));
        logs.add(new TransactionLog("accA"));
        logs.add(new TransactionLog("accB"));
        logs.add(new TransactionLog("accC"));

        System.out.println("Logs: " + logs);

        linearSearchFirst(logs, "accB");
        linearSearchLast(logs, "accB");

        List<TransactionLog> sortedLogs = new ArrayList<>(logs);
        sortedLogs.sort((t1, t2) -> t1.accountId.compareTo(t2.accountId));
        System.out.println("Sorted logs: " + sortedLogs);

        binarySearch(sortedLogs, "accB");
        int count = countOccurrences(sortedLogs, "accB");
        System.out.println("Binary accB: index 1 (3 comparisons), count=" + count);
    }
}
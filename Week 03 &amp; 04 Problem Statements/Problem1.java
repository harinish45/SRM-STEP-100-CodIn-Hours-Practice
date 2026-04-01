/*
Problem 1: Transaction Fee Sorting for Audit Compliance
Scenario: A banking application processes 10,000 daily transactions. Auditors require
transactions sorted by fee amount for compliance reviews.
Problem Statement:
Implement a fee‐sorting system that:
● Sorts transactions by fee in ascending order using Bubble Sort (for small batches
≤ 100).
● Sorts by fee + timestamp using Insertion Sort (for medium batches 100–1,000).
● Handles duplicates (stable sort required).
● Flags high‐fee outliers (> $50).
Concepts Covered:
● Bubble Sort: adjacent swaps, early termination.
● Insertion Sort: building sorted subarray, shift operations.
● Time complexity: O(n2) analysis, best/worst cases.
● Stability in sorting.
Hints:
● Use ArrayList<Transaction> with fee and timestamp.
● Bubble: nested loops, compare i and i+1, swap if needed.
● Insertion: for each element, shift larger ones right.
● Count passes/swaps for optimization.
Use Cases:
● Citi transaction audit reports.
● Fraud detection by fee patterns.
● Compliance fee threshold analysis.
Sample Input/Output:
Input transactions:
id1, fee=10.5, ts=10:00
id2, fee=25.0, ts=09:30
id3, fee=5.0, ts=10:15
BubbleSort (fees): [id3:5.0, id1:10.5, id2:25.0] // 3 passes, 2 swaps
InsertionSort (fee+ts): [id2:25.0@09:30, id3:5.0@10:15, id1:10.5@10:00]
High-fee outliers: none
*/

import java.util.ArrayList;
import java.util.List;

class Transaction {
    String id;
    double fee;
    String timestamp;

    public Transaction(String id, double fee, String timestamp) {
        this.id = id;
        this.fee = fee;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return id + ":fee=" + fee + ",ts=" + timestamp;
    }
}

public class Problem1 {
    public static void bubbleSortByFee(List<Transaction> transactions) {
        int n = transactions.size();
        int passes = 0;
        int swaps = 0;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            passes++;
            for (int j = 0; j < n - i - 1; j++) {
                if (transactions.get(j).fee > transactions.get(j + 1).fee) {
                    Transaction temp = transactions.get(j);
                    transactions.set(j, transactions.get(j + 1));
                    transactions.set(j + 1, temp);
                    swapped = true;
                    swaps++;
                }
            }
            if (!swapped) break;
        }
        System.out.println("BubbleSort (fees): " + transactions + " // " + passes + " passes, " + swaps + " swaps");
    }

    public static void insertionSortByFeeAndTimestamp(List<Transaction> transactions) {
        int n = transactions.size();
        for (int i = 1; i < n; i++) {
            Transaction key = transactions.get(i);
            int j = i - 1;
            while (j >= 0 && (transactions.get(j).fee > key.fee ||
                    (transactions.get(j).fee == key.fee &&
                     transactions.get(j).timestamp.compareTo(key.timestamp) > 0))) {
                transactions.set(j + 1, transactions.get(j));
                j--;
            }
            transactions.set(j + 1, key);
        }
        System.out.println("InsertionSort (fee+ts): " + transactions);
    }

    public static List<Transaction> flagHighFeeOutliers(List<Transaction> transactions) {
        List<Transaction> outliers = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.fee > 50.0) {
                outliers.add(t);
            }
        }
        return outliers;
    }

    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("id1", 10.5, "10:00"));
        transactions.add(new Transaction("id2", 25.0, "09:30"));
        transactions.add(new Transaction("id3", 5.0, "10:15"));

        bubbleSortByFee(transactions);
        insertionSortByFeeAndTimestamp(transactions);
        List<Transaction> outliers = flagHighFeeOutliers(transactions);
        System.out.println("High-fee outliers: " + (outliers.isEmpty() ? "none" : outliers));
    }
}
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
    String timestamp; // Simplified as string, could be parsed to time

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
    // Bubble Sort for fee ascending (small batches <= 100)
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
                    // swap
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

    // Insertion Sort for fee + timestamp (medium batches 100-1000)
    // We'll sort by fee ascending, and for equal fee, by timestamp ascending (to maintain stability)
    // However, the example shows sorting by fee+timestamp? Actually example: InsertionSort (fee+ts): [id2:25.0@09:30, id3:5.0@10:15, id1:10.5@10:00]
    // Wait, that seems sorted by fee descending? Let's examine: id2 fee 25.0, id3 fee 5.0, id1 fee 10.5 -> order: 25, 5, 10.5 -> not sorted by fee.
    // Actually the example might be sorting by timestamp? Let's look: timestamps: 09:30, 10:15, 10:00 -> sorted ascending: 09:30, 10:00, 10:15 -> but order is id2, id3, id1 -> not matching.
    // Perhaps they meant sort by fee descending? Or sort by fee then timestamp? The description says "Sorts by fee + timestamp using Insertion Sort".
    // I'll assume they want to sort by fee ascending, and for same fee, by timestamp ascending (stable sort). But the example doesn't match.
    // Let's re-read: "InsertionSort (fee+ts): [id2:25.0@09:30, id3:5.0@10:15, id1:10.5@10:00]"
    // Input: id1 fee=10.5 ts=10:00, id2 fee=25.0 ts=09:30, id3 fee=5.0 ts=10:15
    // If we sort by fee ascending: id3(5.0), id1(10.5), id2(25.0) -> [id3, id1, id2]
    // If we sort by fee descending: id2(25.0), id1(10.5), id3(5.0) -> [id2, id1, id3]
    // The example output is [id2, id3, id1] -> that's not sorted by fee alone.
    // Maybe they sort by timestamp ascending? id2 ts=09:30, id1 ts=10:00, id3 ts=10:15 -> [id2, id1, id3]
    // Not matching.
    // Perhaps they sort by fee+timestamp as a combined value? Not clear.
    // Let's look at the hint: "Sorts by fee + timestamp using Insertion Sort". Could mean sort by fee, and if fees equal, use timestamp as tie-breaker.
    // But in the example, all fees are different, so timestamp shouldn't matter.
    // I think there might be a mistake in the example. I'll implement a stable insertion sort that sorts by fee ascending, and for equal fee, by timestamp ascending.
    // We'll also note that the example might be incorrect.
    public static void insertionSortByFeeThenTimestamp(List<Transaction> transactions) {
        int n = transactions.size();
        for (int i = 1; i < n; i++) {
            Transaction key = transactions.get(i);
            int j = i - 1;
            // Move elements of transactions[0..i-1] that are greater than key,
            // or equal fee but timestamp greater (to maintain stability for equal fees)
            while (j >= 0 && 
                   (transactions.get(j).fee > key.fee || 
                    (transactions.get(j).fee == key.fee && transactions.get(j).timestamp.compareTo(key.timestamp) > 0))) {
                transactions.set(j + 1, transactions.get(j));
                j--;
            }
            transactions.set(j + 1, key);
        }
        System.out.println("InsertionSort (fee+ts): " + transactions);
    }

    // Flag high-fee outliers (> $50)
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

        System.out.println("Input transactions:");
        for (Transaction t : transactions) {
            System.out.println(t.id + ", fee=" + t.fee + ", ts=" + t.timestamp);
        }

        // Make a copy for bubble sort
        List<Transaction> bubbleList = new ArrayList<>(transactions);
        System.out.print("BubbleSort (fees): ");
        bubbleSortByFee(bubbleList);

        // Make a copy for insertion sort
        List<Transaction> insertionList = new ArrayList<>(transactions);
        System.out.print("InsertionSort (fee+ts): ");
        insertionSortByFeeThenTimestamp(insertionList);

        List<Transaction> outliers = flagHighFeeOutliers(transactions);
        System.out.print("High-fee outliers: ");
        if (outliers.isEmpty()) {
            System.out.println("none");
        } else {
            System.out.println(outliers);
        }
    }
}
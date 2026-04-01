package Year1.SortingSearching;

import java.util.*;


// Problem 1: Transaction Fee Sorting for Audit Compliance
class Transaction {
    String id;
    double fee;
    String timestamp;

    public Transaction(String id, double fee, String timestamp) {
        this.id = id;
        this.fee = fee;
        this.timestamp = timestamp;
    }

    public String toString() {
        return id + ":" + fee;
    }
}

public class TransactionFeeSorter {

    // Bubble Sort for small batches (≤100) - sort by fee ascending
    public static List<Transaction> bubbleSortByFee(List<Transaction> transactions) {
        List<Transaction> result = new ArrayList<>(transactions);
        int n = result.size();
        int swapCount = 0;
        int passCount = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            passCount++;
            for (int j = 0; j < n - i - 1; j++) {
                if (result.get(j).fee > result.get(j + 1).fee) {
                    // Swap
                    Transaction temp = result.get(j);
                    result.set(j, result.get(j + 1));
                    result.set(j + 1, temp);
                    swapped = true;
                    swapCount++;
                }
            }
            // Early termination if no swaps
            if (!swapped)
                break;
        }

        System.out.println("BubbleSort (fees): " + result);
        System.out.println("Passes: " + passCount + ", Swaps: " + swapCount);
        return result;
    }

    // Insertion Sort for medium batches (100-1000) - sort by fee + timestamp
    public static List<Transaction> insertionSortByFeeAndTimestamp(List<Transaction> transactions) {
        List<Transaction> result = new ArrayList<>(transactions);
        int n = result.size();

        for (int i = 1; i < n; i++) {
            Transaction key = result.get(i);
            int j = i - 1;

            // Compare fee first, then timestamp
            while (j >= 0 && compareTransactions(result.get(j), key) > 0) {
                result.set(j + 1, result.get(j));
                j--;
            }
            result.set(j + 1, key);
        }

        System.out.println("InsertionSort (fee+ts): " + result);
        return result;
    }

    // Compare two transactions: fee first, then timestamp
    private static int compareTransactions(Transaction t1, Transaction t2) {
        if (t1.fee != t2.fee) {
            return Double.compare(t1.fee, t2.fee);
        }
        return t1.timestamp.compareTo(t2.timestamp);
    }

    // Flag high-fee outliers (> $50)
    public static List<Transaction> findHighFeeOutliers(List<Transaction> transactions) {
        List<Transaction> outliers = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.fee > 50) {
                outliers.add(t);
            }
        }
        return outliers;
    }

    public static void main(String[] args) {
        // Sample Input
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("id1", 10.5, "10:00"));
        transactions.add(new Transaction("id2", 25.0, "09:30"));
        transactions.add(new Transaction("id3", 5.0, "10:15"));

        System.out.println("=== Transaction Fee Sorting for Audit Compliance ===\n");
        System.out.println("Input transactions:");
        for (Transaction t : transactions) {
            System.out.println("  " + t.id + ", fee=" + t.fee + ", ts=" + t.timestamp);
        }
        System.out.println();

        // Bubble Sort (for small batches ≤ 100)
        bubbleSortByFee(transactions);

        // Insertion Sort (for medium batches 100-1000)
        insertionSortByFeeAndTimestamp(transactions);

        // High-fee outliers
        List<Transaction> outliers = findHighFeeOutliers(transactions);
        System.out.println("High-fee outliers: " + (outliers.isEmpty() ? "none" : outliers));

        // Additional test cases
        System.out.println("\n=== Additional Test Cases ===\n");

        // Test with duplicates
        List<Transaction> duplicates = new ArrayList<>();
        duplicates.add(new Transaction("id1", 10.5, "10:00"));
        duplicates.add(new Transaction("id4", 10.5, "09:00"));
        duplicates.add(new Transaction("id2", 25.0, "09:30"));

        System.out.println("Test with duplicates:");
        bubbleSortByFee(duplicates);

        // Test with high-fee outliers
        List<Transaction> highFees = new ArrayList<>();
        highFees.add(new Transaction("id1", 10.5, "10:00"));
        highFees.add(new Transaction("id2", 75.0, "09:30"));
        highFees.add(new Transaction("id3", 5.0, "10:15"));

        System.out.println("\nTest with high-fee outliers:");
        List<Transaction> highFeeOutliers = findHighFeeOutliers(highFees);
        System.out.println("High-fee outliers (> $50): " + highFeeOutliers);
    }
}

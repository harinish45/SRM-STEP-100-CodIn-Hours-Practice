/*
Problem 3: Historical Trade Volume Analysis
Scenario: Analyze 1 million daily trades by volume for market trend reports (Citi trading
desk).
Problem Statement:
● Sort trades by volume ascending using Merge Sort (stable, guaranteed O(n log
n)).
● Sort by volume DESC using Quick Sort (in‐place, average O(n log n)).
● Merge two sorted trade lists (e.g., morning/afternoon sessions).
● Compute total volume post‐sort.
Concepts Covered:
● Merge Sort: divide‐conquer, merge step.
● Quick Sort: pivot selection, partitioning, recursion.
● Stability, worst‐case O(n2) in Quick.
Hints:
● Merge: merge(left, right, temp).
● Quick: lomutoPartition(pivotIndex), recurse on partitions.
● Use int[] volumes or Trade[].
Use Cases:
● Citi market volume reports.
● Portfolio rebalancing.
● High‐frequency trading analytics.
Sample Input/Output:
Input: [trade3:500, trade1:100, trade2:300]
MergeSort: [1:100, 2:300, 3:500] // Stable
QuickSort (desc): [3:500, 2:300, 1:100] // Pivot: median
Merged morning+afternoon total: 900
*/

class Trade {
    String id;
    int volume;

    public Trade(String id, int volume) {
        this.id = id;
        this.volume = volume;
    }

    @Override
    public String toString() {
        return id + ":" + volume;
    }
}

public class Problem3 {
    // Merge Sort for volume ascending (stable)
    public static void mergeSortAsc(Trade[] trades) {
        if (trades == null || trades.length < 2) {
            return;
        }
        Trade[] temp = new Trade[trades.length];
        mergeSortAsc(trades, temp, 0, trades.length - 1);
        System.out.print("MergeSort: [");
        for (int i = 0; i < trades.length; i++) {
            System.out.print(trades[i]);
            if (i < trades.length - 1) System.out.print(", ");
        }
        System.out.println("] // Stable");
    }

    private static void mergeSortAsc(Trade[] trades, Trade[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return;
        }
        int middle = (leftStart + rightEnd) / 2;
        mergeSortAsc(trades, temp, leftStart, middle);
        mergeSortAsc(trades, temp, middle + 1, rightEnd);
        mergeHalves(trades, temp, leftStart, rightEnd);
    }

    private static void mergeHalves(Trade[] trades, Trade[] temp, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (trades[left].volume <= trades[right].volume) {
                temp[index] = trades[left];
                left++;
            } else {
                temp[index] = trades[right];
                right++;
            }
            index++;
        }

        System.arraycopy(trades, left, temp, index, leftEnd - left + 1);
        System.arraycopy(trades, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, trades, leftStart, size);
    }

    // Quick Sort for volume descending (in-place)
    public static void quickSortDesc(Trade[] trades) {
        if (trades == null || trades.length < 2) {
            return;
        }
        quickSortDesc(trades, 0, trades.length - 1);
        System.out.print("QuickSort (desc): [");
        for (int i = 0; i < trades.length; i++) {
            System.out.print(trades[i]);
            if (i < trades.length - 1) System.out.print(", ");
        }
        System.out.println("] // Pivot: median");
    }

    private static void quickSortDesc(Trade[] trades, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(trades, low, high);
            quickSortDesc(trades, low, pivotIndex - 1);
            quickSortDesc(trades, pivotIndex + 1, high);
        }
    }

    private static int partition(Trade[] trades, int low, int high) {
        // Using median-of-three for better pivot selection
        int mid = low + (high - low) / 2;
        // Order low, mid, high
        if (trades[low].volume < trades[mid].volume) {
            swap(trades, low, mid);
        }
        if (trades[low].volume < trades[high].volume) {
            swap(trades, low, high);
        }
        if (trades[mid].volume < trades[high].volume) {
            swap(trades, mid, high);
        }
        // Now mid has the median, swap with high to use as pivot
        swap(trades, mid, high);
        
        Trade pivot = trades[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            // For descending order, we want elements greater than pivot to come first
            if (trades[j].volume >= pivot.volume) {
                i++;
                swap(trades, i, j);
            }
        }
        swap(trades, i + 1, high);
        return i + 1;
    }

    private static void swap(Trade[] trades, int i, int j) {
        Trade temp = trades[i];
        trades[i] = trades[j];
        trades[j] = temp;
    }

    // Merge two sorted trade lists (e.g., morning/afternoon sessions)
    public static Trade[] mergeSortedLists(Trade[] list1, Trade[] list2) {
        Trade[] merged = new Trade[list1.length + list2.length];
        int i = 0, j = 0, k = 0;
        
        // Both lists are assumed to be sorted in ascending order by volume
        while (i < list1.length && j < list2.length) {
            if (list1[i].volume <= list2[j].volume) {
                merged[k++] = list1[i++];
            } else {
                merged[k++] = list2[j++];
            }
        }
        
        while (i < list1.length) {
            merged[k++] = list1[i++];
        }
        
        while (j < list2.length) {
            merged[k++] = list2[j++];
        }
        
        return merged;
    }

    // Compute total volume post-sort
    public static int computeTotalVolume(Trade[] trades) {
        int total = 0;
        for (Trade t : trades) {
            total += t.volume;
        }
        return total;
    }

    public static void main(String[] args) {
        Trade[] trades = {
            new Trade("trade3", 500),
            new Trade("trade1", 100),
            new Trade("trade2", 300)
        };

        System.out.println("Input: [trade3:500, trade1:100, trade2:300]");

        // Make copies for each sort
        Trade[] mergeTrades = trades.clone();
        Trade[] quickTrades = trades.clone();

        System.out.print("MergeSort: ");
        mergeSortAsc(mergeTrades);

        System.out.print("QuickSort (desc): ");
        quickSortDesc(quickTrades);

        // Example of merging two sorted lists (morning/afternoon sessions)
        Trade[] morning = {new Trade("m1", 100), new Trade("m2", 200)};
        Trade[] afternoon = {new Trade("a1", 150), new Trade("a2", 350)};
        Trade[] merged = mergeSortedLists(morning, afternoon);
        System.out.print("Merged morning+afternoon: [");
        for (int i = 0; i < merged.length; i++) {
            System.out.print(merged[i]);
            if (i < merged.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        
        int totalVolume = computeTotalVolume(merged);
        System.out.println("Merged morning+afternoon total: " + totalVolume);
    }
}
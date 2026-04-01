package SortingSearching;

// Problem 3: Historical Trade Volume Analysis
class Trade {
    String id;
    int volume;
    String session; // "morning" or "afternoon"

    public Trade(String id, int volume, String session) {
        this.id = id;
        this.volume = volume;
        this.session = session;
    }

    public String toString() {
        return id + ":" + volume;
    }
}

public class TradeVolumeSorter {

    // Merge Sort - ascending (stable)
    public static Trade[] mergeSort(Trade[] trades) {
        if (trades.length <= 1)
            return trades;

        int mid = trades.length / 2;
        Trade[] left = new Trade[mid];
        Trade[] right = new Trade[trades.length - mid];

        System.arraycopy(trades, 0, left, 0, mid);
        System.arraycopy(trades, mid, right, 0, trades.length - mid);

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private static Trade[] merge(Trade[] left, Trade[] right) {
        Trade[] result = new Trade[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].volume <= right[j].volume) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length)
            result[k++] = left[i++];
        while (j < right.length)
            result[k++] = right[j++];

        return result;
    }

    // Quick Sort - descending (in-place)
    public static void quickSortDesc(Trade[] trades, int low, int high) {
        if (low < high) {
            int pi = partitionDesc(trades, low, high);
            quickSortDesc(trades, low, pi - 1);
            quickSortDesc(trades, pi + 1, high);
        }
    }

    private static int partitionDesc(Trade[] trades, int low, int high) {
        // Median-of-3 pivot selection
        int mid = (low + high) / 2;
        Trade pivot = trades[mid];

        // Swap pivot to end
        trades[mid] = trades[high];
        trades[high] = pivot;

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (trades[j].volume > pivot.volume) { // Descending
                i++;
                Trade temp = trades[i];
                trades[i] = trades[j];
                trades[j] = temp;
            }
        }

        Trade temp = trades[i + 1];
        trades[i + 1] = trades[high];
        trades[high] = temp;

        return i + 1;
    }

    // Merge two sorted lists (morning + afternoon)
    public static Trade[] mergeSortedLists(Trade[] morning, Trade[] afternoon) {
        Trade[] result = new Trade[morning.length + afternoon.length];
        int i = 0, j = 0, k = 0;

        while (i < morning.length && j < afternoon.length) {
            if (morning[i].volume <= afternoon[j].volume) {
                result[k++] = morning[i++];
            } else {
                result[k++] = afternoon[j++];
            }
        }

        while (i < morning.length)
            result[k++] = morning[i++];
        while (j < afternoon.length)
            result[k++] = afternoon[j++];

        return result;
    }

    // Compute total volume
    public static int computeTotalVolume(Trade[] trades) {
        int total = 0;
        for (Trade t : trades) {
            total += t.volume;
        }
        return total;
    }

    public static void main(String[] args) {
        // Sample Input
        Trade[] trades = {
                new Trade("trade3", 500, "morning"),
                new Trade("trade1", 100, "afternoon"),
                new Trade("trade2", 300, "morning")
        };

        System.out.println("=== Historical Trade Volume Analysis ===\n");
        System.out.println("Input: [trade3:500, trade1:100, trade2:300]");

        // Merge Sort (ascending - stable)
        Trade[] mergeSorted = mergeSort(trades.clone());
        System.out.print("MergeSort: ");
        for (Trade t : mergeSorted) {
            System.out.print(t.id + ":" + t.volume + " ");
        }
        System.out.println("// Stable");

        // Quick Sort (descending)
        Trade[] quickSorted = trades.clone();
        quickSortDesc(quickSorted, 0, quickSorted.length - 1);
        System.out.print("QuickSort (desc): ");
        for (Trade t : quickSorted) {
            System.out.print(t.id + ":" + t.volume + " ");
        }
        System.out.println("// Pivot: median");

        // Merge morning and afternoon sessions
        Trade[] morning = {
                new Trade("M1", 100, "morning"),
                new Trade("M2", 300, "morning")
        };
        Trade[] afternoon = {
                new Trade("A1", 200, "afternoon"),
                new Trade("A2", 300, "afternoon")
        };

        Trade[] merged = mergeSortedLists(morning, afternoon);
        int totalVolume = computeTotalVolume(merged);

        System.out.print("Merged morning+afternoon: ");
        for (Trade t : merged) {
            System.out.print(t.id + ":" + t.volume + " ");
        }
        System.out.println("\nMerged morning+afternoon total: " + totalVolume);
    }
}

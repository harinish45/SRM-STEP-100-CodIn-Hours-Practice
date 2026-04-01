/*
Problem 4: Portfolio Return Sorting
Scenario: Sort 10,000 assets by historical returns for investment recommendations.
Problem Statement:
● Merge Sort assets by returnRate (preserve original order for ties).
● Quick Sort by returnRate DESC + volatility ASC.
● Handle pivot selection (random vs median‐of‐3).
Concepts Covered:
● External sorting if data > memory.
● Hybrid algorithms (Quick + Insertion for small partitions).
Hints:
● Merge: auxiliary array.
● Quick: partition(low, high, pivot).
Use Cases:
● Asset allocation optimization.
● Risk‐parity portfolio construction.
Sample Input/Output:
Input: [AAPL:12%, TSLA:8%, GOOG:15%]
Merge: [TSLA:8%, AAPL:12%, GOOG:15%]
Quick (desc): [GOOG:15%, AAPL:12%, TSLA:8%]
*/

class Asset {
    String symbol;
    double returnRate;
    double volatility;

    public Asset(String symbol, double returnRate, double volatility) {
        this.symbol = symbol;
        this.returnRate = returnRate;
        this.volatility = volatility;
    }

    @Override
    public String toString() {
        return symbol + ":" + returnRate + "%";
    }
}

public class Problem4 {
    public static void mergeSortByReturnRateAsc(Asset[] assets) {
        if (assets == null || assets.length < 2) return;
        Asset[] temp = new Asset[assets.length];
        mergeSortByReturnRateAsc(assets, temp, 0, assets.length - 1);
        System.out.print("Merge: [");
        for (int i = 0; i < assets.length; i++) {
            System.out.print(assets[i]);
            if (i < assets.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    private static void mergeSortByReturnRateAsc(Asset[] assets, Asset[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) return;
        int middle = (leftStart + rightEnd) / 2;
        mergeSortByReturnRateAsc(assets, temp, leftStart, middle);
        mergeSortByReturnRateAsc(assets, temp, middle + 1, rightEnd);
        mergeHalvesByReturnRate(assets, temp, leftStart, rightEnd);
    }

    private static void mergeHalvesByReturnRate(Asset[] assets, Asset[] temp, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (assets[left].returnRate < assets[right].returnRate ||
                (assets[left].returnRate == assets[right].returnRate && left <= right)) {
                temp[index] = assets[left];
                left++;
            } else {
                temp[index] = assets[right];
                right++;
            }
            index++;
        }

        System.arraycopy(assets, left, temp, index, leftEnd - left + 1);
        System.arraycopy(assets, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, assets, leftStart, size);
    }

    public static void quickSortByReturnRateDesc(Asset[] assets) {
        if (assets == null || assets.length < 2) return;
        quickSortByReturnRateDesc(assets, 0, assets.length - 1);
        System.out.print("Quick (desc): [");
        for (int i = 0; i < assets.length; i++) {
            System.out.print(assets[i]);
            if (i < assets.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    private static void quickSortByReturnRateDesc(Asset[] assets, int low, int high) {
        if (high - low + 1 <= 10) {
            insertionSortByReturnRateDesc(assets, low, high);
            return;
        }
        if (low < high) {
            int pivotIndex = partition(assets, low, high);
            quickSortByReturnRateDesc(assets, low, pivotIndex - 1);
            quickSortByReturnRateDesc(assets, pivotIndex + 1, high);
        }
    }

    private static int partition(Asset[] assets, int low, int high) {
        int mid = low + (high - low) / 2;
        if (assets[low].returnRate < assets[mid].returnRate) {
            swap(assets, low, mid);
        }
        if (assets[low].returnRate < assets[high].returnRate) {
            swap(assets, low, high);
        }
        if (assets[mid].returnRate < assets[high].returnRate) {
            swap(assets, mid, high);
        }
        swap(assets, mid, high);

        Asset pivot = assets[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (assets[j].returnRate > pivot.returnRate) {
                i++;
                swap(assets, i, j);
            }
        }
        swap(assets, i + 1, high);
        return i + 1;
    }

    private static void insertionSortByReturnRateDesc(Asset[] assets, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            Asset key = assets[i];
            int j = i - 1;
            while (j >= low && assets[j].returnRate < key.returnRate) {
                assets[j + 1] = assets[j];
                j--;
            }
            assets[j + 1] = key;
        }
    }

    private static void swap(Asset[] assets, int i, int j) {
        Asset temp = assets[i];
        assets[i] = assets[j];
        assets[j] = temp;
    }

    public static void main(String[] args) {
        Asset[] assets = {
            new Asset("AAPL", 12.0, 20.0),
            new Asset("TSLA", 8.0, 30.0),
            new Asset("GOOG", 15.0, 25.0)
        };

        System.out.println("Input: [AAPL:12%, TSLA:8%, GOOG:15%]");

        Asset[] mergeAssets = assets.clone();
        mergeSortByReturnRateAsc(mergeAssets);

        Asset[] quickAssets = assets.clone();
        quickSortByReturnRateDesc(quickAssets);
    }
}
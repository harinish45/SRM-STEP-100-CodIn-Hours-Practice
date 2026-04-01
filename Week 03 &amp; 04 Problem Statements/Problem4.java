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
    double returnRate; // as percentage, e.g., 12.0 for 12%
    double volatility; // as percentage

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
    // Merge Sort assets by returnRate (preserve original order for ties) - stable sort
    public static void mergeSortByReturnRateAsc(Asset[] assets) {
        if (assets == null || assets.length < 2) {
            return;
        }
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
        if (leftStart >= rightEnd) {
            return;
        }
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
            // For stability, if return rates are equal, we take from left first
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

    // Quick Sort by returnRate DESC + volatility ASC
    // Primary: returnRate descending
    // Secondary: volatility ascending (for equal returnRates)
    public static void quickSortByReturnRateDescThenVolatilityAsc(Asset[] assets) {
        if (assets == null || assets.length < 2) {
            return;
        }
        quickSortByReturnRateDescThenVolatilityAsc(assets, 0, assets.length - 1);
        System.out.print("Quick (desc): [");
        for (int i = 0; i < assets.length; i++) {
            System.out.print(assets[i]);
            if (i < assets.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    private static void quickSortByReturnRateDescThenVolatilityAsc(Asset[] assets, int low, int high) {
        // Use insertion sort for small partitions (hybrid approach)
        if (high - low + 1 <= 10) {
            insertionSortByReturnRateDescThenVolatilityAsc(assets, low, high);
            return;
        }
        if (low < high) {
            int pivotIndex = partition(assets, low, high);
            quickSortByReturnRateDescThenVolatilityAsc(assets, low, pivotIndex - 1);
            quickSortByReturnRateDescThenVolatilityAsc(assets, pivotIndex + 1, high);
        }
    }

    private static int partition(Asset[] assets, int low, int high) {
        // Using median-of-three for pivot selection based on returnRate
        int mid = low + (high - low) / 2;
        // Order low, mid, high by returnRate (descending for pivot selection logic)
        if (assets[low].returnRate < assets[mid].returnRate) {
            swap(assets, low, mid);
        }
        if (assets[low].returnRate < assets[high].returnRate) {
            swap(assets, low, high);
        }
        if (assets[mid].returnRate < assets[high].returnRate) {
            swap(assets, mid, high);
        }
        // Now mid has the median returnRate, swap with high to use as pivot
        swap(assets, mid, high);
        
        Asset pivot = assets[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            // For primary sort: returnRate descending (greater returnRate comes first)
            // For secondary sort: if returnRate equal, volatility ascending (lower volatility comes first)
            if (assets[j].returnRate > pivot.returnRate || 
                (assets[j].returnRate == pivot.returnRate && assets[j].volatility < pivot.volatility)) {
                i++;
                swap(assets, i, j);
            }
        }
        swap(assets, i + 1, high);
        return i + 1;
    }

    private static void insertionSortByReturnRateDescThenVolatilityAsc(Asset[] assets, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            Asset key = assets[i];
            int j = i - 1;
            // Move elements of assets[low..i-1] that have smaller returnRate than key,
            // or equal returnRate but greater volatility than key (to maintain stability for equal both)
            while (j >= low && 
                   (assets[j].returnRate < key.returnRate || 
                    (assets[j].returnRate == key.returnRate && assets[j].volatility > key.volatility))) {
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

        // Make copies for each sort
        Asset[] mergeAssets = assets.clone();
        Asset[] quickAssets = assets.clone();

        System.out.print("Merge: ");
        mergeSortByReturnRateAsc(mergeAssets);

        System.out.print("Quick (desc): ");
        quickSortByReturnRateDescThenVolatilityAsc(quickAssets);
    }
}
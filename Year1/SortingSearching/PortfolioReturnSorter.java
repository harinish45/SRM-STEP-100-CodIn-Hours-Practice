package SortingSearching;

// Problem 4: Portfolio Return Sorting
class Asset {
    String symbol;
    double returnRate;
    double volatility;

    public Asset(String symbol, double returnRate, double volatility) {
        this.symbol = symbol;
        this.returnRate = returnRate;
        this.volatility = volatility;
    }

    public String toString() {
        return symbol + ":" + returnRate + "%";
    }
}

public class PortfolioReturnSorter {

    // Merge Sort - by returnRate (stable for ties)
    public static Asset[] mergeSortByReturn(Asset[] assets) {
        if (assets.length <= 1)
            return assets;

        int mid = assets.length / 2;
        Asset[] left = new Asset[mid];
        Asset[] right = new Asset[assets.length - mid];

        System.arraycopy(assets, 0, left, 0, mid);
        System.arraycopy(assets, mid, right, 0, assets.length - mid);

        left = mergeSortByReturn(left);
        right = mergeSortByReturn(right);

        return mergeByReturn(left, right);
    }

    private static Asset[] mergeByReturn(Asset[] left, Asset[] right) {
        Asset[] result = new Asset[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            // Stable: if return rates equal, preserve original order
            if (left[i].returnRate <= right[j].returnRate) {
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

    // Quick Sort - returnRate DESC, volatility ASC (in-place)
    public static void quickSortReturnDescVolAsc(Asset[] assets, int low, int high) {
        if (low < high) {
            int pi = partitionReturnDescVolAsc(assets, low, high);
            quickSortReturnDescVolAsc(assets, low, pi - 1);
            quickSortReturnDescVolAsc(assets, pi + 1, high);
        }
    }

    private static int partitionReturnDescVolAsc(Asset[] assets, int low, int high) {
        // Random pivot selection
        int random = low + (int) (Math.random() * (high - low + 1));
        Asset pivot = assets[random];

        // Swap pivot to end
        assets[random] = assets[high];
        assets[high] = pivot;

        int i = low - 1;
        for (int j = low; j < high; j++) {
            // Desc by return, asc by volatility
            if (compareAssetsDescReturnAscVol(pivot, assets[j]) > 0) {
                i++;
                Asset temp = assets[i];
                assets[i] = assets[j];
                assets[j] = temp;
            }
        }

        Asset temp = assets[i + 1];
        assets[i + 1] = assets[high];
        assets[high] = temp;

        return i + 1;
    }

    private static int compareAssetsDescReturnAscVol(Asset a1, Asset a2) {
        // Return rate descending first
        if (a1.returnRate != a2.returnRate) {
            return Double.compare(a2.returnRate, a1.returnRate);
        }
        // Volatility ascending for ties
        return Double.compare(a1.volatility, a2.volatility);
    }

    // Quick Sort - median-of-3 pivot
    public static void quickSortMedianOf3(Asset[] assets, int low, int high) {
        if (low < high) {
            int pi = partitionMedianOf3(assets, low, high);
            quickSortMedianOf3(assets, low, pi - 1);
            quickSortMedianOf3(assets, pi + 1, high);
        }
    }

    private static int partitionMedianOf3(Asset[] assets, int low, int high) {
        int mid = low + (high - low) / 2;

        // Sort low, mid, high
        if (assets[low].returnRate > assets[mid].returnRate)
            swap(assets, low, mid);
        if (assets[low].returnRate > assets[high].returnRate)
            swap(assets, low, high);
        if (assets[mid].returnRate > assets[high].returnRate)
            swap(assets, mid, high);

        // Mid is pivot
        Asset pivot = assets[mid];
        swap(assets, mid, high);

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

    private static void swap(Asset[] assets, int i, int j) {
        Asset temp = assets[i];
        assets[i] = assets[j];
        assets[j] = temp;
    }

    public static void main(String[] args) {
        // Sample Input
        Asset[] assets = {
                new Asset("AAPL", 12, 15),
                new Asset("TSLA", 8, 25),
                new Asset("GOOG", 15, 18)
        };

        System.out.println("=== Portfolio Return Sorting ===\n");
        System.out.println("Input: [AAPL:12%, TSLA:8%, GOOG:15%]");

        // Merge Sort (ascending by return - stable)
        Asset[] mergeSorted = mergeSortByReturn(assets.clone());
        System.out.print("Merge: ");
        for (Asset a : mergeSorted) {
            System.out.print(a.symbol + ":" + a.returnRate + "% ");
        }
        System.out.println();

        // Quick Sort (descending by return, ascending by volatility)
        Asset[] quickSorted = assets.clone();
        quickSortReturnDescVolAsc(quickSorted, 0, quickSorted.length - 1);
        System.out.print("Quick (desc): ");
        for (Asset a : quickSorted) {
            System.out.print(a.symbol + ":" + a.returnRate + "% ");
        }
        System.out.println();

        // Additional test with ties
        System.out.println("\n=== Test with ties ===");
        Asset[] tiedAssets = {
                new Asset("A", 10, 20),
                new Asset("B", 10, 10),
                new Asset("C", 15, 15),
                new Asset("D", 10, 5)
        };

        System.out.println("Input: [A:10%, B:10%, C:15%, D:10%]");
        Asset[] stableSorted = mergeSortByReturn(tiedAssets.clone());
        System.out.print("Merge (stable): ");
        for (Asset a : stableSorted) {
            System.out.print(a.symbol + ":" + a.returnRate + "% ");
        }
        System.out.println();
    }
}

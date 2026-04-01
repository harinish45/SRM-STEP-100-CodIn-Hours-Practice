package SortingSearching;

// Problem 2: Client Risk Score Ranking
class Client {
    String name;
    int riskScore;
    double accountBalance;

    public Client(String name, int riskScore, double accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }

    public String toString() {
        return name + ":" + riskScore;
    }
}

public class ClientRiskRanker {

    // Bubble Sort - ascending by riskScore
    public static Client[] bubbleSortAscending(Client[] clients) {
        Client[] result = clients.clone();
        int n = result.length;
        int swapCount = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (result[j].riskScore > result[j + 1].riskScore) {
                    Client temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                    swapCount++;
                }
            }
        }

        System.out.println("Bubble (asc): " + java.util.Arrays.toString(result) + " // Swaps: " + swapCount);
        return result;
    }

    // Insertion Sort - descending by riskScore, then by accountBalance
    public static Client[] insertionSortDescending(Client[] clients) {
        Client[] result = clients.clone();
        int n = result.length;

        for (int i = 1; i < n; i++) {
            Client key = result[i];
            int j = i - 1;

            while (j >= 0 && compareClientsDesc(result[j], key) < 0) {
                result[j + 1] = result[j];
                j--;
            }
            result[j + 1] = key;
        }

        System.out.println("Insertion (desc): " + java.util.Arrays.toString(result));
        return result;
    }

    private static int compareClientsDesc(Client c1, Client c2) {
        if (c1.riskScore != c2.riskScore) {
            return Integer.compare(c2.riskScore, c1.riskScore); // Descending
        }
        return Double.compare(c2.accountBalance, c1.accountBalance); // Descending
    }

    // Find top N highest risk clients
    public static Client[] getTopRiskClients(Client[] clients, int k) {
        Client[] sorted = insertionSortDescending(clients);
        Client[] top = new Client[Math.min(k, sorted.length)];
        for (int i = 0; i < top.length; i++) {
            top[i] = sorted[i];
        }
        return top;
    }

    public static void main(String[] args) {
        // Sample Input
        Client[] clients = {
                new Client("clientC", 80, 5000),
                new Client("clientA", 20, 10000),
                new Client("clientB", 50, 7500)
        };

        System.out.println("=== Client Risk Score Ranking ===\n");
        System.out.println("Input: [clientC:80, clientA:20, clientB:50]");

        // Bubble Sort ascending
        Client[] bubbleSorted = bubbleSortAscending(clients);

        // Insertion Sort descending
        Client[] insertionSorted = insertionSortDescending(clients);

        // Top 3 highest risk clients
        Client[] top3 = getTopRiskClients(clients, 3);
        System.out.print("Top 3 risks: ");
        for (Client c : top3) {
            System.out.print(c.name + "(" + c.riskScore + "), ");
        }
        System.out.println();

        // Additional test
        System.out.println("\n=== Additional Test ===");
        Client[] moreClients = {
                new Client("P1", 45, 2000),
                new Client("P2", 90, 500),
                new Client("P3", 30, 15000),
                new Client("P4", 75, 8000),
                new Client("P5", 60, 3000)
        };

        System.out.println("\nInput: [P1:45, P2:90, P3:30, P4:75, P5:60]");
        bubbleSortAscending(moreClients);

        Client[] top10 = getTopRiskClients(moreClients, 10);
        System.out.print("Top 5 risks: ");
        for (Client c : top10) {
            System.out.print(c.name + "(" + c.riskScore + "), ");
        }
    }
}

/*
Problem 2: Client Risk Score Ranking
Scenario: Risk management team needs quick sorting of 500 client risk scores for
priority review.
Problem Statement:
● Sort clients by riskScore ascending using Bubble Sort (visualize swaps for demo).
● Sort by riskScore DESC + accountBalance using Insertion Sort.
● Identify top 10 highest risk clients post‐sort.
Concepts Covered:
● In‐place sorting algorithms.
● Adaptive behavior (Insertion excels on nearly‐sorted data).
● Space complexity O(1).
Hints:
● Client[] array.
● Bubble: for(int i=0; i<n-1; i++) outer, inner j<n-i-1.
● Insertion: for(int i=1; i<n; i++) shift from j=i-1.
Use Cases:
● KYC risk prioritization.
● Loan approval ranking.
● AML watchlist generation.
Sample Input/Output:
Input: [clientC:80, clientA:20, clientB:50]
Bubble (asc): [A:20, B:50, C:80] // Swaps: 2
Insertion (desc): [C:80, B:50, A:20]
Top 3 risks: C(80), B(50), A(20)
*/

import java.util.ArrayList;
import java.util.List;

class Client {
    String id;
    int riskScore;
    double accountBalance;

    public Client(String id, int riskScore, double accountBalance) {
        this.id = id;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return id + ":" + riskScore;
    }
}

public class Problem2 {
    public static void bubbleSortByRiskScoreAsc(Client[] clients) {
        int n = clients.length;
        int swaps = 0;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (clients[j].riskScore > clients[j + 1].riskScore) {
                    Client temp = clients[j];
                    clients[j] = clients[j + 1];
                    clients[j + 1] = temp;
                    swaps++;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        System.out.print("Bubble (asc): [");
        for (int i = 0; i < clients.length; i++) {
            System.out.print(clients[i]);
            if (i < clients.length - 1) System.out.print(", ");
        }
        System.out.println("] // Swaps: " + swaps);
    }

    public static void insertionSortByRiskScoreDesc(Client[] clients) {
        int n = clients.length;
        for (int i = 1; i < n; i++) {
            Client key = clients[i];
            int j = i - 1;
            while (j >= 0 && clients[j].riskScore < key.riskScore) {
                clients[j + 1] = clients[j];
                j--;
            }
            clients[j + 1] = key;
        }
        System.out.print("Insertion (desc): [");
        for (int i = 0; i < clients.length; i++) {
            System.out.print(clients[i]);
            if (i < clients.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static List<Client> getTopKRiskClients(Client[] clients, int k) {
        List<Client> topClients = new ArrayList<>();
        int limit = Math.min(k, clients.length);
        for (int i = 0; i < limit; i++) {
            topClients.add(clients[i]);
        }
        return topClients;
    }

    public static void main(String[] args) {
        Client[] clients = {
            new Client("clientC", 80, 1000.0),
            new Client("clientA", 20, 5000.0),
            new Client("clientB", 50, 2000.0)
        };

        System.out.println("Input: [clientC:80, clientA:20, clientB:50]");

        Client[] bubbleClients = clients.clone();
        bubbleSortByRiskScoreAsc(bubbleClients);

        Client[] insertionClients = clients.clone();
        insertionSortByRiskScoreDesc(insertionClients);

        List<Client> top3 = getTopKRiskClients(insertionClients, 3);
        System.out.print("Top 3 risks: ");
        for (int i = 0; i < top3.size(); i++) {
            Client c = top3.get(i);
            System.out.print(c.id + "(" + c.riskScore + ")");
            if (i < top3.size() - 1) System.out.print(", ");
        }
        System.out.println();
    }
}
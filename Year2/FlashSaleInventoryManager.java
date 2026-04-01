package Year2;

import java.util.*;

// Problem 2: E-commerce Flash Sale Inventory Manager

public class FlashSaleInventoryManager {
    private HashMap<String, Integer> stockLevels;
    private LinkedHashMap<String, ArrayList<String>> waitingList; // product -> userIds

    public FlashSaleInventoryManager() {
        stockLevels = new HashMap<>();
        waitingList = new LinkedHashMap<>();

        // Initialize stock
        stockLevels.put("IPHONE15_256GB", 100);
    }

    // Check stock - O(1)
    public String checkStock(String productId) {
        int stock = stockLevels.getOrDefault(productId, 0);
        return stock + " units available";
    }

    // Purchase item - synchronized for thread safety
    public synchronized String purchaseItem(String productId, String userId) {
        int currentStock = stockLevels.getOrDefault(productId, 0);

        if (currentStock > 0) {
            // Decrease stock
            stockLevels.put(productId, currentStock - 1);
            return "Success, " + (currentStock - 1) + " units remaining";
        } else {
            // Add to waiting list
            if (!waitingList.containsKey(productId)) {
                waitingList.put(productId, new ArrayList<>());
            }
            waitingList.get(productId).add(userId);
            int position = waitingList.get(productId).size();
            return "Added to waiting list, position #" + position;
        }
    }

    // Get waiting list size
    public int getWaitingListSize(String productId) {
        return waitingList.getOrDefault(productId, new ArrayList<>()).size();
    }

    public static void main(String[] args) {
        FlashSaleInventoryManager manager = new FlashSaleInventoryManager();

        System.out.println("=== E-commerce Flash Sale Inventory Manager ===\n");

        // Check initial stock
        System.out.println("checkStock(\"IPHONE15_256GB\") → " +
                manager.checkStock("IPHONE15_256GB"));

        // Simulate purchases
        System.out.println("\npurchaseItem(\"IPHONE15_256GB\", userId=12345) → " +
                manager.purchaseItem("IPHONE15_256GB", "12345"));

        System.out.println("purchaseItem(\"IPHONE15_256GB\", userId=67890) → " +
                manager.purchaseItem("IPHONE15_256GB", "67890"));

        // Simulate multiple purchases to deplete stock
        for (int i = 0; i < 98; i++) {
            manager.purchaseItem("IPHONE15_256GB", "user_" + i);
        }

        // Try to purchase when out of stock
        System.out.println("purchaseItem(\"IPHONE15_256GB\", userId=99999) → " +
                manager.purchaseItem("IPHONE15_256GB", "99999"));

        System.out.println("\nWaiting list size: " +
                manager.getWaitingListSize("IPHONE15_256GB"));
    }
}

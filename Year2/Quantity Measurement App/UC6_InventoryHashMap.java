package HotelBookingSystem;

import java.util.HashMap;
import java.util.Map;

public class UC6_InventoryHashMap {
    private Map<String, Integer> inventory;

    public UC6_InventoryHashMap() {
        inventory = new HashMap<>();
    }

    public void initializeInventory() {
        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);
    }

    public void addRoomType(String roomType, int count) {
        inventory.put(roomType, count);
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public boolean bookRoom(String roomType) {
        int current = inventory.getOrDefault(roomType, 0);
        if (current > 0) {
            inventory.put(roomType, current - 1);
            return true;
        }
        return false;
    }

    public void cancelBooking(String roomType) {
        int current = inventory.getOrDefault(roomType, 0);
        inventory.put(roomType, current + 1);
    }

    public void displayInventory() {
        System.out.println("\n=== Room Inventory (HashMap) ===");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " available");
        }
    }

    public int getTotalAvailable() {
        int total = 0;
        for (int count : inventory.values()) {
            total += count;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println("=== Use Case 6: Inventory with HashMap ===\n");

        UC6_InventoryHashMap inventory = new UC6_InventoryHashMap();
        inventory.initializeInventory();
        inventory.displayInventory();

        System.out.println("\nBooking rooms:");
        inventory.bookRoom("Single");
        inventory.bookRoom("Double");
        inventory.bookRoom("Suite");
        inventory.displayInventory();

        System.out.println("\nTotal available: " + inventory.getTotalAvailable());
    }
}
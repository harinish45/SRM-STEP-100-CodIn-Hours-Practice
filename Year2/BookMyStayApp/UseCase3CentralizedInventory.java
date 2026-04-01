package BookMyStayApp;


/**
 * UseCase3CentralizedInventory
 * Demonstrates centralized inventory management using HashMap
 * @author Student
 * @version 1.0
 */
import java.util.HashMap;
import java.util.Map;

public class UseCase3CentralizedInventory {

    // RoomInventory class - centralized management using HashMap
    static class RoomInventory {
        // HashMap to store room type and available count
        private HashMap<String, Integer> inventory;

        // Constructor - initialize inventory
        public RoomInventory() {
            inventory = new HashMap<>();
            // Initialize room availability
            inventory.put("Single", 5);
            inventory.put("Double", 3);
            inventory.put("Suite", 2);
        }

        // Get availability for a room type - O(1) lookup
        public int getAvailability(String roomType) {
            return inventory.getOrDefault(roomType, 0);
        }

        // Update availability - O(1)
        public void updateAvailability(String roomType, int count) {
            if (inventory.containsKey(roomType)) {
                int current = inventory.get(roomType);
                inventory.put(roomType, current + count);
            } else {
                inventory.put(roomType, count);
            }
        }

        // Book a room - decrease availability
        public boolean bookRoom(String roomType) {
            int current = inventory.getOrDefault(roomType, 0);
            if (current > 0) {
                inventory.put(roomType, current - 1);
                return true;
            }
            return false;
        }

        // Cancel a booking - increase availability
        public void cancelBooking(String roomType) {
            updateAvailability(roomType, 1);
        }

        // Display entire inventory
        public void displayInventory() {
            System.out.println("\n--- Centralized Room Inventory (HashMap) ---");
            for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
                System.out.println(entry.getKey() + " Rooms Available: " + entry.getValue());
            }
        }

        // Get total available rooms
        public int getTotalAvailable() {
            int total = 0;
            for (int count : inventory.values()) {
                total += count;
            }
            return total;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Use Case 3: Centralized Room Inventory Management ===\n");

        // Initialize centralized inventory
        RoomInventory inventory = new RoomInventory();

        // Display initial inventory
        inventory.displayInventory();

        // Book some rooms
        System.out.println("\n--- Booking Rooms ---");
        boolean booked1 = inventory.bookRoom("Single");
        System.out.println("Booked Single room: " + booked1);

        boolean booked2 = inventory.bookRoom("Double");
        System.out.println("Booked Double room: " + booked2);

        boolean booked3 = inventory.bookRoom("Suite");
        System.out.println("Booked Suite room: " + booked3);

        // Display updated inventory
        inventory.displayInventory();

        // Try to book more Single rooms
        System.out.println("\n--- Attempting to book more Single rooms ---");
        for (int i = 0; i < 6; i++) {
            boolean result = inventory.bookRoom("Single");
            System.out.println("Booking attempt " + (i + 1) + ": " + result);
        }

        // Display final inventory
        inventory.displayInventory();

        // Cancel a booking
        System.out.println("\n--- Cancelling a Single room booking ---");
        inventory.cancelBooking("Single");
        inventory.displayInventory();

        System.out.println("\nTotal Available Rooms: " + inventory.getTotalAvailable());

        System.out.println("\n[Key Concepts Demonstrated]");
        System.out.println("- HashMap for O(1) lookup and updates");
        System.out.println("- Centralized single source of truth");
        System.out.println("- Encapsulation of inventory logic");
        System.out.println("- Scalability - easy to add new room types");
    }
}

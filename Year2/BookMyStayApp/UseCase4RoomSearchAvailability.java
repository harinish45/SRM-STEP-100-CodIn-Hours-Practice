package BookMyStayApp;


/**
 * UseCase4RoomSearchAvailability
 * Demonstrates read-only room search without modifying system state
 * @author Student
 * @version 1.0
 */
import java.util.HashMap;
import java.util.Map;

public class UseCase4RoomSearchAvailability {

    // Room class - domain model
    static class Room {
        private String roomType;
        private double pricePerNight;
        private String amenities;

        public Room(String roomType, double pricePerNight, String amenities) {
            this.roomType = roomType;
            this.pricePerNight = pricePerNight;
            this.amenities = amenities;
        }

        public String getRoomType() {
            return roomType;
        }

        public double getPricePerNight() {
            return pricePerNight;
        }

        public String getAmenities() {
            return amenities;
        }
    }

    // RoomInventory class - manages room availability
    static class RoomInventory {
        private HashMap<String, Integer> inventory;

        public RoomInventory() {
            inventory = new HashMap<>();
            inventory.put("Single", 5);
            inventory.put("Double", 3);
            inventory.put("Suite", 2);
        }

        // Read-only method - returns availability without modification
        public int getAvailability(String roomType) {
            return inventory.getOrDefault(roomType, 0);
        }

        // Write method - for booking operations
        public boolean bookRoom(String roomType) {
            int current = inventory.getOrDefault(roomType, 0);
            if (current > 0) {
                inventory.put(roomType, current - 1);
                return true;
            }
            return false;
        }
    }

    // SearchService class - handles read-only search operations
    static class SearchService {
        private RoomInventory inventory;
        private HashMap<String, Room> roomDetails;

        public SearchService(RoomInventory inventory) {
            this.inventory = inventory;
            this.roomDetails = new HashMap<>();
            initializeRoomDetails();
        }

        private void initializeRoomDetails() {
            roomDetails.put("Single", new Room("Single", 50.0, "WiFi, TV, AC"));
            roomDetails.put("Double", new Room("Double", 80.0, "WiFi, TV, AC, Mini Bar"));
            roomDetails.put("Suite", new Room("Suite", 150.0, "WiFi, TV, AC, Mini Bar, Spa Access"));
        }

        // Read-only search - does NOT modify inventory
        public void searchAvailableRooms() {
            System.out.println("=== Searching Available Rooms (Read-Only) ===\n");

            boolean found = false;
            for (Map.Entry<String, Room> entry : roomDetails.entrySet()) {
                String roomType = entry.getKey();
                Room room = entry.getValue();

                // Get availability - read-only operation
                int available = inventory.getAvailability(roomType);

                // Only display rooms with availability > 0
                if (available > 0) {
                    System.out.println("Room Type: " + room.getRoomType());
                    System.out.println("Price: $" + room.getPricePerNight() + "/night");
                    System.out.println("Amenities: " + room.getAmenities());
                    System.out.println("Available: " + available + " rooms");
                    System.out.println("--------------------------");
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No rooms available!");
            }
        }

        // Read-only check - does NOT modify inventory
        public boolean isRoomAvailable(String roomType) {
            return inventory.getAvailability(roomType) > 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Use Case 4: Room Search & Availability Check ===\n");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Initialize search service
        SearchService searchService = new SearchService(inventory);

        // Guest searches for available rooms - read-only operation
        System.out.println("--- Guest searches for available rooms ---");
        searchService.searchAvailableRooms();

        // Check specific room availability - read-only
        System.out.println("\n--- Checking Specific Room Availability ---");
        System.out.println("Single available: " + searchService.isRoomAvailable("Single"));
        System.out.println("Suite available: " + searchService.isRoomAvailable("Suite"));

        // Verify inventory is unchanged
        System.out.println("\n--- Verifying Inventory State (Unchanged) ---");
        System.out.println("Single rooms: " + inventory.getAvailability("Single"));
        System.out.println("Double rooms: " + inventory.getAvailability("Double"));
        System.out.println("Suite rooms: " + inventory.getAvailability("Suite"));

        System.out.println("\n[Key Concepts Demonstrated]");
        System.out.println("- Read-only access to inventory");
        System.out.println("- Separation of search and booking logic");
        System.out.println("- Defensive programming - only show available rooms");
        System.out.println("- No state modification during search");
    }
}

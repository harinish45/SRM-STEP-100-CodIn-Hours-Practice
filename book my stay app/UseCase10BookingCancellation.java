import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// RoomInventory Class
class RoomInventory3 {
    private Map<String, Integer> inventory;

    public RoomInventory3() {
        inventory = new HashMap<>();
    }

    public void addRoomType(String roomType, int count) {
        inventory.put(roomType, count);
    }

    public int getAvailability(String roomType) {
        Integer count = inventory.get(roomType);
        return count != null ? count : 0;
    }

    public void restoreInventory(String roomType) {
        Integer count = inventory.get(roomType);
        if (count != null) {
            inventory.put(roomType, count + 1);
        }
    }
}

// CancellationService Class
class CancellationService {
    private Map<String, String> reservationToRoomTypeMap;
    private Stack<String> rollbackHistory;

    public CancellationService() {
        reservationToRoomTypeMap = new HashMap<>();
        rollbackHistory = new Stack<>();
    }

    // Store booking info
    public void registerBooking(String reservationId, String roomType) {
        reservationToRoomTypeMap.put(reservationId, roomType);
    }

    // Cancel booking and restore inventory
    public void cancelBooking(String reservationId, RoomInventory3 inventory) {
        // Validate reservation exists
        if (!reservationToRoomTypeMap.containsKey(reservationId)) {
            System.out.println("Reservation not found: " + reservationId);
            return;
        }

        // Get room type
        String roomType = reservationToRoomTypeMap.get(reservationId);

        // Restore inventory
        inventory.restoreInventory(roomType);

        // Add to rollback history (LIFO)
        rollbackHistory.push(reservationId);

        System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);
    }

    // Display rollback in LIFO order
    public void showRollbackHistory() {
        if (rollbackHistory.isEmpty()) {
            System.out.println("No cancellations yet.");
            return;
        }

        System.out.println("\nRollback History (Most Recent First):");
        for (int i = rollbackHistory.size() - 1; i >= 0; i--) {
            System.out.println("Released Reservation ID: " + rollbackHistory.get(i));
        }
    }
}

public class UseCase10BookingCancellation {
    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("   Booking Cancellation");
        System.out.println("=================================\n");

        // Create inventory with 5 Single rooms
        RoomInventory3 inventory = new RoomInventory3();
        inventory.addRoomType("Single", 5);

        // Create cancellation service
        CancellationService cancellationService = new CancellationService();

        // Register some bookings
        cancellationService.registerBooking("Single-1", "Single");
        cancellationService.registerBooking("Single-2", "Single");

        // Show initial inventory
        System.out.println("Initial Single Room Availability: " + inventory.getAvailability("Single"));

        // Cancel a booking
        cancellationService.cancelBooking("Single-1", inventory);

        // Show rollback history
        cancellationService.showRollbackHistory();

        // Show updated inventory
        System.out.println("\nUpdated Single Room Availability: " + inventory.getAvailability("Single"));
    }
}

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UseCase6RoomAllocation {

    public static void main(String[] args) {
        System.out.println("Room Allocation Processing\n");

        // Create inventory
        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType("Single", 5);
        inventory.addRoomType("Double", 3);
        inventory.addRoomType("Suite", 2);

        // Create allocation service
        RoomAllocationService allocationService = new RoomAllocationService();

        // Create some reservations
        Reservation r1 = new Reservation("Abhi", "Single", 101);
        Reservation r2 = new Reservation("Subha", "Single", 102);
        Reservation r3 = new Reservation("Vanmathi", "Suite", 301);

        // Allocate rooms
        allocationService.allocateRoom(r1, inventory);
        allocationService.allocateRoom(r2, inventory);
        allocationService.allocateRoom(r3, inventory);
    }
}

// RoomAllocationService Class
class RoomAllocationService {

    // Set to prevent duplicate room IDs
    private Set<String> allocatedRoomIds;

    // Map to group rooms by type
    private Map<String, Set<String>> assignedRoomsByType;

    // Counter for room IDs per type
    private Map<String, Integer> roomCounters;

    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
        roomCounters = new HashMap<>();
    }

    // Confirm booking and assign unique room ID
    public void allocateRoom(Reservation reservation, RoomInventory inventory) {
        String roomType = reservation.getRoomType();
        String guestName = reservation.getGuestName();

        // Check availability
        if (!inventory.isAvailable(roomType)) {
            System.out.println("No rooms available for: " + guestName);
            return;
        }

        // Generate unique room ID
        String roomId = generateRoomId(roomType);

        // Ensure uniqueness (in case of race condition)
        while (allocatedRoomIds.contains(roomId)) {
            roomId = generateRoomId(roomType);
        }

        // Mark room as allocated
        allocatedRoomIds.add(roomId);

        // Add to type-based map
        if (!assignedRoomsByType.containsKey(roomType)) {
            assignedRoomsByType.put(roomType, new HashSet<>());
        }
        assignedRoomsByType.get(roomType).add(roomId);

        // Reduce inventory count
        inventory.reduceInventory(roomType);

        // Confirm booking
        System.out.println("Booking confirmed for Guest: " + guestName + ", Room ID: " + roomId);
    }

    // Generate unique room ID like Single-1, Suite-1, etc.
    private String generateRoomId(String roomType) {
        // Initialize counter if not exists
        if (!roomCounters.containsKey(roomType)) {
            roomCounters.put(roomType, 0);
        }

        // Increment counter
        int count = roomCounters.get(roomType) + 1;
        roomCounters.put(roomType, count);

        return roomType + "-" + count;
    }
}

// RoomInventory Class (simple version)
class RoomInventory {
    private Map<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
    }

    public void addRoomType(String roomType, int count) {
        inventory.put(roomType, count);
    }

    public boolean isAvailable(String roomType) {
        Integer count = inventory.get(roomType);
        return count != null && count > 0;
    }

    public void reduceInventory(String roomType) {
        Integer count = inventory.get(roomType);
        if (count != null && count > 0) {
            inventory.put(roomType, count - 1);
        }
    }
}

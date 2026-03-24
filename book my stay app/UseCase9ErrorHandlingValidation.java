import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Custom Exception for invalid booking
class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}

// RoomInventory Class (from previous use cases)
class RoomInventory2 {
    private Map<String, Integer> inventory;

    public RoomInventory2() {
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

// ReservationValidator Class - validates input and system state
class ReservationValidator {

    // Valid room types
    private static final String[] VALID_ROOM_TYPES = {"Single", "Double", "Suite"};

    public void validate(String guestName, String roomType, RoomInventory2 inventory) 
            throws InvalidBookingException {
        
        // Validate guest name - not empty
        if (guestName == null || guestName.trim().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty.");
        }

        // Validate room type - must be exact match (case sensitive)
        boolean validRoomType = false;
        for (String type : VALID_ROOM_TYPES) {
            if (type.equals(roomType)) {
                validRoomType = true;
                break;
            }
        }
        
        if (!validRoomType) {
            throw new InvalidBookingException("Invalid room type selected.");
        }

        // Validate room availability
        if (!inventory.isAvailable(roomType)) {
            throw new InvalidBookingException("No rooms available for type: " + roomType);
        }
    }
}

public class UseCase9ErrorHandlingValidation {
    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("   Booking Validation");
        System.out.println("=================================\n");

        Scanner scanner = new Scanner(System.in);
        
        // Create inventory
        RoomInventory2 inventory = new RoomInventory2();
        inventory.addRoomType("Single", 5);
        inventory.addRoomType("Double", 3);
        inventory.addRoomType("Suite", 2);
        
        // Create validator
        ReservationValidator validator = new ReservationValidator();

        try {
            // Get guest name input
            System.out.print("Enter guest name: ");
            String guestName = scanner.nextLine();
            
            // Get room type input
            System.out.print("Enter room type (Single/Double/Suite): ");
            String roomType = scanner.nextLine();
            
            // Validate the booking
            validator.validate(guestName, roomType, inventory);
            
            // If validation passes, process booking
            inventory.reduceInventory(roomType);
            System.out.println("Booking confirmed for " + guestName + " in " + roomType + " room.");
            
        } catch (InvalidBookingException e) {
            System.out.println("Booking failed: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

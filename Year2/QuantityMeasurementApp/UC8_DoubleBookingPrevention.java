package QuantityMeasurementApp;

import java.util.HashSet;
import java.util.Set;

public class UC8_DoubleBookingPrevention {
    private UC1_RoomManagement roomManager;
    private Set<String> bookedRoomIds;

    public UC8_DoubleBookingPrevention(UC1_RoomManagement roomManager) {
        this.roomManager = roomManager;
        this.bookedRoomIds = new HashSet<>();
    }

    public boolean bookRoom(Guest guest, String roomType, int nights) {
        for (Room room : roomManager.rooms) {
            if (room.getRoomType().equals(roomType) && room.isAvailable()) {
                String roomId = roomType + "-" + room.getRoomNumber();
                if (!bookedRoomIds.contains(roomId)) {
                    bookedRoomIds.add(roomId);
                    room.setAvailable(false);
                    System.out.println("Booked Room " + room.getRoomNumber() + " for " + guest.getName());
                    return true;
                }
            }
        }
        System.out.println("Could not book " + roomType + " - no availability or already booked");
        return false;
    }

    public void displayBookedRooms() {
        System.out.println("\nBooked Room IDs: " + bookedRoomIds);
    }

    public static void main(String[] args) {
        System.out.println("=== Use Case 8: Double Booking Prevention ===\n");

        UC1_RoomManagement roomManager = new UC1_RoomManagement();
        roomManager.addRoom("Single", 50.0);
        roomManager.addRoom("Single", 50.0);
        roomManager.addRoom("Double", 80.0);

        UC8_DoubleBookingPrevention system = new UC8_DoubleBookingPrevention(roomManager);

        Guest g1 = new Guest("G001", "Alice", "", "");
        Guest g2 = new Guest("G002", "Bob", "", "");

        system.bookRoom(g1, "Single", 2);
        system.bookRoom(g2, "Single", 1);
        system.bookRoom(g1, "Single", 1); // Try to double-book

        system.displayBookedRooms();
        roomManager.displayAvailableRooms();
    }
}
package HotelBookingSystem;

import java.util.ArrayList;
import java.util.List;

public class UC1_RoomManagement {
    public List<Room> rooms;
    private int nextRoomNumber = 101;

    public UC1_RoomManagement() {
        rooms = new ArrayList<>();
    }

    public void addRoom(String roomType, double pricePerNight) {
        Room room = new Room(nextRoomNumber++, roomType, pricePerNight);
        rooms.add(room);
        System.out.println("Added: " + room);
    }

    public void displayAllRooms() {
        System.out.println("\n=== All Rooms ===");
        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    public void displayAvailableRooms() {
        System.out.println("\n=== Available Rooms ===");
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println(room);
            }
        }
    }

    public int getTotalRooms() {
        return rooms.size();
    }

    public int getAvailableCount() {
        int count = 0;
        for (Room room : rooms) {
            if (room.isAvailable()) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("=== Use Case 1: Room Management ===\n");

        UC1_RoomManagement manager = new UC1_RoomManagement();

        manager.addRoom("Single", 50.0);
        manager.addRoom("Double", 80.0);
        manager.addRoom("Suite", 150.0);
        manager.addRoom("Single", 50.0);
        manager.addRoom("Double", 80.0);

        manager.displayAllRooms();
        System.out.println("\nTotal rooms: " + manager.getTotalRooms());
        System.out.println("Available rooms: " + manager.getAvailableCount());
    }
}
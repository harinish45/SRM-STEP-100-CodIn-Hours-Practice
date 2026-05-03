package QuantityMeasurementApp;

import java.util.TreeMap;
import java.util.Map;

public class UC11_RoomAvailabilityTreeMap {
    private TreeMap<String, Integer> roomAvailability;

    public UC11_RoomAvailabilityTreeMap() {
        roomAvailability = new TreeMap<>();
    }

    public void initializeAvailability() {
        roomAvailability.put("Single", 5);
        roomAvailability.put("Double", 3);
        roomAvailability.put("Suite", 2);
    }

    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }

    public void bookRoom(String roomType) {
        int current = roomAvailability.getOrDefault(roomType, 0);
        if (current > 0) {
            roomAvailability.put(roomType, current - 1);
            System.out.println("Booked " + roomType + " room. Remaining: " + roomAvailability.get(roomType));
        } else {
            System.out.println("No " + roomType + " rooms available");
        }
    }

    public void cancelBooking(String roomType) {
        int current = roomAvailability.getOrDefault(roomType, 0);
        roomAvailability.put(roomType, current + 1);
        System.out.println("Canceled " + roomType + " booking. Available: " + roomAvailability.get(roomType));
    }

    public int getTotalAvailable() {
        int total = 0;
        for (int count : roomAvailability.values()) {
            total += count;
        }
        return total;
    }

    public void displayAvailability() {
        System.out.println("\n=== Room Availability (Sorted by Type) ===");
        for (Map.Entry<String, Integer> entry : roomAvailability.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " available");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Use Case 11: Room Availability TreeMap ===\n");

        UC11_RoomAvailabilityTreeMap system = new UC11_RoomAvailabilityTreeMap();
        system.initializeAvailability();
        
        system.displayAvailability();
        System.out.println("Total available: " + system.getTotalAvailable());

        system.bookRoom("Single");
        system.bookRoom("Double");
        system.bookRoom("Suite");
        
        system.cancelBooking("Double");
        
        system.displayAvailability();
    }
}
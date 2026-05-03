package HotelBookingSystem;

import java.util.HashMap;
import java.util.Map;

public class UC7_BookingWithHashMap {
    private Map<String, Booking> bookings;
    private Map<String, Integer> roomInventory;
    private int nextBookingId = 1;

    public UC7_BookingWithHashMap() {
        bookings = new HashMap<>();
        roomInventory = new HashMap<>();
        initializeInventory();
    }

    private void initializeInventory() {
        roomInventory.put("Single", 5);
        roomInventory.put("Double", 3);
        roomInventory.put("Suite", 2);
    }

    public String createBooking(Guest guest, String roomType, int nights) {
        int available = roomInventory.getOrDefault(roomType, 0);
        if (available <= 0) {
            System.out.println("No " + roomType + " rooms available");
            return null;
        }

        String bookingId = "B" + String.format("%03d", nextBookingId++);
        Booking booking = new Booking(bookingId, guest, 
            new Room(nextBookingId * 10, roomType, getPriceForType(roomType)), null, nights);
        
        bookings.put(bookingId, booking);
        roomInventory.put(roomType, available - 1);
        System.out.println("Created booking: " + bookingId);
        
        return bookingId;
    }

    private double getPriceForType(String roomType) {
        switch (roomType) {
            case "Single": return 50.0;
            case "Double": return 80.0;
            case "Suite": return 150.0;
            default: return 50.0;
        }
    }

    public void displayAllBookings() {
        System.out.println("\n=== All Bookings ===");
        for (Map.Entry<String, Booking> entry : bookings.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public Booking getBooking(String bookingId) {
        return bookings.get(bookingId);
    }

    public void displayInventory() {
        System.out.println("\n=== Inventory ===");
        for (Map.Entry<String, Integer> entry : roomInventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Use Case 7: Booking with HashMap ===\n");

        UC7_BookingWithHashMap system = new UC7_BookingWithHashMap();

        Guest g1 = new Guest("G001", "Alice", "alice@email.com", "");
        Guest g2 = new Guest("G002", "Bob", "bob@email.com", "");

        system.createBooking(g1, "Single", 2);
        system.createBooking(g2, "Double", 3);
        system.createBooking(g1, "Suite", 1);

        system.displayAllBookings();
        system.displayInventory();

        System.out.println("\nLooking up booking B001: " + system.getBooking("B001"));
    }
}
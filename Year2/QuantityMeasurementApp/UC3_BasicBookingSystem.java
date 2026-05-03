package QuantityMeasurementApp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UC3_BasicBookingSystem {
    private List<Room> rooms;
    private List<Booking> bookings;
    private int nextBookingId = 1;

    public UC3_BasicBookingSystem() {
        rooms = new ArrayList<>();
        bookings = new ArrayList<>();
        initializeRooms();
    }

    private void initializeRooms() {
        rooms.add(new Room(101, "Single", 50.0));
        rooms.add(new Room(102, "Single", 50.0));
        rooms.add(new Room(103, "Double", 80.0));
        rooms.add(new Room(104, "Suite", 150.0));
        rooms.add(new Room(105, "Single", 50.0));
    }

    public Booking createBooking(Guest guest, String roomType, int nights) {
        for (Room room : rooms) {
            if (room.isAvailable() && room.getRoomType().equals(roomType)) {
                String bookingId = "B" + String.format("%03d", nextBookingId++);
                Booking booking = new Booking(bookingId, guest, room, new Date(), nights);
                bookings.add(booking);
                System.out.println("Booking created: " + booking);
                return booking;
            }
        }
        System.out.println("No available " + roomType + " rooms");
        return null;
    }

    public void displayBookings() {
        System.out.println("\n=== All Bookings ===");
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }

    public double getTotalRevenue() {
        double total = 0;
        for (Booking booking : bookings) {
            if (booking.isActive()) {
                total += booking.getTotalAmount();
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println("=== Use Case 3: Basic Booking System ===\n");

        UC3_BasicBookingSystem system = new UC3_BasicBookingSystem();

        Guest guest1 = new Guest("G001", "Alice", "alice@email.com", "123-456-7890");
        Guest guest2 = new Guest("G002", "Bob", "bob@email.com", "234-567-8901");
        Guest guest3 = new Guest("G003", "Charlie", "charlie@email.com", "345-678-9012");

        system.createBooking(guest1, "Single", 2);
        system.createBooking(guest2, "Double", 3);
        system.createBooking(guest3, "Suite", 1);

        system.displayBookings();
        System.out.println("\nTotal Revenue: $" + system.getTotalRevenue());
    }
}
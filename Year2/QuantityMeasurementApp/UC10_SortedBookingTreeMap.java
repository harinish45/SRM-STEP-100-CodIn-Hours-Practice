package QuantityMeasurementApp;

import java.util.TreeMap;
import java.util.Map;

public class UC10_SortedBookingTreeMap {
    private TreeMap<String, Booking> sortedBookings;

    public UC10_SortedBookingTreeMap() {
        sortedBookings = new TreeMap<>();
    }

    public void addBooking(Booking booking) {
        sortedBookings.put(booking.getBookingId(), booking);
        System.out.println("Added booking: " + booking.getBookingId());
    }

    public void displayBookingsInOrder() {
        System.out.println("\n=== Bookings in Sorted Order ===");
        for (Map.Entry<String, Booking> entry : sortedBookings.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getGuest().getName() + 
                " - " + entry.getValue().getRoom().getRoomType());
        }
    }

    public Booking getBooking(String bookingId) {
        return sortedBookings.get(bookingId);
    }

    public void removeBooking(String bookingId) {
        sortedBookings.remove(bookingId);
        System.out.println("Removed booking: " + bookingId);
    }

    public static void main(String[] args) {
        System.out.println("=== Use Case 10: Sorted Booking TreeMap ===\n");

        UC10_SortedBookingTreeMap system = new UC10_SortedBookingTreeMap();

        Guest g1 = new Guest("G001", "Charlie", "", "");
        Guest g2 = new Guest("G002", "Alice", "", "");
        Guest g3 = new Guest("G003", "Bob", "", "");
        Guest g4 = new Guest("G004", "David", "", "");

        system.addBooking(new Booking("B003", g1, new Room(101, "Single", 50.0), null, 2));
        system.addBooking(new Booking("B001", g2, new Room(102, "Double", 80.0), null, 1));
        system.addBooking(new Booking("B004", g3, new Room(103, "Suite", 150.0), null, 3));
        system.addBooking(new Booking("B002", g4, new Room(104, "Single", 50.0), null, 2));

        system.displayBookingsInOrder();

        System.out.println("\nLooking up B002: " + system.getBooking("B002").getGuest().getName());
    }
}
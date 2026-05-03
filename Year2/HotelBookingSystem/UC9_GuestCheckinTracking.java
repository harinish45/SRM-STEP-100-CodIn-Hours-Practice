package HotelBookingSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UC9_GuestCheckinTracking {
    private List<Booking> activeBookings;
    private Map<String, Booking> checkedInGuests;
    private Map<String, Booking> checkedOutGuests;

    public UC9_GuestCheckinTracking() {
        activeBookings = new ArrayList<>();
        checkedInGuests = new HashMap<>();
        checkedOutGuests = new HashMap<>();
    }

    public void checkIn(String bookingId, Booking booking) {
        activeBookings.add(booking);
        checkedInGuests.put(bookingId, booking);
        System.out.println("Guest checked in: " + booking.getGuest().getName());
    }

    public void checkOut(String bookingId) {
        Booking booking = checkedInGuests.remove(bookingId);
        if (booking != null) {
            activeBookings.removeIf(b -> b.getBookingId().equals(bookingId));
            booking.cancel();
            checkedOutGuests.put(bookingId, booking);
            System.out.println("Guest checked out: " + booking.getGuest().getName());
        }
    }

    public void displayCheckedInGuests() {
        System.out.println("\n=== Checked In Guests ===");
        for (Map.Entry<String, Booking> entry : checkedInGuests.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getGuest().getName());
        }
    }

    public void displayCheckedOutGuests() {
        System.out.println("\n=== Checked Out Guests ===");
        for (Map.Entry<String, Booking> entry : checkedOutGuests.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getGuest().getName());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Use Case 9: Guest Checkin Tracking ===\n");

        UC9_GuestCheckinTracking tracking = new UC9_GuestCheckinTracking();

        Guest g1 = new Guest("G001", "Alice", "", "");
        Guest g2 = new Guest("G002", "Bob", "", "");
        
        Booking b1 = new Booking("B001", g1, new Room(101, "Single", 50.0), null, 2);
        Booking b2 = new Booking("B002", g2, new Room(102, "Double", 80.0), null, 3);

        tracking.checkIn("B001", b1);
        tracking.checkIn("B002", b2);

        tracking.displayCheckedInGuests();

        tracking.checkOut("B001");

        tracking.displayCheckedInGuests();
        tracking.displayCheckedOutGuests();
    }
}
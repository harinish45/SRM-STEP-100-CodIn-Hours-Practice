package HotelBookingSystem;

import java.util.ArrayList;
import java.util.List;

public class UC2_GuestManagement {
    private List<Guest> guests;
    private int nextGuestId = 1;

    public UC2_GuestManagement() {
        guests = new ArrayList<>();
    }

    public void addGuest(String name, String email, String phone) {
        String guestId = "G" + String.format("%03d", nextGuestId++);
        Guest guest = new Guest(guestId, name, email, phone);
        guests.add(guest);
        System.out.println("Added: " + guest);
    }

    public Guest findGuestByName(String name) {
        for (Guest guest : guests) {
            if (guest.getName().equalsIgnoreCase(name)) {
                return guest;
            }
        }
        return null;
    }

    public Guest findGuestById(String guestId) {
        for (Guest guest : guests) {
            if (guest.getGuestId().equals(guestId)) {
                return guest;
            }
        }
        return null;
    }

    public void displayAllGuests() {
        System.out.println("\n=== All Guests ===");
        for (Guest guest : guests) {
            System.out.println(guest);
        }
    }

    public int getTotalGuests() {
        return guests.size();
    }

    public static void main(String[] args) {
        System.out.println("=== Use Case 2: Guest Management ===\n");

        UC2_GuestManagement manager = new UC2_GuestManagement();

        manager.addGuest("Alice Johnson", "alice@email.com", "123-456-7890");
        manager.addGuest("Bob Smith", "bob@email.com", "234-567-8901");
        manager.addGuest("Charlie Brown", "charlie@email.com", "345-678-9012");

        manager.displayAllGuests();
        System.out.println("\nTotal guests: " + manager.getTotalGuests());

        System.out.println("\nSearching for 'Alice Johnson': " + manager.findGuestByName("Alice Johnson"));
        System.out.println("Searching for 'G002': " + manager.findGuestById("G002"));
    }
}
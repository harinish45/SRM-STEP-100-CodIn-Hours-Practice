package HotelBookingSystem;

import java.util.*;

public class UC13_CompleteHotelSystem {
    private UC1_RoomManagement roomManager;
    private UC6_InventoryHashMap inventory;
    private UC12_HotelAnalytics analytics;
    private Queue<BookingRequest> requestQueue;
    private Map<String, Booking> activeBookings;
    private Set<String> bookedRoomIds;
    private int nextBookingId = 1;

    public UC13_CompleteHotelSystem() {
        roomManager = new UC1_RoomManagement();
        inventory = new UC6_InventoryHashMap();
        analytics = new UC12_HotelAnalytics();
        requestQueue = new LinkedList<>();
        activeBookings = new HashMap<>();
        bookedRoomIds = new HashSet<>();
        initializeSystem();
    }

    private void initializeSystem() {
        roomManager.addRoom("Single", 50.0);
        roomManager.addRoom("Single", 50.0);
        roomManager.addRoom("Single", 50.0);
        roomManager.addRoom("Double", 80.0);
        roomManager.addRoom("Double", 80.0);
        roomManager.addRoom("Suite", 150.0);
        
        inventory.initializeInventory();
    }

    public String submitBookingRequest(Guest guest, String roomType, int nights) {
        String requestId = "R" + String.format("%03d", requestQueue.size() + 1);
        BookingRequest request = new BookingRequest(requestId, guest, roomType, nights);
        requestQueue.offer(request);
        System.out.println("Request submitted: " + request);
        return requestId;
    }

    public boolean processBookingRequest(BookingRequest request) {
        String roomType = request.getRoomType();
        int available = inventory.getAvailability(roomType);
        
        if (available <= 0) {
            System.out.println("No " + roomType + " rooms available");
            return false;
        }

        for (Room room : roomManager.rooms) {
            if (room.getRoomType().equals(roomType) && room.isAvailable()) {
                String roomId = roomType + "-" + room.getRoomNumber();
                if (!bookedRoomIds.contains(roomId)) {
                    bookedRoomIds.add(roomId);
                    room.setAvailable(false);
                    
                    String bookingId = "B" + String.format("%03d", nextBookingId++);
                    Booking booking = new Booking(bookingId, request.getGuest(), room, new Date(), request.getNights());
                    activeBookings.put(bookingId, booking);
                    analytics.recordBooking(booking);
                    
                    inventory.bookRoom(roomType);
                    System.out.println("Booking confirmed: " + bookingId);
                    return true;
                }
            }
        }
        return false;
    }

    public void processAllRequests() {
        System.out.println("\n=== Processing All Requests ===");
        while (!requestQueue.isEmpty()) {
            BookingRequest request = requestQueue.poll();
            processBookingRequest(request);
        }
    }

    public void displayStatus() {
        System.out.println("\n=== System Status ===");
        System.out.println("Total Rooms: " + roomManager.getTotalRooms());
        System.out.println("Available: " + roomManager.getAvailableCount());
        System.out.println("Pending Requests: " + requestQueue.size());
        System.out.println("Active Bookings: " + activeBookings.size());
    }

    public void displayAnalytics() {
        analytics.displayAnalytics();
    }

    public static void main(String[] args) {
        System.out.println("=== Use Case 13: Complete Hotel System ===\n");

        UC13_CompleteHotelSystem system = new UC13_CompleteHotelSystem();

        Guest g1 = new Guest("G001", "Alice", "alice@email.com", "123-456-7890");
        Guest g2 = new Guest("G002", "Bob", "bob@email.com", "234-567-8901");
        Guest g3 = new Guest("G003", "Charlie", "charlie@email.com", "345-678-9012");
        Guest g4 = new Guest("G004", "Diana", "diana@email.com", "456-789-0123");

        system.submitBookingRequest(g1, "Single", 2);
        system.submitBookingRequest(g2, "Double", 3);
        system.submitBookingRequest(g3, "Suite", 1);
        system.submitBookingRequest(g4, "Single", 1);

        system.processAllRequests();
        system.displayStatus();
        system.displayAnalytics();
    }
}
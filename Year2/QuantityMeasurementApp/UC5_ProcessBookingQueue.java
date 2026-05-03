package QuantityMeasurementApp;

import java.util.LinkedList;
import java.util.Queue;

public class UC5_ProcessBookingQueue {
    private UC1_RoomManagement roomManager;
    private Queue<BookingRequest> requestQueue;
    private int nextBookingId = 1;

    public UC5_ProcessBookingQueue(UC1_RoomManagement roomManager) {
        this.roomManager = roomManager;
        this.requestQueue = new LinkedList<>();
    }

    public void addRequest(BookingRequest request) {
        requestQueue.offer(request);
    }

    public void processAllRequests() {
        System.out.println("\n=== Processing Booking Requests ===");
        while (!requestQueue.isEmpty()) {
            BookingRequest request = requestQueue.poll();
            processRequest(request);
        }
    }

    private void processRequest(BookingRequest request) {
        System.out.println("Processing: " + request);
        // Find available room of requested type
        for (Room room : roomManager.rooms) {
            if (room.isAvailable() && room.getRoomType().equals(request.getRoomType())) {
                String bookingId = "B" + String.format("%03d", nextBookingId++);
                System.out.println("  -> Assigned Room " + room.getRoomNumber() + " to " + request.getGuest().getName());
                room.setAvailable(false);
                return;
            }
        }
        System.out.println("  -> No available " + request.getRoomType() + " rooms");
    }

    public static void main(String[] args) {
        System.out.println("=== Use Case 5: Process Booking Queue ===\n");

        UC1_RoomManagement roomManager = new UC1_RoomManagement();
        roomManager.addRoom("Single", 50.0);
        roomManager.addRoom("Single", 50.0);
        roomManager.addRoom("Double", 80.0);
        roomManager.addRoom("Suite", 150.0);

        UC5_ProcessBookingQueue processor = new UC5_ProcessBookingQueue(roomManager);

        processor.addRequest(new BookingRequest("R001", new Guest("G001", "Alice", "", ""), "Single", 2));
        processor.addRequest(new BookingRequest("R002", new Guest("G002", "Bob", "", ""), "Double", 3));
        processor.addRequest(new BookingRequest("R003", new Guest("G003", "Charlie", "", ""), "Single", 1));

        processor.processAllRequests();

        System.out.println("\nRemaining available rooms:");
        roomManager.displayAvailableRooms();
    }
}
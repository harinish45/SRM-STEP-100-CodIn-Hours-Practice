package HotelBookingSystem;

import java.util.LinkedList;
import java.util.Queue;

public class UC4_BookingRequestQueue {
    private Queue<BookingRequest> requestQueue;
    private int nextRequestId = 1;

    public UC4_BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    public void submitRequest(Guest guest, String roomType, int nights) {
        String requestId = "R" + String.format("%03d", nextRequestId++);
        BookingRequest request = new BookingRequest(requestId, guest, roomType, nights);
        requestQueue.offer(request);
        System.out.println("Request submitted: " + request);
    }

    public BookingRequest getNextRequest() {
        return requestQueue.poll();
    }

    public void displayQueue() {
        System.out.println("\n=== Booking Request Queue (FIFO) ===");
        if (requestQueue.isEmpty()) {
            System.out.println("No pending requests");
            return;
        }
        int i = 1;
        for (BookingRequest req : requestQueue) {
            System.out.println(i++ + ". " + req);
        }
    }

    public int getQueueSize() {
        return requestQueue.size();
    }

    public boolean isEmpty() {
        return requestQueue.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("=== Use Case 4: Booking Request Queue ===\n");

        UC4_BookingRequestQueue queue = new UC4_BookingRequestQueue();
        UC2_GuestManagement guestManager = new UC2_GuestManagement();

        Guest g1 = new Guest("G001", "Alice", "alice@email.com", "123-456-7890");
        Guest g2 = new Guest("G002", "Bob", "bob@email.com", "234-567-8901");
        Guest g3 = new Guest("G003", "Charlie", "charlie@email.com", "345-678-9012");

        queue.submitRequest(g1, "Single", 2);
        queue.submitRequest(g2, "Double", 3);
        queue.submitRequest(g3, "Suite", 1);

        queue.displayQueue();

        System.out.println("\nProcessing requests:");
        while (!queue.isEmpty()) {
            BookingRequest req = queue.getNextRequest();
            System.out.println("Processing: " + req);
        }
    }
}
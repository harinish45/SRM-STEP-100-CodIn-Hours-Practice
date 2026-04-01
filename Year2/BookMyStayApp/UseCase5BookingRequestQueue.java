package BookMyStayApp;


/**
 * UseCase5BookingRequestQueue
 * Demonstrates FIFO Queue for fair booking request handling
 * @author Student
 * @version 1.0
 */
import java.util.LinkedList;
import java.util.Queue;

public class UseCase5BookingRequestQueue {

    // Reservation class - represents guest's booking intent
    static class Reservation {
        private String guestName;
        private String roomType;
        private int nights;
        private long requestTime;

        public Reservation(String guestName, String roomType, int nights) {
            this.guestName = guestName;
            this.roomType = roomType;
            this.nights = nights;
            this.requestTime = System.currentTimeMillis();
        }

        public String getGuestName() {
            return guestName;
        }

        public String getRoomType() {
            return roomType;
        }

        public int getNights() {
            return nights;
        }

        public long getRequestTime() {
            return requestTime;
        }

        @Override
        public String toString() {
            return "Reservation[Guest: " + guestName + ", Room: " + roomType +
                    ", Nights: " + nights + "]";
        }
    }

    // BookingRequestQueue class - manages incoming requests using Queue
    static class BookingRequestQueue {
        private Queue<Reservation> queue;

        public BookingRequestQueue() {
            // LinkedList implements Queue interface
            queue = new LinkedList<>();
        }

        // Add request to queue - enqueue operation (FIFO)
        public void addRequest(Reservation reservation) {
            queue.offer(reservation); // offer() is preferred over add()
            System.out.println("Request added: " + reservation.getGuestName());
        }

        // Remove and process request - dequeue operation
        public Reservation processRequest() {
            return queue.poll(); // poll() returns null if empty
        }

        // View first request without removing
        public Reservation peekRequest() {
            return queue.peek();
        }

        // Check if queue is empty
        public boolean isEmpty() {
            return queue.isEmpty();
        }

        // Get queue size
        public int getQueueSize() {
            return queue.size();
        }

        // Display all pending requests
        public void displayQueue() {
            System.out.println("\n--- Pending Booking Requests (FIFO Order) ---");
            if (queue.isEmpty()) {
                System.out.println("No pending requests.");
                return;
            }

            int i = 1;
            for (Reservation res : queue) {
                System.out.println(i++ + ". " + res);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Use Case 5: Booking Request (First-Come-First-Served) ===\n");

        // Create booking request queue
        BookingRequestQueue requestQueue = new BookingRequestQueue();

        // Guest submits booking requests - arrives in order
        System.out.println("--- Guests Submitting Booking Requests ---");

        Reservation r1 = new Reservation("Alice", "Single", 2);
        requestQueue.addRequest(r1);

        Reservation r2 = new Reservation("Bob", "Double", 3);
        requestQueue.addRequest(r2);

        Reservation r3 = new Reservation("Charlie", "Suite", 1);
        requestQueue.addRequest(r3);

        Reservation r4 = new Reservation("Diana", "Single", 4);
        requestQueue.addRequest(r4);

        Reservation r5 = new Reservation("Eve", "Double", 2);
        requestQueue.addRequest(r5);

        // Display current queue
        requestQueue.displayQueue();

        System.out.println("\n--- Processing Requests (FIFO Order) ---");

        // Process requests in FIFO order
        while (!requestQueue.isEmpty()) {
            Reservation current = requestQueue.processRequest();
            System.out.println("Processing: " + current);
            System.out.println("Remaining requests: " + requestQueue.getQueueSize());
        }

        // Verify queue is empty
        System.out.println("\n--- Final Status ---");
        System.out.println("Queue empty: " + requestQueue.isEmpty());
        System.out.println("Requests processed: 5");

        System.out.println("\n[Key Concepts Demonstrated]");
        System.out.println("- Queue data structure for FIFO processing");
        System.out.println("- Fair request handling (first-come, first-served)");
        System.out.println("- Decoupling request intake from allocation");
        System.out.println("- Request ordering preserved automatically");
    }
}

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

// RoomInventory Class
class RoomInventory4 {
    private Map<String, Integer> inventory;

    public RoomInventory4() {
        inventory = new HashMap<>();
    }

    public void addRoomType(String roomType, int count) {
        inventory.put(roomType, count);
    }

    public synchronized boolean isAvailable(String roomType) {
        Integer count = inventory.get(roomType);
        return count != null && count > 0;
    }

    public synchronized void reduceInventory(String roomType) {
        Integer count = inventory.get(roomType);
        if (count != null && count > 0) {
            inventory.put(roomType, count - 1);
        }
    }

    public synchronized int getAvailability(String roomType) {
        Integer count = inventory.get(roomType);
        return count != null ? count : 0;
    }
}

// BookingRequest class
class BookingRequest2 {
    String guestName;
    String roomType;

    BookingRequest2(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }
}

// BookingRequestQueue Class
class BookingRequestQueue2 {
    private Queue<BookingRequest2> queue;

    public BookingRequestQueue2() {
        queue = new ConcurrentLinkedQueue<>();
    }

    public synchronized void addRequest(BookingRequest2 request) {
        queue.add(request);
    }

    public synchronized BookingRequest2 getRequest() {
        return queue.poll();
    }

    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }
}

// RoomAllocationService Class
class RoomAllocationService2 {
    private Map<String, Integer> roomCounters;

    public RoomAllocationService2() {
        roomCounters = new HashMap<>();
    }

    public synchronized String allocateRoom(String roomType) {
        // Generate room ID
        if (!roomCounters.containsKey(roomType)) {
            roomCounters.put(roomType, 0);
        }

        int count = roomCounters.get(roomType) + 1;
        roomCounters.put(roomType, count);

        return roomType + "-" + count;
    }
}

// ConcurrentBookingProcessor Class - implements Runnable for thread execution
class ConcurrentBookingProcessor implements Runnable {
    private BookingRequestQueue2 bookingQueue;
    private RoomInventory4 inventory;
    private RoomAllocationService2 allocationService;

    public ConcurrentBookingProcessor(
            BookingRequestQueue2 bookingQueue,
            RoomInventory4 inventory,
            RoomAllocationService2 allocationService) {
        this.bookingQueue = bookingQueue;
        this.inventory = inventory;
        this.allocationService = allocationService;
    }

    @Override
    public void run() {
        while (true) {
            BookingRequest2 request;

            // Critical section 1: Safe queue retrieval
            synchronized (bookingQueue) {
                request = bookingQueue.getRequest();
                if (request == null) {
                    break;
                }
            }

            String roomType = request.getRoomType();

            // Critical section 2: Safe inventory allocation
            synchronized (inventory) {
                if (inventory.isAvailable(roomType)) {
                    // Allocate room
                    String roomId = allocationService.allocateRoom(roomType);

                    // Reduce inventory
                    inventory.reduceInventory(roomType);

                    System.out.println("Booking confirmed for Guest: " +
                            request.getGuestName() + ", Room ID: " + roomId);
                }
            }
        }
    }
}

public class UseCase11ConcurrentBookingSimulation {
    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("   Concurrent Booking Simulation");
        System.out.println("=================================\n");

        // Create shared resources
        BookingRequestQueue2 bookingQueue = new BookingRequestQueue2();
        RoomInventory4 inventory = new RoomInventory4();
        inventory.addRoomType("Single", 5);
        inventory.addRoomType("Double", 3);
        inventory.addRoomType("Suite", 2);
        RoomAllocationService2 allocationService = new RoomAllocationService2();

        // Add booking requests to queue
        bookingQueue.addRequest(new BookingRequest2("Abhi", "Single"));
        bookingQueue.addRequest(new BookingRequest2("Vanmathi", "Double"));
        bookingQueue.addRequest(new BookingRequest2("Kural", "Suite"));
        bookingQueue.addRequest(new BookingRequest2("Subha", "Single"));

        // Create threads
        Thread t1 = new Thread(
                new ConcurrentBookingProcessor(bookingQueue, inventory, allocationService));
        Thread t2 = new Thread(
                new ConcurrentBookingProcessor(bookingQueue, inventory, allocationService));

        // Start threads
        t1.start();
        t2.start();

        // Wait for threads to complete
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread execution interrupted.");
        }

        // Show remaining inventory
        System.out.println("\nRemaining Inventory:");
        System.out.println("Single: " + inventory.getAvailability("Single"));
        System.out.println("Double: " + inventory.getAvailability("Double"));
        System.out.println("Suite: " + inventory.getAvailability("Suite"));
    }
}

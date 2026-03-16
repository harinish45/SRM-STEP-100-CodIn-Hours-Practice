import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class InventoryManager {
    private ConcurrentHashMap<String, AtomicInteger> stock;
    private ConcurrentHashMap<String, Queue<Integer>> waitingLists;

    public InventoryManager() {
        stock = new ConcurrentHashMap<>();
        waitingLists = new ConcurrentHashMap<>();

        // Initialize stock
        stock.put("IPHONE15_256GB", new AtomicInteger(100));
        waitingLists.put("IPHONE15_256GB", new ConcurrentLinkedQueue<>());
    }

    public String checkStock(String productId) {
        AtomicInteger count = stock.get(productId);
        return count != null ? count.get() + " units available" : "Product not found";
    }

    public String purchaseItem(String productId, int userId) {
        AtomicInteger count = stock.get(productId);
        if (count == null)
            return "Product not found";

        while (true) {
            int currentStock = count.get();
            if (currentStock > 0) {
                if (count.compareAndSet(currentStock, currentStock - 1)) {
                    return "Success, " + (currentStock - 1) + " units remaining";
                }
                // content failed, retry
            } else {
                // Out of stock, add to waiting list
                waitingLists.putIfAbsent(productId, new ConcurrentLinkedQueue<>());
                Queue<Integer> queue = waitingLists.get(productId);
                queue.add(userId);
                // Simple position check (not strictly thread-safe for exact position but good
                // enough for estimate)
                return "Added to waiting list, position #" + queue.size();
            }
        }
    }

    public static void main(String[] args) {
        InventoryManager sys = new InventoryManager();

        System.out.println("checkStock(\"IPHONE15_256GB\") -> " + sys.checkStock("IPHONE15_256GB"));

        System.out.println("purchaseItem(\"IPHONE15_256GB\", 12345) -> " + sys.purchaseItem("IPHONE15_256GB", 12345));
        System.out.println("purchaseItem(\"IPHONE15_256GB\", 67890) -> " + sys.purchaseItem("IPHONE15_256GB", 67890));

        // Simulate sell out
        for (int i = 0; i < 98; i++) {
            sys.purchaseItem("IPHONE15_256GB", 1000 + i);
        }

        System.out.println("purchaseItem(\"IPHONE15_256GB\", 99999) -> " + sys.purchaseItem("IPHONE15_256GB", 99999));
    }
}

package BookMyStayApp;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


// RoomInventory Class
class RoomInventory5 {
    private Map<String, Integer> inventory;

    public RoomInventory5() {
        inventory = new HashMap<>();
    }

    public void addRoomType(String roomType, int count) {
        inventory.put(roomType, count);
    }

    public int getAvailability(String roomType) {
        Integer count = inventory.get(roomType);
        return count != null ? count : 0;
    }

    public void setAvailability(String roomType, int count) {
        inventory.put(roomType, count);
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }
}

// FilePersistenceService Class
class FilePersistenceService {

    // Save inventory to file
    public void saveInventory(RoomInventory5 inventory, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            Map<String, Integer> inv = inventory.getInventory();
            for (Map.Entry<String, Integer> entry : inv.entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue());
                writer.newLine();
            }
            System.out.println("Inventory saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving inventory: " + e.getMessage());
        }
    }

    // Load inventory from file
    public void loadInventory(RoomInventory5 inventory, String filePath) {
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("No valid inventory data found. Starting fresh.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean hasData = false;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    String roomType = parts[0];
                    int count = Integer.parseInt(parts[1].trim());
                    inventory.setAvailability(roomType, count);
                    hasData = true;
                }
            }

            if (!hasData) {
                System.out.println("No valid inventory data found. Starting fresh.");
            } else {
                System.out.println("Inventory loaded successfully.");
            }
        } catch (IOException e) {
            System.out.println("Error loading inventory: " + e.getMessage());
            System.out.println("Starting fresh.");
        }
    }
}

public class UseCase12DataPersistenceRecovery {
    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("   System Recovery");
        System.out.println("=================================\n");

        String filePath = "inventory_data.txt";

        // Create inventory
        RoomInventory5 inventory = new RoomInventory5();

        // Create persistence service
        FilePersistenceService persistenceService = new FilePersistenceService();

        // Try to load inventory from file
        persistenceService.loadInventory(inventory, filePath);

        // If no data loaded, initialize with defaults
        if (inventory.getAvailability("Single") == 0 &&
                inventory.getAvailability("Double") == 0 &&
                inventory.getAvailability("Suite") == 0) {
            inventory.addRoomType("Single", 5);
            inventory.addRoomType("Double", 3);
            inventory.addRoomType("Suite", 2);
        }

        // Display current inventory
        System.out.println("\nCurrent Inventory:");
        System.out.println("Single: " + inventory.getAvailability("Single"));
        System.out.println("Double: " + inventory.getAvailability("Double"));
        System.out.println("Suite: " + inventory.getAvailability("Suite"));

        // Save inventory to file
        System.out.println();
        persistenceService.saveInventory(inventory, filePath);
    }
}

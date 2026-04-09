import java.util.HashMap;
import java.util.Map;

public class UC6_Map_Bogie_to_Capacity {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("UC6 - Map Bogie to Capacity (HashMap)");
        System.out.println("========================================");
        System.out.println();

        Map<String, Integer> bogieCapacity = new HashMap<>();

        // Insert capacity values (matching expected output data)
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 56);
        bogieCapacity.put("First Class", 24);
        bogieCapacity.put("Cargo", 120);

        System.out.println("Bogie Capacity Details:");
        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println();
        System.out.println("UC6 bogie-capacity mapping completed...");
    }
}
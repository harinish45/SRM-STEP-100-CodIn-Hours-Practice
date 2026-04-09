import java.util.HashMap;
import java.util.Map;

public class UC6_Map_Bogie_to_Capacity {
    public static void main(String[] args) {
        Map<String, Integer> bogieCapacity = new HashMap<>();
        
        // Insert capacity values
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 60);
        bogieCapacity.put("First Class", 24);
        
        // Iterate over the map
        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println("Bogie: " + entry.getKey() + ", Capacity: " + entry.getValue());
        }
    }
}
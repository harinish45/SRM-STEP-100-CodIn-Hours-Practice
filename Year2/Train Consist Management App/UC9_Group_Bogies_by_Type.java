import java.util.*;
import java.util.stream.Collectors;

public class UC9_Group_Bogies_by_Type {
    public static void main(String[] args) {
        List<Bogie> bogies = new ArrayList<>();
        
        // Add bogies (including duplicates for grouping)
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 72)); // duplicate for grouping
        
        // Group by type using Collectors.groupingBy
        Map<String, List<Bogie>> grouped = bogies.stream()
            .collect(Collectors.groupingBy(Bogie::getName));
        
        // Display grouped result
        System.out.println("Grouped bogies by type:");
        for (Map.Entry<String, List<Bogie>> entry : grouped.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
import java.util.*;
import java.util.stream.Collectors;

public class UC9_Group_Bogies_by_Type {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("UC9 - Group Bogies by Type");
        System.out.println("========================================");
        System.out.println();

        List<Bogie> bogies = new ArrayList<>();

        // Add bogies including duplicates for grouping (matching expected data)
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("AC Chair", 60));

        System.out.println("All Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b.getName() + " -> " + b.getCapacity());
        }
        System.out.println();

        // Group by bogie name using Collectors.groupingBy
        Map<String, List<Bogie>> grouped = bogies.stream()
            .collect(Collectors.groupingBy(Bogie::getName));

        System.out.println("Grouped Bogies:");
        for (Map.Entry<String, List<Bogie>> entry : grouped.entrySet()) {
            System.out.println();
            System.out.println("Bogie Type: " + entry.getKey());
            for (Bogie b : entry.getValue()) {
                System.out.println("  Capacity -> " + b.getCapacity());
            }
        }
        System.out.println();
        System.out.println("UC9 grouping completed...");
    }
}
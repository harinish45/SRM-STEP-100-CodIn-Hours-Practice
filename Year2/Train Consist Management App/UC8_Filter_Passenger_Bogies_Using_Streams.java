import java.util.*;
import java.util.stream.Collectors;

public class UC8_Filter_Passenger_Bogies_Using_Streams {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("UC8 - Filter Passenger Bogies Using Streams");
        System.out.println("========================================");
        System.out.println();

        List<Bogie> bogies = new ArrayList<>();

        // Add bogies matching expected data
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        System.out.println("All Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b.getName() + " -> " + b.getCapacity());
        }
        System.out.println();

        // Filter bogies with capacity > 60 using Streams
        List<Bogie> filtered = bogies.stream()
            .filter(b -> b.getCapacity() > 60)
            .collect(Collectors.toList());

        System.out.println("Filtered Bogies (Capacity > 60):");
        for (Bogie b : filtered) {
            System.out.println(b.getName() + " -> " + b.getCapacity());
        }
        System.out.println();
        System.out.println("UC8 filtering completed...");
    }
}
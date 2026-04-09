import java.util.*;
import java.util.stream.Collectors;

public class UC8_Filter_Passenger_Bogies_Using_Streams {
    public static void main(String[] args) {
        List<Bogie> bogies = new ArrayList<>();
        
        // Add bogies (reuse from UC7)
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 24));
        
        // Filter bogies with capacity > 60
        List<Bogie> filtered = bogies.stream()
            .filter(b -> b.getCapacity() > 60)
            .collect(Collectors.toList());
        
        // Display filtered bogies
        System.out.println("Filtered bogies (capacity > 60):");
        for (Bogie b : filtered) {
            System.out.println(b);
        }
    }
}
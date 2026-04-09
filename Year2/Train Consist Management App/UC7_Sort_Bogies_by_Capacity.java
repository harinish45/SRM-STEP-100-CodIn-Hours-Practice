import java.util.*;

public class UC7_Sort_Bogies_by_Capacity {
    public static void main(String[] args) {
        List<Bogie> bogies = new ArrayList<>();
        
        // Add bogies
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 24));
        
        // Sort by capacity
        bogies.sort(Comparator.comparingInt(Bogie::getCapacity));
        
        // Display sorted bogies
        System.out.println("Sorted bogies by capacity:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }
    }
}
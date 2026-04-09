import java.util.*;

public class UC10_Count_Total_Seats_in_Train {
    public static void main(String[] args) {
        List<Bogie> bogies = new ArrayList<>();
        
        // Add bogies (reuse from previous UCs)
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 24));
        
        // Calculate total seats using map and reduce
        int totalSeats = bogies.stream()
            .mapToInt(Bogie::getCapacity)
            .reduce(0, Integer::sum);
        
        // Display total seating capacity
        System.out.println("Total seating capacity: " + totalSeats);
    }
}
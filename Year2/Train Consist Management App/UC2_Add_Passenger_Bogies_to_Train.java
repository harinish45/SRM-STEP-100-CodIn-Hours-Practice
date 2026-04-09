import java.util.ArrayList;
import java.util.List;

public class UC2_Add_Passenger_Bogies_to_Train {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        List<String> passengerBogies = new ArrayList<>();
        
        // Add bogies
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");
        
        // Print the list after insertion
        System.out.println("Passenger bogies after insertion: " + passengerBogies);
        
        // Remove one bogie
        passengerBogies.remove("AC Chair");
        
        // Check existence
        if (passengerBogies.contains("Sleeper")) {
            System.out.println("Sleeper exists in the list.");
        }
        
        // Print final list state
        System.out.println("Final passenger bogies: " + passengerBogies);
    }
}
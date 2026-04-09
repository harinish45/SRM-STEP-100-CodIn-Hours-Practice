import java.util.HashSet;
import java.util.Set;

public class UC3_Track_Unique_Bogie_IDs {
    public static void main(String[] args) {
        Set<String> bogieIDs = new HashSet<>();
        
        // Add bogie IDs, including duplicates
        bogieIDs.add("BG101");
        bogieIDs.add("BG102");
        bogieIDs.add("BG101"); // duplicate
        
        // Print the final set
        System.out.println("Unique bogie IDs: " + bogieIDs);
    }
}
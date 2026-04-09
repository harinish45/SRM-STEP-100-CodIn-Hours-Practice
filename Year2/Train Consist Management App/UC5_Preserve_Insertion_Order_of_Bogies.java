import java.util.LinkedHashSet;
import java.util.Set;

public class UC5_Preserve_Insertion_Order_of_Bogies {
    public static void main(String[] args) {
        Set<String> formation = new LinkedHashSet<>();
        
        // Attach bogies
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        
        // Attempt to attach duplicate
        formation.add("Sleeper"); // duplicate
        
        // Display the final formation order
        System.out.println("Final formation order: " + formation);
    }
}
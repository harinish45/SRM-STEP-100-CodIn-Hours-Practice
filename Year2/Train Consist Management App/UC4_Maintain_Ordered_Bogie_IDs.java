import java.util.LinkedList;

public class UC4_Maintain_Ordered_Bogie_IDs {
    public static void main(String[] args) {
        LinkedList<String> consist = new LinkedList<>();
        
        // Add bogies
        consist.add("Engine");
        consist.add("Sleeper");
        consist.add("AC");
        consist.add("Cargo");
        consist.add("Guard");
        
        // Insert Pantry Car at position 2
        consist.add(2, "Pantry Car");
        
        // Remove first and last bogie
        consist.removeFirst();
        consist.removeLast();
        
        // Display the final ordered train consist
        System.out.println("Final ordered train consist: " + consist);
    }
}
import java.util.LinkedList;

public class UC4_Maintain_Ordered_Bogie_IDs {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("UC4 - Maintain Ordered Bogie Consist");
        System.out.println("========================================");
        System.out.println();

        LinkedList<String> consist = new LinkedList<>();

        // Add bogies
        consist.add("Engine");
        consist.add("Sleeper");
        consist.add("AC");
        consist.add("Cargo");
        consist.add("Guard");

        System.out.println("Initial Train Consist:");
        System.out.println(consist);
        System.out.println();

        // Insert Pantry Car at position 2
        consist.add(2, "Pantry Car");

        System.out.println("After Inserting 'Pantry Car' at position 2:");
        System.out.println(consist);
        System.out.println();

        // Remove first and last bogie
        consist.removeFirst();
        consist.removeLast();

        System.out.println("After Removing First and Last Bogie:");
        System.out.println(consist);
        System.out.println();
        System.out.println("UC4 ordered consist operations completed...");
    }
}
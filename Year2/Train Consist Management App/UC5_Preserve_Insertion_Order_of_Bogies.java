import java.util.LinkedHashSet;
import java.util.Set;

public class UC5_Preserve_Insertion_Order_of_Bogies {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("UC5 - Preserve Insertion Order of Bogies");
        System.out.println("========================================");
        System.out.println();

        Set<String> formation = new LinkedHashSet<>();

        // Attach bogies (LinkedHashSet preserves insertion order)
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper"); // duplicate — ignored, order preserved

        System.out.println("Final Train Formation:");
        System.out.println(formation);
        System.out.println();
        System.out.println("Note:");
        System.out.println("LinkedHashSet preserves insertion order and removes duplicates automatically.");
        System.out.println();
        System.out.println("UC5 formation setup completed...");
    }
}
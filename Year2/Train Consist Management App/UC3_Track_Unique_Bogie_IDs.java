import java.util.HashSet;
import java.util.Set;

public class UC3_Track_Unique_Bogie_IDs {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("UC3 - Track Unique Bogie IDs");
        System.out.println("========================================");
        System.out.println();

        Set<String> bogieIDs = new HashSet<>();

        // Add bogie IDs, including duplicates
        bogieIDs.add("BG101");
        bogieIDs.add("BG102");
        bogieIDs.add("BG103");
        bogieIDs.add("BG104");
        bogieIDs.add("BG101"); // duplicate — ignored by HashSet
        bogieIDs.add("BG102"); // duplicate — ignored by HashSet

        System.out.println("Bogie IDs After Insertion:");
        System.out.println(bogieIDs);
        System.out.println();
        System.out.println("Note:");
        System.out.println("Duplicates are automatically ignored by HashSet.");
        System.out.println();
        System.out.println("UC3 uniqueness validation completed...");
    }
}
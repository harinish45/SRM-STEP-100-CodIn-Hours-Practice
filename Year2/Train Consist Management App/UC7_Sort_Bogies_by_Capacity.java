import java.util.*;

public class UC7_Sort_Bogies_by_Capacity {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("UC7 - Sort Bogies by Capacity (Comparator)");
        System.out.println("========================================");
        System.out.println();

        List<Bogie> bogies = new ArrayList<>();

        // Add bogies matching expected data
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        System.out.println("Before Sorting:");
        for (Bogie b : bogies) {
            System.out.println(b.getName() + " -> " + b.getCapacity());
        }
        System.out.println();

        // Sort by capacity ascending using Comparator
        bogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        System.out.println("After Sorting by Capacity:");
        for (Bogie b : bogies) {
            System.out.println(b.getName() + " -> " + b.getCapacity());
        }
        System.out.println();
        System.out.println("UC7 sorting completed...");
    }
}
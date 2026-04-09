import java.util.*;

public class UC10_Count_Total_Seats_in_Train {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("UC10 - Count Total Seats in Train");
        System.out.println("========================================");
        System.out.println();

        List<Bogie> bogies = new ArrayList<>();

        // Add bogies matching expected data (total = 72 + 56 + 24 + 70 = 222)
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));

        System.out.println("Bogies in Train:");
        for (Bogie b : bogies) {
            System.out.println(b.getName() + " -> " + b.getCapacity());
        }
        System.out.println();

        // Calculate total seats using mapToInt and reduce
        int totalSeats = bogies.stream()
            .mapToInt(Bogie::getCapacity)
            .reduce(0, Integer::sum);

        System.out.println("Total Seating Capacity of Train: " + totalSeats);
        System.out.println();
        System.out.println("UC10 aggregation completed...");
    }
}
import java.util.*;

public class UC12_Safety_Compliance_Check_for_Goods_Bogies {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("UC12 - Safety Compliance Check for Goods Bogies");
        System.out.println("========================================");
        System.out.println();

        List<GoodsBogie> bogies = new ArrayList<>();

        // Add goods bogies matching expected data
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Open", "Coal"));
        bogies.add(new GoodsBogie("Box", "Grain"));
        bogies.add(new GoodsBogie("Cylindrical", "Coal")); // unsafe: Cylindrical must carry Petroleum

        System.out.println("Goods Bogies in Train:");
        for (GoodsBogie b : bogies) {
            System.out.println(b.getType() + " -> " + b.getCargo());
        }
        System.out.println();

        // Safety rule: Cylindrical bogies must only carry Petroleum
        boolean isSafe = bogies.stream()
            .allMatch(b -> {
                if ("Cylindrical".equals(b.getType())) {
                    return "Petroleum".equals(b.getCargo());
                }
                return true; // other types allow any cargo
            });

        System.out.println("Safety Compliance Status: " + isSafe);
        if (isSafe) {
            System.out.println("Train formation is SAFE.");
        } else {
            System.out.println("Train formation is NOT SAFE.");
        }
        System.out.println();
        System.out.println("UC12 safety validation completed...");
    }
}
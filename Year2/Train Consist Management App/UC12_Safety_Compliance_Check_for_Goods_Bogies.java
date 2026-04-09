import java.util.*;

public class UC12_Safety_Compliance_Check_for_Goods_Bogies {
    public static void main(String[] args) {
        List<GoodsBogie> bogies = new ArrayList<>();
        
        // Add goods bogies
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Rectangular", "Coal"));
        bogies.add(new GoodsBogie("Cylindrical", "Grain")); // invalid for safety
        
        // Check safety compliance using allMatch
        boolean isSafe = bogies.stream()
            .allMatch(b -> {
                if ("Cylindrical".equals(b.getType())) {
                    return "Petroleum".equals(b.getCargo());
                }
                return true; // other types allow any cargo
            });
        
        // Display result
        System.out.println("Train is " + (isSafe ? "safe" : "unsafe"));
    }
}
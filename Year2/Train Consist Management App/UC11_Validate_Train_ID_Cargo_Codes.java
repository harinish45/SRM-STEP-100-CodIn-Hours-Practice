import java.util.regex.*;

public class UC11_Validate_Train_ID_Cargo_Codes {
    public static void main(String[] args) {
        // Define regex patterns
        Pattern trainIdPattern = Pattern.compile("TRN-\\d{4}");
        Pattern cargoCodePattern = Pattern.compile("PET-[A-Z]{2}");
        
        // Example inputs for validation
        String[] trainIds = {"TRN-1234", "TRAIN12", "TRN12A", "1234-TRN", "TRN-123", "TRN-12345"};
        String[] cargoCodes = {"PET-AB", "PET-ab", "PET123", "AB-PET", "PET-A", "PET-ABC"};
        
        // Validate Train IDs
        System.out.println("Train ID Validation:");
        for (String id : trainIds) {
            Matcher matcher = trainIdPattern.matcher(id);
            System.out.println("Train ID '" + id + "' is " + (matcher.matches() ? "valid" : "invalid"));
        }
        
        // Validate Cargo Codes
        System.out.println("\nCargo Code Validation:");
        for (String code : cargoCodes) {
            Matcher matcher = cargoCodePattern.matcher(code);
            System.out.println("Cargo Code '" + code + "' is " + (matcher.matches() ? "valid" : "invalid"));
        }
    }
}
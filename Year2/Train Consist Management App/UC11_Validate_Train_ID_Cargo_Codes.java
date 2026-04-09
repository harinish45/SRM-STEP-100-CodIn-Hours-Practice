import java.util.Scanner;
import java.util.regex.*;

public class UC11_Validate_Train_ID_Cargo_Codes {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("UC11 - Validate Train ID and Cargo Code");
        System.out.println("========================================");
        System.out.println();

        // Define regex patterns
        Pattern trainIdPattern = Pattern.compile("TRN-\\d{4}");
        Pattern cargoCodePattern = Pattern.compile("PET-[A-Z]{2}");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine().trim();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine().trim();

        // Validate inputs
        boolean isTrainIdValid = trainIdPattern.matcher(trainId).matches();
        boolean isCargoCodeValid = cargoCodePattern.matcher(cargoCode).matches();

        System.out.println();
        System.out.println("Validation Results:");
        System.out.println("Train ID Valid: " + isTrainIdValid);
        System.out.println("Cargo Code Valid: " + isCargoCodeValid);
        System.out.println();
        System.out.println("UC11 validation completed...");

        scanner.close();
    }
}
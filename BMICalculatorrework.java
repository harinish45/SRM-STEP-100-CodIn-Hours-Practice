import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take the number of persons as input
        System.out.print("Enter the number of persons: ");
        int n = scanner.nextInt();

        // Create a 2D array to store height, weight, and BMI for each person
        double[][] personData = new double[n][3]; // personData[i][0] = height, personData[i][1] = weight, personData[i][2] = BMI
        String[] weightStatus = new String[n]; // To store the weight status for each person

        // Take input for height and weight of each person
        for (int i = 0; i < n; i++) {
            System.out.print("Enter height (in meters) for person " + (i + 1) + ": ");
            personData[i][0] = getValidHeight(scanner);
            
            System.out.print("Enter weight (in kg) for person " + (i + 1) + ": ");
            personData[i][1] = getValidWeight(scanner);

            // Calculate BMI and store it in the 2D array at index 2
            personData[i][2] = personData[i][1] / (personData[i][0] * personData[i][0]);

            // Determine the weight status based on BMI
            if (personData[i][2] <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (personData[i][2] <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // Display the height, weight, BMI, and status of each person
        System.out.println("\nPerson Data:");
        System.out.printf("%-15s %-15s %-15s %-15s\n", "Height(m)", "Weight(kg)", "BMI", "Status");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-15.2f %-15.2f %-15.2f %-15s\n", personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }

        scanner.close();
    }

    // Function to get valid weight input
    public static double getValidWeight(Scanner scanner) {
        double weight = -1;
        while (weight <= 0) {
            if (scanner.hasNextDouble()) {
                weight = scanner.nextDouble();
                if (weight <= 0) {
                    System.out.println("Error: Weight must be a positive number. Please enter again.");
                }
            } else {
                System.out.println("Error: Invalid input. Please enter a valid weight.");
                scanner.next(); // clear invalid input
            }
        }
        return weight;
    }

    // Function to get valid height input
    public static double getValidHeight(Scanner scanner) {
        double height = -1;
        while (height <= 0) {
            if (scanner.hasNextDouble()) {
                height = scanner.nextDouble();
                if (height <= 0) {
                    System.out.println("Error: Height must be a positive number. Please enter again.");
                }
            } else {
                System.out.println("Error: Invalid input. Please enter a valid height.");
                scanner.next(); // clear invalid input
            }
        }
        return height;
    }
}

import java.util.Scanner;

public class TriangularParkRun {
    public static double calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        return 5000 / perimeter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first side of the triangular park (in meters): ");
        double side1 = scanner.nextDouble();
        System.out.print("Enter the second side of the triangular park (in meters): ");
        double side2 = scanner.nextDouble();
        System.out.print("Enter the third side of the triangular park (in meters): ");
        double side3 = scanner.nextDouble();
        
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            System.out.println("Sides must be positive values.");
        } else {
            double rounds = calculateRounds(side1, side2, side3);
            System.out.println("The athlete needs to complete " + Math.ceil(rounds) + " rounds to cover 5 km.");
        }
        
        scanner.close();
    }
}
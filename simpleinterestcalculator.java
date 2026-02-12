import java.util.Scanner;

public class SimpleInterestCalculator {
    // Method to calculate Simple Interest
    public static double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Taking user input
        System.out.print("Enter Principal amount: ");
        double principal = scanner.nextDouble();
        
        System.out.print("Enter Rate of Interest: ");
        double rate = scanner.nextDouble();
        
        System.out.print("Enter Time (in years): ");
        double time = scanner.nextDouble();
        
        // Calculating simple interest
        double simpleInterest = calculateSimpleInterest(principal, rate, time);
        
        // Displaying the result
        System.out.println("The Simple Interest is " + simpleInterest + " for Principal " + principal + ", Rate of Interest " + rate + " and Time " + time);
        
        scanner.close();
    }
}

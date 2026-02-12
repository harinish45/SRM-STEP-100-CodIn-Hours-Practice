Here's the same program without comments:

```java
import java.util.Scanner;

public class ZaraBonusCalculation {

    public static void main(String[] args) {
        double[] oldSalary = new double[10];
        double[] yearsOfService = new double[10];
        double[] bonus = new double[10];
        double[] newSalary = new double[10];
        
        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        
        Scanner scanner = new Scanner(System.in);
        
        for (int i = 0; i < oldSalary.length; i++) {
            System.out.println("Enter the old salary for employee " + (i + 1) + ": ");
            oldSalary[i] = getValidSalary(scanner);
            
            System.out.println("Enter the years of service for employee " + (i + 1) + ": ");
            yearsOfService[i] = getValidYearsOfService(scanner);
            
            if (yearsOfService[i] > 5) {
                bonus[i] = oldSalary[i] * 0.05;
            } else {
                bonus[i] = oldSalary[i] * 0.02;
            }
            
            newSalary[i] = oldSalary[i] + bonus[i];
            
            totalBonus += bonus[i];
            totalOldSalary += oldSalary[i];
            totalNewSalary += newSalary[i];
        }
        
        System.out.println("\nTotal bonus payout: " + totalBonus);
        System.out.println("Total old salary payout: " + totalOldSalary);
        System.out.println("Total new salary payout: " + totalNewSalary);
        
        scanner.close();
    }
    
    public static double getValidSalary(Scanner scanner) {
        double salary = -1;
        while (salary <= 0) {
            if (scanner.hasNextDouble()) {
                salary = scanner.nextDouble();
                if (salary <= 0) {
                    System.out.println("Error: Salary must be a positive number. Please enter again: ");
                }
            } else {
                System.out.println("Error: Invalid input. Please enter a valid salary number: ");
                scanner.next();
            }
        }
        return salary;
    }

    public static double getValidYearsOfService(Scanner scanner) {
        double years = -1;
        while (years < 0) {
            if (scanner.hasNextDouble()) {
                years = scanner.nextDouble();
                if (years < 0) {
                    System.out.println("Error: Years of service cannot be negative. Please enter again: ");
                }
            } else {
                System.out.println("Error: Invalid input. Please enter a valid number of years: ");
                scanner.next();
            }
        }
        return years;
    }
}
```
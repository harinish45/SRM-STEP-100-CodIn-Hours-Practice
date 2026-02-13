import java.util.Scanner;

public class YoungestAndTallest {

    public static void main(String[] args) {
        String[] friends = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];
        
        Scanner scanner = new Scanner(System.in);
        
        for (int i = 0; i < friends.length; i++) {
            System.out.println("Enter age of " + friends[i] + ": ");
            ages[i] = getValidAge(scanner);
            
            System.out.println("Enter height of " + friends[i] + ": ");
            heights[i] = getValidHeight(scanner);
        }
        
        int youngestIndex = 0;
        int tallestIndex = 0;
        
        for (int i = 1; i < friends.length; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }
        
        System.out.println("\nThe youngest friend is: " + friends[youngestIndex]);
        System.out.println("The tallest friend is: " + friends[tallestIndex]);
        
        scanner.close();
    }
    
    public static int getValidAge(Scanner scanner) {
        int age = -1;
        while (age <= 0) {
            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
                if (age <= 0) {
                    System.out.println("Error: Age must be a positive number. Please enter again: ");
                }
            } else {
                System.out.println("Error: Invalid input. Please enter a valid age: ");
                scanner.next(); // clear invalid input
            }
        }
        return age;
    }

    public static double getValidHeight(Scanner scanner) {
        double height = -1;
        while (height <= 0) {
            if (scanner.hasNextDouble()) {
                height = scanner.nextDouble();
                if (height <= 0) {
                    System.out.println("Error: Height must be a positive number. Please enter again: ");
                }
            } else {
                System.out.println("Error: Invalid input. Please enter a valid height: ");
                scanner.next(); // clear invalid input
            }
        }
        return height;
    }
}

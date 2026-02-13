import java.util.Scanner;

public class BMI_INDEX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = new String[10];
        double[] height = new double[10]; // in meters
        double[] weight = new double[10]; // in kg
        double[] bmi = new double[10];
        String[] status = new String[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter name of member " + (i + 1) + ": ");
            names[i] = sc.next();
            System.out.print("Enter height (m) of " + names[i] + ": ");
            height[i] = sc.nextDouble();
            System.out.print("Enter weight (kg) of " + names[i] + ": ");
            weight[i] = sc.nextDouble();

            bmi[i] = weight[i] / (height[i] * height[i]);

            if (bmi[i] <= 18.4) status[i] = "Underweight";
            else if (bmi[i] <= 24.9) status[i] = "Normal";
            else if (bmi[i] <= 39.9) status[i] = "Overweight";
            else status[i] = "Obese";
        }

        System.out.println("\nBMI Report");
        System.out.println("Name\tHeight\tWeight\tBMI\tStatus");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s\t%.2f\t%.2f\t%.2f\t%s%n", names[i], height[i], weight[i], bmi[i], status[i]);
        }
        sc.close();
    }
}

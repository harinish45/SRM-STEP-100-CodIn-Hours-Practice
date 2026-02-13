import java.util.Scanner;

public class LineCalculator {
    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static double[] calculateLineEquation(double x1, double y1, double x2, double y2) {
        double[] result = new double[2];
        double slope = (y2 - y1) / (x2 - x1);
        double intercept = y1 - slope * x1;
        result[0] = slope;
        result[1] = intercept;
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter x1: ");
        double x1 = sc.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = sc.nextDouble();
        System.out.print("Enter x2: ");
        double x2 = sc.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = sc.nextDouble();

        double distance = calculateDistance(x1, y1, x2, y2);
        double[] line = calculateLineEquation(x1, y1, x2, y2);

        System.out.println("\n------------ Result ------------");
        System.out.printf("Euclidean Distance      : %.2f\n", distance);
        System.out.printf("Slope (m)               : %.2f\n", line[0]);
        System.out.printf("Y-Intercept (b)         : %.2f\n", line[1]);
        System.out.printf("Line Equation           : y = %.2fx + %.2f\n", line[0], line[1]);
        System.out.println("--------------------------------");
    }
}

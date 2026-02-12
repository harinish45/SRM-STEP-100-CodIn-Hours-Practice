import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        int[] physics = new int[n];
        int[] chemistry = new int[n];
        int[] maths = new int[n];
        double[] percentage = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter marks for student " + (i + 1) + ":");
            
            System.out.print("Physics: ");
            physics[i] = scanner.nextInt();
            if (physics[i] < 0) { i--; continue; }

            System.out.print("Chemistry: ");
            chemistry[i] = scanner.nextInt();
            if (chemistry[i] < 0) { i--; continue; }

            System.out.print("Maths: ");
            maths[i] = scanner.nextInt();
            if (maths[i] < 0) { i--; continue; }

            percentage[i] = (physics[i] + chemistry[i] + maths[i]) / 3.0;

            if (percentage[i] >= 80) {
                grade[i] = 'A';
            } else if (percentage[i] >= 70) {
                grade[i] = 'B';
            } else if (percentage[i] >= 60) {
                grade[i] = 'C';
            } else if (percentage[i] >= 50) {
                grade[i] = 'D';
            } else if (percentage[i] >= 40) {
                grade[i] = 'E';
            } else {
                grade[i] = 'R';
            }
        }

        System.out.println("\nStudent Data:");
        System.out.printf("%-10s %-10s %-10s %-15s %-10s %-10s\n", "Physics", "Chemistry", "Maths", "Percentage", "Grade");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-10d %-10d %-10d %-15.2f %-10c\n", physics[i], chemistry[i], maths[i], percentage[i], grade[i]);
        }

        scanner.close();
    }
}
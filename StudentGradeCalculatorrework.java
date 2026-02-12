import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for the number of students
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        // 2D array to store marks (rows are students, columns are subjects)
        int[][] marks = new int[n][3]; // marks[i][0] = physics, marks[i][1] = chemistry, marks[i][2] = maths
        double[] percentage = new double[n]; // To store percentage for each student
        char[] grade = new char[n]; // To store grade for each student

        // Taking input for each student's marks
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter marks for student " + (i + 1) + ":");

            // Input marks for physics, chemistry, and maths for each student
            System.out.print("Physics: ");
            marks[i][0] = scanner.nextInt();
            if (marks[i][0] < 0) { i--; continue; }

            System.out.print("Chemistry: ");
            marks[i][1] = scanner.nextInt();
            if (marks[i][1] < 0) { i--; continue; }

            System.out.print("Maths: ");
            marks[i][2] = scanner.nextInt();
            if (marks[i][2] < 0) { i--; continue; }

            // Calculate percentage
            percentage[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;

            // Determine grade based on percentage
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

        // Display the results
        System.out.println("\nStudent Data:");
        System.out.printf("%-10s %-10s %-10s %-15s %-10s %-10s\n", "Physics", "Chemistry", "Maths", "Percentage", "Grade");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-10d %-10d %-10d %-15.2f %-10c\n", marks[i][0], marks[i][1], marks[i][2], percentage[i], grade[i]);
        }

        scanner.close();
    }
}

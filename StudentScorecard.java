import java.util.Scanner;

public class StudentScorecard {

    public static int[][] generatePCM(int n) {
        int[][] pcm = new int[n][3];
        for (int i = 0; i < n; i++) {
            pcm[i][0] = (int)(Math.random() * 100); // Physics
            pcm[i][1] = (int)(Math.random() * 100); // Chemistry
            pcm[i][2] = (int)(Math.random() * 100); // Math
        }
        return pcm;
    }

    public static double[][] calculateScores(int[][] pcm) {
        int n = pcm.length;
        double[][] result = new double[n][3]; // [Total, Average, Percentage]

        for (int i = 0; i < n; i++) {
            int total = pcm[i][0] + pcm[i][1] + pcm[i][2];
            double avg = total / 3.0;
            double percent = (total / 300.0) * 100;

            result[i][0] = total;
            result[i][1] = Math.round(avg * 100.0) / 100.0;
            result[i][2] = Math.round(percent * 100.0) / 100.0;
        }
        return result;
    }

    public static String getGrade(double percent) {
        if (percent >= 80) return "A";
        else if (percent >= 70) return "B";
        else if (percent >= 60) return "C";
        else if (percent >= 50) return "D";
        else if (percent >= 40) return "E";
        else return "R";
    }

    public static void displayScorecard(int[][] pcm, double[][] scores) {
        System.out.println("ID\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercent\tGrade");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < pcm.length; i++) {
            double percent = scores[i][2];
            String grade = getGrade(percent);

            System.out.println((i + 1) + "\t" + pcm[i][0] + "\t" + pcm[i][1] + "\t\t" +
                pcm[i][2] + "\t" + (int)scores[i][0] + "\t" + scores[i][1] + "\t" +
                scores[i][2] + "\t" + grade);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] pcm = generatePCM(n);
        double[][] scores = calculateScores(pcm);
        displayScorecard(pcm, scores);
    }
}

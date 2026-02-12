import java.util.Random;

public class VotingEligibility {
    public static int[] generateAges(int n) {
        Random rand = new Random();
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            ages[i] = rand.nextInt(100); // Random age between 0 and 99
        }
        return ages;
    }

    public static String[][] checkEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            result[i][1] = (ages[i] >= 18) ? "Can Vote" : "Cannot Vote";
        }
        return result;
    }

    public static void displayEligibility(String[][] data) {
        System.out.printf("%-10s%-15s%n", "Age", "Eligibility");
        for (String[] row : data) {
            System.out.printf("%-10s%-15s%n", row[0], row[1]);
        }
    }

    public static void main(String[] args) {
        int[] ages = generateAges(10);
        String[][] eligibility = checkEligibility(ages);
        displayEligibility(eligibility);
    }
}




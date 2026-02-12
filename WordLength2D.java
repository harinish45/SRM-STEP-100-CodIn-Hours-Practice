import java.util.Scanner;

public class WordLength2D {
    public static int customLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
            // do nothing
        }
        return count;
    }

    public static String[][] wordsWithLength(String text) {
        String[] words = text.split(" ");
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(customLength(words[i]));
        }
        return result;
    }

    public static void displayTable(String[][] data) {
        System.out.printf("%-15s%-10s%n", "Word", "Length");
        for (String[] row : data) {
            System.out.printf("%-15s%-10s%n", row[0], row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        String[][] wordLengths = wordsWithLength(input);
        displayTable(wordLengths);
    }
}

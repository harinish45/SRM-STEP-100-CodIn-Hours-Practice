import java.util.Scanner;

public class VowelConsonantTable {
    public static String checkCharType(char ch) {
        if (ch >= 'A' && ch <= 'Z') ch = (char)(ch + 32);
        if (ch >= 'a' && ch <= 'z') {
            if (ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') return "Vowel";
            else return "Consonant";
        }
        return "Not a Letter";
    }

    public static String[][] charWithType(String str) {
        String[][] table = new String[str.length()][2];
        for (int i = 0; i < str.length(); i++) {
            table[i][0] = String.valueOf(str.charAt(i));
            table[i][1] = checkCharType(str.charAt(i));
        }
        return table;
    }

    public static void displayTable(String[][] arr) {
        System.out.println("Character\tType");
        for (String[] row : arr) {
            System.out.println(row[0] + "\t\t" + row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        displayTable(charWithType(input));
    }
}

import java.util.Scanner;

public class CharacterTypeDisplay {
    public static String getCharType(char ch) {
        if (Character.isLetter(ch)) {
            ch = Character.toLowerCase(ch);
            if ("aeiou".indexOf(ch) != -1) {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "Not a Letter";
        }
    }

    public static void displayCharTypes(String text) {
        System.out.printf("%-10s%-15s%n", "Character", "Type");
        for (char ch : text.toCharArray()) {
            System.out.printf("%-10s%-15s%n", ch, getCharType(ch));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        displayCharTypes(input);
    }
}
import java.util.Scanner;

public class CustomTrim {
    public static String trimSpaces(String text) {
        int start = 0, end = text.length() - 1;

        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }

        StringBuilder trimmed = new StringBuilder();
        for (int i = start; i <= end; i++) {
            trimmed.append(text.charAt(i));
        }
        return trimmed.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string with spaces: ");
        String input = sc.nextLine();

        String customTrimmed = trimSpaces(input);
        String builtInTrimmed = input.trim();

        System.out.println("Custom Trimmed: \"" + customTrimmed + "\"");
        System.out.println("Built-in Trimmed: \"" + builtInTrimmed + "\"");
        System.out.println("Are both equal? " + customTrimmed.equals(builtInTrimmed));
    }
}

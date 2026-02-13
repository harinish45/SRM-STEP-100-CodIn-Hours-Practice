import java.util.Scanner;


public class CaseConverter {
    public static char toUpperCase(char c) {
        if (c >= 'a' && c <= 'z') {
            return (char) (c - 32);
        }
        return c;
    }
   
    public static char toLowerCase(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) (c + 32);
        }
        return c;
    }


    public static String toTitleCase(String input) {
        StringBuilder result = new StringBuilder();
        boolean newWord = true;


        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                if (newWord) {
                    result.append(toUpperCase(c));
                    newWord = false;
                } else {
                    result.append(toLowerCase(c));
                }
            } else {
                result.append(c);
                newWord = true;
            }
        }
        return result.toString();
    }


    public static void compareWithBuiltInMethods(String input) {
        String builtInUpper = input.toUpperCase();
        String builtInLower = input.toLowerCase();
        String builtInTitle = toTitleCase(input);


        System.out.printf("| %-20s | %-20s | %-20s | %-20s |\n", input, builtInUpper, builtInLower, builtInTitle);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();


        System.out.println("\n| Original Text       | Uppercase (Built-in) | Lowercase (Built-in) | Title Case (Built-in) |");
        System.out.println("|---------------------|----------------------|----------------------|-----------------------|");
        compareWithBuiltInMethods(input);


        scanner.close();
    }
}



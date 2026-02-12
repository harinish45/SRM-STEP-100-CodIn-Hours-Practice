import java.util.Scanner;

public class SubstringCompare {
    public static String substringUsingCharAt(String str, int start, int end) {
        String result = "";
        for (int i = start; i < end && i < str.length(); i++) {
            result += str.charAt(i);
        }
        return result;
    }

    public static boolean compareUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String text = sc.nextLine();
        System.out.print("Enter start index: ");
        int start = sc.nextInt();
        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        String manualSub = substringUsingCharAt(text, start, end);
        String builtInSub = text.substring(start, end);
        boolean isEqual = compareUsingCharAt(manualSub, builtInSub);

        System.out.println("Manual Substring: " + manualSub);
        System.out.println("Built-in Substring: " + builtInSub);
        System.out.println("Are both substrings equal? " + isEqual);
    }
}

import java.util.Scanner;

public class PalindromeCheck {

    static boolean isPalindrome1(String text) {
        int start = 0, end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start++) != text.charAt(end--)) return false;
        }
        return true;
    }

    static boolean isPalindrome2(String text, int start, int end) {
        if (start >= end) return true;
        if (text.charAt(start) != text.charAt(end)) return false;
        return isPalindrome2(text, start + 1, end - 1);
    }

    static boolean isPalindrome3(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            reversed[i] = text.charAt(text.length() - 1 - i);
        }
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.println("Logic 1 (Two pointers): " + isPalindrome1(text));
        System.out.println("Logic 2 (Recursion): " + isPalindrome2(text, 0, text.length() - 1));
        System.out.println("Logic 3 (Reverse char array): " + isPalindrome3(text));
    }
}

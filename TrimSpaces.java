import java.util.Scanner;

public class TrimSpaces {
    public static int[] findTrimIndexes(String str) {
        int start = 0, end = 0, len = str.length();
        // Find first non-space
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) != ' ') {
                start = i;
                break;
            }
        }
        // Find last non-space
        for (int i = len - 1; i >= 0; i--) {
            if (str.charAt(i) != ' ') {
                end = i;
                break;
            }
        }
        return new int[]{start, end};
    }

    public static String customSubstring(String str, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static boolean compareStrings(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text with spaces: ");
        String input = sc.nextLine();

        int[] indexes = findTrimIndexes(input);

import java.util.Scanner;

public class StringLength {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();

        int customLen = customLength(input);
        int builtInLen = input.length();

        System.out.println("Custom Length: " + customLen);
        System.out.println("Built-in Length: " + builtInLen);
    }
}

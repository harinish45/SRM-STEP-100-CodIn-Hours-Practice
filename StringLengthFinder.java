import java.util.Scanner;


public class StringLengthFinder {
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter a string: ");
        String input = scanner.next();


        int customLength = findLength(input);
        int builtinLength = input.length();


        System.out.println("Length found by custom method: " + customLength);
        System.out.println("Length found by built-in length(): " + builtinLength);


        scanner.close();
    }
}



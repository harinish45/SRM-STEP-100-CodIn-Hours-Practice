import java.util.Scanner;
import java.util.Arrays;

public class 


 {
    public static char[] customToCharArray(String str) {
        char[] arr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        return arr;
    }

    public static boolean compareCharArrays(char[] a, char[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        char[] manualArray = customToCharArray(input);
        char[] builtInArray = input.toCharArray();

        System.out.println("Manual: " + Arrays.toString(manualArray));
        System.out.println("Built-in: " + Arrays.toString(builtInArray));
        System.out.println("Are both equal? " + compareCharArrays(manualArray, builtInArray));
    }
}


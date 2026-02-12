import java.util.Scanner;

public class IllegalArgumentDemo {
    public static void generateException(String str) {
        System.out.println(str.substring(5, 2));
    }

    public static void handleException(String str) {
        try {
            System.out.println(str.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        //generateException(text); // Uncomment to see exception
        handleException(text);
    }
}

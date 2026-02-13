import java.util.Scanner;
public class ArrayIndexDemo {
    public static void generateException(String[] arr, int index) {
        System.out.println(arr[index]);
    }

    public static void handleException(String[] arr, int index) {
        try {
            System.out.println(arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {"Alice", "Bob", "Charlie"};
        int index = sc.nextInt();
        //generateException(names, index); // Uncomment to see exception
        handleException(names, index);
    }
}

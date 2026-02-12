import java.util.Scanner;

public class HandshakeCalculator {
    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        
        if (n < 2) {
            System.out.println("At least two students are needed for a handshake.");
        } else {
            int maxHandshakes = calculateHandshakes(n);
            System.out.println("The maximum number of handshakes among " + n + " students is " + maxHandshakes);
        }
        
        scanner.close();
    }
}

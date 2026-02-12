import java.util.Scanner;

public class FactorOperations {
    static int[] findFactors(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) count++;
        }
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                factors[index] = i;
                index++;
            }
        }
        return factors;
    }

    static int sum(int[] arr) {
        int s = 0;
        for (int i : arr) s += i;
        return s;
    }

    static int product(int[] arr) {
        int p = 1;
        for (int i : arr) p *= i;
        return p;
    }

    static int sumOfSquares(int[] arr) {
        int s = 0;
        for (int i : arr) s += Math.pow(i, 2);
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int[] factors = findFactors(num);
        System.out.print("Factors: ");
        for (int f : factors) System.out.print(f + " ");
        System.out.println();
        System.out.println("Sum of factors: " + sum(factors));
        System.out.println("Product of factors: " + product(factors));
        System.out.println("Sum of squares of factors: " + sumOfSquares(factors));
    }
}













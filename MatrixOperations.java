import java.util.Random;
import java.util.Scanner;

public class MatrixOperations {

    // Method to generate a random matrix
    public static int[][] generateMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = rand.nextInt(10); // random number between 0-9
        return matrix;
    }

    // Method to display any matrix
    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row)
                System.out.print(val + "\t");
            System.out.println();
        }
        System.out.println();
    }

    public static void displayMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row)
                System.out.printf("%.2f\t", val);
            System.out.println();
        }
        System.out.println();
    }

    // Matrix addition
    public static int[][] addMatrix(int[][] A, int[][] B) {
        int[][] result = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                result[i][j] = A[i][j] + B[i][j];
        return result;
    }

    // Matrix subtraction
    public static int[][] subtractMatrix(int[][] A, int[][] B) {
        int[][] result = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                result[i][j] = A[i][j] - B[i][j];
        return result;
    }

    // Matrix multiplication
    public static int[][] multiplyMatrix(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < B[0].length; j++)
                for (int k = 0; k < A[0].length; k++)
                    result[i][j] += A[i][k] * B[k][j];
        return result;
    }

    // Transpose of a matrix
    public static int[][] transposeMatrix(int[][] A) {
        int[][] result = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                result[j][i] = A[i][j];
        return result;
    }

    // Determinant of 2x2
    public static int determinant2x2(int[][] A) {
        return A[0][0] * A[1][1] - A[0][1] * A[1][0];
    }

    // Determinant of 3x3
    public static int determinant3x3(int[][] A) {
        return A[0][0]*(A[1][1]*A[2][2]-A[1][2]*A[2][1])
             - A[0][1]*(A[1][0]*A[2][2]-A[1][2]*A[2][0])
             + A[0][2]*(A[1][0]*A[2][1]-A[1][1]*A[2][0]);
    }

    // Inverse of 2x2
    public static double[][] inverse2x2(int[][] A) {
        int det = determinant2x2(A);
        if (det == 0)
            return null;

        double[][] inv = new double[2][2];
        inv[0][0] = A[1][1] / (double) det;
        inv[0][1] = -A[0][1] / (double) det;
        inv[1][0] = -A[1][0] / (double) det;
        inv[1][1] = A[0][0] / (double) det;
        return inv;
    }

    // Inverse of 3x3
    public static double[][] inverse3x3(int[][] A) {
        int det = determinant3x3(A);
        if (det == 0)
            return null;

        double[][] inv = new double[3][3];
        inv[0][0] = (A[1][1]*A[2][2]-A[1][2]*A[2][1]) / (double) det;
        inv[0][1] = -(A[0][1]*A[2][2]-A[0][2]*A[2][1]) / (double) det;
        inv[0][2] = (A[0][1]*A[1][2]-A[0][2]*A[1][1]) / (double) det;

        inv[1][0] = -(A[1][0]*A[2][2]-A[1][2]*A[2][0]) / (double) det;
        inv[1][1] = (A[0][0]*A[2][2]-A[0][2]*A[2][0]) / (double) det;
        inv[1][2] = -(A[0][0]*A[1][2]-A[0][2]*A[1][0]) / (double) det;

        inv[2][0] = (A[1][0]*A[2][1]-A[1][1]*A[2][0]) / (double) det;
        inv[2][1] = -(A[0][0]*A[2][1]-A[0][1]*A[2][0]) / (double) det;
        inv[2][2] = (A[0][0]*A[1][1]-A[0][1]*A[1][0]) / (double) det;

        return inv;
    }

    // MAIN METHOD
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows and columns for matrix: ");
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] A = generateMatrix(rows, cols);
        int[][] B = generateMatrix(rows, cols);

        System.out.println("Matrix A:");
        displayMatrix(A);
        System.out.println("Matrix B:");
        displayMatrix(B);

        System.out.println("Addition:");
        displayMatrix(addMatrix(A, B));

        System.out.println("Subtraction:");
        displayMatrix(subtractMatrix(A, B));

        if (A[0].length == B.length) {
            System.out.println("Multiplication:");
            displayMatrix(multiplyMatrix(A, B));
        } else {
            System.out.println("Cannot multiply A and B due to dimension mismatch.");
        }

        System.out.println("Transpose of Matrix A:");
        displayMatrix(transposeMatrix(A));

        if (rows == 2 && cols == 2) {
            System.out.println("Determinant of A (2x2): " + determinant2x2(A));
            double[][] inv = inverse2x2(A);
            if (inv != null) {
                System.out.println("Inverse of A:");
                displayMatrix(inv);
            } else {
                System.out.println("Inverse does not exist (Determinant = 0)");
            }
        }

        if (rows == 3 && cols == 3) {
            System.out.println("Determinant of A (3x3): " + determinant3x3(A));
            double[][] inv = inverse3x3(A);
            if (inv != null) {
                System.out.println("Inverse of A:");
                displayMatrix(inv);
            } else {
                System.out.println("Inverse does not exist (Determinant = 0)");
            }
        }

        sc.close();
    }
}

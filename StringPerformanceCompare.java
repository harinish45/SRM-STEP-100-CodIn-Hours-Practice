import java.util.Scanner;

public class StringPerformanceCompare {

    // String Concatenation using +
    public static long stringConcatTest(int iterations) {
        long start = System.currentTimeMillis();
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result += "abc";
        }
        long end = System.currentTimeMillis();
        System.out.println("Final length (String): " + result.length());
        return end - start;
    }

    // StringBuilder test
    public static long stringBuilderTest(int iterations) {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("abc");
        }
        long end = System.currentTimeMillis();
        System.out.println("Final length (StringBuilder): " + sb.length());
        return end - start;
    }

    // StringBuffer test
    public static long stringBufferTest(int iterations) {
        long start = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append("abc");
        }
        long end = System.currentTimeMillis();
        System.out.println("Final length (StringBuffer): " + sbf.length());
        return end - start;
    }

    // Display results in a tabular format
    public static void displayResults(long concatTime, long builderTime, long bufferTime) {
        System.out.println("\nPerformance Comparison:");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-20s %-20s %-20s%n", "Method", "Time (ms)", "Memory Efficiency");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-20s %-20d %-20s%n", "String (+)", concatTime, "Low");
        System.out.printf("%-20s %-20d %-20s%n", "StringBuilder", builderTime, "High");
        System.out.printf("%-20s %-20d %-20s%n", "StringBuffer", bufferTime, "Medium");
        System.out.println("--------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of iterations (e.g., 1000, 10000, 100000): ");
        int iterations = sc.nextInt();

        long concatTime = stringConcatTest(iterations);
        long builderTime = stringBuilderTest(iterations);
        long bufferTime = stringBufferTest(iterations);

        displayResults(concatTime, builderTime, bufferTime);

        sc.close();
    }
}

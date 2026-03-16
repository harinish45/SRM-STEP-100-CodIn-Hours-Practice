/**
 * UseCase1HotelBookingApp
 * Demonstrates application entry and welcome message
 * 
 * This use case establishes a clear and predictable starting point for the
 * Hotel Booking application by demonstrating how a Java program begins
 * execution
 * and produces console output.
 * 
 * @author Student
 * @version 1.0
 */
public class UseCase1HotelBookingApp {

    /**
     * Main method - Entry point of every standalone Java application
     * The JVM looks specifically for this method signature:
     * public static void main(String[] args)
     * 
     * public - accessible to JVM
     * static - can be executed without creating an object
     * void - returns no value
     * main - method name recognized by JVM
     * String[] args - command line arguments
     */
    public static void main(String[] args) {
        // Console Output using System.out.println()
        // Sends text output to the console
        // Demonstrates method invocation: calling println() on out object

        System.out.println("========================================");
        System.out.println("  Use Case 1: Application Entry & Welcome Message");
        System.out.println("========================================");
        System.out.println();
        System.out.println("Welcome to Hotel Booking System v1.0");
        System.out.println();

        // String Literals - text in double quotes
        // Stored in String pool (immutable)
        String appName = "Book My Stay";
        String version = "v1.0";

        // Display application info
        System.out.println("Application: " + appName);
        System.out.println("Version: " + version);
        System.out.println();

        // Application flow - linear execution
        System.out.println("Key Concepts Demonstrated:");
        System.out.println("- Class definition");
        System.out.println("- main() method as entry point");
        System.out.println("- static keyword usage");
        System.out.println("- Console output (System.out.println)");
        System.out.println("- String literals");
        System.out.println("- Method invocation");
        System.out.println("- Linear application flow");
        System.out.println("- JavaDoc comments and annotations");

        System.out.println();
        System.out.println("========================================");
        System.out.println("Application terminated successfully!");
    }
}

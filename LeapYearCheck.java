import java.util.Scanner;

public class LeapYearCheck {
    static boolean isLeapYear(int year) {
        if (year >= 1582) {
            return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = sc.nextInt();
        if (year < 1582) {
            System.out.println("Year is before Gregorian calendar. Invalid input.");
        } else {
            if (isLeapYear(year)) {
                System.out.println("Year is a Leap Year");
            } else {
                System.out.println("Year is not a Leap Year");
            }
        }
    }
}

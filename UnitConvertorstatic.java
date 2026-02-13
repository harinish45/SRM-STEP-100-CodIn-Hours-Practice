import java.util.Scanner;

class UnitConvertor {
    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }

    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = 2.20462;
        return kilograms * kilograms2pounds;
    }

    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }

    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Fahrenheit: ");
        double f = sc.nextDouble();
        System.out.println("Celsius: " + UnitConvertor.convertFahrenheitToCelsius(f));

        System.out.print("Enter Celsius: ");
        double c = sc.nextDouble();
        System.out.println("Fahrenheit: " + UnitConvertor.convertCelsiusToFahrenheit(c));

        System.out.print("Enter Pounds: ");
        double pounds = sc.nextDouble();
        System.out.println("Kilograms: " + UnitConvertor.convertPoundsToKilograms(pounds));

        System.out.print("Enter Kilograms: ");
        double kg = sc.nextDouble();
        System.out.println("Pounds: " + UnitConvertor.convertKilogramsToPounds(kg));

        System.out.print("Enter Gallons: ");
        double gal = sc.nextDouble();
        System.out.println("Liters: " + UnitConvertor.convertGallonsToLiters(gal));

        System.out.print("Enter Liters: ");
        double lit = sc.nextDouble();
        System.out.println("Gallons: " + UnitConvertor.convertLitersToGallons(lit));
    }
}

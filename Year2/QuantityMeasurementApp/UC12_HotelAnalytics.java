package QuantityMeasurementApp;

import java.util.HashMap;
import java.util.Map;

public class UC12_HotelAnalytics {
    private Map<String, Integer> bookingsByType;
    private Map<String, Double> revenueByType;
    private int totalBookings;
    private double totalRevenue;

    public UC12_HotelAnalytics() {
        bookingsByType = new HashMap<>();
        revenueByType = new HashMap<>();
        totalBookings = 0;
        totalRevenue = 0.0;
    }

    public void recordBooking(Booking booking) {
        String roomType = booking.getRoom().getRoomType();
        double amount = booking.getTotalAmount();

        bookingsByType.put(roomType, bookingsByType.getOrDefault(roomType, 0) + 1);
        revenueByType.put(roomType, revenueByType.getOrDefault(roomType, 0.0) + amount);
        
        totalBookings++;
        totalRevenue += amount;
    }

    public void displayAnalytics() {
        System.out.println("\n=== Hotel Analytics Report ===");
        System.out.println("Total Bookings: " + totalBookings);
        System.out.println("Total Revenue: $" + totalRevenue);
        
        System.out.println("\nBookings by Room Type:");
        for (Map.Entry<String, Integer> entry : bookingsByType.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
        
        System.out.println("\nRevenue by Room Type:");
        for (Map.Entry<String, Double> entry : revenueByType.entrySet()) {
            System.out.println("  " + entry.getKey() + ": $" + entry.getValue());
        }
    }

    public int getMostPopularRoomType() {
        String popularType = "";
        int maxCount = 0;
        
        for (Map.Entry<String, Integer> entry : bookingsByType.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                popularType = entry.getKey();
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println("=== Use Case 12: Hotel Analytics ===\n");

        UC12_HotelAnalytics analytics = new UC12_HotelAnalytics();

        Guest g1 = new Guest("G001", "Alice", "", "");
        Guest g2 = new Guest("G002", "Bob", "", "");
        Guest g3 = new Guest("G003", "Charlie", "", "");

        Booking b1 = new Booking("B001", g1, new Room(101, "Single", 50.0), null, 2);
        Booking b2 = new Booking("B002", g2, new Room(102, "Double", 80.0), null, 3);
        Booking b3 = new Booking("B003", g3, new Room(103, "Single", 50.0), null, 1);

        analytics.recordBooking(b1);
        analytics.recordBooking(b2);
        analytics.recordBooking(b3);

        analytics.displayAnalytics();
        
        System.out.println("\nMost popular room type bookings: " + analytics.getMostPopularRoomType());
    }
}
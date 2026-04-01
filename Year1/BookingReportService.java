import java.util.List;

public class BookingReportService {

    // Generate and display booking history report
    public void generateReport(BookingHistory history) {
        List<Reservation> reservations = history.getConfirmedReservations();

        System.out.println("\n=================================");
        System.out.println("   Booking History Report");
        System.out.println("=================================\n");

        if (reservations.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        for (Reservation reservation : reservations) {
            System.out.println("Guest: " + reservation.getGuestName() +
                    ", Room Type: " + reservation.getRoomType());
        }

        System.out.println("\n---------------------------------");
        System.out.println("Total Bookings: " + history.getTotalBookings());
        System.out.println("=================================");
    }

    // Generate summary report without modifying stored data
    public void generateSummaryReport(BookingHistory history) {
        List<Reservation> reservations = history.getConfirmedReservations();

        // Count bookings by room type
        int singleRooms = 0;
        int doubleRooms = 0;
        int suiteRooms = 0;

        for (Reservation reservation : reservations) {
            String roomType = reservation.getRoomType();
            if (roomType.equals("Single")) {
                singleRooms++;
            } else if (roomType.equals("Double")) {
                doubleRooms++;
            } else if (roomType.equals("Suite")) {
                suiteRooms++;
            }
        }

        System.out.println("\n=================================");
        System.out.println("   Summary Report");
        System.out.println("=================================");
        System.out.println("Total Bookings: " + reservations.size());
        System.out.println("Single Rooms: " + singleRooms);
        System.out.println("Double Rooms: " + doubleRooms);
        System.out.println("Suite Rooms: " + suiteRooms);
        System.out.println("=================================\n");
    }
}

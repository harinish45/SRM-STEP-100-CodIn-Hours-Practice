public class UseCase8BookingHistoryReport {

    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("   Booking History and Reporting");
        System.out.println("=================================\n");

        // Create BookingHistory instance
        BookingHistory bookingHistory = new BookingHistory();

        // Create BookingReportService instance
        BookingReportService reportService = new BookingReportService();

        // Simulate some bookings
        // Booking 1: Abhi - Single Room
        Reservation reservation1 = new Reservation("Abhi", "Single", 101);
        bookingHistory.addReservation(reservation1);

        // Booking 2: Subha - Double Room
        Reservation reservation2 = new Reservation("Subha", "Double", 202);
        bookingHistory.addReservation(reservation2);

        // Booking 3: Vanmathi - Suite
        Reservation reservation3 = new Reservation("Vanmathi", "Suite", 301);
        bookingHistory.addReservation(reservation3);

        // Generate Booking History Report
        reportService.generateReport(bookingHistory);

        // Generate Summary Report
        reportService.generateSummaryReport(bookingHistory);
    }
}

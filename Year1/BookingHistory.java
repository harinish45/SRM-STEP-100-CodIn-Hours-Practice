package Year1;

import java.util.ArrayList;
import java.util.List;

public class BookingHistory {

    private List<Reservation> confirmedReservations;

    public BookingHistory() {
        confirmedReservations = new ArrayList<>();
    }

    // Add a confirmed reservation to history
    public void addReservation(Reservation reservation) {
        confirmedReservations.add(reservation);
    }

    // Get all confirmed reservations
    public List<Reservation> getConfirmedReservations() {
        return confirmedReservations;
    }

    // Get total number of bookings
    public int getTotalBookings() {
        return confirmedReservations.size();
    }
}

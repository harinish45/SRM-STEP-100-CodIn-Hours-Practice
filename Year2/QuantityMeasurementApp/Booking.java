package QuantityMeasurementApp;

import java.util.Date;

public class Booking {
    private String bookingId;
    private Guest guest;
    private Room room;
    private Date checkInDate;
    private Date checkOutDate;
    private int nights;
    private double totalAmount;
    private boolean isActive;

    public Booking(String bookingId, Guest guest, Room room, Date checkInDate, int nights) {
        this.bookingId = bookingId;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.nights = nights;
        this.totalAmount = room.getPricePerNight() * nights;
        this.isActive = true;
        this.room.setAvailable(false);
    }

    public String getBookingId() {
        return bookingId;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public int getNights() {
        return nights;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public boolean isActive() {
        return isActive;
    }

    public void cancel() {
        this.isActive = false;
        this.room.setAvailable(true);
    }

    @Override
    public String toString() {
        return "Booking " + bookingId + " - " + guest.getName() + " in " + room.getRoomType() +
               " for " + nights + " nights";
    }
}
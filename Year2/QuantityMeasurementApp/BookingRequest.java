package QuantityMeasurementApp;

import java.util.Date;

public class BookingRequest {
    private String requestId;
    private Guest guest;
    private String roomType;
    private Date checkInDate;
    private int nights;
    private long requestTime;

    public BookingRequest(String requestId, Guest guest, String roomType, int nights) {
        this.requestId = requestId;
        this.guest = guest;
        this.roomType = roomType;
        this.nights = nights;
        this.checkInDate = new Date();
        this.requestTime = System.currentTimeMillis();
    }

    public String getRequestId() {
        return requestId;
    }

    public Guest getGuest() {
        return guest;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getNights() {
        return nights;
    }

    public long getRequestTime() {
        return requestTime;
    }

    @Override
    public String toString() {
        return "Request " + requestId + " - " + guest.getName() + " for " + roomType + " (" + nights + " nights)";
    }
}
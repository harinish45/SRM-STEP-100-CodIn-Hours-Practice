package Year1;

public class Reservation {

    private String guestName;
    private String roomType;
    private int roomNumber;

    public Reservation(String guestName, String roomType, int roomNumber) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.roomNumber = roomNumber;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getRoomNumber() {
        return roomNumber;
    }
}

/**
 * UseCase2BasicRoomTypes
 * Demonstrates inheritance and abstraction for room types
 * 
 * @author Student
 * @version 1.0
 */
public class UseCase2BasicRoomTypes {

    // Abstract Room class
    abstract static class Room {
        protected int roomNumber;
        protected String roomType;
        protected int beds;
        protected double pricePerNight;

        abstract void displayRoomInfo();

        public int getRoomNumber() {
            return roomNumber;
        }

        public double getPricePerNight() {
            return pricePerNight;
        }
    }

    // Concrete class: Single Room
    static class SingleRoom extends Room {
        public SingleRoom(int roomNumber) {
            this.roomNumber = roomNumber;
            this.roomType = "Single";
            this.beds = 1;
            this.pricePerNight = 50.0;
        }

        @Override
        void displayRoomInfo() {
            System.out.println("Room " + roomNumber + " [" + roomType + "] - " +
                    beds + " Bed - $" + pricePerNight + "/night");
        }
    }

    // Concrete class: Double Room
    static class DoubleRoom extends Room {
        public DoubleRoom(int roomNumber) {
            this.roomNumber = roomNumber;
            this.roomType = "Double";
            this.beds = 2;
            this.pricePerNight = 80.0;
        }

        @Override
        void displayRoomInfo() {
            System.out.println("Room " + roomNumber + " [" + roomType + "] - " +
                    beds + " Beds - $" + pricePerNight + "/night");
        }
    }

    // Concrete class: Suite Room
    static class SuiteRoom extends Room {
        public SuiteRoom(int roomNumber) {
            this.roomNumber = roomNumber;
            this.roomType = "Suite";
            this.beds = 3;
            this.pricePerNight = 150.0;
        }

        @Override
        void displayRoomInfo() {
            System.out.println("Room " + roomNumber + " [" + roomType + "] - " +
                    beds + " Beds - $" + pricePerNight + "/night");
        }
    }

    public static void main(String[] args) {
        // Static availability - stored in simple variables
        int singleRoomsAvailable = 5;
        int doubleRoomsAvailable = 3;
        int suiteRoomsAvailable = 2;

        // Create room objects using polymorphism
        Room[] rooms = new Room[3];
        rooms[0] = new SingleRoom(101);
        rooms[1] = new DoubleRoom(102);
        rooms[2] = new SuiteRoom(103);

        System.out.println("=== Use Case 2: Basic Room Types & Static Availability ===\n");

        System.out.println("--- Room Details ---");
        for (Room room : rooms) {
            room.displayRoomInfo();
        }

        System.out.println("\n--- Room Availability ---");
        System.out.println("Single Rooms Available: " + singleRoomsAvailable);
        System.out.println("Double Rooms Available: " + doubleRoomsAvailable);
        System.out.println("Suite Rooms Available: " + suiteRoomsAvailable);

        int totalAvailable = singleRoomsAvailable + doubleRoomsAvailable + suiteRoomsAvailable;
        System.out.println("\nTotal Rooms Available: " + totalAvailable);
    }
}

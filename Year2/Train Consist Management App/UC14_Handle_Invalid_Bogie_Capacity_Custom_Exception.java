public class UC14_Handle_Invalid_Bogie_Capacity_Custom_Exception {

    /**
     * Checked exception raised when a passenger bogie is constructed
     * with a capacity value that violates the business rule (must be > 0).
     */
    static class InvalidCapacityException extends Exception {

        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    /**
     * Represents a passenger bogie with enforced capacity validation.
     * Invalid bogies are rejected at construction time (fail-fast).
     */
    static class PassengerBogie {

        private final String type;
        private final int capacity;

        /**
         * Constructs a PassengerBogie after validating the capacity.
         *
         * @param type     bogie type e.g. Sleeper, AC Chair
         * @param capacity seating capacity — must be greater than zero
         * @throws InvalidCapacityException if capacity is zero or negative
         */
        PassengerBogie(String type, int capacity)
                throws InvalidCapacityException {

            if (capacity <= 0) {
                throw new InvalidCapacityException(
                        "Capacity must be greater than zero");
            }

            this.type     = type;
            this.capacity = capacity;
        }

        public String getType()     { return type; }
        public int    getCapacity() { return capacity; }
    }

    public static void main(String[] args) {

        System.out.println("==================================================");
        System.out.println("UC14 - Handle Invalid Bogie Capacity");
        System.out.println("==================================================\n");

        // ── Valid bogie creation ──────────────────────────────────────────
        try {
            PassengerBogie validBogie = new PassengerBogie("Sleeper", 72);
            System.out.println("Passenger bogie created successfully.");
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();

        // ── Invalid bogie creation (capacity = -10) ───────────────────────
        try {
            PassengerBogie invalidBogie = new PassengerBogie("AC Chair", -10);
            System.out.println("Passenger bogie created successfully.");
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC14 execution completed...");
    }
}

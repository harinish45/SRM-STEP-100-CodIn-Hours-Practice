public class UC15_Safe_Cargo_Assignment_Using_Try_Catch_Finally {

    /**
     * Custom runtime exception raised when an unsafe cargo-to-bogie
     * shape combination is detected during assignment.
     */
    static class CargoSafetyException extends RuntimeException {

        public CargoSafetyException(String message) {
            super(message);
        }
    }

    /**
     * Represents a goods bogie with a specific shape.
     * Cargo assignment is validated at runtime before being accepted.
     */
    static class GoodsBogie {

        private final String shape;
        private String cargo;

        GoodsBogie(String shape) {
            this.shape = shape;
        }

        /**
         * Attempts to assign cargo to this bogie.
         * Throws CargoSafetyException if the combination is unsafe.
         * The finally block always logs completion regardless of outcome.
         *
         * @param cargo the cargo type to assign
         */
        void assignCargo(String cargo) {

            try {
                // Safety rule: Rectangular bogie cannot carry Petroleum
                if (shape.equalsIgnoreCase("Rectangular")
                        && cargo.equalsIgnoreCase("Petroleum")) {
                    throw new CargoSafetyException("Unsafe cargo assignment.");
                }

                this.cargo = cargo;
                System.out.println("Cargo assigned: " + cargo);

            } catch (CargoSafetyException e) {
                System.out.println("Error: " + e.getMessage());

            } finally {
                // Always executes — used for logging or cleanup
                System.out.println("Validation completed.");
            }
        }

        public String getCargo() {
            return cargo;
        }
    }

    public static void main(String[] args) {

        System.out.println("==================================================");
        System.out.println("UC15 - Safe Cargo Assignment Using try-catch-finally");
        System.out.println("==================================================\n");

        // Safe assignment: Coal to Rectangular bogie — allowed
        GoodsBogie rectangularBogie = new GoodsBogie("Rectangular");
        rectangularBogie.assignCargo("Coal");

        System.out.println();

        // Unsafe assignment: Petroleum to Rectangular bogie — rejected
        GoodsBogie unsafeBogie = new GoodsBogie("Rectangular");
        unsafeBogie.assignCargo("Petroleum");

        System.out.println();
        System.out.println("Program continues safely...");
    }
}

public class GoodsBogie {

    private String shape;   // Cylindrical, Rectangular, Open, Box
    private String cargo;   // assigned cargo type

    public GoodsBogie(String shape) {
        this.shape = shape;
        this.cargo = null;  // no cargo assigned at creation
    }

    // ── Cargo Assignment with Safety Validation ───────────────
    public void assignCargo(String cargoType) {
        try {
            // Safety Rule: Petroleum must NOT go into Rectangular bogie
            if (shape.equalsIgnoreCase("Rectangular")
                    && cargoType.equalsIgnoreCase("Petroleum")) {
                throw new CargoSafetyException(
                        "UNSAFE: Petroleum cannot be assigned to a Rectangular bogie.");
            }
            // Safety Rule: Non-Petroleum must NOT go into Cylindrical bogie
            if (shape.equalsIgnoreCase("Cylindrical")
                    && !cargoType.equalsIgnoreCase("Petroleum")) {
                throw new CargoSafetyException(
                        "UNSAFE: Cylindrical bogie can only carry Petroleum.");
            }

            // Safe assignment
            this.cargo = cargoType;
            System.out.println("  [SUCCESS] " + shape + " bogie assigned cargo : "
                    + cargoType + "  ✔");

        } catch (CargoSafetyException e) {
            System.out.println("  [EXCEPTION] " + e.getMessage() + "  ✘");
            // cargo remains null — never assigned

        } finally {
            System.out.println("  [FINALLY]  Cargo assignment validation"
                    + " completed for : " + shape + " bogie.");
        }
    }

    public String getShape() { return shape; }
    public String getCargo() { return cargo; }

    @Override
    public String toString() {
        return "GoodsBogie [Shape: " + shape
                + ", Cargo: " + (cargo != null ? cargo : "NOT ASSIGNED") + "]";
    }
}
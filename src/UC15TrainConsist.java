public class UC15TrainConsist {

    public static void main(String[] args) {

        // ===================== UC15 =====================
        System.out.println("===========================================");
        System.out.println("  UC15: Safe Cargo Assignment             ");
        System.out.println("        (try-catch-finally)               ");
        System.out.println("===========================================");

        // ── Scenario 1: Safe — Cylindrical + Petroleum ───────
        System.out.println("\n[Scenario 1 — Safe Assignment]");
        System.out.println("  Cylindrical bogie  ← Petroleum");
        System.out.println("-------------------------------------------");
        GoodsBogie cylindrical = new GoodsBogie("Cylindrical");
        cylindrical.assignCargo("Petroleum");

        // ── Scenario 2: Safe — Rectangular + Coal ────────────
        System.out.println("\n[Scenario 2 — Safe Assignment]");
        System.out.println("  Rectangular bogie  ← Coal");
        System.out.println("-------------------------------------------");
        GoodsBogie rectangular1 = new GoodsBogie("Rectangular");
        rectangular1.assignCargo("Coal");

        // ── Scenario 3: Unsafe — Rectangular + Petroleum ─────
        System.out.println("\n[Scenario 3 — Unsafe Assignment]");
        System.out.println("  Rectangular bogie  ← Petroleum");
        System.out.println("-------------------------------------------");
        GoodsBogie rectangular2 = new GoodsBogie("Rectangular");
        rectangular2.assignCargo("Petroleum");

        // ── Scenario 4: Unsafe — Cylindrical + Coal ──────────
        System.out.println("\n[Scenario 4 — Unsafe Assignment]");
        System.out.println("  Cylindrical bogie  ← Coal");
        System.out.println("-------------------------------------------");
        GoodsBogie cylindrical2 = new GoodsBogie("Cylindrical");
        cylindrical2.assignCargo("Coal");

        // ── Scenario 5: Safe — Open + Grain ──────────────────
        System.out.println("\n[Scenario 5 — Safe Assignment]");
        System.out.println("  Open bogie  ← Grain");
        System.out.println("-------------------------------------------");
        GoodsBogie openBogie = new GoodsBogie("Open");
        openBogie.assignCargo("Grain");

        // ── Program continues after all exceptions ────────────
        System.out.println("\n[Application continues after all scenarios]");
        System.out.println("-------------------------------------------");

        // ── Final Consist State ───────────────────────────────
        System.out.println("\n--- Final Goods Bogie State ---");
        System.out.println("-------------------------------------------");
        System.out.println("  " + cylindrical);
        System.out.println("  " + rectangular1);
        System.out.println("  " + rectangular2);  // cargo should be NOT ASSIGNED
        System.out.println("  " + cylindrical2);  // cargo should be NOT ASSIGNED
        System.out.println("  " + openBogie);
        System.out.println("---------------------------------------");
        System.out.println("  Rule 1: Rectangular bogies cannot carry Petroleum.");
        System.out.println("  Rule 2: Cylindrical bogies can only carry Petroleum.");
        System.out.println("  Unsafe assignments were caught — app never crashed.");
        System.out.println("---------------------------------------");
    }
}
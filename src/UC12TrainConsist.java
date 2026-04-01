import java.util.ArrayList;
import java.util.List;

public class UC12TrainConsist {

    // ── Safety Rule ───────────────────────────────────────────
    // Cylindrical bogies → only Petroleum allowed
    // All other types   → any cargo allowed
    public static boolean isSafetyCompliant(List<GoodsBogie> bogieList) {
        return bogieList.stream()
                .allMatch(b -> !b.getType().equalsIgnoreCase("Cylindrical")
                        || b.getCargo().equalsIgnoreCase("Petroleum"));
    }

    // ── Display Helper ────────────────────────────────────────
    private static void printBogieList(List<GoodsBogie> list) {
        for (GoodsBogie b : list) {
            String ruleStatus = b.getType().equalsIgnoreCase("Cylindrical")
                    ? (b.getCargo().equalsIgnoreCase("Petroleum")
                    ? "  ✔ Rule OK"
                    : "  ✘ Rule VIOLATED")
                    : "  ✔ No restriction";
            System.out.println("  " + b + ruleStatus);
        }
    }

    public static void main(String[] args) {

        // ===================== UC12 =====================
        System.out.println("===========================================");
        System.out.println("  UC12: Safety Compliance Check           ");
        System.out.println("        for Goods Bogies                  ");
        System.out.println("===========================================");

        // ── Scenario 1: All bogies compliant ─────────────────
        System.out.println("\n[Scenario 1 — All Bogies Compliant]");
        System.out.println("-------------------------------------------");
        List<GoodsBogie> safeList = new ArrayList<>();
        safeList.add(new GoodsBogie("Cylindrical",  "Petroleum"));
        safeList.add(new GoodsBogie("Rectangular",  "Coal"));
        safeList.add(new GoodsBogie("Open",         "Grain"));

        printBogieList(safeList);
        boolean safe1 = isSafetyCompliant(safeList);
        System.out.println("\n  Safety Compliance Result : "
                + (safe1 ? "SAFE ✔" : "UNSAFE ✘"));

        // ── Scenario 2: Cylindrical bogie with invalid cargo ──
        System.out.println("\n[Scenario 2 — Cylindrical Bogie Carrying Coal]");
        System.out.println("-------------------------------------------");
        List<GoodsBogie> unsafeList = new ArrayList<>();
        unsafeList.add(new GoodsBogie("Cylindrical", "Coal"));      // violation
        unsafeList.add(new GoodsBogie("Rectangular", "Cement"));
        unsafeList.add(new GoodsBogie("Open",        "Grain"));

        printBogieList(unsafeList);
        boolean safe2 = isSafetyCompliant(unsafeList);
        System.out.println("\n  Safety Compliance Result : "
                + (safe2 ? "SAFE ✔" : "UNSAFE ✘"));

        // ── Scenario 3: Non-cylindrical bogies only ───────────
        System.out.println("\n[Scenario 3 — Non-Cylindrical Bogies Only]");
        System.out.println("-------------------------------------------");
        List<GoodsBogie> nonCylList = new ArrayList<>();
        nonCylList.add(new GoodsBogie("Rectangular", "Coal"));
        nonCylList.add(new GoodsBogie("Open",        "Grain"));
        nonCylList.add(new GoodsBogie("Box",         "Cement"));

        printBogieList(nonCylList);
        boolean safe3 = isSafetyCompliant(nonCylList);
        System.out.println("\n  Safety Compliance Result : "
                + (safe3 ? "SAFE ✔" : "UNSAFE ✘"));

        // ── Scenario 4: Empty bogie list ──────────────────────
        System.out.println("\n[Scenario 4 — Empty Bogie List]");
        System.out.println("-------------------------------------------");
        List<GoodsBogie> emptyList = new ArrayList<>();
        boolean safe4 = isSafetyCompliant(emptyList);
        System.out.println("  No bogies in list.");
        System.out.println("\n  Safety Compliance Result : "
                + (safe4 ? "SAFE ✔" : "UNSAFE ✘"));

        // ── Final Summary ─────────────────────────────────────
        System.out.println("\n--- Safety Compliance Summary ---");
        System.out.println("  Scenario 1 (All valid)          : "
                + (safe1 ? "SAFE ✔" : "UNSAFE ✘"));
        System.out.println("  Scenario 2 (Cylindrical+Coal)   : "
                + (safe2 ? "SAFE ✔" : "UNSAFE ✘"));
        System.out.println("  Scenario 3 (Non-cylindrical)    : "
                + (safe3 ? "SAFE ✔" : "UNSAFE ✘"));
        System.out.println("  Scenario 4 (Empty list)         : "
                + (safe4 ? "SAFE ✔" : "UNSAFE ✘"));
        System.out.println("---------------------------------------");
        System.out.println("  Rule: Cylindrical bogies must carry");
        System.out.println("        only PETROLEUM cargo.");
        System.out.println("---------------------------------------");
    }
}
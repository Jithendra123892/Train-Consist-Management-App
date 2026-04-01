import java.util.ArrayList;
import java.util.List;

public class UC14TrainConsist {

    public static void main(String[] args) {

        // ===================== UC14 =====================
        System.out.println("===========================================");
        System.out.println("  UC14: Handle Invalid Bogie Capacity     ");
        System.out.println("        (Custom Exception)                ");
        System.out.println("===========================================");

        List<PassengerBogie> consist = new ArrayList<>();

        // ── Scenario 1: Valid bogie creation ─────────────────
        System.out.println("\n[Scenario 1 — Valid Bogie Creations]");
        System.out.println("-------------------------------------------");

        try {
            PassengerBogie sleeper = new PassengerBogie("Sleeper", 72);
            consist.add(sleeper);
            System.out.println("  Created : " + sleeper + "  ✔");
        } catch (InvalidCapacityException e) {
            System.out.println("  ERROR   : " + e.getMessage());
        }

        try {
            PassengerBogie acChair = new PassengerBogie("AC Chair", 56);
            consist.add(acChair);
            System.out.println("  Created : " + acChair + "  ✔");
        } catch (InvalidCapacityException e) {
            System.out.println("  ERROR   : " + e.getMessage());
        }

        try {
            PassengerBogie firstClass = new PassengerBogie("First Class", 18);
            consist.add(firstClass);
            System.out.println("  Created : " + firstClass + "  ✔");
        } catch (InvalidCapacityException e) {
            System.out.println("  ERROR   : " + e.getMessage());
        }

        // ── Scenario 2: Negative capacity ────────────────────
        System.out.println("\n[Scenario 2 — Negative Capacity]");
        System.out.println("-------------------------------------------");

        try {
            PassengerBogie invalid = new PassengerBogie("Sleeper", -10);
            consist.add(invalid);
            System.out.println("  Created : " + invalid);
        } catch (InvalidCapacityException e) {
            System.out.println("  Attempting : PassengerBogie(\"Sleeper\", -10)");
            System.out.println("  EXCEPTION  : " + e.getMessage() + "  ✘");
        }

        // ── Scenario 3: Zero capacity ─────────────────────────
        System.out.println("\n[Scenario 3 — Zero Capacity]");
        System.out.println("-------------------------------------------");

        try {
            PassengerBogie invalid = new PassengerBogie("AC Chair", 0);
            consist.add(invalid);
            System.out.println("  Created : " + invalid);
        } catch (InvalidCapacityException e) {
            System.out.println("  Attempting : PassengerBogie(\"AC Chair\", 0)");
            System.out.println("  EXCEPTION  : " + e.getMessage() + "  ✘");
        }

        // ── Scenario 4: Corrupted config value ───────────────
        System.out.println("\n[Scenario 4 — Corrupted Config Value]");
        System.out.println("-------------------------------------------");

        try {
            PassengerBogie invalid = new PassengerBogie("First Class", -999);
            consist.add(invalid);
            System.out.println("  Created : " + invalid);
        } catch (InvalidCapacityException e) {
            System.out.println("  Attempting : PassengerBogie(\"First Class\", -999)");
            System.out.println("  EXCEPTION  : " + e.getMessage() + "  ✘");
        }

        // ── Final Consist — only valid bogies ─────────────────
        System.out.println("\n--- Final Train Consist (Valid Bogies Only) ---");
        System.out.println("-------------------------------------------");
        if (consist.isEmpty()) {
            System.out.println("  No valid bogies in consist.");
        } else {
            for (PassengerBogie b : consist) {
                System.out.println("  " + b);
            }
        }
        System.out.println("Total Valid Bogies : " + consist.size());
        System.out.println("---------------------------------------");
        System.out.println("  Rule: Capacity must be greater than zero.");
        System.out.println("  Invalid bogies were NEVER added to consist.");
        System.out.println("---------------------------------------");
    }
}
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UC11TrainConsist {

    // ── Regex Patterns ──────────────────────────────────────
    private static final String TRAIN_ID_PATTERN  = "TRN-\\d{4}";
    private static final String CARGO_CODE_PATTERN = "PET-[A-Z]{2}";

    // ── Validation Helpers ───────────────────────────────────
    public static boolean isValidTrainID(String input) {
        Pattern pattern = Pattern.compile(TRAIN_ID_PATTERN);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static boolean isValidCargoCode(String input) {
        Pattern pattern = Pattern.compile(CARGO_CODE_PATTERN);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    // ── Display Helper ───────────────────────────────────────
    private static void printValidation(String label, String input, boolean isValid) {
        String status = isValid ? "VALID   ✔" : "INVALID ✘";
        System.out.printf("  %-25s : %-15s --> %s%n", label, input, status);
    }

    public static void main(String[] args) {

        // ===================== UC11 =====================
        System.out.println("===========================================");
        System.out.println("  UC11: Validate Train ID & Cargo Codes   ");
        System.out.println("        (Regex — Pattern & Matcher)       ");
        System.out.println("===========================================");

        // ── Train ID Validation ──────────────────────────────
        System.out.println("\n[Train ID Validation — Pattern: TRN-\\d{4}]");
        System.out.println("-------------------------------------------");

        printValidation("TRN-1234 (valid)",    "TRN-1234",   isValidTrainID("TRN-1234"));
        printValidation("TRN-5678 (valid)",    "TRN-5678",   isValidTrainID("TRN-5678"));
        printValidation("TRAIN12 (invalid)",   "TRAIN12",    isValidTrainID("TRAIN12"));
        printValidation("TRN12A (invalid)",    "TRN12A",     isValidTrainID("TRN12A"));
        printValidation("1234-TRN (invalid)",  "1234-TRN",   isValidTrainID("1234-TRN"));
        printValidation("TRN-123 (invalid)",   "TRN-123",    isValidTrainID("TRN-123"));
        printValidation("TRN-12345 (invalid)", "TRN-12345",  isValidTrainID("TRN-12345"));
        printValidation("Empty (invalid)",     "",           isValidTrainID(""));

        // ── Cargo Code Validation ────────────────────────────
        System.out.println("\n[Cargo Code Validation — Pattern: PET-[A-Z]{2}]");
        System.out.println("-------------------------------------------");

        printValidation("PET-AB (valid)",      "PET-AB",     isValidCargoCode("PET-AB"));
        printValidation("PET-XY (valid)",      "PET-XY",     isValidCargoCode("PET-XY"));
        printValidation("PET-ab (invalid)",    "PET-ab",     isValidCargoCode("PET-ab"));
        printValidation("PET123 (invalid)",    "PET123",     isValidCargoCode("PET123"));
        printValidation("AB-PET (invalid)",    "AB-PET",     isValidCargoCode("AB-PET"));
        printValidation("PET-A (invalid)",     "PET-A",      isValidCargoCode("PET-A"));
        printValidation("PET-ABC (invalid)",   "PET-ABC",    isValidCargoCode("PET-ABC"));
        printValidation("Empty (invalid)",     "",           isValidCargoCode(""));

        // ── Summary ──────────────────────────────────────────
        System.out.println("\n--- Validation Summary ---");
        System.out.println("Train ID  Pattern : TRN-\\d{4}      (e.g. TRN-1234)");
        System.out.println("Cargo Code Pattern : PET-[A-Z]{2}   (e.g. PET-AB)");
        System.out.println("---------------------------------------");
    }
}
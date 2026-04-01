import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistAppTest {

    // ── Train ID Tests ───────────────────────────────────────

    @Test
    public void testRegex_ValidTrainID() {
        assertTrue(TrainConsistApp.isValidTrainID("TRN-1234"));
        assertTrue(TrainConsistApp.isValidTrainID("TRN-5678"));
        assertTrue(TrainConsistApp.isValidTrainID("TRN-0000"));
    }

    @Test
    public void testRegex_InvalidTrainIDFormat() {
        assertFalse(TrainConsistApp.isValidTrainID("TRAIN12"));
        assertFalse(TrainConsistApp.isValidTrainID("TRN12A"));
        assertFalse(TrainConsistApp.isValidTrainID("1234-TRN"));
    }

    @Test
    public void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(TrainConsistApp.isValidTrainID("TRN-123"));    // 3 digits
        assertFalse(TrainConsistApp.isValidTrainID("TRN-12345"));  // 5 digits
        assertTrue(TrainConsistApp.isValidTrainID("TRN-1234"));    // exactly 4
    }

    // ── Cargo Code Tests ─────────────────────────────────────

    @Test
    public void testRegex_ValidCargoCode() {
        assertTrue(TrainConsistApp.isValidCargoCode("PET-AB"));
        assertTrue(TrainConsistApp.isValidCargoCode("PET-XY"));
        assertTrue(TrainConsistApp.isValidCargoCode("PET-ZZ"));
    }

    @Test
    public void testRegex_InvalidCargoCodeFormat() {
        assertFalse(TrainConsistApp.isValidCargoCode("PET-ab"));   // lowercase
        assertFalse(TrainConsistApp.isValidCargoCode("PET123"));   // no dash
        assertFalse(TrainConsistApp.isValidCargoCode("AB-PET"));   // reversed
    }

    @Test
    public void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(TrainConsistApp.isValidCargoCode("PET-ab"));   // lowercase
        assertFalse(TrainConsistApp.isValidCargoCode("PET-Ab"));   // mixed case
        assertTrue(TrainConsistApp.isValidCargoCode("PET-AB"));    // uppercase only
    }

    // ── Edge Case Tests ──────────────────────────────────────

    @Test
    public void testRegex_EmptyInputHandling() {
        assertFalse(TrainConsistApp.isValidTrainID(""));
        assertFalse(TrainConsistApp.isValidCargoCode(""));
    }

    @Test
    public void testRegex_ExactPatternMatch() {
        assertFalse(TrainConsistApp.isValidTrainID("TRN-1234X"));   // extra char
        assertFalse(TrainConsistApp.isValidTrainID("XTRN-1234"));   // prefix extra
        assertFalse(TrainConsistApp.isValidCargoCode("PET-ABC"));   // 3 letters
        assertFalse(TrainConsistApp.isValidCargoCode("XPET-AB"));   // prefix extra
    }
}

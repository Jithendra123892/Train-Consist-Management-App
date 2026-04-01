import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistAppTest {

    @Test
    public void testSafety_AllBogiesValid() {
        List<GoodsBogie> list = new ArrayList<>();
        list.add(new GoodsBogie("Cylindrical",  "Petroleum"));
        list.add(new GoodsBogie("Rectangular",  "Coal"));
        list.add(new GoodsBogie("Open",         "Grain"));
        assertTrue(UC12TrainConsist.isSafetyCompliant(list));
    }

    @Test
    public void testSafety_CylindricalWithInvalidCargo() {
        List<GoodsBogie> list = new ArrayList<>();
        list.add(new GoodsBogie("Cylindrical", "Coal"));   // violation
        list.add(new GoodsBogie("Rectangular", "Cement"));
        assertFalse(UC12TrainConsist.isSafetyCompliant(list));
    }

    @Test
    public void testSafety_NonCylindricalBogiesAllowed() {
        List<GoodsBogie> list = new ArrayList<>();
        list.add(new GoodsBogie("Rectangular", "Coal"));
        list.add(new GoodsBogie("Open",        "Grain"));
        list.add(new GoodsBogie("Box",         "Cement"));
        assertTrue(UC12TrainConsist.isSafetyCompliant(list));
    }

    @Test
    public void testSafety_MixedBogiesWithViolation() {
        List<GoodsBogie> list = new ArrayList<>();
        list.add(new GoodsBogie("Cylindrical", "Petroleum")); // valid
        list.add(new GoodsBogie("Cylindrical", "Coal"));      // violation
        list.add(new GoodsBogie("Open",        "Grain"));
        assertFalse(UC12TrainConsist.isSafetyCompliant(list));
    }

    @Test
    public void testSafety_EmptyBogieList() {
        List<GoodsBogie> list = new ArrayList<>();
        // allMatch on empty stream returns true
        assertTrue(UC12TrainConsist.isSafetyCompliant(list));
    }
}

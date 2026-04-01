import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistAppTest {

    @Test
    public void testCargo_SafeAssignment() {
        GoodsBogie bogie = new GoodsBogie("Cylindrical");
        bogie.assignCargo("Petroleum");
        assertEquals("Petroleum", bogie.getCargo());
    }

    @Test
    public void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");
        // Should not throw — exception is caught inside assignCargo
        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"));
    }

    @Test
    public void testCargo_CargoNotAssignedAfterFailure() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");
        bogie.assignCargo("Petroleum"); // unsafe — caught internally
        assertNull(bogie.getCargo());   // cargo must remain null
    }

    @Test
    public void testCargo_ProgramContinuesAfterException() {
        GoodsBogie b1 = new GoodsBogie("Rectangular");
        GoodsBogie b2 = new GoodsBogie("Cylindrical");
        GoodsBogie b3 = new GoodsBogie("Open");

        // None of these should crash the program
        assertDoesNotThrow(() -> {
            b1.assignCargo("Petroleum"); // unsafe — caught
            b2.assignCargo("Petroleum"); // safe
            b3.assignCargo("Grain");     // safe
        });

        assertNull(b1.getCargo());           // failed — null
        assertEquals("Petroleum", b2.getCargo()); // success
        assertEquals("Grain",     b3.getCargo()); // success
    }

    @Test
    public void testCargo_FinallyBlockExecution() {
        // finally always runs — verified by no crash and cargo state
        GoodsBogie bogie = new GoodsBogie("Cylindrical");
        bogie.assignCargo("Coal");       // unsafe — finally still runs
        assertNull(bogie.getCargo());    // cargo not assigned
    }
}

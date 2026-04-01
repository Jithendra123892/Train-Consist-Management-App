import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistAppTest {

    @Test
    public void testException_ValidCapacityCreation() {
        assertDoesNotThrow(() -> {
            PassengerBogie bogie = new PassengerBogie("Sleeper", 72);
            assertNotNull(bogie);
        });
    }

    @Test
    public void testException_NegativeCapacityThrowsException() {
        InvalidCapacityException exception = assertThrows(
                InvalidCapacityException.class,
                () -> new PassengerBogie("Sleeper", -10)
        );
        assertNotNull(exception);
    }

    @Test
    public void testException_ZeroCapacityThrowsException() {
        InvalidCapacityException exception = assertThrows(
                InvalidCapacityException.class,
                () -> new PassengerBogie("AC Chair", 0)
        );
        assertNotNull(exception);
    }

    @Test
    public void testException_ExceptionMessageValidation() {
        InvalidCapacityException exception = assertThrows(
                InvalidCapacityException.class,
                () -> new PassengerBogie("Sleeper", -10)
        );
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    public void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException {
        PassengerBogie bogie = new PassengerBogie("First Class", 18);
        assertEquals("First Class", bogie.getType());
        assertEquals(18,            bogie.getCapacity());
    }

    @Test
    public void testException_MultipleValidBogiesCreation() {
        assertDoesNotThrow(() -> {
            PassengerBogie b1 = new PassengerBogie("Sleeper",     72);
            PassengerBogie b2 = new PassengerBogie("AC Chair",    56);
            PassengerBogie b3 = new PassengerBogie("First Class", 18);
            assertNotNull(b1);
            assertNotNull(b2);
            assertNotNull(b3);
        });
    }
}

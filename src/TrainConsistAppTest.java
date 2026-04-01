import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistAppTest {

    private List<Bogie> bogieList;
    private static final int THRESHOLD = 60;

    @BeforeEach
    public void setUp() {
        bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper",     72));
        bogieList.add(new Bogie("AC Chair",    56));
        bogieList.add(new Bogie("First Class", 18));
    }

    @Test
    public void testLoopFilteringLogic() {
        List<Bogie> result = UC13TrainConsist.filterByLoops(bogieList, THRESHOLD);
        assertEquals(1, result.size());
        assertEquals("Sleeper", result.get(0).getName());
    }

    @Test
    public void testStreamFilteringLogic() {
        List<Bogie> result = UC13TrainConsist.filterByStream(bogieList, THRESHOLD);
        assertEquals(1, result.size());
        assertEquals("Sleeper", result.get(0).getName());
    }

    @Test
    public void testLoopAndStreamResultsMatch() {
        List<Bogie> loopResult   = UC13TrainConsist.filterByLoops(bogieList, THRESHOLD);
        List<Bogie> streamResult = UC13TrainConsist.filterByStream(bogieList, THRESHOLD);
        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    public void testExecutionTimeMeasurement() {
        long start   = System.nanoTime();
        UC13TrainConsist.filterByLoops(bogieList, THRESHOLD);
        long end     = System.nanoTime();
        long elapsed = end - start;
        assertTrue(elapsed > 0);
    }

    @Test
    public void testLargeDatasetProcessing() {
        List<Bogie> largeList    = UC13TrainConsist.generateLargeDataset(100_000);
        List<Bogie> loopResult   = UC13TrainConsist.filterByLoops(largeList, THRESHOLD);
        List<Bogie> streamResult = UC13TrainConsist.filterByStream(largeList, THRESHOLD);
        assertEquals(loopResult.size(), streamResult.size());
        assertTrue(loopResult.size() > 0);
    }
}

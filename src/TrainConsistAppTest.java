import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistAppTest {

    private List<Bogie> bogieList;

    @BeforeEach
    public void setUp() {
        bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper",     72));
        bogieList.add(new Bogie("AC Chair",    56));
        bogieList.add(new Bogie("First Class", 18));
    }

    // Aggregation helper
    private int getTotalSeats(List<Bogie> list) {
        return list.stream()
                .map(b -> b.getCapacity())
                .reduce(0, Integer::sum);
    }

    @Test
    public void testReduce_TotalSeatCalculation() {
        int total = getTotalSeats(bogieList);
        assertEquals(146, total); // 72 + 56 + 18
    }

    @Test
    public void testReduce_MultipleBogiesAggregation() {
        bogieList.add(new Bogie("Sleeper", 72));
        int total = getTotalSeats(bogieList);
        assertEquals(218, total); // 72 + 56 + 18 + 72
    }

    @Test
    public void testReduce_SingleBogieCapacity() {
        List<Bogie> singleList = new ArrayList<>();
        singleList.add(new Bogie("Sleeper", 72));
        int total = getTotalSeats(singleList);
        assertEquals(72, total);
    }

    @Test
    public void testReduce_EmptyBogieList() {
        List<Bogie> emptyList = new ArrayList<>();
        int total = getTotalSeats(emptyList);
        assertEquals(0, total);
    }

    @Test
    public void testReduce_CorrectCapacityExtraction() {
        int total = getTotalSeats(bogieList);
        int manualSum = bogieList.stream()
                .mapToInt(Bogie::getCapacity)
                .sum();
        assertEquals(manualSum, total);
    }

    @Test
    public void testReduce_AllBogiesIncluded() {
        int total    = getTotalSeats(bogieList);
        int expected = 72 + 56 + 18;
        assertEquals(expected, total);
    }

    @Test
    public void testReduce_OriginalListUnchanged() {
        int originalSize = bogieList.size();
        getTotalSeats(bogieList);
        assertEquals(originalSize, bogieList.size());
        assertEquals("Sleeper",     bogieList.get(0).getName());
        assertEquals("AC Chair",    bogieList.get(1).getName());
        assertEquals("First Class", bogieList.get(2).getName());
    }
}

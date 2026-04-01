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
        bogieList.add(new Bogie("First Class", 18));
        bogieList.add(new Bogie("AC Chair",    56));
        bogieList.add(new Bogie("Pantry Car",  30));
        bogieList.add(new Bogie("Garib Rath",  64));
    }

    @Test
    public void testBubbleSort_AscendingOrder() {
        UC16TrainConsist.bubbleSortAscending(bogieList);
        assertEquals(18, bogieList.get(0).getCapacity());
        assertEquals(30, bogieList.get(1).getCapacity());
        assertEquals(56, bogieList.get(2).getCapacity());
        assertEquals(64, bogieList.get(3).getCapacity());
        assertEquals(72, bogieList.get(4).getCapacity());
    }

    @Test
    public void testBubbleSort_DescendingOrder() {
        UC16TrainConsist.bubbleSortDescending(bogieList);
        assertEquals(72, bogieList.get(0).getCapacity());
        assertEquals(64, bogieList.get(1).getCapacity());
        assertEquals(56, bogieList.get(2).getCapacity());
        assertEquals(30, bogieList.get(3).getCapacity());
        assertEquals(18, bogieList.get(4).getCapacity());
    }

    @Test
    public void testBubbleSort_SingleElement() {
        List<Bogie> single = new ArrayList<>();
        single.add(new Bogie("Sleeper", 72));
        UC16TrainConsist.bubbleSortAscending(single);
        assertEquals(72, single.get(0).getCapacity());
    }

    @Test
    public void testBubbleSort_AlreadySorted() {
        List<Bogie> sorted = new ArrayList<>();
        sorted.add(new Bogie("First Class", 18));
        sorted.add(new Bogie("Pantry Car",  30));
        sorted.add(new Bogie("AC Chair",    56));
        UC16TrainConsist.bubbleSortAscending(sorted);
        assertEquals(18, sorted.get(0).getCapacity());
        assertEquals(30, sorted.get(1).getCapacity());
        assertEquals(56, sorted.get(2).getCapacity());
    }

    @Test
    public void testBubbleSort_EmptyList() {
        List<Bogie> empty = new ArrayList<>();
        assertDoesNotThrow(() -> UC16TrainConsist.bubbleSortAscending(empty));
        assertTrue(empty.isEmpty());
    }

    @Test
    public void testBubbleSort_ListSizeUnchanged() {
        int originalSize = bogieList.size();
        UC16TrainConsist.bubbleSortAscending(bogieList);
        assertEquals(originalSize, bogieList.size());
    }

    @Test
    public void testBubbleSort_AllElementsPresent() {
        UC16TrainConsist.bubbleSortAscending(bogieList);
        // All capacities must still exist after sort
        List<Integer> caps = new ArrayList<>();
        for (Bogie b : bogieList) caps.add(b.getCapacity());
        assertTrue(caps.contains(72));
        assertTrue(caps.contains(18));
        assertTrue(caps.contains(56));
        assertTrue(caps.contains(30));
        assertTrue(caps.contains(64));
    }
}

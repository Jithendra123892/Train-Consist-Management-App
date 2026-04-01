import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    // Filter helper
    private List<Bogie> filterByCapacity(List<Bogie> list, int threshold) {
        return list.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());
    }

    @Test
    public void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> result = filterByCapacity(bogieList, 70);
        assertEquals(1, result.size());
        assertEquals("Sleeper", result.get(0).getName());
    }

    @Test
    public void testFilter_CapacityEqualToThreshold() {
        List<Bogie> result = filterByCapacity(bogieList, 72);
        // Equal to 72 → not included (condition is strictly >)
        assertFalse(result.stream().anyMatch(b -> b.getName().equals("Sleeper")));
    }

    @Test
    public void testFilter_CapacityLessThanThreshold() {
        List<Bogie> result = filterByCapacity(bogieList, 80);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testFilter_MultipleBogiesMatching() {
        List<Bogie> result = filterByCapacity(bogieList, 10);
        assertEquals(3, result.size());
    }

    @Test
    public void testFilter_NoBogiesMatching() {
        List<Bogie> result = filterByCapacity(bogieList, 100);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testFilter_AllBogiesMatching() {
        List<Bogie> result = filterByCapacity(bogieList, 0);
        assertEquals(bogieList.size(), result.size());
    }

    @Test
    public void testFilter_EmptyBogieList() {
        List<Bogie> emptyList = new ArrayList<>();
        List<Bogie> result    = filterByCapacity(emptyList, 60);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testFilter_OriginalListUnchanged() {
        int originalSize = bogieList.size();
        filterByCapacity(bogieList, 60);
        assertEquals(originalSize, bogieList.size());
    }
}

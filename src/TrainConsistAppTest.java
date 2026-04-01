import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
        bogieList.add(new Bogie("Sleeper",     72)); // duplicate type
        bogieList.add(new Bogie("AC Chair",    56)); // duplicate type
    }

    // Grouping helper
    private Map<String, List<Bogie>> groupByType(List<Bogie> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Bogie::getName));
    }

    @Test
    public void testGrouping_BogiesGroupedByType() {
        Map<String, List<Bogie>> result = groupByType(bogieList);
        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
        assertTrue(result.containsKey("First Class"));
    }

    @Test
    public void testGrouping_MultipleBogiesInSameGroup() {
        Map<String, List<Bogie>> result = groupByType(bogieList);
        assertEquals(2, result.get("Sleeper").size());
        assertEquals(2, result.get("AC Chair").size());
    }

    @Test
    public void testGrouping_DifferentBogieTypes() {
        Map<String, List<Bogie>> result = groupByType(bogieList);
        assertEquals(3, result.size()); // Sleeper, AC Chair, First Class
    }

    @Test
    public void testGrouping_EmptyBogieList() {
        List<Bogie> emptyList            = new ArrayList<>();
        Map<String, List<Bogie>> result  = groupByType(emptyList);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testGrouping_SingleBogieCategory() {
        List<Bogie> singleType = new ArrayList<>();
        singleType.add(new Bogie("Sleeper", 72));
        singleType.add(new Bogie("Sleeper", 72));
        Map<String, List<Bogie>> result = groupByType(singleType);
        assertEquals(1, result.size());
        assertTrue(result.containsKey("Sleeper"));
    }

    @Test
    public void testGrouping_MapContainsCorrectKeys() {
        Map<String, List<Bogie>> result = groupByType(bogieList);
        assertTrue(result.keySet().contains("Sleeper"));
        assertTrue(result.keySet().contains("AC Chair"));
        assertTrue(result.keySet().contains("First Class"));
    }

    @Test
    public void testGrouping_GroupSizeValidation() {
        Map<String, List<Bogie>> result = groupByType(bogieList);
        assertEquals(2, result.get("Sleeper").size());
        assertEquals(2, result.get("AC Chair").size());
        assertEquals(1, result.get("First Class").size());
    }

    @Test
    public void testGrouping_OriginalListUnchanged() {
        int originalSize = bogieList.size();
        groupByType(bogieList);
        assertEquals(originalSize, bogieList.size());
    }
}

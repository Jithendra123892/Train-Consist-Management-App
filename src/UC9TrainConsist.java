import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UC9TrainConsist {

    public static void main(String[] args) {

        // ===================== UC9 =====================
        System.out.println("===========================================");
        System.out.println("  UC9: Group Bogies by Type               ");
        System.out.println("       (Collectors.groupingBy)            ");
        System.out.println("===========================================");

        // Step 1: Create bogie list with multiple bogies per type
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper",     72));
        bogieList.add(new Bogie("AC Chair",    56));
        bogieList.add(new Bogie("First Class", 18));
        bogieList.add(new Bogie("Sleeper",     72));  // second Sleeper
        bogieList.add(new Bogie("AC Chair",    56));  // second AC Chair

        // Step 2: Display original flat list
        System.out.println("\n[Original Bogie List]");
        System.out.println("-------------------------------------------");
        for (Bogie b : bogieList) {
            System.out.println("  " + b);
        }
        System.out.println("Total Bogies : " + bogieList.size());

        // Step 3: Group bogies by name/type using groupingBy
        Map<String, List<Bogie>> groupedBogies = bogieList.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        // Step 4: Display grouped structure
        System.out.println("\n[Bogies Grouped by Type]");
        System.out.println("-------------------------------------------");
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println("\n  Type     : " + entry.getKey());
            System.out.println("  Count    : " + entry.getValue().size());
            System.out.println("  Bogies   :");
            for (Bogie b : entry.getValue()) {
                System.out.println("    -> " + b);
            }
        }

        // Step 5: Group summary
        System.out.println("\n[Group Summary]");
        System.out.println("-------------------------------------------");
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.printf("  %-15s : %d bogie(s)%n",
                    entry.getKey(), entry.getValue().size());
        }

        // Step 6: Verify original list unchanged
        System.out.println("\n[Original List After Grouping]");
        System.out.println("Original List Size (Unchanged) : " + bogieList.size());

        // Step 7: Final summary
        System.out.println("\n--- Final Grouping Summary ---");
        System.out.println("Total Bogies         : " + bogieList.size());
        System.out.println("Total Unique Groups  : " + groupedBogies.size());
        System.out.println("---------------------------------------");
    }
}
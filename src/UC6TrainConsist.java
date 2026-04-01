import java.util.HashMap;
import java.util.Map;

public class UC6TrainConsist {

    public static void main(String[] args) {

        // ===================== UC6 =====================
        System.out.println("===========================================");
        System.out.println("   UC6: Map Bogie to Capacity (HashMap)   ");
        System.out.println("===========================================");

        // Step 1: Create HashMap to associate bogie name with capacity
        Map<String, Integer> bogieCapacityMap = new HashMap<>();

        // Step 2: Insert bogie-capacity pairs using put()
        bogieCapacityMap.put("Sleeper",     72);
        bogieCapacityMap.put("AC Chair",    64);
        bogieCapacityMap.put("First Class", 18);

        System.out.println("\n[Bogie Capacity Mapping Added]");
        System.out.println("Total Bogies Mapped : " + bogieCapacityMap.size());

        // Step 3: Iterate and display using entrySet()
        System.out.println("\n[Bogie wise Capacity Details]");
        System.out.println("-------------------------------------------");
        System.out.println("  Bogie Type       | Seating Capacity");
        System.out.println("-------------------------------------------");
        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            System.out.printf("  %-16s | %d seats%n", entry.getKey(), entry.getValue());
        }
        System.out.println("-------------------------------------------");

        // Step 4: Fast lookup using key
        System.out.println("\n[Fast Lookup by Bogie Name]");
        System.out.println("Capacity of 'Sleeper'     : " + bogieCapacityMap.get("Sleeper") + " seats");
        System.out.println("Capacity of 'AC Chair'    : " + bogieCapacityMap.get("AC Chair") + " seats");
        System.out.println("Capacity of 'First Class' : " + bogieCapacityMap.get("First Class") + " seats");

        // Step 5: Final summary
        System.out.println("\n--- Final Bogie Capacity Map ---");
        System.out.println("Mapping : " + bogieCapacityMap);
        System.out.println("Total Bogies Tracked : " + bogieCapacityMap.size());
        System.out.println("---------------------------------------");
    }
}

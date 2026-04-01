import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UC8TrainConsist {

    public static void main(String[] args) {

        // ===================== UC8 =====================
        System.out.println("===========================================");
        System.out.println("  UC8: Filter Passenger Bogies            ");
        System.out.println("       Using Streams                      ");
        System.out.println("===========================================");

        // Step 1: Create original bogie list (reused from UC7)
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper",     72));
        bogieList.add(new Bogie("AC Chair",    56));
        bogieList.add(new Bogie("First Class", 18));

        // Step 2: Display original list
        System.out.println("\n[Original Bogie List]");
        System.out.println("-------------------------------------------");
        for (Bogie b : bogieList) {
            System.out.println("  " + b);
        }
        System.out.println("Total Bogies : " + bogieList.size());

        // Step 3: Apply Stream filter — capacity > 60
        int threshold = 60;
        List<Bogie> filteredList = bogieList.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());

        // Step 4: Display filtered result
        System.out.println("\n[Filtered Bogies — Capacity > " + threshold + "]");
        System.out.println("-------------------------------------------");
        if (filteredList.isEmpty()) {
            System.out.println("  No bogies match the filter condition.");
        } else {
            for (Bogie b : filteredList) {
                System.out.println("  " + b);
            }
        }
        System.out.println("Matching Bogies : " + filteredList.size());

        // Step 5: Verify original list is unchanged
        System.out.println("\n[Original List After Stream Operation]");
        System.out.println("-------------------------------------------");
        for (Bogie b : bogieList) {
            System.out.println("  " + b);
        }
        System.out.println("Original List Size (Unchanged) : " + bogieList.size());

        // Step 6: Additional filter — capacity > 70
        int threshold2 = 70;
        List<Bogie> highCapacity = bogieList.stream()
                .filter(b -> b.getCapacity() > threshold2)
                .collect(Collectors.toList());

        System.out.println("\n[Filtered Bogies — Capacity > " + threshold2 + "]");
        System.out.println("-------------------------------------------");
        if (highCapacity.isEmpty()) {
            System.out.println("  No bogies match the filter condition.");
        } else {
            for (Bogie b : highCapacity) {
                System.out.println("  " + b);
            }
        }
        System.out.println("Matching Bogies : " + highCapacity.size());

        // Step 7: Final summary
        System.out.println("\n--- Final Stream Filter Summary ---");
        System.out.println("Original Bogie Count  : " + bogieList.size());
        System.out.println("Filtered (> 60) Count : " + filteredList.size());
        System.out.println("Filtered (> 70) Count : " + highCapacity.size());
        System.out.println("---------------------------------------");
    }
}
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UC7TrainConsist {

    public static void main(String[] args) {

        // ===================== UC7 =====================
        System.out.println("===========================================");
        System.out.println("  UC7: Sort Bogies by Capacity            ");
        System.out.println("       (Comparator)                       ");
        System.out.println("===========================================");

        // Step 1: Create List of Bogie objects
        List<Bogie> bogieList = new ArrayList<>();

        // Step 2: Add passenger bogies with capacities
        bogieList.add(new Bogie("Sleeper",     72));
        bogieList.add(new Bogie("AC Chair",    56));
        bogieList.add(new Bogie("First Class", 18));

        // Step 3: Display bogies before sorting
        System.out.println("\n[Bogies Before Sorting]");
        System.out.println("-------------------------------------------");
        for (Bogie b : bogieList) {
            System.out.println("  " + b);
        }

        // Step 4: Sort using Comparator by capacity (ascending)
        bogieList.sort(Comparator.comparingInt(Bogie::getCapacity));

        // Step 5: Display bogies after sorting (ascending)
        System.out.println("\n[Bogies Sorted by Capacity - Ascending]");
        System.out.println("-------------------------------------------");
        for (Bogie b : bogieList) {
            System.out.println("  " + b);
        }

        // Step 6: Sort descending using reversed()
        bogieList.sort(Comparator.comparingInt(Bogie::getCapacity).reversed());

        System.out.println("\n[Bogies Sorted by Capacity - Descending]");
        System.out.println("-------------------------------------------");
        for (Bogie b : bogieList) {
            System.out.println("  " + b);
        }

        // Step 7: Final summary
        System.out.println("\n--- Final Consist Summary ---");
        System.out.println("Total Bogies : " + bogieList.size());
        System.out.println("Highest Capacity : " + bogieList.get(0).getName()
                + " → " + bogieList.get(0).getCapacity() + " seats");
        System.out.println("Lowest Capacity  : " + bogieList.get(bogieList.size() - 1).getName()
                + " → " + bogieList.get(bogieList.size() - 1).getCapacity() + " seats");
        System.out.println("---------------------------------------");
    }
}

import java.util.ArrayList;
import java.util.List;

public class UC10TrainConsist{

    public static void main(String[] args) {

        // ===================== UC10 =====================
        System.out.println("===========================================");
        System.out.println("  UC10: Count Total Seats in Train        ");
        System.out.println("        (Stream reduce)                   ");
        System.out.println("===========================================");

        // Step 1: Create bogie list
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper",     72));
        bogieList.add(new Bogie("AC Chair",    56));
        bogieList.add(new Bogie("First Class", 18));

        // Step 2: Display original bogie list
        System.out.println("\n[Bogie List]");
        System.out.println("-------------------------------------------");
        for (Bogie b : bogieList) {
            System.out.println("  " + b);
        }
        System.out.println("Total Bogies : " + bogieList.size());

        // Step 3: Extract capacities using map() and aggregate using reduce()
        int totalSeats = bogieList.stream()
                .map(b -> b.getCapacity())
                .reduce(0, Integer::sum);

        // Step 4: Display total seat count
        System.out.println("\n[Stream Aggregation — map() + reduce()]");
        System.out.println("-------------------------------------------");
        System.out.println("  Sleeper     capacity : 72 seats");
        System.out.println("  AC Chair    capacity : 56 seats");
        System.out.println("  First Class capacity : 18 seats");
        System.out.println("                        ----------");
        System.out.println("  Total Seating Capacity : " + totalSeats + " seats");

        // Step 5: Per bogie contribution %
        System.out.println("\n[Per Bogie Capacity Contribution]");
        System.out.println("-------------------------------------------");
        for (Bogie b : bogieList) {
            double percent = (b.getCapacity() * 100.0) / totalSeats;
            System.out.printf("  %-15s : %2d seats  (%.1f%%)%n",
                    b.getName(), b.getCapacity(), percent);
        }

        // Step 6: Empty list edge case
        List<Bogie> emptyList = new ArrayList<>();
        int emptyTotal = emptyList.stream()
                .map(b -> b.getCapacity())
                .reduce(0, Integer::sum);

        System.out.println("\n[Empty List Aggregation]");
        System.out.println("Total Seats (empty list) : " + emptyTotal);

        // Step 7: Verify original list unchanged
        System.out.println("\n[Original List After Stream Operation]");
        System.out.println("Original List Size (Unchanged) : " + bogieList.size());

        // Step 8: Final summary
        System.out.println("\n--- Final Aggregation Summary ---");
        System.out.println("Total Bogies          : " + bogieList.size());
        System.out.println("Total Seating Capacity: " + totalSeats + " seats");
        System.out.println("---------------------------------------");
    }
}
import java.util.ArrayList;
import java.util.List;

public class UC16TrainConsist {

    // ── Bubble Sort — Ascending ───────────────────────────────
    public static void bubbleSortAscending(List<Bogie> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).getCapacity() > list.get(j + 1).getCapacity()) {
                    // Swap
                    Bogie temp = list.get(j);
                    list.set(j,     list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    // ── Bubble Sort — Descending ──────────────────────────────
    public static void bubbleSortDescending(List<Bogie> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).getCapacity() < list.get(j + 1).getCapacity()) {
                    // Swap
                    Bogie temp = list.get(j);
                    list.set(j,     list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    // ── Display Helper ────────────────────────────────────────
    private static void printBogieList(List<Bogie> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("  Position " + (i + 1) + " : " + list.get(i));
        }
    }

    public static void main(String[] args) {

        // ===================== UC16 =====================
        System.out.println("===========================================");
        System.out.println("  UC16: Sort Bogie Capacities             ");
        System.out.println("        (Bubble Sort)                     ");
        System.out.println("===========================================");

        // Step 1: Create bogie list
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper",     72));
        bogieList.add(new Bogie("First Class", 18));
        bogieList.add(new Bogie("AC Chair",    56));
        bogieList.add(new Bogie("Pantry Car",  30));
        bogieList.add(new Bogie("Garib Rath",  64));

        // Step 2: Display original unsorted list
        System.out.println("\n[Original Bogie List — Unsorted]");
        System.out.println("-------------------------------------------");
        printBogieList(bogieList);

        // Step 3: Bubble sort — ascending
        bubbleSortAscending(bogieList);
        System.out.println("\n[After Bubble Sort — Ascending (Low → High)]");
        System.out.println("-------------------------------------------");
        printBogieList(bogieList);

        // Step 4: Bubble sort — descending
        bubbleSortDescending(bogieList);
        System.out.println("\n[After Bubble Sort — Descending (High → Low)]");
        System.out.println("-------------------------------------------");
        printBogieList(bogieList);

        // Step 5: Step-by-step pass trace (ascending on fresh list)
        System.out.println("\n[Bubble Sort Pass Trace — Ascending]");
        System.out.println("-------------------------------------------");
        List<Bogie> traceList = new ArrayList<>();
        traceList.add(new Bogie("Sleeper",     72));
        traceList.add(new Bogie("First Class", 18));
        traceList.add(new Bogie("AC Chair",    56));
        traceList.add(new Bogie("Pantry Car",  30));
        traceList.add(new Bogie("Garib Rath",  64));

        int n = traceList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (traceList.get(j).getCapacity()
                        > traceList.get(j + 1).getCapacity()) {
                    Bogie temp = traceList.get(j);
                    traceList.set(j,     traceList.get(j + 1));
                    traceList.set(j + 1, temp);
                }
            }
            System.out.print("  Pass " + (i + 1) + " : ");
            for (Bogie b : traceList) {
                System.out.print(b.getCapacity() + " ");
            }
            System.out.println();
        }

        // Step 6: Final summary
        System.out.println("\n--- Final Sort Summary ---");
        System.out.println("  Algorithm     : Bubble Sort");
        System.out.println("  Total Bogies  : " + bogieList.size());
        System.out.println("  Highest Cap   : " + bogieList.get(0).getName()
                + " → " + bogieList.get(0).getCapacity() + " seats");
        System.out.println("  Lowest  Cap   : "
                + bogieList.get(bogieList.size() - 1).getName()
                + " → " + bogieList.get(bogieList.size() - 1).getCapacity() + " seats");
        System.out.println("---------------------------------------");
        System.out.println("  No library sort methods used.");
        System.out.println("  Pure algorithmic implementation.");
        System.out.println("---------------------------------------");
    }
}
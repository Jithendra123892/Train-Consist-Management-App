import java.util.ArrayList;
import java.util.List;

public class UC2TrainConsist {

    public static void main(String[] args) {

        // ===================== UC2 =====================
        System.out.println("===========================================");
        System.out.println("   UC2: Add Passenger Bogies to Train     ");
        System.out.println("===========================================");

        // Step 1: Create ArrayList for passenger bogies
        List<String> bogieList = new ArrayList<>();

        // Step 2: Add passenger bogies using add()
        bogieList.add("Sleeper");
        bogieList.add("AC Chair");
        bogieList.add("First Class");

        // Step 3: Display bogies after insertion
        System.out.println("\n[After Adding Bogies]");
        System.out.println("Passenger Bogies in Consist : " + bogieList);
        System.out.println("Total Bogies                : " + bogieList.size());

        // Step 4: Remove a bogie using remove()
        bogieList.remove("AC Chair");
        System.out.println("\n[After Removing AC Chair]");
        System.out.println("Passenger Bogies in Consist : " + bogieList);
        System.out.println("Total Bogies                : " + bogieList.size());

        // Step 5: Check existence using contains()
        System.out.println("\n[Checking Bogie Existence]");
        System.out.println("Contains 'Sleeper'   : " + bogieList.contains("Sleeper"));
        System.out.println("Contains 'AC Chair'  : " + bogieList.contains("AC Chair"));

        // Step 6: Final consist state
        System.out.println("\n--- Final Consist State ---");
        System.out.println("Bogies : " + bogieList);
        System.out.println("Count  : " + bogieList.size());
        System.out.println("---------------------------------------");
    }
}

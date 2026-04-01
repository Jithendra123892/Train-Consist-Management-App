import java.util.LinkedHashSet;
import java.util.Set;

public class UC5TrainConsist {

    public static void main(String[] args) {

        // ===================== UC5 =====================
        System.out.println("===========================================");
        System.out.println("  UC5: Preserve Insertion Order of Bogies ");
        System.out.println("       (LinkedHashSet)                    ");
        System.out.println("===========================================");

        // Step 1: Create LinkedHashSet to maintain insertion order + uniqueness
        Set<String> trainFormation = new LinkedHashSet<>();

        // Step 2: Attach bogies in physical order
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        System.out.println("\n[Initial Train Formation]");
        System.out.println("Formation : " + trainFormation);
        System.out.println("Total     : " + trainFormation.size());

        // Step 3: Attempt to add duplicate bogie
        System.out.println("\n[Attempting Duplicate Attachment]");
        boolean result = trainFormation.add("Sleeper");
        System.out.println("Trying to attach 'Sleeper' again...");
        System.out.println("Was Sleeper added? : " + result);

        // Step 4: Display formation after duplicate attempt
        System.out.println("\n[Formation After Duplicate Attempt]");
        System.out.println("Formation : " + trainFormation);
        System.out.println("Total     : " + trainFormation.size());

        // Step 5: Display final ordered formation
        System.out.println("\n--- Final Train Formation (Insertion Order) ---");
        int position = 1;
        for (String bogie : trainFormation) {
            System.out.println("  Position " + position + " : " + bogie);
            position++;
        }
        System.out.println("Total Bogies : " + trainFormation.size());
        System.out.println("---------------------------------------");
    }
}

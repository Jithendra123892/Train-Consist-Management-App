import java.util.HashSet;
import java.util.Set;
public class UC3TrainConsist {
        public static void main(String[] args) {

            // ===================== UC3 =====================
            System.out.println("===========================================");
            System.out.println("   UC3: Track Unique Bogie IDs (HashSet)  ");
            System.out.println("===========================================");

            // Step 1: Create HashSet for unique bogie IDs
            Set<String> bogieIdSet = new HashSet<>();

            // Step 2: Add bogie IDs including intentional duplicates
            bogieIdSet.add("BG101");
            bogieIdSet.add("BG102");
            bogieIdSet.add("BG103");
            bogieIdSet.add("BG101"); // duplicate
            bogieIdSet.add("BG102"); // duplicate

            // Step 3: Display result
            System.out.println("\n[Bogie IDs Added]");
            System.out.println("Attempted to add : BG101, BG102, BG103, BG101, BG102");

            System.out.println("\n[Unique Bogie IDs in Consist]");
            System.out.println("Bogie ID Set : " + bogieIdSet);
            System.out.println("Total Unique Bogies : " + bogieIdSet.size());

            // Step 4: Demonstrate duplicate rejection
            System.out.println("\n[Duplicate Check]");
            boolean added = bogieIdSet.add("BG101");
            System.out.println("Trying to add BG101 again...");
            System.out.println("Was BG101 added? : " + added);

            // Step 5: Final summary
            System.out.println("\n--- Final Consist State ---");
            System.out.println("Unique Bogie IDs : " + bogieIdSet);
            System.out.println("Count            : " + bogieIdSet.size());
            System.out.println("---------------------------------------");
        }
 }


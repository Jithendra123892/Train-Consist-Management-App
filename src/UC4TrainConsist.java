import java.util.LinkedList;

public class UC4TrainConsist {

    public static void main(String[] args) {

        // ===================== UC4 =====================
        System.out.println("===========================================");
        System.out.println("  UC4: Maintain Ordered Bogie IDs         ");
        System.out.println("       (LinkedList)                       ");
        System.out.println("===========================================");

        // Step 1: Create LinkedList for ordered train consist
        LinkedList<String> trainConsist = new LinkedList<>();

        // Step 2: Add bogies in physical train order
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("\n[Initial Train Consist]");
        System.out.println("Consist : " + trainConsist);
        System.out.println("Total   : " + trainConsist.size());

        // Step 3: Insert Pantry Car at position 2 (middle)
        trainConsist.add(2, "Pantry Car");
        System.out.println("\n[After Inserting Pantry Car at Position 2]");
        System.out.println("Consist : " + trainConsist);
        System.out.println("Total   : " + trainConsist.size());

        // Step 4: Add bogie at first and last positions
        trainConsist.addFirst("Locomotive");
        trainConsist.addLast("Brake Van");
        System.out.println("\n[After addFirst(Locomotive) and addLast(Brake Van)]");
        System.out.println("Consist : " + trainConsist);
        System.out.println("Total   : " + trainConsist.size());

        // Step 5: Remove first and last bogies
        String removedFirst = trainConsist.removeFirst();
        String removedLast  = trainConsist.removeLast();
        System.out.println("\n[After Removing First and Last]");
        System.out.println("Removed First : " + removedFirst);
        System.out.println("Removed Last  : " + removedLast);
        System.out.println("Consist       : " + trainConsist);
        System.out.println("Total         : " + trainConsist.size());

        // Step 6: Final ordered consist
        System.out.println("\n--- Final Ordered Train Consist ---");
        for (int i = 0; i < trainConsist.size(); i++) {
            System.out.println("  Position " + (i + 1) + " : " + trainConsist.get(i));
        }
        System.out.println("Total Bogies : " + trainConsist.size());
        System.out.println("---------------------------------------");
    }
}
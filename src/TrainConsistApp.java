import java.util.ArrayList;
import java.util.List;

public class TrainConsistApp {

    public static void main(String[] args) {

        // UC1: Welcome Message
        System.out.println("===========================================");
        System.out.println("   === Train Consist Management App ===   ");
        System.out.println("===========================================");

        // UC1: Initialize empty bogie list using List interface + ArrayList
        List<String> bogieList = new ArrayList<>();

        // UC1: Display initial consist summary
        System.out.println("\n--- Consist Summary ---");
        System.out.println("Train Engine  : Ready");
        System.out.println("Total Bogies  : " + bogieList.size());
        System.out.println("Status        : Awaiting bogie attachment");
        System.out.println("---------------------------------------");
        System.out.println("Application initialized successfully.");
    }
}

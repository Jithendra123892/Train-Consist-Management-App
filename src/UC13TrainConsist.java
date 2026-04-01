import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UC13TrainConsist{

    // ── Loop-Based Filtering ──────────────────────────────────
    public static List<Bogie> filterByLoops(List<Bogie> bogieList, int threshold) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogieList) {
            if (b.getCapacity() > threshold) {
                result.add(b);
            }
        }
        return result;
    }

    // ── Stream-Based Filtering ────────────────────────────────
    public static List<Bogie> filterByStream(List<Bogie> bogieList, int threshold) {
        return bogieList.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());
    }

    // ── Large Dataset Generator ───────────────────────────────
    public static List<Bogie> generateLargeDataset(int size) {
        List<Bogie> list = new ArrayList<>();
        String[] types = {"Sleeper", "AC Chair", "First Class"};
        for (int i = 0; i < size; i++) {
            int capacity = 20 + (i % 80); // capacities 20–99
            list.add(new Bogie(types[i % types.length], capacity));
        }
        return list;
    }

    public static void main(String[] args) {

        // ===================== UC13 =====================
        System.out.println("===========================================");
        System.out.println("  UC13: Performance Comparison            ");
        System.out.println("        (Loops vs Streams)                ");
        System.out.println("===========================================");

        final int THRESHOLD = 60;

        // ── Small Dataset ─────────────────────────────────────
        System.out.println("\n[Small Dataset — 3 Bogies]");
        System.out.println("-------------------------------------------");
        List<Bogie> smallList = new ArrayList<>();
        smallList.add(new Bogie("Sleeper",     72));
        smallList.add(new Bogie("AC Chair",    56));
        smallList.add(new Bogie("First Class", 18));

        for (Bogie b : smallList) {
            System.out.println("  " + b);
        }

        // Loop — small
        long startLoop = System.nanoTime();
        List<Bogie> loopResult = filterByLoops(smallList, THRESHOLD);
        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;

        // Stream — small
        long startStream = System.nanoTime();
        List<Bogie> streamResult = filterByStream(smallList, THRESHOLD);
        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;

        System.out.println("\n[Small Dataset Filtering — Capacity > " + THRESHOLD + "]");
        System.out.println("-------------------------------------------");
        System.out.println("  Loop   Result  : " + loopResult.size()
                + " bogie(s) | Time: " + loopTime + " ns");
        System.out.println("  Stream Result  : " + streamResult.size()
                + " bogie(s) | Time: " + streamTime + " ns");
        System.out.println("  Results Match  : " + (loopResult.size() == streamResult.size()));

        // ── Large Dataset ─────────────────────────────────────
        int LARGE_SIZE = 100_000;
        System.out.println("\n[Large Dataset — " + LARGE_SIZE + " Bogies]");
        System.out.println("-------------------------------------------");
        List<Bogie> largeList = generateLargeDataset(LARGE_SIZE);
        System.out.println("  Dataset generated with " + largeList.size() + " bogies.");

        // Loop — large
        long startLoopLarge = System.nanoTime();
        List<Bogie> loopLargeResult = filterByLoops(largeList, THRESHOLD);
        long endLoopLarge = System.nanoTime();
        long loopLargeTime = endLoopLarge - startLoopLarge;

        // Stream — large
        long startStreamLarge = System.nanoTime();
        List<Bogie> streamLargeResult = filterByStream(largeList, THRESHOLD);
        long endStreamLarge = System.nanoTime();
        long streamLargeTime = endStreamLarge - startStreamLarge;

        System.out.println("\n[Large Dataset Filtering — Capacity > " + THRESHOLD + "]");
        System.out.println("-------------------------------------------");
        System.out.printf("  Loop   Result  : %6d bogie(s) | Time: %,d ns%n",
                loopLargeResult.size(), loopLargeTime);
        System.out.printf("  Stream Result  : %6d bogie(s) | Time: %,d ns%n",
                streamLargeResult.size(), streamLargeTime);
        System.out.println("  Results Match  : "
                + (loopLargeResult.size() == streamLargeResult.size()));

        // ── Winner ────────────────────────────────────────────
        System.out.println("\n[Performance Verdict — Large Dataset]");
        System.out.println("-------------------------------------------");
        if (loopLargeTime < streamLargeTime) {
            System.out.println("  Winner : Loop  ✔  (faster by "
                    + (streamLargeTime - loopLargeTime) + " ns)");
        } else if (streamLargeTime < loopLargeTime) {
            System.out.println("  Winner : Stream ✔  (faster by "
                    + (loopLargeTime - streamLargeTime) + " ns)");
        } else {
            System.out.println("  Result : Both performed equally.");
        }

        // ── Final Summary ─────────────────────────────────────
        System.out.println("\n--- Performance Summary ---");
        System.out.printf("  Small Dataset Loop   Time : %,d ns%n", loopTime);
        System.out.printf("  Small Dataset Stream Time : %,d ns%n", streamTime);
        System.out.printf("  Large Dataset Loop   Time : %,d ns%n", loopLargeTime);
        System.out.printf("  Large Dataset Stream Time : %,d ns%n", streamLargeTime);
        System.out.println("---------------------------------------");
        System.out.println("  Note: Results vary per JVM run.");
        System.out.println("  Always measure — never assume.");
        System.out.println("---------------------------------------");
    }
}
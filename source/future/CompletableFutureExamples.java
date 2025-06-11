package future;

import java.util.concurrent.*;

public class CompletableFutureExamples {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        System.out.println("--- Basic Async Execution ---");
        basicAsyncExecution();

        long endTime = System.nanoTime();

        double durationInSeconds = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("Elapsed time: " + durationInSeconds + " seconds");

        System.out.println("\n--- Chaining Computations ---");
        chainingComputations();
        endTime = System.nanoTime();
        durationInSeconds = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("Elapsed time: " + durationInSeconds + " seconds");

        System.out.println("\n--- Combining Multiple Futures ---");
        combiningFutures();

        endTime = System.nanoTime();
        durationInSeconds = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("Elapsed time: " + durationInSeconds + " seconds");

        System.out.println("\n--- Handling Exceptions ---");
        handlingExceptions();

        endTime = System.nanoTime();
        durationInSeconds = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("Before Sleep Elapsed time: " + durationInSeconds + " seconds");

        sleep(50); // Ensuring main thread stays active for async tasks

        endTime = System.nanoTime();
        durationInSeconds = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("Last Elapsed time: " + durationInSeconds + " seconds");
    }

    // Basic Asynchronous Execution
    private static void basicAsyncExecution() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            sleep(2000); // Simulate delay
            return "Hello, CompletableFuture!";
        });

        future.thenAccept(System.out::println); // Executes when the Future completes
        System.out.println("----------------");

        future.join();
    }

    // Chaining Computations with thenApply()
    private static void chainingComputations() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 10)
                .thenApply(n -> n * 2) // Transforms result
                .thenApply(n -> n + 5); // Further processing

        System.out.println("Chained Computation Result: " + future.join()); // Output: 25
    }

    // Combining Two Futures with thenCombine()
    private static void combiningFutures() {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 5);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 10);

        CompletableFuture<Integer> combined = future1.thenCombine(future2, Integer::sum);
        System.out.println("Combined Future Result: " + combined.join()); // Output: 15
    }

    // Handling Exceptions with exceptionally()
    private static void handlingExceptions() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            if (true) throw new RuntimeException("Something went wrong!");
            return 10;
        }).exceptionally(ex -> {
            System.out.println("Error Occurred: "+"---" + ex.getMessage());
            return -1; // Fallback value
        });

        System.out.println("Exception Handling Result: " + future.join()); // Output: -1
    }

    // Helper method to simulate processing delays
    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package future;

import java.util.concurrent.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class FutureExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long startTime = System.nanoTime();
        System.out.println("Hello and welcome!");

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(() -> {
            Thread.sleep(4000); // Simulate a long-running task
            return 42; // Computed result
        });
        Thread.sleep(2000);

        long endTime1 = System.nanoTime();


        System.out.println("Doing other work...");
        System.out.println("Still doing");
        double durationInSeconds = (endTime1 - startTime) / 1_000_000_000.0;

        System.out.println("Elapsed time: " + durationInSeconds + " seconds");
        // Blocking call, waits until the result is available
        System.out.println("Result: " + future.get());
        long endTime2 = System.nanoTime();

        durationInSeconds = (endTime2 - startTime) / 1_000_000_000.0;

        System.out.println("Elapsed time: " + durationInSeconds + " seconds");
        System.out.println("work continues...");
        executor.shutdown();
    }
}
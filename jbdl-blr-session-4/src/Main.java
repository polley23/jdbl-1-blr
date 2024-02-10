import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
//        Incrementor incrementor = new Incrementor();
//        ExecutorService executorService = Executors.newFixedThreadPool(100);
//        Callable<Integer> task = () -> {
//            incrementor.increment();
//            return 0;
//        };
//        Collection<Callable<Integer>> tasks = new ArrayList<Callable<Integer>>();
//        for (int i = 0 ; i < 10000000; i++){
//            tasks.add(task);
//        }
//        try {
//            executorService.invokeAll(tasks);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        executorService.shutdown();
//        incrementor.print();

        OddEvenIncrementor oddEvenIncrementor = new OddEvenIncrementor();

        Runnable printEven = () -> {
            try {
                oddEvenIncrementor.printEven();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable printOdd = () -> {
            try {
                oddEvenIncrementor.printOdd();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread threadEven = new Thread(printEven);
        Thread threadOdd = new Thread(printOdd);

        threadEven.start();
        threadOdd.start();
    }
}
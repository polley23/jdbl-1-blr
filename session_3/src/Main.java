import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
       /* Map<String, String> map = new ConcurrentHashMap<>() {
        };
        map.put("hello","world");
        map.put("hello2","world2");
        map.put("hello3","world3");
        map.put("hello4","world4");
        map.put("hello5","world5");

        for (String s : map.keySet()){
            System.out.println(map.get(s));
            map.remove(s);
        }*/

        // MT

//        Thread thread = new Thread(new Task(), "Thread 1");
//        Thread thread2 = new Thread(new Task(), "Thread 2");
//        thread.setPriority(Thread.MAX_PRIORITY);
//        thread2.setPriority(Thread.MIN_PRIORITY);
//
//        thread.start();
//
//        thread2.start();

        Incrementor incrementor = new Incrementor();

        Callable<Integer> task1 = () -> {
            incrementor.increment();
            return 0;
        };
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        Collection<Callable<Integer>> callableCollections = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            callableCollections.add(task1);
        }
        executorService.invokeAll(callableCollections);
        executorService.shutdown();
        incrementor.print();
    }

}
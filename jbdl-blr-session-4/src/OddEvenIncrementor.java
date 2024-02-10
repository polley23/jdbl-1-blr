import java.util.concurrent.atomic.AtomicInteger;

public class OddEvenIncrementor {
    int i = 0;
    int max = 2000;

    void printEven() throws InterruptedException {
        while(i < max){
            synchronized (this) {
                if (i % 2 == 0) {
                    System.out.println(i++);
                    notify();
                } else {
                    wait();
                }
            }
//            if (i % 2 == 0) {
//                System.out.println(i++);
//            }
        }
    }

    void printOdd() throws InterruptedException {
        while(i < max){
            synchronized (this) {
                if (i % 2 != 0) {
                    System.out.println(i++);
                    notify();
                } else {
                    wait();
                }
            }
//            if (i % 2 != 0) {
//                System.out.println(i++);
//            }
        }


    }

}

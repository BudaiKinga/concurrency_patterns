package race.condition;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by BudaiK on Oct, 2020.
 */
public class Counter {
    AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet();
    }

    public int get() {
        return count.get();
    }

    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        int nrThread = 100;
        List<Thread> threads = new LinkedList<>();
        for (int i = 0; i < nrThread; i++) {
            Thread th = new Thread(() -> c.increment());
            threads.add(th);
            th.start();
        }
        for (Thread th : threads) {
            th.join();
        }
        System.out.println(c.get());

    }
}

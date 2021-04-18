package patterns.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by BudaiK on Nov, 2020.
 */
public class DeadLockExampleWithReentrantLock {

    private Lock lock = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        DeadLockExampleWithReentrantLock instance = new DeadLockExampleWithReentrantLock();
        instance.execute();
    }

    private void execute() {
        new Thread(this::processThis).start();
        new Thread(this::processThat).start();
    }

    private void processThat() {
        while (true) {
            lock.lock();
            lock2.lock();

            System.out.println("Reached processThat");
            lock2.unlock();
            lock.unlock();
        }
    }


    public void processThis() {
        while (true) {
            lock2.lock();
            lock.lock();

            System.out.println("Reached processThis");
            lock.unlock();
            lock2.unlock();
        }

    }
}

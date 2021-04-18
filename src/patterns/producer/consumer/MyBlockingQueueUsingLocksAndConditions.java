package patterns.producer.consumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by BudaiK on Nov, 2020.
 */
public class MyBlockingQueueUsingLocksAndConditions<E> {
    private Queue<E> queue;
    private int size;
    private ReentrantLock lock = new ReentrantLock(true);
    private Condition isFull = lock.newCondition();
    private Condition isEmpty = lock.newCondition();

    public MyBlockingQueueUsingLocksAndConditions(int currentSize) {
        queue = new LinkedList<>();
        this.size = currentSize;
    }

    public void add(E msg) {
        lock.lock();
        try {
            while (queue.size() == size) {
                isFull.await();
            }
            queue.add(msg);
            isEmpty.signalAll();
        } catch (InterruptedException e) {
            System.out.println("Exception interrupt");
        } finally {
            lock.unlock();
        }
    }

    public E take() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                isEmpty.await();
            }
            E e = queue.remove();
            isFull.signalAll();
            return e;
        } catch (InterruptedException e) {
            System.out.println("Exception interrupt");
            return null;
        } finally {
            lock.unlock();
        }
    }

}

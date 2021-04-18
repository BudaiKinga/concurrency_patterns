package patterns.producer.consumer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by BudaiK on Nov, 2020.
 */
public class MyBlockingQueueUsingWaitNotify<E> {
    private final Queue<E> queue;
    private int size;


    public MyBlockingQueueUsingWaitNotify(int currentSize) {
        queue = new LinkedList<>();
        this.size = currentSize;
    }

    public void add(E msg) {
        synchronized (queue) {
            while (queue.size() == size) {
                System.out.println("Full queue, waiting to consume");
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    System.out.println("Expection");
                }
            }
            System.out.println("Adding msg to queue");
            queue.add(msg);
            System.out.println("Notifying that queue is not empty");
            queue.notifyAll();
        }

    }

    public E take() {
        synchronized (queue) {
            while (queue.isEmpty()) {
                System.out.println("Empty queue, waiting");
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    System.out.println("Expection");
                }
            }
            System.out.println("Consuming msg froom queue");
            E e = queue.remove();
            System.out.println("Notify that msg canbe addded to queue");
            queue.notifyAll();
            return e;
        }

    }

}

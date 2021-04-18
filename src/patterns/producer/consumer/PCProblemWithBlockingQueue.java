package patterns.producer.consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by BudaiK on Nov, 2020.
 */
public class PCProblemWithBlockingQueue {

    public static void main(String[] args) {
        int sizeOfQueue = 10;
        BlockingQueue<MyMessage> queue = new ArrayBlockingQueue<>(sizeOfQueue);
        final Runnable producer = () -> {
            while (true) {
                try {
                    System.out.println("Adding msg to queue by thread " + Thread.currentThread().getId());
                    queue.put(new MyMessage());
                } catch (InterruptedException e) {
                    System.out.println("Interrupted producer...");
                }
            }
        };

        Thread th1 = new Thread(producer);
        Thread th2 = new Thread(producer);

        th1.start();
        th2.start();

        Runnable consumer = () -> {
            while (true) {
                try {
                    MyMessage msg = queue.take();
                    System.out.println("Consumer " + Thread.currentThread().getId() + " consumed msg " + msg.getInstance());
                } catch (InterruptedException e) {
                    System.out.println("Interrupted consumer");
                }
            }
        };
        Thread th3 = new Thread(consumer);
        Thread th4 = new Thread(consumer);
        th3.start();
        th4.start();
    }

}

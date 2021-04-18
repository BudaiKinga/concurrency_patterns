package patterns.producer.consumer;

/**
 * Created by BudaiK on Nov, 2020.
 */
public class PCProblemWithoutlockingQueue {
    public static void main(String[] args) {
        exampleOnObjectsAndWait();

//        exampleOnLocksAndConditions();
    }

    private static void exampleOnLocksAndConditions() {
        MyBlockingQueueUsingLocksAndConditions<MyMessage> queue = new MyBlockingQueueUsingLocksAndConditions<>(10);
        Runnable prod = () -> {
            while (true) {
                MyMessage msg = new MyMessage();
                queue.add(msg);
                System.out.println("Added msg " + msg.getInstance() + " by " + Thread.currentThread().getId());
            }
        };

        Runnable cons = () -> {
            while (true) {
                MyMessage msg = queue.take();
                System.out.println("Took msg " + msg.getInstance() + " by " + Thread.currentThread().getId());
            }
        };

        new Thread(prod).start();
        new Thread(cons).start();
    }

    private static void exampleOnObjectsAndWait() {
        MyBlockingQueueUsingWaitNotify<MyMessage> queue = new MyBlockingQueueUsingWaitNotify<>(10);
        Runnable prod = () -> {
            while (true) {
                MyMessage msg = new MyMessage();
                queue.add(msg);
                System.out.println("Added msg " + msg.getInstance() + " by " + Thread.currentThread().getId());
            }
        };

        Runnable cons = () -> {
            while (true) {
                MyMessage msg = queue.take();
                System.out.println("Took msg " + msg.getInstance() + " by " + Thread.currentThread().getId());
            }
        };

        new Thread(prod).start();
        new Thread(cons).start();
    }

}

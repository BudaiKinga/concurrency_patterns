package patterns.deadlock;

/**
 * Created by BudaiK on Nov, 2020.
 */
public class DeadLockExampleWithSynchronized {
    private static final Object obj = new Object();
    private static final Object obj2 = new Object();

    public static void main(String[] args) {
        new Thread(new First()).start();
        new Thread(new Second()).start();
    }

    private static class First implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (obj) {
                    synchronized (obj2) {
                        System.out.println("Reached First");
                    }
                }
            }
        }
    }

    private static class Second implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (obj2) {
                    synchronized (obj) {
                        System.out.println("Reached Second");
                    }
                }
            }
        }
    }

}

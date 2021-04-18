/**
 * Created by BudaiK on Oct, 2020.
 */
public class DoubleCheckedLocking {
    private Object obj = new Object();


    public static void main(String[] args) {
        DoubleCheckedLocking locking = new DoubleCheckedLocking();
        locking.myMethod();
    }

    public void myMethod() {
        synchronized (obj) {
            System.out.println("HEllo");
        }
    }
}

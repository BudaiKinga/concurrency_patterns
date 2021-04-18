package patterns.producer.consumer;

/**
 * Created by BudaiK on Nov, 2020.
 */
public class MyMessage {
    private volatile static int instaneNo = 0;
    private int instance = 0;

    public MyMessage() {
        instaneNo++;
        instance = instaneNo;
    }

    public int getInstance() {
        return instance;
    }

}

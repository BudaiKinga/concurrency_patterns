import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by BudaiK on Oct, 2020.
 */
public class NonThreadSafeObjects {

    public static void main(String[] args) throws ParseException {
        NonThreadSafeObjects obj = new NonThreadSafeObjects();
        Date date = obj.getDate("5/24/2020");
        System.out.println(date);
    }

    private Date getDate(String date) throws ParseException {
        DateFormat format = DateFormat.getDateInstance();
        return format.parse(date);
    }
}

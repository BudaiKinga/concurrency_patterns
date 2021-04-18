import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by BudaiK on Oct, 2020.
 */
public class ThreadSafeCollections {


    public static void main(String[] args) {
        // synchronized collections, mutually exclusive -> if on thread reads/writes/modifies it will be locked
        Map<String, String> map = Collections.synchronizedMap(new HashMap<>());
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());

        // other synchronized mechanisms that permit multiple reads
        CopyOnWriteArrayList<String> listCopyOnWrite = new CopyOnWriteArrayList<>();
        Map<String, String> mapCopyOnWrite = new ConcurrentHashMap<>();

    }
}



package guava;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.List;

/**
 * Created by yanghongwu on 2017/7/12.
 */
public class MultiMapTest {

    public static void main(String[] args) {
        Multimap<String,User> userMultimap = ArrayListMultimap.create();

        userMultimap.put("yang1", new User() {{
            setName("yang1");
        }});

        userMultimap.put("yang1", new User() {{
            setName("yang11");
        }});

        userMultimap.put("yang2", new User() {{
            setName("yang2");
        }});


        List<User> userList = (List)userMultimap.get("yang1");

        for (User u : userList) {

            System.out.println(u.getName());

        }
    }

}

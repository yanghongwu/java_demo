package openframework.fastjson;

import com.alibaba.fastjson.JSON;

/**
 * Created by yanghongwu on 2017/3/8.
 */
public class FastjsonTest {
    public static void main(String[] args) {
        User u1 = new User();
        String jsonStrng = JSON.toJSONString(u1);

        User u2 = JSON.parseObject("{\"name\":\"test\",\"age\":2}", User.class);
    }
}

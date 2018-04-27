package hutool;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.Singleton;
import cn.hutool.core.util.RuntimeUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import cn.hutool.script.ScriptUtil;

/**
 * Created by yanghongwu on 2018/1/16.
 */
public class MainTest {
    public static void main(String[] args) {
        String str = RuntimeUtil.execForStr("jstat -gcutil 12");
        System.out.println(str);
        Assert.notNull(null);

        Log log = LogFactory.get();
        log.info("", new RuntimeException());
    }
}

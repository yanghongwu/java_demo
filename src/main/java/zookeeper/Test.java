package zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanghongwu on 2017/6/21.
 */
public class Test {

    public static void main(String[] args) {
        Watcher watcher = new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("监听到事件: " + watchedEvent);
            }
        };
        List<ACL> acls = new ArrayList<ACL>();
        //添加第一个id，采用用户名密码形式
        Id id1 = null;
        try {
            id1 = new Id("digest",
                    DigestAuthenticationProvider.generateDigest("admin:admin"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        ACL acl1 = new ACL(ZooDefs.Perms.ALL, id1);
        acls.add(acl1);
        //添加第二个id，所有用户可读权限
        Id id2 = new Id("world", "anyone");
        ACL acl2 = new ACL(ZooDefs.Perms.READ, id2);
        acls.add(acl2);

        try {
            ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2161", 9999999, watcher);
            System.out.println("获得连接: " + zooKeeper);

            zooKeeper.create("/zk1", "hello zookeeper".getBytes(), acls, CreateMode.PERSISTENT);

            final byte[] data= zooKeeper.getData("/zk1", watcher, null);
            System.out.println("读取的值：" + new String(data));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}

package socket;

import java.net.*;
import java.util.Enumeration;

/**
 * Created by yanghongwu on 2017/6/12.
 */
public class InetAddressExample {

    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaceList = NetworkInterface.getNetworkInterfaces();
            if (interfaceList == null) {
                System.out.println("---No interface found-");
            } else {
                while (interfaceList.hasMoreElements()) {
                    NetworkInterface iface = interfaceList.nextElement();
                    System.out.println("Interface: " + iface.getName());

                    Enumeration<InetAddress> addrList = iface.getInetAddresses();
                    if (!addrList.hasMoreElements()) {
                        System.out.println("\t(No addresses for thisinterface)");
                    }

                    while (addrList.hasMoreElements()) {
                        InetAddress address = addrList.nextElement();
                        System.out.println(address instanceof Inet4Address ? "(v4)" : address instanceof Inet6Address ? "(v6)" : "(?)");
                        System.out.println(": " + address.getHostAddress());
                    }
                    System.out.println();
                }
            }

            for (String host : args) {
                System.out.println(host + ":");
                try {
                    InetAddress[] addressesList = InetAddress.getAllByName(host);
                    for (InetAddress address : addressesList) {
                        System.out.println("\t" + address.getHostName() + "/" + address.getHostAddress());
                    }
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }

            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

}

package InetAddr;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetAddr {
    public static void main(String[] args) throws UnknownHostException {

        InetAddress localIP = InetAddress.getLocalHost();
        System.out.println("내 컴퓨터의 Host Name : "+localIP.getHostName());
        System.out.println("내 컴퓨터의 Host Name : "+localIP.getHostAddress());
        System.out.println();
    }

}

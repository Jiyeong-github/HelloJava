package InetAddr;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class CheckServer {
    public static void main(String[] args){
        System.out.println("InetAddress와 isReachable 사용해서 ping 체크하기");

        try{

            /*[설 명]
             * 1. InetAddress.getByName(ip 주소); : 서버 아이피 주소를 지정합니다
             * 2. isReachable : 타임아웃 체크로 해당 서버에서 응답이 있을 경우 true 반환, 응답이 없을 경우 false 반환합니다
             * */

            InetAddress pingCheck = InetAddress.getByName("192.168.19.111");
            boolean isChecked = pingCheck.isReachable(1000);
            System.out.println("서버 응답:"+isChecked);
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
}

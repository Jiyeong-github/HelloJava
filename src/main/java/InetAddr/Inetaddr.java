package InetAddr;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Inetaddr {
    //InetAddress 클래스는 자바에서 IP 주소를 표현할 때 사용하는 클래스
    //InetAddress 클래스의 생성자는 하나만 존재하나, 기본 생성자의 접근 제한자가 default라서 new 연산자 객체 생성 불가
    //대신 static으로 InetAddress 객체를 생성하는 메서드 (5개 존재)
    //InetAddress의 주요 메서드
    /*
    * getAddress() : InetAddress 객체의 IP 주소를 반환
    * getHostAddress() : IP 주소를 반환
    * getHostName() : 호스트 이름을 문자열로 반환
    */

    public static void main(String args[]) throws UnknownHostException{
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println("로컬 컴퓨터 이름:"+addr.getHostName());
        System.out.println("로컬 컴퓨터 IP 주소:"+addr.getHostAddress());

        addr = InetAddress.getByName("www.naver.com");
        System.out.println("www.naver.com의 이름과 IP 주소:"+ addr);

        InetAddress sw[] = InetAddress.getAllByName(("www.naver.com"));

        for(int i=0; i<sw.length; i++){
            System.out.println(sw[i]);
        }

    }
}

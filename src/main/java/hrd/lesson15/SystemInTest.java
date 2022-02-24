package hrd.lesson15;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class SystemInTest {

    public static void main(String[] args) throws IOException {

        int i = System.in.read(); // System.in보다 자주 활용 가능한 클래스 'Scanner'
        System.out.println(i + ","+(char)i);

        Scanner scanner = new Scanner(System.in);
        System.out.println("이름:");
        String name = scanner.nextLine();
        System.out.println("번호:");
        int num = scanner.nextInt();

        System.out.println(name);
        System.out.println(num);

        Socket socket = new Socket();
        socket.getInputStream(); //Socket에서 데이터 읽기 - 바이트 스트림으로 한글 읽기 불가
        //BufferedReader br = new BufferedInputStream(new InputStreamReader(socket.getInputStream())); // 이러면 한글 읽기 가능


    }

}

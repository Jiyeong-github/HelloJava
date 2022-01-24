package SocketServer;


import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketThreadServer extends Thread{

    private static final Logger logger = Logger.getLogger(SocketThreadServer.class);
    //빠르고 효과적으로 로깅할 수 있도록 도와주는 오픈 소스로 로깅 메세지를 Appender에게 전달

    private Socket socket;

    public SocketThreadServer(Socket socket){
        this.socket = socket;
    }

    //단순 문자열 Thread Server
    public void run(){
        BufferedReader br = null;
        //Scanner와 유사하지만 많은 양의 데이터를 처리할 때 용이함.
        //readLine(0시 리턴 값이 String으로 고정되어 있어서 String이 아닌 다른 타입으로 입력을 받으려면 형변환 필수.
        //예외 처리 필수
        PrintWriter pw = null;
        //문자열 출력

        try{
            String connIP = socket.getInetAddress().getHostAddress(); //InetAddress : IP 번호를 처리할 때 사용, HostAddress : 호스트의 IP 주소를 이용해 iadder의 호스트 ip 주소를 받아 옴
            System.out.println(connIP+"에서 연결 시도.");
            /*접근한 소켓 계정의 ip를 체크 -> KTOA 연동 모듈인지 체크
            * 정상이면 먼저 정상 접근되었음을 의미*/

            br = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            //InputStreamReader : 키보드에서 생성한 문자열은 키보드 버퍼에 정보를 저장해 뒀다가 사용자가 입력을 마치면 문자열이 JVM에 전달되고 전달된 문자는 다시 System.in인 InputStream 객체로 저장.
            pw = new PrintWriter(socket.getOutputStream());

            //클라이언트에서 보낸 문자열 출력
            System.out.println(br.readLine());

            //클라이언트에 문자열 전송
            pw.println("수신 완료");
            pw.flush(); //출력 스트림과 버퍼된 출력 바이트를 강제로 쓰게 함.
        }catch (IOException e) {
           logger.error(e);
        }finally{
            try{
                if(pw != null){pw.close();}
                if(br != null){br.close();}
                if(socket != null){socket.close();}
            }catch (IOException e){
                logger.error(e);
            }
        }
    }
}

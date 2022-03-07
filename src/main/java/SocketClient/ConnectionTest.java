package SocketClient;

import java.io.IOException;
import java.net.Socket;

public class ConnectionTest{
        public static void main(String[] args) {
            Socket socket;
            {
                try {
                    socket = new Socket("127.0.0.1", 4432);
                    boolean result = socket.isConnected();
                    if(result) System.out.println("서버에 연결됨");
                    else System.out.println("서버에 연결 실패");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
}

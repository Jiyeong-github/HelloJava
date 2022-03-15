package InetAddr;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class CheckPort {
    public static void main(String[] args){
        for(String host: args){
            try{
                Socket socket = new Socket("127.0.0.1", 4);
                System.out.println(socket.getInetAddress()+"의"+socket.getPort()
                +"포트에"+socket.getLocalAddress()+"의"+socket.getLocalPort()+"포트로 연결되었습니다."
                );
            }catch (UnknownHostException e){
                System.out.println(host+"를 찾을 수 없습니다.");
            }catch (SocketException e){
                System.out.println(host+"에 연결할 수 없습니다.");
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

package SocketClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private Socket socket;
    private BufferedReader br;
    private PrintWriter pw;

    public Client(String ip, int port){

            try {
                //서버에 요청 보내기
                socket = new Socket(ip, port);
                System.out.println(socket.getInetAddress().getHostAddress() + "에 연결됨");

                //메시지 받기
                br = new BufferedReader(new InputStreamReader((socket.getInputStream())));
                pw = new PrintWriter(socket.getOutputStream());

                //메시지 전달
                pw.println("메시지 발송");
                pw.flush();

                //응답 출력
                System.out.println(br.readLine());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } finally {
                //소켓 연결 종료
                try {
                    if (socket != null) {
                        socket.close();
                    }
                    if (br != null) {
                        br.close();
                    }
                    if (pw != null) {
                        pw.close();
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }


package SocketClient;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Client3rd {
    private Socket socket;
    private BufferedReader br;
    private PrintWriter pw;

    public Client3rd(String ip, int port){
        try{
            //서버에 요청 보내기
            socket = new Socket(ip, port);
            System.out.println(socket.getInetAddress().getHostAddress()+"연결됨");

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream());

            ArrayList<BoardVO> list = new ArrayList<>();
            for(int i=0; i<5; i++){
                BoardVO vo= new BoardVO();
                vo.setTitle(i+"번째 제목");
                vo.setContent("문자열 테스트 컨텐츠");
                vo.setIdx(i);
                vo.setWriter("졍쓰");
                list.add(vo);
           }
            JsonObject jo = new JsonObject();
           // jo.put("list",list);

            //VO 메시지 발송
            pw.println(new Gson().toJson(jo));
            pw.flush();

            //발송 후 메시지 받기
            System.out.println(br.readLine());
        }catch (IOException e){
            System.out.println(e);
        }finally {
            //연결 끊기
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
                System.out.println(e);
            }
        }
    }
}

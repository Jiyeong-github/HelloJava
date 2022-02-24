package SocketServer;

import com.google.gson.Gson;
import com.sun.javafx.collections.MappingChange;
import netscape.javascript.JSObject;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SocketThreadServer3rd extends Thread {

    private static Class<SocketServer.SocketThreadServer3rd> SocketThreadServer3rd;
    private static final Logger logger = Logger.getLogger(SocketThreadServer3rd);

    private Socket socket;

    public SocketThreadServer3rd(Socket socket) {
        this.socket = socket;
    }

//    private static final InterlockDao interlockDao = InterlockDao.getInstance();

    //JSON 데이터 넘기기 -> list 키에 담아서 발송(파싱 부분 Map 형태)
    public void run() {
        BufferedReader br = null;
        PrintWriter pw = null;

        try {
            String connIp = socket.getInetAddress().getHostAddress();
            System.out.println(connIp + "에서 연결 시도");

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream());

            //클라이언트에서 보낸 문자열 출력
            String returnMessage = br.readLine();
            System.out.println(returnMessage);

            Gson gson = new Gson();
            JSObject jo = gson.fromJson(returnMessage, JSObject.class);
            // List<Map<Object, Object>> list = (ArrayList<MappingChange.Map<Object, Object>>) jo.get("list");

         /*   for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).toString());
            }*/
            //클라이언트에 문자열 전송
            pw.println("수신 완료");
            pw.flush();

            HashMap<String, Object> params = new HashMap<String, Object>();
            //List<Map<String, Object>> test = interlockDao.selectTest(params);
           /* for (int i = 0; i < test.size(); i++) {
                System.out.println(test.get(i));
            }*/
        } catch (IOException e) {
            logger.error(e);
        } finally {
            try {
                if (pw != null) {
                    pw.close();
                }
                if (br != null) {
                    br.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                logger.error(e);
            }
        }
    }
}

package SocketServer;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
//VO 데이터 직렬화해서 넘기는 방법 - ObjectInputStream과 ObjectOutputStream
public class SocketThreadSever2nd extends Thread {

    private static final Logger logger = Logger.getLogger(SocketThreadServer.class);

    private Socket socket;

    public SocketThreadSever2nd(Socket socket) {
        this.socket = socket;
    }

    //vo형태 serializable 데이터 넘기기
    public void run() {
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(socket.getInputStream());
            oos = new ObjectOutputStream(socket.getOutputStream());

            HashMap<Object, Object> map = (HashMap<Object, Object>) ois.readObject();
            ArrayList<BoardVO> list = (ArrayList<BoardVO>) map.get("list");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).toString());
            }

            oos.writeObject(map);
            oos.flush();
        } catch (IOException e) {
            logger.error(e);
        } catch (ClassNotFoundException e) {
            logger.error(e);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (ois != null) {
                    ois.close();
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



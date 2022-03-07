package SocketClient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class SndClient {
    private Socket socket;
    private ObjectOutputStream oos; //객체의 직렬화를 역직렬화
    private ObjectInputStream ois; //객체를 직렬화하여 전송

    public SndClient(String ip, int port){
        try{
            //서버에 요청보내기
            socket = new Socket(ip, port);
            System.out.println(socket.getInetAddress().getHostAddress()+"연결됨");

            oos = new ObjectOutputStream(socket.getOutputStream());

            ArrayList<BoardVO> list = new ArrayList<>();
            /*ArrayList는 list 인터페이스를 상속받은 클래스로 크기가 가변적으로 변하는 선형리스트*/
            for(int i=0; i<5; i++){
                BoardVO vo = new BoardVO();
                vo.setTitle(i+"번째 제목");
                vo.setContent("문자열 테스트 컨텐츠");
                vo.setIdx(i);
                vo.setWriter("졍쓰");
                list.add(vo);
            }

            HashMap<Object, Object> map = new HashMap<>();
            //HashMap은 Map 인터페이스를 구현했으며, Map은 key와 value로 구성된 Entry 객체를 저장하는 구조를 가짐.
            //키는 중복 저장 불가능. 많은 양의 데이터를 검색하는데 유리함.
            map.put("list",list);
            //VO 메세지 발송
            oos.writeObject(map);
            oos.flush();

            //발송 후 메시지 받기
            ois = new ObjectInputStream(socket.getInputStream());
            //응답 출력
            HashMap<Object, Object> returnMap = (HashMap<Object, Object>) ois.readObject();
            //readObject() 메소드는 스트림에서 객체를 읽는데 사용, 전송된 객체의 유형과 동일한 형태로 캐스팅 후 파싱 필요.
            ArrayList<BoardVO> returnList = (ArrayList<BoardVO>) returnMap.get("list");
            for(int i=0; i<returnList.size(); i++){
                System.out.println(returnList.get(i).toString());
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }finally {
                //소켓 닫기
                try{
                    if(socket != null){socket.close();}
                    if(oos != null){oos.close();}
                    if(ois != null){ois.close();}
                }catch (IOException e){
                    System.out.println(e.getMessage());
                    }
            }
        }
    }

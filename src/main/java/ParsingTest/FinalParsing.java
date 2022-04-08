package ParsingTest;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;

public class FinalParsing {

    static URL url = null;
    static HttpURLConnection connection = null;
    static PreparedStatement prst =null;
    static Connection con = null;
    //프로토콜이 http인 경우 HttpURLConnection으로 객체 캐스팅 가능

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, SQLException {
        String xmlString = URLCall();
        List<Map<String, Object>> dataList = parsing(xmlString);

        getDbConnection();
        dbInsert(dataList);
        freeConnection();

    }

    public static String URLCall() throws IOException{
        try{
            url = new URL("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson?serviceKey=uXaKeTiEK0mlqvsqLLlHxCx95yE3V0DKIpj9jAAyBPPN17VRhX9ipGXmiPodpawd5j5N4X%2BzJ%2BraOmxxUExmGw%3D%3D&pageNo=1&numOfRows=10&startCreateDt=20200310&endCreateDt=20200315");
        } catch (MalformedURLException e) {
            System.out.println("잘못된 url입니다.");
        }

        try{
            connection = (HttpURLConnection) url.openConnection();
        }catch (IOException e) {
            System.out.println("연결 중 I/O Exception 발생");
        }

        try{ //url 요청에 대한 메소드 설정
            connection.setRequestMethod("GET");
        }catch (IOException e) {
            System.out.println("연결 중 프로토콜 오류 발생");
        }

        connection.setRequestProperty("Content-Type","text/html"); //key,value로 지정된 일반 요청 속성 지정
        connection.setConnectTimeout(5000); //연결 타임아웃
        connection.setReadTimeout(5000);//읽기 타임아웃
        connection.setInstanceFollowRedirects(true); //리다이렉트 자동

        //inputstream : 읽기가 가능한 바이트 스트림
        InputStream is = (InputStream) connection.getContent(); //내용 가져오기
//        String result = IOUtils.toString(is, StandardCharsets.UTF_8);
//        System.out.println(result);

        String newLine = System.getProperty("line.separator");
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder result = new StringBuilder();

        for (String line; (line = reader.readLine()) != null; ) {
            if (result.length() > 0) {
                result.append(newLine);
            }
            result.append(line);
        }
        connection.disconnect();
        return result.toString();
    }

    public static List<Map<String, Object>> parsing(String xmlString) throws ParserConfigurationException, SAXException, IOException{
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>(); //리스트 생성

        //XML 파싱
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource inputS = new InputSource( new StringReader( xmlString ) );

        Document document = builder.parse(inputS);

        NodeList nodeList = document.getElementsByTagName("item");

        for(int i=0; i<nodeList.getLength(); i++){
            Map<String, Object> dataMap = new HashMap<String, Object>();
            Node node = nodeList.item(i);
            NodeList nodeList2 = node.getChildNodes();

            for(int j = 0 ; j<nodeList2.getLength(); j++){
                Node node2 = nodeList2.item(j);
                String key = node2.getNodeName();
                String value = getTagValue(key,node2);
                dataMap.put(key,value);
            }
            list.add(dataMap);
        }
        return list;
    }

    public static void getDbConnection(){
        //DB 연결
        String server = "jdbc:mariadb://127.0.0.1:3306";
        String database = "test";
        String user_name = "root";
        String password = "비밀이지롱";

        //드라이버 로딩
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println(" 드라이버 로딩 오류 : " + e.getMessage());
            e.printStackTrace();
        }
        //드라이버 연결
        try {
            con = DriverManager.getConnection(
                    server + "/" +database +"?useSSL=false", user_name, password); // SSL 실행 확인
            System.out.println("연결 성공");
        } catch(SQLException e) {
            System.err.println("에러 내용 :" + e.getMessage());
            e.printStackTrace();
        }

        try {
            if(con != null)
                con.close();
        } catch (SQLException e) {

        }
    }

    public static void dbInsert(List<Map<String, Object>> dataList) throws SQLException{
        //SQL Insert
        String sql = "insert into TB_COVID(ACCDEFRATE,ACCEXAMCNT,CREATEDT,DEATHCNT,DECIDECNT,SEQ,STATEDT,STATETIME,UPDATEDT) values(?,?,?,?,?,?,?,?,?)";

        for(Map<String, Object> dataMap : dataList){
            String a = (String) dataMap.get("ACCDEFRATE");
            String b = (String) dataMap.get("ACCEXAMCNT");
            String c = (String) dataMap.get("CREATEDT");
            String d = (String) dataMap.get("DEATHCNT");
            String e = (String) dataMap.get("DECIDECNT");
            String f = (String) dataMap.get("SEQ");
            String g = (String) dataMap.get("STATEDT");
            String h = (String) dataMap.get("STATETIME");
            String i = (String) dataMap.get("UPDATEDT");

            prst = con.prepareStatement(sql);
            prst.setString(1,a);
            prst.setString(2,b);
            prst.setString(3,c);
            prst.setString(4,d);
            prst.setString(5,e);
            prst.setString(6,f);
            prst.setString(7,g);
            prst.setString(8,h);
            prst.setString(9,i);
            prst.execute(sql);
        }
    }


    //connection.close() 하는 메소드
    public static void freeConnection() throws SQLException{
        prst.close();
        con.close();
    }

    // tag값의 정보를 가져오는 메소드
    private static String getTagValue(String tag, Node node2) {
        NodeList list = node2.getChildNodes();
        String xmlValue = list.item(0).getNodeValue();

        return xmlValue;
    }
}


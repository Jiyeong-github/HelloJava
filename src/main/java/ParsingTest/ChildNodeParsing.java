package ParsingTest;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ChildNodeParsing {
    static Map<String, Object> map = new HashMap<>();

    public static void main(String[] args) {
        try {
            File file = new File(Paths.get("").toAbsolutePath() + "/src/main/resources/xml/partner.xml");
            File NewFile = new File(Paths.get("").toAbsolutePath() + "/src/main/resources/xml/partner_new.xml");
            //파일 읽기
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(file);
            Document doc = builder.parse(NewFile);
            document.getDocumentElement().normalize();
            doc.getDocumentElement().normalize();

            System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());
            System.out.println("New Element : " + document.getDocumentElement().getNodeName());
            System.out.println("파일 출력");

            //읽어들인 파일 불러오기
            NodeList nodeList = doc.getElementsByTagName("host");
            NodeList Listnode = document.getElementsByTagName("host");

            setMap(nodeList);
            setMap(Listnode);
            System.out.println(map);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setMap(NodeList nodeList){
        // XML 데이터 중 <host> 태그의 내용을 가져온다.
        // <host> 태그 리스트를 하나씩 돌면서 값들을 가져온다.
        for (int i = 0; i < nodeList.getLength(); ++i) {
            Node node = nodeList.item(i);
            Element element = (Element) node;
            // 속성 값인 이름 가져오기.
            String nodeValue = nodeList.item(i).getAttributes().getNamedItem("alias").getNodeValue();
            // <alias> 태그의 하위 노드들을 가져온다. ( 여기서 노드는 태그를 의미한다. )
            NodeList childNodes = nodeList .item(i).getChildNodes();
            for (int j = 0; j < childNodes.getLength(); ++j) {
                if(nodeValue.isEmpty()){
                    map.put("value",nodeValue.equals("GAC#1"));
                }else if(!nodeValue.isEmpty()){
                    if(nodeList.item(i).getAttributes().getNamedItem("alias").equals("")){
                        if ("url".equals(childNodes.item(j).getNodeName())){
                            map.remove("url",element.getAttribute("url"));
                            map.put("url",element.getAttribute("url"));
                        }
                        if ("description".equals(childNodes.item(j).getNodeName())) {
                            map.remove("description",element.getAttribute("description"));
                            map.put("description",element.getAttribute("description"));
                        }
                    }
                }
            }
        }
    }
}

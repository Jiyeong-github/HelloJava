package ParsingTest;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.nio.file.Paths;
import java.util.*;

public class HashmapParsing {

    static Document document = null;
    Map<String, String> map = new HashMap<>();

    public static void main(String[] args) {

        try {
            File file = new File(Paths.get("").toAbsolutePath() + "/src/main/resources/xml/partner.xml");
            File NewFile = new File(Paths.get("").toAbsolutePath() + "/src/main/resources/xml/partner_new.xml");
            //파일 읽기
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            ;
            Document docm = builder.parse(file);
            Document doc = builder.parse(NewFile);
            docm.getDocumentElement().normalize();
            doc.getDocumentElement().normalize();

            System.out.println("파일 출력");

            //읽어들인 파일 불러오기
            NodeList nodeList = doc.getElementsByTagName("host");
            NodeList Listnode = docm.getElementsByTagName("host");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setNode(NodeList nodeList) {
        if (document == null) return;
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeName().equals("host")) {
                Node node = nodeList.item(i);
                //자식 노드 목록
                NodeList ChildNode = document.getDocumentElement().getChildNodes();
                Element element = (Element)node;
                String NodeName = element.getNodeName();
                String NodeThing = element.getChildNodes().item(i).getNodeValue();

                if(NodeName.equals("alias")){
                    NodeThing.replace(ChildNode.);
                }
                //같은 node가 있다면 새 node로 replace (2개)
                //새로운 node는 put (1개)
                //기존 node들은 냅두기(중복되는 거 많음)
                if(node.getAttributes().getNamedItem("alias").getNodeValue().equals(node.getAttributes().getNamedItem("alias").getNodeValue())){

                }else if(){

                }

            }
        }
    }
}


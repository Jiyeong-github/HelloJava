package ParsingTest;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.naming.event.ObjectChangeListener;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.nio.file.Paths;
import java.util.*;

public class HashmapParsing {

    static Document document = null;
    static Map<String, Object> map = new HashMap<>();

    public static void main(String[] args) {
        try {
            File file = new File(Paths.get("").toAbsolutePath() + "/src/main/resources/xml/partner.xml");
            File NewFile = new File(Paths.get("").toAbsolutePath() + "/src/main/resources/xml/partner_new.xml");
            //파일 읽기
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();

            Document docm = builder.parse(file);
            Document doc = builder.parse(NewFile);
            docm.getDocumentElement().normalize();
            doc.getDocumentElement().normalize();

            System.out.println("파일 출력");

            //읽어들인 파일 불러오기
            NodeList nodeList = doc.getElementsByTagName("host");
            NodeList Listnode = docm.getElementsByTagName("host");

            setNode(nodeList);
            setNode(Listnode);
            System.out.println(map);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //같은 node가 있다면 새 node로 replace (2개)
    //새로운 node는 put (1개)
    //기존 node들은 냅두기(중복되는 거 많음)


    private static void setNode(NodeList nodeList) {
        if (document == null) return;
        //root 구하기
        Element root = document.getDocumentElement();
        //자식 노드 목록
        NodeList ChildNode = document.getDocumentElement().getChildNodes();

        List<Object> list = new ArrayList<>();
        nodeList = nodeList.item(0).getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node deno = nodeList.item(i);
            System.out.println("nodeList" + i + "번째");
            if (deno.getNodeType() == Node.ELEMENT_NODE) {
                //node 엘리먼트가 자식 node일 경우 실행
                if (nodeList.item(i).getNodeName().equals("host")) {
                    for (int j = 0; j < ChildNode.getLength(); j++) {
                        Node node = ChildNode.item(j);
                        if (node.getFirstChild().isEqualNode(root)) {
                            Element element = (Element) node;
                            String NodeName = element.getNodeName();

                            node.removeChild(root);
                            node.appendChild(root);
                            System.out.println(NodeName);
                        }
                        System.out.println(node);
                    }//2nd for

                    Node node = nodeList.item(i);
                    Element element = (Element) node;
                    //GAC#01
                    if (!element.getAttribute("alias").equals("")) {
                        map.put("alias", element.getAttribute("alias"));
                    }
                    if (element.getNodeName().equals("alias")) {
                        map.remove("alias", element.getAttribute("alias"));
                        map.putIfAbsent("alias", element.getAttribute("alias"));
                    }
                    list.add(map);

                }

            }
        }
    }
}


package ParsingTest;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapListParsing {
    static Document document = null;
    static List<Object> list = new ArrayList<>();
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

            System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());
            System.out.println("New Element : " + docm.getDocumentElement().getNodeName());
            System.out.println("파일 출력");

            //읽어들인 파일 불러오기
            NodeList nodeList = doc.getElementsByTagName("host");
            NodeList Listnode = docm.getElementsByTagName("host");

            setNode(nodeList);
            setNode(Listnode);
            System.out.println(map);
            System.out.println("파일의 길이 : " + nodeList.getLength());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setNode(NodeList nodeList) {
        if (document == null) return;
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeName().equals("host")) {
                Node node = nodeList.item(i);
                System.out.println("nodeList" + i + "번째");

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    //노드명
                    System.out.println("node 이름 : " + node.getNodeName());

                    if (!element.getAttribute("alias").equals("")) {
                        map.put("alias", element.getAttribute("alias"));
                    }
                    if (element.getNodeName().equals("alias")) {
                        map.remove("alias", element.getAttribute("alias"));
                        map.putIfAbsent("alias", element.getAttribute("alias"));
                    }
                    list.add(map);
                    //element - if

                    //childnode
                    if (node.getNodeName().equals("alias")) {
                        NodeList dataList = node.getChildNodes();

                        List<Map<String, Object>> mapList = new ArrayList<>();
                        System.out.println("datList의 길이: " + dataList.getLength());
                        for (int j = 0; j < dataList.getLength(); j++) {
                            Node deno = dataList.item(j);
                            if (deno.getNodeType() == Node.ELEMENT_NODE) {
                                Element elem = (Element) deno;
                                Map<String, Object> stringObjectMap = new HashMap<>();

                                stringObjectMap.put("alias", elem.getAttribute("alias"));

                                mapList.add(stringObjectMap);
                            }
                        }
                        map.put("alias", mapList);
                    }//childnode - if
                }
                System.out.println("-------------------");
            }//nodelist - for
            System.out.println(list);
            for (Object node : list) {
                if (node instanceof Map) {
                    System.out.println(node);
                } else if (node instanceof List) {
                    List<Map<String, Object>> arrayList = (ArrayList<Map<String, Object>>) node;
                    for (Object map : arrayList) {
                        System.out.println(map);
                    }
                }
            }
        }
    }
}



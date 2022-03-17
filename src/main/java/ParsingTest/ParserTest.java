package ParsingTest;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.nio.file.Paths;
import java.util.*;

public class ParserTest {

    static Document doc = null;
    static Set set = new HashSet<>();


    public static void main(String[] args) {
        try {
            //파일 경로
            File file = new File(Paths.get("").toAbsolutePath() + "/src/main/resources/xml/partner.xml");
            File NewFile = new File(Paths.get("").toAbsolutePath() + "/src/main/resources/xml/partner_new.xml");
            //파일 읽기
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            doc = builder.parse(file);
            Document document = builder.parse(NewFile);
            doc.getDocumentElement().normalize();
            document.getDocumentElement().normalize();

            System.out.println("파일 출력");

            //읽어들인 파일 불러오기
            NodeList nodeList = doc.getElementsByTagName("host");
            NodeList Listnode = document.getElementsByTagName("host");

            aliasSet(nodeList);
            aliasSet(Listnode);
            urlSet(nodeList);
            urlSet(Listnode);
            uidSet(nodeList);
            uidSet(Listnode);
            pwdSet(nodeList);
            pwdSet(Listnode);
            proxySet(nodeList);
            proxySet(Listnode);
            desSet(nodeList);
            desSet(Listnode);

            System.out.println(set);

            System.out.println("기존 Host의 갯수: "+nodeList.getLength());
            System.out.println("새로운 Host의 갯수: "+Listnode.getLength());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void aliasSet(NodeList nodeList){
        if(doc == null) return;
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeName().equals("host")) {
                Node node = nodeList.item(i);
                String alias = node.getAttributes().getNamedItem("alias").getNodeValue();
                set.add(alias);
            }
        }
    }

    private static void urlSet(NodeList nodeList){
        if(doc == null) return;
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeName().equals("host")) {
                Node node = nodeList.item(i);
                String url = node.getAttributes().getNamedItem("url").getNodeValue();
                set.add(url);
            }
        }
    }

    private static void uidSet(NodeList nodeList){
        if(doc == null) return;
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeName().equals("host")) {
                Node node = nodeList.item(i);
                String uid_out = node.getAttributes().getNamedItem("uid_out").getNodeValue();
                set.add(uid_out);
            }
        }
    }

    private static void pwdSet(NodeList nodeList){
        if(doc == null) return;
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeName().equals("host")) {
                Node node = nodeList.item(i);
                String passwd_out = node.getAttributes().getNamedItem("passwd_out").getNodeValue();
                set.add(passwd_out);
            }
        }
    }

    private static void proxySet(NodeList nodeList){
        if(doc == null) return;
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeName().equals("host")) {
                Node node = nodeList.item(i);
                String usesproxy = node.getAttributes().getNamedItem("usesproxy").getNodeValue();
                set.add(usesproxy);
            }
        }
    }

    private static void desSet(NodeList nodeList){
        if(doc == null) return;
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeName().equals("host")) {
                Node node = nodeList.item(i);
                String description = node.getAttributes().getNamedItem("description").getNodeValue();
                set.add(description);
            }
        }
    }
}
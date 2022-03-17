package ParsingTest;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TreeMapParsing {
    static Document doc = null;
    static List<String> partner = new ArrayList<>();
    static List<String> NewPartner = new ArrayList<>();

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

            setPartner(nodeList);
            setNewPartner(Listnode);

            System.out.println(partner);
            System.out.println(NewPartner);

            System.out.println("기존 Host의 갯수: "+nodeList.getLength());
            System.out.println("새로운 Host의 갯수: "+Listnode.getLength());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private static void setPartner(NodeList nodeList){
        if(doc == null) return;
        for(int i=0; i < nodeList.getLength(); i++){
            if(nodeList.item(i).getNodeName().equals("host")){
                Node node = nodeList.item(i);
                String alias = node.getAttributes().getNamedItem("alias").getNodeValue();
                String url = node.getAttributes().getNamedItem("url").getNodeValue();
                String uid_out = node.getAttributes().getNamedItem("uid_out").getNodeValue();
                String passwd_out = node.getAttributes().getNamedItem("passwd_out").getNodeValue();
                String usesproxy = node.getAttributes().getNamedItem("usesproxy").getNodeValue();
                String description = node.getAttributes().getNamedItem("description").getNodeValue();

                partner.add(alias);
                partner.add(url);
                partner.add(uid_out);
                partner.add(passwd_out);
                partner.add(usesproxy);
                partner.add(description);
            }
        }
    }

    private static void setNewPartner(NodeList nodeList){
        if(doc == null) return;
        for(int i=0; i < nodeList.getLength(); i++){
            if(nodeList.item(i).getNodeName().equals("host")){
                Node node = nodeList.item(i);
                String alias = node.getAttributes().getNamedItem("alias").getNodeValue();
                String url = node.getAttributes().getNamedItem("url").getNodeValue();
                String uid_out = node.getAttributes().getNamedItem("uid_out").getNodeValue();
                String passwd_out = node.getAttributes().getNamedItem("passwd_out").getNodeValue();
                String usesproxy = node.getAttributes().getNamedItem("usesproxy").getNodeValue();
                String description = node.getAttributes().getNamedItem("description").getNodeValue();

                if(partner.contains("alias") == NewPartner.contains("alias")){
                    partner.remove("alias");
                }
                partner.add(alias);
                partner.add(url);
                partner.add(uid_out);
                partner.add(passwd_out);
                partner.add(usesproxy);
                partner.add(description);
                partner.add(" ");
            }
        }
    }

}

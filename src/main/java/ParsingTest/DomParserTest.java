package ParsingTest;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File;
import java.nio.file.Paths;


public class DomParserTest {
    public static void main(String[] args) {
        try {
            //파일 경로
            File file = new File(Paths.get("").toAbsolutePath() + "/src/main/resources/xml/partner.xml");
            File NewFile = new File(Paths.get("").toAbsolutePath() + "/src/main/resources/xml/partner_new.xml");
            //파일 읽기
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document doc = builder.parse(file);
            Document document = builder.parse(NewFile);
            doc.getDocumentElement().normalize();
            document.getDocumentElement().normalize();

            System.out.println("파일 출력");

            //읽어들인 파일 불러오기
            NodeList nodeList = doc.getElementsByTagName("host");
            NodeList Listnode = document.getElementsByTagName("host");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                for(int j=0; j < Listnode.getLength(); j++) {
                    Node deno = Listnode.item(j);
//                    if(Listnode.item(j).getNodeName().equals("host")){
//                        System.out.println("새로운 Host : "+deno.getAttributes().getNamedItem("alias").getNodeValue().toString());
//                    }
//                    if (nodeList.item(i).getNodeName().equals(Listnode.item(j).getNodeName())) {
//                        System.out.println("Host : "+node.getAttributes().getNamedItem("alias").getNodeValue().addAll().toString());
//                    }

                }//2nd for
            }
            System.out.println("기존 Host의 갯수: "+nodeList.getLength());
            System.out.println("새로운 Host의 갯수: "+Listnode.getLength());
        }catch (Exception e){
            e.printStackTrace();

        }

    }
}

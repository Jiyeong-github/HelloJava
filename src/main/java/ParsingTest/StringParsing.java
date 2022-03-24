package ParsingTest;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StringParsing {
    static Document doc = null;
    static List<String> list = new ArrayList<>();

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

            for(int i=0; i<nodeList.getLength(); i++) {
                for(int j=0; j<Listnode.getLength(); j++) {
                    if (nodeList.item(i).getNodeName().equals("host") && Listnode.item(j).getNodeName().equals("host")) {
                        String alias1 = nodeList.item(i).getAttributes().getNamedItem("alias").getNodeValue();
                        String url = nodeList.item(i).getAttributes().getNamedItem("url").getNodeValue();
                        String uid_out = nodeList.item(i).getAttributes().getNamedItem("uid_out").getNodeValue();
                        String passwd_out = nodeList.item(i).getAttributes().getNamedItem("passwd_out").getNodeValue();
                        String usesproxy = nodeList.item(i).getAttributes().getNamedItem("usesproxy").getNodeValue();
                        String description = nodeList.item(i).getAttributes().getNamedItem("description").getNodeValue();

                        String alias2 = Listnode.item(j).getAttributes().getNamedItem("alias").getNodeValue();
                        String url2 = Listnode.item(j).getAttributes().getNamedItem("url").getNodeValue();
                        String uid_out2 = Listnode.item(j).getAttributes().getNamedItem("uid_out").getNodeValue();
                        String passwd_out2 = Listnode.item(j).getAttributes().getNamedItem("passwd_out").getNodeValue();
                        String usesproxy2 = Listnode.item(j).getAttributes().getNamedItem("usesproxy").getNodeValue();
                        String description2 = Listnode.item(j).getAttributes().getNamedItem("description").getNodeValue();


                        if(alias2.contains(alias1)){
                            for(String string: alias1){}
                            for(int n =0; n<list.size(); n++){

                            }
                            list.remove(alias1.equals(alias2));
                            list.add(alias2);
                            list.add(url2);
                            list.add(uid_out2);
                            list.add(passwd_out2);
                            list.add(usesproxy2);
                            list.add(description2);

                        }
//                        if(alias1.equals(alias2)){
//                            list.remove(alias1);
//                            list.add(alias2);
//                            }
//                        else if(!alias1.equals(alias2)){
//                            list.add(alias2);
//                        }
                    }
                }
            }
            System.out.println(list);
            System.out.println("기존 Host의 갯수: "+nodeList.getLength());
            System.out.println("새로운 Host의 갯수: "+Listnode.getLength());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

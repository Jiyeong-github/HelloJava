package ParsingTest;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringParsing {
    static List<String> list = new ArrayList<>();

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

            for(int i=0; i<nodeList.getLength(); i++) {//1번 xml 파일 돌리기
                String alias1 = nodeList.item(i).getAttributes().getNamedItem("alias").getNodeValue();
                String url = nodeList.item(i).getAttributes().getNamedItem("url").getNodeValue();
                String uid_out = nodeList.item(i).getAttributes().getNamedItem("uid_out").getNodeValue();
                String passwd_out = nodeList.item(i).getAttributes().getNamedItem("passwd_out").getNodeValue();
                String usesproxy = nodeList.item(i).getAttributes().getNamedItem("usesproxy").getNodeValue();
                String description = nodeList.item(i).getAttributes().getNamedItem("description").getNodeValue();

                for(int j=0; j<Listnode.getLength(); j++) {//2번 xml 파일 돌리기
                    String alias2 = Listnode.item(j).getAttributes().getNamedItem("alias").getNodeValue();
                    String url2 = Listnode.item(j).getAttributes().getNamedItem("url").getNodeValue();
                    String uid_out2 = Listnode.item(j).getAttributes().getNamedItem("uid_out").getNodeValue();
                    String passwd_out2 = Listnode.item(j).getAttributes().getNamedItem("passwd_out").getNodeValue();
                    String usesproxy2 = Listnode.item(j).getAttributes().getNamedItem("usesproxy").getNodeValue();
                    String description2 = Listnode.item(j).getAttributes().getNamedItem("description").getNodeValue();

                    //조건문 : host 노드 들고오기
                    if (nodeList.item(i).getNodeName().equals("host") && Listnode.item(j).getNodeName().equals("host")) {
                        //리스트1 배열
                        String[] node = new String[6];
                        node[0] = alias1;
                        node[1] = url;
                        node[2] = uid_out;
                        node[3] = passwd_out;
                        node[4] = usesproxy;
                        node[5] = description;
                        List<String> list1 = new ArrayList<>(Arrays.asList(node));

                        //리스트2 배열
                        String[] node2 = new String[6];
                        node[0] = alias2;
                        node[1] = url2;
                        node[2] = uid_out2;
                        node[3] = passwd_out2;
                        node[4] = usesproxy2;
                        node[5] = description2;
                        List<String> list2 = new ArrayList<>(Arrays.asList(node2));

                        //리스트 1에 리스트 2 합치기
                        list.addAll(list1);
                        list.addAll(list2);

                        if(list.equals(list2)){//리스트2에 리스트1과 같은 내용이 있다면?
                            System.out.println("금욜");
                            list.remove(list1); //리스트에서 리스트2와 같은 리스트1 배열 삭제
                            list.addAll(list2);
                        }
                        if(!list.contains(list2)){//GAC#1 추가
                            list.addAll(list2);
                        }
                    }
                }
            }
            System.out.println(list);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

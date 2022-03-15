package ParsingTest;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.List;

public class SaxParserTest {
    public static void main(String[] args) {
        File file = new File("./src/main/resources/xml/partner.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try{
            SAXParser parser = factory.newSAXParser();
            SaxParserHandler handler = new SaxParserHandler();
            parser.parse(file, handler);

            List<Host> hostList = handler.getHostList();

            for(Host host : hostList){
                System.out.println(host);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

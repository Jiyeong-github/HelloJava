package ParsingTest;

import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SaxParserHandler extends DefaultHandler {
    //파싱한 Host 객체를 넣을 리스트
    private List<Host> hostList;
    //파싱한 host 객체
    private Host host;
    //character 메소드에서 저장할 문자열 변수
    private String str;

    public SaxParserHandler(){
        hostList = new ArrayList<>();
    }

    public void startElement(String name){
        if(name.equals("host")){
            host = new Host();
            hostList.add(host);
        }
    }

    public void endElement(String name){
        if(name.equals("host")){
            host.setHost(name);
        }
    }
    public void characters(char[]ch, int start, int length){
        //태그와 태그 사이의 내용 처리
        str = new String(ch, start, length);
    }

    public List<Host> getHostList(){
        return hostList;
    }

    public void setHostList(List<Host> hostList){
        this.hostList = hostList;
    }
}

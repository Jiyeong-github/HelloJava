//package ParsingTest;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.conn.ClientConnectionManager;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.params.HttpConnectionParams;
//import org.apache.http.params.HttpParams;
//import org.apache.http.util.EntityUtils;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.NodeList;
//import org.xml.sax.SAXException;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.nio.charset.StandardCharsets;
//import java.util.ArrayList;
//import java.util.List;
//
//public class WebParsing {
//    static URL url;
//
//    static {
//        try {
//            url = new URL("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson?serviceKey=uXaKeTiEK0mlqvsqLLlHxCx95yE3V0DKIpj9jAAyBPPN17VRhX9ipGXmiPodpawd5j5N4X%2BzJ%2BraOmxxUExmGw%3D%3D&pageNo=1&numOfRows=10&startCreateDt=20200310&endCreateDt=20200315");
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    DefaultHttpClient client;
//
//    public DefaultHttpClient getThreadClient(){
//        if(client != null) return client;
//
//        client = new DefaultHttpClient();
//
//        ClientConnectionManager manager = client.getConnectionManager();
//
//        HttpParams params = client.getParams();
//        client = new DefaultHttpClient(new ThreadSafeClientConnManager(params, manager.getSchemeRegistry()), params);
//
//        return client;
//    }
//
//    //?????? url ????????? ????????? xml ????????? ??????
//    public String pageParsing() throws MalformedURLException {
//        String result = null;
//
//
//        //?????? ?????? ??????
//        HttpClient client = getThreadClient();
//
//        //?????????????????? ????????? ????????? ??? ?????? ?????? ?????? ????????? ?????? ??? ?????? ??????
//        HttpConnectionParams.setConnectionTimeout(client.getParams(), 5000);
//
//        //???????????????-?????? ??? ???????????? ????????? ?????? ?????? ?????? ??? ?????? ??????
//        HttpConnectionParams.setSoTimeout(client.getParams(), 5000);
//
//        HttpPost post = new HttpPost(String.valueOf(url));
//
//        //???????????? ????????????
//        // NameValuePair : post??????
//        // URIBuilder : get??????
//        List<NameValuePair> nameValuePairs = new ArrayList<>();
//
//        if(false){ nameValuePairs.add(new BasicNameValuePair("input", "value")); }
//        try{ post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
//            HttpResponse responsePost = null;
//
//            // http ????????? request ????????? response ????????????
//            responsePost = client.execute(post);
//            HttpEntity resEntity = responsePost.getEntity();
//            if(resEntity != null){result = EntityUtils.toString(resEntity).trim();}
//
//        } catch(Exception e){
//            e.printStackTrace();
//        }finally{ }
//
//        return result;
//    }
//
//    public static void main(String[] args) {
//      try{
//
//            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder builder = factory.newDocumentBuilder();
//
//            ByteArrayInputStream is = new ByteArrayInputStream(String.valueOf(url.getBytes(StandardCharsets.UTF_8)));
//            //builder??? ???????????? XML ?????? -> document ??????
//            Document document = builder.parse(is);
//            //????????? document?????? ??? ???????????? ????????? ????????? ??????
//            Element root = document.getDocumentElement();
//
//            NodeList accDefRate = document.getElementsByTagName("accDefRate");
//            NodeList accExamCnt = document.getElementsByTagName("accExamCnt");
//            NodeList createDt = document.getElementsByTagName("createDt");
//            NodeList deathCnt = document.getElementsByTagName("deathCnt");
//            NodeList decideCnt = document.getElementsByTagName("decideCnt");
//            NodeList seq = document.getElementsByTagName("seq");
//            NodeList stateDt = document.getElementsByTagName("stateDt");
//            NodeList stateTime = document.getElementsByTagName("stateTime");
//            NodeList updateDt = document.getElementsByTagName("updateDt");
///*
//            for(int i=0; i<accDefRate.getLength(); i++){
//                System.out.print("<tr>");
//                System.out.print("<td>"+accDefRate.item(i).getFirstChild().getNodeValue()+"</td>");
//                System.out.print("<td>"+accExamCnt.item(i).getFirstChild().getNodeValue()+"</td>");
//                System.out.print("<td>"+createDt.item(i).getFirstChild().getNodeValue()+"</td>");
//                System.out.print("<td>"+deathCnt.item(i).getFirstChild().getNodeValue()+"</td>");
//                System.out.print("<td>"+decideCnt.item(i).getFirstChild().getNodeValue()+"</td>");
//                System.out.print("<td>"+seq.item(i).getFirstChild().getNodeValue()+"</td>");
//                System.out.print("<td>"+stateDt.item(i).getFirstChild().getNodeValue()+"</td>");
//                System.out.print("<td>"+stateTime.item(i).getFirstChild().getNodeValue()+"</td>");
//                System.out.print("<td>"+updateDt.item(i).getFirstChild().getNodeValue()+"</td>");
//                System.out.print("</tr>"); }
//*/
//        }catch(ParserConfigurationException e){
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (SAXException e) {
//            e.printStackTrace();
//        }
//    }
//}

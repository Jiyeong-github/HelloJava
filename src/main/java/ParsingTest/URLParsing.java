package ParsingTest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.io.InputStream;

public class URLParsing {
    public static void main(String[] args) {
        String url = "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson?serviceKey=uXaKeTiEK0mlqvsqLLlHxCx95yE3V0DKIpj9jAAyBPPN17VRhX9ipGXmiPodpawd5j5N4X%2BzJ%2BraOmxxUExmGw%3D%3D&pageNo=1&numOfRows=10&startCreateDt=20200310&endCreateDt=20200315";
        String enc = "UTF-8";

        //통신 객체 - 웹 브라우저에 해당함
        HttpClient client = null;

        //읽은 값을 복사할 변수 선언 및 초기화
        String result = null;

        //응답 결과가 저장될 객체
        InputStream is = null;

        //통신에 필요한 요청 정보 설정 -> URL 주소 표시줄 입력
        HttpGet get = new HttpGet(url);

        try {
            //요청을 보낸 후 응답 받기
            HttpResponse response = null;

            HttpEntity entity = response.getEntity();
            BufferedHttpEntity bufferedHttp = new BufferedHttpEntity(entity);

            //추출한 데이터를 InputStream으로 변환
            is = bufferedHttp.getContent();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            client.finished();
        }

        try {
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            result = new String(buffer, enc);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package hrd.lesson14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileIOExceptionTest {
    //주어진 이름의 파일의 데이터를 바이트 단위로 읽어들임
        try( FileInputStream fis = new FileInputStream("a.txt")){

        } catch (FileNotFoundException e) {
        System.out.println(e);
        return;
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }catch (NullPointerException e){
                System.out.println(e);
            }
            System.out.println("finally");
        }
    }



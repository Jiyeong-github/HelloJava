package hrd.lesson15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOTest {
    public static void main(String[] args) throws IOException {

        FileOutputStream fos = new FileOutputStream("a.txt", true);//파일이 없으면 파일을 생성해 줌
        fos.write(97);
        fos.write(98);
        fos.write(99);
        fos.close();
        FileInputStream fis = new FileInputStream("a.txt");
        //이러면 에러 터지기때문에 a.txt 파일을 만들어주기
        int i;
        /*read()의 종류
        1. read() : 하나만 읽기
        2. read(byte[]b) : 바이트로 읽기
        3. read(byte[]b, int off, int len) : 바이트 + 특징 offset + 특정 length 읽기
        */
        while((i = fis.read()) != -1) {
            System.out.println(i + " " + (char) i);
        }
    }
}

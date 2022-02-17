package hrd.lesson14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowException {

    public Class loadClass(String filename, String className) throws FileNotFoundException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("a2.txt");
        Class c = Class.forName(className);
        return c;
    }
    public static void main(String[] args){
        ThrowException test = new ThrowException(); //예외 처리
        try {
            test.loadClass("a2.txt", "Test");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

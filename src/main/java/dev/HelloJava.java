package dev;

import java.util.Vector;

public class HelloJava {

    public static void main(String[] args) {
        System.out.println("Hello");
        BaseClass bc = new SubClass("message", 10);
        bc.printMessage();

        String a = new String("test");
        String b = new String("test");

        if (a==b) {
            //이 경우 같지 않음
        } else if (a.equals(b)) {
            //이래야 맞다다
        }

    }
}

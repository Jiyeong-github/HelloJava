package hrd.lesson12;

import java.util.HashSet;

public class HashSetTest {

    public static void main(String[] args){
        HashSet<String> set = new HashSet<String>();

        set.add("abc");
        set.add("test");
        set.add("def");
        set.add("abc"); //중복 불가!

        System.out.println(set);
    }
}

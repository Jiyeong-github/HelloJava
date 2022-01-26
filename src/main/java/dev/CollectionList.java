package dev;

import java.util.ArrayList;
import java.util.List;

public class CollectionList {
    public void printList(){
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");

        for(String item : list){//array 또는 collection이 올 수 있음
            System.out.println("item:"+item);
        }
    }
}

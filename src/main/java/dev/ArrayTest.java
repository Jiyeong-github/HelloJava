package dev;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArrayTest {
    String[] dataArray;
    String[] dataArray2 = {"a","b","c"};
    String[] dataArray3;

    public void takeArray(){
        int size = 3;
        dataArray = new String[size];
        dataArray[0] = "a";
        dataArray[1] = "b";
        dataArray[2] = "c";
        int length = dataArray.length;

        dataArray3 = new String[] {"a","b","c"};
        List<String> list = Arrays.asList(dataArray);

        setStrings("a","b","c");
        Arrays.sort(dataArray, new Comparator<String>() {//comparable한 게 아니라면 Comparator 객체 사용
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    };

    public void setStrings(String... strings){//...은 파라미터가 한두개 이상 들어간다는 뜻
        int length = strings.length;
        for(int i=0; i<length; i++){
            System.out.println("i:"+i+",value:"+strings[i]);
        }
    }

    MyData[] myDataArray = {new MyData("A",1), new MyData("b",2), new MyData("c",3)};
}

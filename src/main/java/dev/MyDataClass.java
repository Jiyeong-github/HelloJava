package dev;

public class MyDataClass {

    String info;

    @MyAnnotation(num=1, name="setMyInfo")
    public void setMyInfo(String info){
        this.info = info;
    }
}

package dev;

public class SubClass extends BaseClass{
    int age;
    public SubClass(String message){
        this(message, 0); //message&age를 가진 생성자 호출
    }

    public SubClass(String message, int age){
        super(message);
        this.age = age;
    }

    @Override
    public void printMessage(){
        System.out.println("message:"+message+",age:"+age);
    }

    @Override
    public int getAge() {
        return age;
    }
}

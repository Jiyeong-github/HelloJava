package dev;

public abstract class BaseClass {
    String message;
    public BaseClass(String message){
        this.message = message;
    }

    public void printMessage() {
        System.out.println("message:" + message);
    }

    public abstract int getAge();

}

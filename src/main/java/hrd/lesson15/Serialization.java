package hrd.lesson15;

import java.io.*;

class Person implements Serializable {
    //객체의 정보를 다른 곳에 저장하기 위해 Serializable 선언 필요

    String name;
    String address;

    Person(String name, String address){
        this.name = name;
        this.address = address;
    }

    public String toString(){
        return name;
    }
}

public class Serialization {
    public static void main(String[] args) throws IOException {
        Person personKim = new Person("Kim", "Seoul");
        Person personLee = new Person("Lee", "New York");

        FileOutputStream fos = new FileOutputStream("object.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(personKim);
        oos.writeObject(personLee);

        oos.close();
    }
}

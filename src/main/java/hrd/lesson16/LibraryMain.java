package hrd.lesson16;

import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;

import java.util.ArrayList;

class Library{
    public ArrayList<String> shelf = new ArrayList<String>();
    public Library(){
        shelf.add("데미안");
        shelf.add("호세");
        shelf.add("돈키호테");
        shelf.add("카르멘");
        shelf.add("사라고사");
    }

    public String lendBook(){

        Thread t = Thread.currentThread();
        String book = shelf.remove(0);
        System.out.println(t.getName()+book+"lend");
        return book;
    }

    public void returnBook(String book){

        Thread t = Thread.currentThread();
        shelf.add(book);
        System.out.println(t.getName()+book+"return");
    }
}

//Thread -> 학생들
//Thread가 하는 일 -> 책 빌리고 반납

class Student extends Thread{
    public void run() {
        try {
            String title = LibraryMain.library.lendBook();
            sleep(5000);
            LibraryMain.library.returnBook(title);
        } catch(InterruptedException e) {
            System.out.println(e);
        }
    }
}

public class LibraryMain {
    public static Library library = new Library();
    //static으로 선언하여 Library는 하나의 객체(instance)가 됨
    public static void main(String[] args){
        Student std1 = new Student();
        Student std2 = new Student();
        Student std3 = new Student();

        std1.start();
        std2.start();
        std3.start();
    }
}

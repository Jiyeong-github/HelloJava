package hrd.lesson13;

class Outer{
    public Runnable getRunnable(){//Runnable한 타입을 반환하는 메서드
        class MyRunnable implements Runnable{//지역 클래스
            @Override
            public void run(){
                System.out.println("run()");
            }
        }
        return new MyRunnable();
    }
}
//이름이 필요없으므로 익명 클래스를 만듦
public class AnonymousInnerTest {
    public static void main(String[] args){
        Outer outer = new Outer();
        Runnable runnable = outer.getRunnable();
        runnable.run();
    }
}

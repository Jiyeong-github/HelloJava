package hrd.lesson16;

class MyThread extends Thread{
    //자바에서 쓰레드를 만드는 방법
    //1.Thread 클래스에서 상속 받기
    // ->public void run() 구현 후 Thread가 실제 해야 할 일 코딩
    //2. implements Runnable interface 구현

    public void run(){
        int i;
        for(i=0; i<=200; i++){
            System.out.println(i + "\t");
            try {
                sleep(100); //0.1초 동안 잠깐 쉬기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class ThreadTest {
    public static void main(String[] args){
        MyThread thread1 = new MyThread();
        thread1.start();
    }
}

package dev;

public class ThreadTest {

    public void newThreadStart(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<10; i++){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("i :"+i);
                }
            }
        }).start();
    }

    public void startMyThread(){
        new MyThread().start();
    }

    public class MyThread extends Thread{
        @Override
        public void run(){
            for(int i=0; i<10; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("i :"+i);
            }
        }
    }
}

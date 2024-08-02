package multithreading;

class MyThread extends Thread {
    public void run(){
        Thread th = Thread.currentThread();
        String name = th.getName();
        for(int i=1; i<=4; i++){
            System.out.println(i + "  " + Thread.currentThread().getName());
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class ThreadDemo1 {
    public static void main(String[] args) throws InterruptedException {
        MyThread th1 = new MyThread();
        th1.start();
        th1.join();

        for(int i=1; i<=4; i++){
            System.out.println(i + " " + Thread.currentThread().getName());
            Thread.sleep(250);
        }
    }
}

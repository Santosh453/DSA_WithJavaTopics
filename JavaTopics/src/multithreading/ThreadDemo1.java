package multithreading;

class MyThread extends Thread {
    public void run(){
        for(int i=1; i<=10; i++){
            System.out.println(i + " " + getName());
        }
    }
}

public class ThreadDemo1 {
    public static void main(String[] args) {
        MyThread th1 = new MyThread();
        MyThread th2 = new MyThread();
        MyThread th3 = new MyThread();
        th1.start();
        th2.start();
        th3.start();
    }
}

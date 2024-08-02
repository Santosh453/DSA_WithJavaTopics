package multithreading;

class MyThread2 implements Runnable{

    @Override
    public void run() {
        for(int i=1; i<=5; i++){
            System.out.println(i);
        }

    }

    MyThread2 (){
        new Thread(this).start();

    }
}

public class ThreadDemo2 {
    public static void main(String[] args) {
//        MyThread2 th = new MyThread2();
//        Thread th1 = new Thread(th);
//        th1.start();

        MyThread2 th = new MyThread2();

    }


}

package multithreading;

public class ThreadDemo3{

}
class Thread1 extends Thread {
    Table t;
    public Thread1(Table t){
        this.t = t;
    }

    public void run(){
        t.getTableDisplay(5);
    }
}


class Thread2 extends Thread {
    Table t;
    public Thread2(Table t){
        this.t = t;
    }

    public void run(){
        t.getTableDisplay(10);
    }
}

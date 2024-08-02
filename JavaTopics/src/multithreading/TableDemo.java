package multithreading;

public class TableDemo {
    public static void main(String[] args) {
        Table table = new Table();

        Thread1 th1 = new Thread1(table);
        Thread2 th2 = new Thread2(table);
        th1.start();
        th2.start();

    }
}

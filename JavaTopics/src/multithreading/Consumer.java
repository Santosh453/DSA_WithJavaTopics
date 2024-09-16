package multithreading;

public class Consumer extends Thread{

    Company company;
    public Consumer(Company company){
        this.company = company;
    }

    public void run(){
        int i=1;
        while(true){
            try {
                this.company.consume_item();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            i++;


        }
    }
}

package multithreading;

public class Producer extends Thread{

    Company company;
    public Producer(Company company){
        this.company = company;
    }

    public void run(){
        int i=1;
        while(true){

            try {
                this.company.produce_item(i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            i++;


        }
    }
}

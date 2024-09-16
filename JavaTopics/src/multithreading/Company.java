package multithreading;

public class Company {

    int n;
    boolean flagMyTurnPC = true;

    synchronized public void produce_item(int n) throws InterruptedException {
        if(!flagMyTurnPC){
            wait();
        }
        this.n = n;
        System.out.println("Produced item : " + this.n);
        flagMyTurnPC = false;
        notify();
    }

    synchronized public int consume_item() throws InterruptedException {
        if(flagMyTurnPC){
            wait();
        }
        System.out.println("Consumed item : " + this.n);
        flagMyTurnPC = true;
        notify();
        return this.n;
    }


}

package multithreading;

public class Table {

//ThreadDemo3

     synchronized void getTableDisplay(int n){
        for(int i=1; i<=10; i++){
            System.out.println(n + " * " + i + " = " + (n*i));
        }

    }
}

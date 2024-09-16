package java8.ConsumerAndSupplier;



import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerSupplierMain {

    public static void main(String[] args) {
        Consumer<List<Integer>> listConsumer1 = li -> {
            for (int i : li) {
                System.out.println(i + 100);
            }
        };


        Consumer<List<Integer>> listConsumer2 = li -> {
            for(int i : li){
                System.out.println(i);
            }
        };

//        listConsumer1.accept(Arrays.asList(1,2,3,4));
        listConsumer1.andThen(listConsumer2).accept(Arrays.asList(1,2,3,4,5,6));
    }
}

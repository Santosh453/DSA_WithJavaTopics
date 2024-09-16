package java8.functionalInterface;

import java.util.Comparator;

public class MyClass implements Comparator<Integer> {

    @Override
    public int compare(Integer a, Integer b) {
        return b-a;
    }
}

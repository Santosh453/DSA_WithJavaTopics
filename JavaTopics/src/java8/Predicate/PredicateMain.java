package java8.Predicate;

import java.util.function.Predicate;

public class PredicateMain {

    public static void main(String[] args) {

        Predicate<Integer> lessThan10 = n -> n<10;
        System.out.println(lessThan10.test(10));
        System.out.println(lessThan10.test(9));

        //or
        Predicate<Integer> isEven = n->n%2==0;
        Predicate<Integer> isEvenOrLessThan10 = lessThan10.or(isEven);
        System.out.println(isEvenOrLessThan10.test(11));
        System.out.println(isEvenOrLessThan10.test(12));



        //and
        Predicate<Integer> greaterThan10 = n -> n>10;
        Predicate<Integer> isEvenAndGreaterThan10 = greaterThan10.and(isEven);
        System.out.println(isEvenAndGreaterThan10.test(20));
        System.out.println(isEvenAndGreaterThan10.test(2));

        //negate
        Predicate<Integer> isOdd = isEven.negate();
        System.out.println(isOdd.test(3));
        System.out.println(isOdd.test(4));

        //isEqual
        Predicate<String> checkString = Predicate.isEqual("Name");
        System.out.println(checkString.test("Name"));
        System.out.println(checkString.test("NotName"));


    }
}

package java8.functionalInterface;

import java.util.*;

abstract class Main {
    public static void main(String[] args) {
        Employee emp = () -> "Software Engineer";
        System.out.println(emp.getName());

        Maths math = (a,b) ->{
            System.out.println("calling sum method of Maths interface");
            return a+b;
        };



        System.out.println(math.sum(4,8));


        Runnable runnable = () -> {
            for(int i=1; i<=10; i++){
                System.out.print(i+" ");
            }
        };

        System.out.println();
        Thread thread = new Thread(runnable);
        thread.run();

        System.out.println();

        List<Integer> list = Arrays.asList(3,5,1,3,5,2);


        List<Integer> list2 = Arrays.asList(3,5,1,3,5,2, 3,4,2,4);
        Collections.sort(list);
        System.out.println(list);
        System.out.println(list2);
        Collections.sort(list2, (a,b)-> b-a);
//        Collections.sort(list2, new MyClass());
        System.out.println((list2));



        Set<Integer> s = new TreeSet<Integer>();
        s.add(22);
        s.add(1);
        s.add(13);
        System.out.println("Before ordering : " + s);

        Set<Integer> ss = new TreeSet<Integer>((a,b)->b-a);
        ss.add(22);
        ss.add(1);
        ss.add(13);
        System.out.println("After ordering : " + ss);


        //Anonymous inner class
        Emp empObject = new Emp() {
            @Override
            public int getSum() {
                return 0;
            }
        };
    }



}

package java8.Function;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionMain {
    public static void main(String[] args) {
        Function<String,Integer> getLength = n -> n.length();
        System.out.println(getLength.apply("Ajay"));



        Function<String, String> getStarting3Letter = n -> n.substring(0,3);
        System.out.println(getStarting3Letter.apply("Vijay"));

        Student s1 = new Student("Ajay", "Ajay.com");
        Student s2 = new Student("Vipul", "Vipul.com");
        Student s3 = new Student("Vippy", "Vippy.com");
        Student s4 = new Student("Anurag", "Anurag.com");
        List<Student> list = Arrays.asList(s1,s2,s3,s4);
        Function<List<Student>,List<Student>> res = n -> {
            List<Student> resArr = new ArrayList<>();
            for(Student s : n){
                if("Vip".equalsIgnoreCase(getStarting3Letter.apply(s.getName()))){
                    resArr.add(s);
                }
            }
            return resArr;
        };

        System.out.println(res.apply(list));

        Function<Integer, Integer> function1 = x -> 2*x;
        Function<Integer, Integer> function2 = x -> x*x*x;

        System.out.println(function1.andThen(function2).apply(3)); //216
        System.out.println(function2.andThen(function1).apply(3)); //54
        System.out.println(function1.compose(function2).apply(3)); //54  compose is reverse of andThen

        Function<String,String> functionIdentity = Function.identity();
        System.out.println(functionIdentity.apply("Vipul"));


    }







    private static class Student{
        String name;
        String email;

        public Student(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }
    }
}

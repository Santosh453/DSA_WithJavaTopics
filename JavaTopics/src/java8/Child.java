package java8;



interface A {
    default void sayHello(){
        System.out.println("A");
    }
}interface B {
    default void sayHello(){
        System.out.println("B");
    }
}



public class Child implements A,B {
    public static void main(String[] args) {
        Child c = new Child();
    }

    @Override
    public void sayHello() {
        A.super.sayHello();
    }
}

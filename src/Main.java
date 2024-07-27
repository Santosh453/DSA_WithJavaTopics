import stack.StackByUsingArray;
import stack.StackEmptyException;
import stack.StackFullException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws StackFullException, StackEmptyException {
        StackByUsingArray stack = new StackByUsingArray(10);
        System.out.println("stack size : " + stack.size());
        System.out.println("stack isEmpty : " + stack.isEmpty());
        stack.push(10);
        stack.push(20);
        System.out.println("stack size : " + stack.size());
        System.out.println("stack isEmpty : " + stack.isEmpty());
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(70);
        stack.push(80);
        stack.push(90);
        stack.push(100);
        System.out.println("stack size : " + stack.size());
        System.out.println("stack isEmpty : " + stack.isEmpty());
        System.out.println("stack top : " + stack.top());
        System.out.println("stack pop : " + stack.pop());
        stack.push(110);
        System.out.println("stack top : " + stack.top());

    }
}
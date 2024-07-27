package stack;

public class StackByUsingArray {
    private int[] data;
    private int topIndex;

    public StackByUsingArray(){
        data = new int[10];
        topIndex=-1;
    }

    public StackByUsingArray(int size){
        data = new int[size];
        topIndex=-1;
    }

    public int size(){
        return topIndex+1;
    }

    public boolean isEmpty(){
        return topIndex == -1;
    }

    public void push(int elem) throws StackFullException {
        if(topIndex+1 < data.length){
            data[++topIndex] = elem;
//            topIndex++;
            System.out.println("ELement " + elem + " added Successfully ");
        }else{
            doubleCapacity();
        }
    }

    private void doubleCapacity() {
        int[] temp = data;
        data = new int[temp.length *2];
        for(int i=0; i<temp.length; i++){
            data[i] = temp[i];
        }
    }

    public int top() throws StackEmptyException {
        if(topIndex>-1){
            return data[topIndex];
        }else{
            throw new StackEmptyException();
        }
    }

    public int pop() throws StackEmptyException {
        if(isEmpty()){
            throw new StackEmptyException();
        }else{
            return data[topIndex--];
        }
    }
}

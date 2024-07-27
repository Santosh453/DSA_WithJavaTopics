package trees;

public class BinaryTreeNode<T> {


    public T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data){
        this.data = data;
        left = null;
        right = null;
    }


}

package trees;

import java.util.ArrayList;

public class TreeNode <T>{
    T data;
    ArrayList<TreeNode<T>> children;

    public TreeNode(T data){
        this.data = data;
        this.children = new ArrayList<>();
    }

    public void printTree1(TreeNode<T> root){
        if(root == null){
            return ;
        }

        System.out.print(root.data+" ");
        for(int i=0; i<root.children.size(); i++){
            TreeNode<T> child = root.children.get(i);
            printTree1(child);
        }
    }


}

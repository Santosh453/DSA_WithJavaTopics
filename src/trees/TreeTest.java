package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeTest {
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<Integer>(4);
        TreeNode<Integer> node1 = new TreeNode<Integer>(2);
        TreeNode<Integer> node2 = new TreeNode<Integer>(3);
        TreeNode<Integer> node3 = new TreeNode<Integer>(1);
        TreeNode<Integer> node4 = new TreeNode<Integer>(5);
        TreeNode<Integer> node5 = new TreeNode<Integer>(6);
//        TreeNode<Integer> node6 = new TreeNode<Integer>(6);
        root.children.add(node1);
        root.children.add(node2);
        root.children.add(node3);
        node2.children.add(node4);
        node2.children.add(node5);
//        node5.children.add(node6);
        System.out.println();
        System.out.println("printTree1 method ");
        printTree1(root);

        System.out.println();
        System.out.println();
        System.out.println("printTree2 method ");
        printTree2(root);

        System.out.println();
        System.out.println("findNoOfNodes method ");
        System.out.println("No of Nodes present in generic tree is " + findNoOfNodes(root));

        System.out.println();
        System.out.println();


//        System.out.println();
        printTree2(takeInput2());




    }

    public static void printTree1(TreeNode<Integer> root){
        if(root == null){
            return ;
        }

        System.out.print(root.data+" ");
        for(int i=0; i<root.children.size(); i++){
            TreeNode<Integer> child = root.children.get(i);
            printTree1(child);
        }
    }


    public static TreeNode<Integer> takeInput2(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter data : ");
        int data  = sc.nextInt();
        System.out.println("Enter No of Child : ");
        int numberOfChild  = sc.nextInt();
        TreeNode<Integer> root = new TreeNode<>(data);
        for(int i =0; i<numberOfChild; i++){
            root.children.add(takeInput2());
        }
        return root;
    }



    //print tree level order
    public static void printLevelWise(TreeNode<Integer> root){
        if(root == null){
            return ;
        }
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode<Integer> currentNode = q.poll();
                System.out.print(currentNode.data + " ");
                for (TreeNode<Integer> child : currentNode.children) {
                    q.add(child);
                }
            }
            System.out.println();
        }
    }


    //get height of tree
    public static int getHeight(TreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int heightCount = 0;
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n= q.size();
            heightCount++;
            for(int i =0;i<n;i++){
                TreeNode<Integer> currentNode = q.poll();
                for(TreeNode<Integer> child :currentNode.children ){
                    q.add(child);
                }
            }
        }
        return heightCount;
    }


    public static void printTree2(TreeNode<Integer> root){
        if(root == null){
            return ;
        }

        System.out.print(root.data + ": ");
        for(int i=0; i<root.children.size(); i++){
            System.out.print(root.children.get(i).data + " ");
        }
        System.out.println();
        for(int i=0; i<root.children.size(); i++){
            TreeNode<Integer> child = root.children.get(i);
            printTree2(child);
        }
    }


    //print Post order
    public static void printPostOrder(TreeNode<Integer> root){
        if(root == null){
            return ;
        }
        for(int i=0; i<root.children.size(); i++){
            TreeNode<Integer> child = root.children.get(i);
            printPostOrder(child);
        }
        System.out.print(root.data + " ");
    }


    // finding no of nodes present
    public static int findNoOfNodes(TreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int nodesCount = 1;
        for(int i=0; i<root.children.size(); i++){
            TreeNode<Integer> child = root.children.get(i);
            nodesCount+=findNoOfNodes(child);
        }
        return nodesCount;
    }



    // checking two tree are identical or not
    public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2){
        if(root1 == null && root2 == null){
            return true;
        }else if(root1 == null || root2 == null){
            return false;
        }
        boolean result = false;
        if(!root1.data.equals(root2.data)){
            return false;
        }
        if (root1.children.size() != root2.children.size()) {
            return false;
        }
        for(int i=0; i<root1.children.size(); i++){
            TreeNode<Integer> child1 = root1.children.get(i);
            TreeNode<Integer> child2 = root2.children.get(i);
            if (!checkIdentical(child1, child2)) {
                return false;
            }
        }
        return true;
    }


    public static void replaceWithDepthValue(TreeNode<Integer> root){
        if(root == null){
            return;
        }
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0; i<n; i++){
                TreeNode<Integer> currentLevel = q.poll();
                currentLevel.data = level;
                for(TreeNode<Integer> child : currentLevel.children){
                    q.add(child);
                }
            }
            level++;
        }
    }



    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){
        if(root  == null){
            return null;
        }
        TreeNode<Integer> nextLarger = null;
        if(root.data>n){
            nextLarger = root;
        }
        for(int i = 0; i<root.children.size(); i++){
            TreeNode<Integer> child = root.children.get(i);
            TreeNode<Integer> candidate = findNextLargerNode(child,n);
            if(candidate != null){
                if(nextLarger == null ||  candidate.data<nextLarger.data){
                    nextLarger = candidate;
                }
            }
        }
        return nextLarger;
    }
}

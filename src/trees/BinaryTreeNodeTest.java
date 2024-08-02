package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeNodeTest {

    public static void main(String[] args) {
        // Create a sample binary tree
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.left = new BinaryTreeNode<>(6);
        root.right.right = new BinaryTreeNode<>(7);

        System.out.println();
        printLevelWise(root);
        System.out.println();
        System.out.println("isBalancedTree(root): " + isBalancedTree(root));
        System.out.println();
        printLevelWiseInline(root);
//        System.out.println();
//        System.out.println("using largest method to get largest node in a tree " + largest(root));
//        System.out.println();
//
//        // Calculate height using the iterative method
//        int iterativeHeight = height(root);
//        System.out.println("Height (Iterative): " + iterativeHeight);
//
//        // Calculate height using the recursive method
//        int recursiveHeight = heightRecursive(root);
//        System.out.println("Height (Recursive): " + recursiveHeight);
//        System.out.println();
//        System.out.println("printDepthKNodes == ");
//        printDepthKNodes(root,1);
//        System.out.println();
//
//        // Check if a node is present
//        int x = 5;
//        boolean isPresent = isNodePresent(root, x);
//        System.out.println("Is node " + x + " present? " + isPresent);
//
//        // Convert the tree to depth tree
//        changeToDepthTree(root);
//        System.out.println("Tree converted to depth values:");
//
//        // Print nodes without siblings
//        System.out.print("Nodes without siblings: ");
//        printNodesWithoutSibling(root);
//        System.out.println();
//
//        System.out.println();
//        System.out.println("No of nodes present in tree " + getNoOfNodes(root));
//
//        System.out.println();
//
//        System.out.println();
//        System.out.println("No of leaf nodes in tree " + getNoOfLeafNodes(root));


    }

    // Iterative approach using a queue to calculate the height of the binary tree
    public static int height(BinaryTreeNode<Integer> root) {
        int height = 0;
        if (root == null) {
            return height;
        }
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                BinaryTreeNode<Integer> current = q.poll();
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
            }
            height++;
        }
        return height;
    }

    // Recursive approach to calculate the height of the binary tree
    public static int heightRecursive(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = heightRecursive(root.left);
        int rightHeight = heightRecursive(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Change all nodes' data to the depth of that node in the tree
    public static void changeToDepthTree(BinaryTreeNode<Integer> root) {
        int depth = 0;
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                BinaryTreeNode<Integer> current = q.poll();
                current.data = depth;
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
            }
            depth++;
        }
    }

    // Print nodes that do not have siblings
    public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.right == null) {
            System.out.print(root.left.data + " ");
        }
        if (root.left == null && root.right != null) {
            System.out.print(root.right.data + " ");
        }
        printNodesWithoutSibling(root.left);
        printNodesWithoutSibling(root.right);
    }

    // Check if a node with the given value is present in the binary tree
    public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
        if (root == null) {
            return false;
        }
        if (root.data == x) {
            return true;
        }
        return isNodePresent(root.left, x) || isNodePresent(root.right, x);
    }


    public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {
        if(root == null){
            return 0;
        }
        int leftCount = countNodesGreaterThanX(root.left, x);
        int rightCount = countNodesGreaterThanX(root.right, x);
        if(root.data>x){
            return 1+leftCount+rightCount;
        }else {
            return leftCount+rightCount;
        }

    }


    public static void preOrder(BinaryTreeNode<Integer> root) {
        if(root == null){
            return ;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }


    public static void postOrder(BinaryTreeNode<Integer> root) {
        if(root == null){
            return ;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }


    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            BinaryTreeNode<Integer> current = q.poll();
            BinaryTreeNode<Integer> leftChild = current.left;
            BinaryTreeNode<Integer> rightChild = current.right;
            int left = -1;
            int right = -1;
            if (leftChild != null) {
                left = leftChild.data;
                q.add(leftChild);
            }

            if (rightChild != null) {
                right = rightChild.data;
                q.add(rightChild);
            }
            System.out.println(current.data + ":L:" + left + ",R:" + right);
        }

    }


    public static void printLevelWiseInline(BinaryTreeNode<Integer> root) {
        System.out.println();
        System.out.println("printLevelWiseInline  =====");
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            BinaryTreeNode<Integer> current = q.poll();
            BinaryTreeNode<Integer> leftChild = current.left;
            BinaryTreeNode<Integer> rightChild = current.right;
            if (leftChild != null) {
                q.add(leftChild);
            }

            if (rightChild != null) {
                q.add(rightChild);
            }
            System.out.print(current.data + " ");
        }

    }

    public static int getSum(BinaryTreeNode<Integer> root) {
        if(root == null){
            return 0;
        }
        int sum = 0;
        int leftSum = getSum(root.left);
        int rightSum = getSum(root.right);
        sum=root.data+leftSum+rightSum;
        return sum;
    }


    public static int getNoOfNodes(BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int leftCount = getNoOfNodes(root.left);
        int rightCount = getNoOfNodes(root.right);
        return leftCount+rightCount+1;
    }


    public static int getNoOfLeafNodes(BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int leftCount = getNoOfLeafNodes(root.left);
        int rightCount = getNoOfLeafNodes(root.right);
        if(root.left == null && root.right == null){
            return 1;
        }else {
            return leftCount + rightCount;
        }
    }

    public static void printDepthKNodes(BinaryTreeNode<Integer> root,int k){
        if(root == null) return;
        if(k == 0){
            System.out.print(root.data + " ");
            return;
        }
        printDepthKNodes(root.left, k-1);
        printDepthKNodes(root.right, k-1);
    }

    public static BinaryTreeNode<Integer> takeTreeInput(){

        System.out.println("Enter root data ");
        Scanner sc = new Scanner(System.in);
        int rootData = sc.nextInt();
        if(rootData == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        BinaryTreeNode<Integer> leftChild = takeTreeInput();
        BinaryTreeNode<Integer> rightChild = takeTreeInput();
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }

    public static BinaryTreeNode<Integer> takeImprovedTreeInput(boolean isRoot, int parentData, boolean isLeft){

        if(isRoot) {
            System.out.println("Enter root data: ");
        }else{
            if(isLeft){
                System.out.println("Enter left Child of " + parentData);
            }else{
                System.out.println("Enter right Child of " + parentData);
            }
        }
        Scanner sc = new Scanner(System.in);
        int rootData = sc.nextInt();
        if(rootData == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        BinaryTreeNode<Integer> leftChild = takeImprovedTreeInput(false,rootData,true);
        BinaryTreeNode<Integer> rightChild = takeImprovedTreeInput(false,rootData,false);
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }


    public static int largest(BinaryTreeNode<Integer> root){

        if(root ==  null){
            return -1;
        }
        return Math.max(Math.max(largest(root.left),largest(root.right)),root.data);
    }

    public static BinaryTreeNode<Integer> removeLeaves(BinaryTreeNode<Integer> root){
        if(root == null){
            return null;
        }

        if(root.left == null && root.right == null){
            return null;
        }

        root.left = removeLeaves(root.left);
        root.right = removeLeaves(root.right);
        return root;
    }

// create Binary tree level wise
    public static BinaryTreeNode<Integer> takeLevelWiseTreeInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Root Data: ");
        int rootData = sc.nextInt();
        if(rootData == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){

            BinaryTreeNode<Integer> currentRoot = q.poll();
            System.out.println("Enter left child of root: " + currentRoot.data);
            int leftChild = sc.nextInt();
            if(leftChild != -1){
                BinaryTreeNode<Integer> leftChildNode = new BinaryTreeNode<Integer>(leftChild);
                currentRoot.left = leftChildNode;
                q.add(leftChildNode);
            }

            System.out.println("Enter right child of root: " + currentRoot.data);
            int rightChild = sc.nextInt();
            if(rightChild != -1){
                BinaryTreeNode<Integer> rightChildNode = new BinaryTreeNode<Integer>(rightChild);
                currentRoot.right = rightChildNode;
                q.add(rightChildNode);
            }
        }
        return root;
    }


    public static void mirrorBinaryTree(BinaryTreeNode<Integer> root){

        //using bfs
//        if(root == null) return ;
//        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
//        q.add(root);
//        while(!q.isEmpty()){
//            int n = q.size();
//            for(int i=0; i<n; i++){
//                BinaryTreeNode<Integer> current = q.poll();
//                BinaryTreeNode<Integer> tempLeft = null;
//                BinaryTreeNode<Integer> tempRight = null;
//                if(current.left != null){
//                    q.add(current.left);
//                    tempLeft = current.left;
//                }
//                if(current.right != null){
//                    q.add(current.right);
//                    tempRight = current.right;
//                }
//                current.left = tempRight;
//                current.right = tempLeft;
//            }
//        }

        //using dfs
        if(root == null) return;
        BinaryTreeNode<Integer> temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorBinaryTree(root.left);
        mirrorBinaryTree(root.right);
    }


    public int sumEvenGrandparent(BinaryTreeNode<Integer> root) {
        int finalSum = 0;
        if (root == null) {
            return 0;
        }
        int leftSum = sumEvenGrandparent(root.left);
        int rightSum = sumEvenGrandparent(root.right);
        if (root.data % 2 == 0) {
            finalSum = sum(root) + leftSum + rightSum;
        }else{
            finalSum = leftSum + rightSum;
        }
        return finalSum;

    }

    public int sum(BinaryTreeNode<Integer> root) {
        int sumValue = 0;
        if (root.data % 2 == 0) {
            if (root.left != null) {
                if (root.left.left != null) {
                    System.out.println(root.left.left.data);
                    sumValue += root.left.left.data;
                }
                if (root.left.right != null) {
                    System.out.println(root.left.right.data);
                    sumValue += root.left.right.data;
                }
            }

            if (root.right != null) {
                if (root.right.left != null) {
                    System.out.println(root.right.left.data);
                    sumValue += root.right.left.data;
                }
                if (root.right.right != null) {
                    sumValue += root.right.right.data;
                    System.out.println(root.right.right.data);
                }
            }

        }
        return sumValue;
    }





//    For a given a Binary Tree of type integer, duplicate every node of the tree and attach it to the left of itself.
//    The root will remain the same. So you just need to insert nodes in the given Binary Tree.
//    Example:
//    alt txt
    public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
        if(root == null){
            return;
        }
        insertDuplicateNode(root.left);
        insertDuplicateNode(root.right);
        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(root.data);
        BinaryTreeNode<Integer> temp = root.left;
        root.left = newNode;
        newNode.left = temp;

    }



//    For a given a Binary Tree of type integer, find and return the minimum and the maximum data values.
//    Return the output as an object of Pair class, which is already created.
//    Note:All the node data will be unique and hence there will always exist a minimum and maximum node data.
public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
    if(root == null){
        return new Pair<Integer, Integer>(Integer.MAX_VALUE,Integer.MIN_VALUE);
    }
    if(root.left == null && root.right== null){
        Pair<Integer, Integer> result = new Pair<Integer, Integer>(root.data,root.data);
        return result;
    }
    Pair<Integer, Integer> resultLeft = getMinAndMax(root.left);
    Pair<Integer, Integer> resultRight = getMinAndMax(root.right);
    int minn = Math.min(Math.min(root.data,resultLeft.minimum),resultRight.minimum);
    int maxx = Math.max(Math.max(root.data,resultLeft.maximum), resultRight.maximum);
    return new  Pair<Integer, Integer>(minn,maxx);
}


    public static BalancedTreeReturn isBalancedTreeBetter(BinaryTreeNode<Integer> root){
        if(root == null){
            return new BalancedTreeReturn(0,false);
        }

        BalancedTreeReturn leftOutput = isBalancedTreeBetter(root.left);
        BalancedTreeReturn rightOutput = isBalancedTreeBetter(root.right);

        boolean isBal = true;
        int height = 1+Math.max(leftOutput.height,rightOutput.height);


        if(Math.abs(leftOutput.height- rightOutput.height)>1){
            isBal = false;
        }

        if(!leftOutput.isBalanced || !rightOutput.isBalanced){
            isBal = false;
        }

        return new BalancedTreeReturn(height,isBal);
    }


public static boolean isBalancedTree(BinaryTreeNode<Integer> root){
        if(root == null){
            return true;
        }

    int leftHeight = height(root.left);
    int rightHeight = height(root.right);
    int res = Math.abs(leftHeight-rightHeight);


    if(res>1){
        return false;
    }

    return isBalancedTree(root.left) && isBalancedTree(root.right);
}


    public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root){
        if (root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1+ leftHeight+rightHeight;
    }



}
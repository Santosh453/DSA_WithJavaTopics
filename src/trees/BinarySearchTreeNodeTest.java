package trees;

public class BinarySearchTreeNodeTest {

    public static void main(String[] args) {

    }

    public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {
//        if(root == null) return false;
//        boolean rightAns = false;
//        boolean leftAns = false;
//        if(root.data == k) return true;
//        else if(root.data < k){
//            rightAns = searchInBST(root.right, k);
//        }else{
//            leftAns = searchInBST(root.left, k);
//        }
//        return rightAns || leftAns;


        if(root == null) return false;
        if(root.data == k) return true;
        if(root.data < k){
            return searchInBST(root.right, k);
        }else{
            return searchInBST(root.left, k);
        }
    }



//    Given a Binary Search Tree and two integers k1 and k2, find and print the elements which are in range k1 and k2 (both inclusive).
//    Print the elements in increasing order.
    public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root,int k1,int k2){
        if(root == null) return;

        if(root.data<k1 && root.data>k2){
            return;
        }
        elementsInRangeK1K2(root.left,k1,k2);
        if(root.data>=k1 && root.data<=k2){
            System.out.print(root.data + " ");
        }
        elementsInRangeK1K2(root.right,k1,k2);

//        if (root == null) return;
//        // If root's data is greater than k1, then only we can get values in left subtree
//        if (root.data > k1) {
//            elementsInRangeK1K2(root.left, k1, k2);
//        }
//        // If root's data is within the range, print it
//        if (root.data >= k1 && root.data <= k2) {
//            System.out.print(root.data + " ");
//        }
//        // If root's data is less than k2, then only we can get values in right subtree
//        if (root.data < k2) {
//            elementsInRangeK1K2(root.right, k1, k2);
//        }
    }



//    Given a binary tree with N number of nodes, check if that input tree is BST (Binary Search Tree). If yes, return true, return false otherwise.
//    Note: Duplicate elements should be kept in the right subtree.
    public static boolean isBST(BinaryTreeNode<Integer> root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBSTUtil(BinaryTreeNode<Integer> node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.data <= min || node.data >= max) {
            return false;
        }
        return isBSTUtil(node.left, min, node.data) && isBSTUtil(node.right, node.data, max);
    }
}

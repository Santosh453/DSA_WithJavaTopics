package linkedlist;

public class LinkedListMain {
    public static void main(String[] args) {

    }

//    Given a singly linked list of integers, reverse it iteratively and return the head to the modified list.
//    Note :
//    No need to print the list, it has already been taken care. Only return the new head to the list.

    public static Node<Integer> reverse_I(Node<Integer> head){
        Node<Integer> current = head;
        Node<Integer> next = null;
        Node<Integer> prev = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }


//    Given a singly linked list of integers and an integer n, find and return the index for the first occurrence of 'n' in the linked list. -1 otherwise.
//    Follow a recursive approach to solve this.
//    Note :
//    Assume that the Indexing for the linked list always starts from 0.
    public static int findNodeRec(Node<Integer> head, int n) {
        if(head == null){
            return -1;
        }
        if(head.data == n){
            return 0;
        }
        int intIndexInList = findNodeRec(head.next, n);
        return intIndexInList == -1 ? -1 : intIndexInList+1;
    }
}

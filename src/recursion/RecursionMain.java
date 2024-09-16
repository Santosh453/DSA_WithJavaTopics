package recursion;

import java.util.*;

public class RecursionMain {


    public static boolean arraySortedOrNot(int []A, int N) {
        return arraySortedOrNotHelper(A,  N, 0);
    }

    private static boolean arraySortedOrNotHelper(int []A, int N, int i) {
        if(i == N-1){
            return true;
        }
        if(A[i]>A[i+1]){
            return false;
        }else{
            return arraySortedOrNotHelper(A,  N, i+1);
        }
    }


    public static int lastIndex(int input[], int x) {
        return lastIndexHelper(input,x,input.length-1);
    }

    private static int lastIndexHelper(int input[], int x, int index){
        if(index < 0){
            return -1;
        }

        if(input[index] == x){
            return index;
        }

        return lastIndexHelper(input,x,input.length-1);
    }


    public static int[] allIndexes(int input[], int x) {
        ArrayList<Integer> arr = new ArrayList<>();
        allIndexesHelper(input,x,0,arr);
        int[] res = new int[arr.size()];
        for(int i=0; i<arr.size(); i++){
            res[i] = arr.get(i);
        }
        return res;
    }

    private static void allIndexesHelper(int input[], int x,int index, ArrayList<Integer> arr) {
        if(input.length <= index){
            return ;
        }
        if(input[index] == x){
            arr.add(index);
        }
        allIndexesHelper(input,x,index+1,arr);
    }


    public static String replaceCharacter(String input, char c1, char c2) {
        return replaceCharacterHelper(input, c1,c2 ,0, "");
    }

    private static String replaceCharacterHelper(String input, char c1, char c2,int i, String s) {
        if(i >= input.length()){
            return s;
        }
        if(input.charAt(i) == c1){
            s+=c2;
        }else{
            s+=input.charAt(i);
        }
        return replaceCharacterHelper(input, c1, c2,i+1, s);
    }


    public static String removeX(String input){
        return removeXHelper(input, "", 0);
    }


    private static String removeXHelper(String input,String ans, int index){
        if(index>=input.length()){
            return ans;
        }
        if(input.charAt(index) != 'x'){
            ans+=input.charAt(index);
        }
        return removeXHelper(input, ans, index+1);
    }


    public static int binarySearch(int input[], int element) {
        return binarySearchHelper(input, element, 0,input.length-1);
    }

    private static int binarySearchHelper(int input[], int element, int l, int r){
        if(l > r){
            return -1;
        }
        int mid = (l+r)/2;
        if(input[mid] == element){
            return mid;
        }else if(input[mid]<element){
            return binarySearchHelper(input, element, mid+1,r);
        }else {
            return binarySearchHelper(input, element, l,mid-1);
        }
    }
}

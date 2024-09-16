package hashmap;

import java.util.HashMap;

public class MainHashMap {

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,4,5,3,2};
        int[] arr2 = {1,2,3,9,2,7,4};
        System.out.println();
        System.out.println("maxFrequencyNumber method calling");
        System.out.println("Maximum Frequency Present in given array 1 {1,2,3,4,4,5,3,2} : " + maxFrequencyNumber(arr1));

        System.out.println();
        System.out.println("Print Intersection of gin=ven arrays array 1 {1,2,3,4,4,5,3,2}, array 2 {1,2,3,9,2,7,4} : ");
        System.out.println("printIntersection method calling");
        printIntersection(arr1,arr2);


        System.out.println("Program Ended");

    }


    // Maximum Frequency Number
//    You are given an array of integers that contain numbers in random order. Write a program to find and return the number which occurs the maximum times in the given input.
//    If two or more elements are having the maximum frequency, return the element which occurs in the array first.

    public static int maxFrequencyNumber(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxCount = Integer.MIN_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for(int a : arr){
            if(map.containsKey(a)){
                map.put(a,map.get(a)+1);
            }else{
                map.put(a,1);
            }
            int count = map.get(a);
            int value = a;
            if(count>maxCount){
                maxCount = count;
                maxValue = value;
            }
        }
        for(int a : arr){
            int current = map.get(a);
            if(current == maxCount){
                maxValue = a;
                break;
            }
        }
        return maxValue;
    }

    // Print Intersection
//    You have been given two integer arrays/lists (ARR1 and ARR2) of size N and M, respectively. You need to print their intersection; An intersection for this problem can be defined when both the arrays/lists contain a particular value or to put it in other words, when there is a common value that exists in both the arrays/lists.
//    Note : Input arrays/lists can contain duplicate elements.
//    The intersection elements printed would be in the order they appear in the second array/list (ARR2).

    public static void printIntersection(int[] arr1,int[] arr2){
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int a : arr1){
            if(map.containsKey(a)){
                map.put(a,map.get(a)+1);
            }else{map.put(a,1);}
        }
        for(int a : arr2){
            if(map.containsKey(a)){
                map.put(a,map.get(a)-1);
                System.out.println(a);
                if(map.get(a)==0){
                    map.remove(a);
                }
            }
        }
    }

}

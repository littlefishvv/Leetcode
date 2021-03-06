package oj;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/2/22 21:05
 * @description：
 * @modified By：
 * @version: $
 */
public class QuickSort {
    //分为非递归快排和递归快排
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){

            String[] str=sc.nextLine().split(" ");
            int[] arr=new int[str.length];
            for(int j=0;j<str.length;j++){
                arr[j]=Integer.parseInt(str[j]);
            }
            problem(arr);


        }
    }
    public static void problem(int[] arr){
        quickSort1(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }
    public static void quickSort(int[] arr,int left,int right){
        if(left<right){
            int mid=partition(arr,left,right);
            quickSort(arr,left,mid-1);
            quickSort(arr,mid+1,right);
        }
    }
    public static int partition(int[] arr,int left,int right){
        int privt=arr[left];
        //注意下面得大于和小于都是和privt比，而不是和arr[left]或者arr[right【比
        while(left<right){
            while(left<right&&arr[right]>=privt){
                right--;
            }
            arr[left]=arr[right];
            while(left<right&&arr[left]<=privt){
                left++;
            }
            arr[right]=arr[left];
        }
        arr[left]=privt;
        return left;
    }

    /*
    * 递归的算法主要是在划分子区间，如果要非递归实现快排，只要使用一个栈来保存区间就可以了。
     一般将递归程序改成非递归首先想到的就是使用栈，因为递归本身就是一个压栈的过程。
    * */

    public static void quickSort1(int[] arr,int left,int right){
        Deque<Integer> stack=new LinkedList<Integer>();
        stack.push(left);
        stack.push(right);
        //注意下面全是l和r而不是left和right
        while(!stack.isEmpty()){
            int r=stack.pop();
            int l=stack.pop();
            int index=partition(arr,l,r);
            if((index-1)>l){
                stack.push(l);
                stack.push(index-1);
            }
            if((index+1)<r){
                stack.push(index+1);
                stack.push(r);
            }
        }
    }
}

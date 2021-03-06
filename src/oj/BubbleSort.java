package oj;

import java.util.Scanner;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/2/22 20:26
 * @description：
 * @modified By：
 * @version: $
 */
public class BubbleSort {
    public static void main(String[] args){
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
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }

            }
        }


        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");

        }
        System.out.println();



    }

}

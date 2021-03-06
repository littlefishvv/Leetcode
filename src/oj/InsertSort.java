package oj;

import java.util.Scanner;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/2/22 20:16
 * @description：
 * @modified By：
 * @version: $
 */
public class InsertSort {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
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
        for(int i=1;i<n;i++){
            int j=i;
            int temp=arr[i];
            while(j-1>=0&&arr[j-1]>temp){
                arr[j]=arr[j-1];
                j=j-1;

            }
            arr[j]=temp;
        }

        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");

        }
        System.out.println();



    }
}

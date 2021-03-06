package oj;

import java.util.Scanner;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/2/22 19:25
 * @description：
 * @modified By：
 * @version: $
 */
public class ShellSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {

            int n = scan.nextInt();
            scan.nextLine();
            for(int i=0;i<n;i++){
                String[] strs=scan.nextLine().split(" ");
                int[] arr=new int[strs.length];
                for(int j=0;j<strs.length;j++){
                    arr[j]=Integer.parseInt(strs[j]);
                }
                String[] temp=scan.nextLine().split(" ");
                int[] count=new int[temp.length];
                for(int j=0;j<temp.length;j++){
                    count[j]=Integer.parseInt(temp[j]);

                }
                problem(arr,count);
            }
        }
    }
    public static void problem(int[] arr,int[] count){
        int n=count.length;

        for(int i=0;i<n;i++){
            int step=count[i];
            //进行希尔排序
            for(int j=step;j<arr.length;j++){
                int k=j;
                int cur=arr[j];
                //元素被换到前面去
                while(k-step>=0&&cur<arr[k-step]){
                    arr[k]=arr[k-step];
                    k=k-step;
                }
                //最后把k得位置更新
                arr[k]=cur;

            }



        }
        for(int t=0;t<arr.length;t++){
            System.out.print(arr[t]+" ");
        }


    }
}

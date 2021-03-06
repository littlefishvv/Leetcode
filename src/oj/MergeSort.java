package oj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/2/24 19:18
 * @description：
 * @modified By：
 * @version: $
 */
//归并排序分为递归和非递归两种
    //归并排序是稳定的
    //
public class MergeSort {
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
    public static  void problem(int[] arr){
         int n=arr.length;
         int[] temp=new int[n];
         merSortNor(arr);
         //System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr));
    }
    public static void merSort(int[] arr,int left,int right,int[] temp){
        if(left<right){
            int mid=left+(right-left)/2;
            merSort(arr,left,mid,temp);

            merSort(arr,mid+1,right,temp);

            merge(arr,left,mid,right,temp);
        }


    }
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        if(left>right) return;
        int i=left;
        int j=mid+1;
        int index=0;
        while(i<=mid&&j<=right){

            if(arr[i]<=arr[j]){
                temp[index++]=arr[i++];

            }else{
                temp[index++]=arr[j++];

            }

        }

        while(i<=mid){
            temp[index++]=arr[i++];
        }
        while(j<=right){
            temp[index++]=arr[j++];
        }
        //这里有个大坑，arr是从left开始往里面写入，而不是从0开始写入 一定要注意
        int k=0;
        while(left<=right){
            arr[left++]=temp[k++];
        }
    }

    //上面是递归的，下面写非递归的归并排序
    public static void merSortNor(int[] arr ){
        int n=arr.length;
        int[] temp=new int[n];
        //步长
        int s=2;
        int i;
        while(s<=n){

            i=0;
            //每一次while循环会把相应间距下标对应的元素排序然后不断扩展步长，但是每次都应当从头开始
            // 【0，1】【2，3】，【4，5】【6，7】【8】
            //【0 1 2 3】【4 5 6 7】【8】
            //【0 1 2 3 4 5 6 7 】【8】
            //【0 1 2 3 4 5 6 7 8】
            System.out.println("s:"+s);
            //i+s就是有边界的后一位
            while(i+s<=n){
                //采用非递归方法merge开头必须判断left是否小于right，否则会报错。
                System.out.println("i:"+i);
                //
                merge(arr,i,i+s/2-1,i+s-1,temp);

                i+=s;
            }
            //处理每次的末尾残留部分这里i+s/2-1是有可能大于right的 但是不影响排序
            merge(arr,i,i+s/2-1,n-1,temp);
            s*=2;
        }
        //从头到尾处理一遍
        merge(arr,0,s/2-1,n-1,temp);
    }

}

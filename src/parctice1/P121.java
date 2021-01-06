package parctice1;

import java.util.Scanner;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/12/28 19:11
 * @description：
 * @modified By：
 * @version: $
 */
public class P121 {
    public static void main(String[] args) {
       /* Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String[] nums = scan.nextLine().split(" ");
            int[] arrs=new int[nums.length];

            for (int i=0;i<nums.length;i++){
                arrs[i]=Integer.parseInt(nums[i]);
                System.out.print(arrs[i]);
            }
            sort(arrs);


            System.out.println(count);
        }*/

       sort(new int[]{8, 3 ,2, 9 ,7 ,1, 5 ,4});
        System.out.println(count);
    }
    static int count=0;
    public static void sort(int[] arr){
        int[] temp=new int[arr.length];
        sort(arr,0,arr.length-1,temp);
    }

    private static void sort(int[] arr,int left,int right,int[] temp){
        //这里是if而不是while  当left不小于right时，说明是单个数字，不需要进行排序
        if (left<right){
            int mid=(left+right)/2;

            //这是要把他们分成到单个数据，这样单个数据就相当于一个有序数组，
            //这是分治中的分的过程 但分的过程也会调用治的过程。
            //左边归并排序，使得左子序列有序
            sort(arr,left,mid,temp);
            ///右边归并排序，使得右子序列有序
            sort(arr,mid+1,right,temp);

            //merge操作的是两段有序的数组内容。
            //这是分治法中的治的过程。  根据left和mid的不同，治的区间也不同。
            merge(arr,left,mid,right,temp);
        }
    }
    //虽然只是记录cout,但还是有必要引入temp,因为我们要更新arr,如果不更新，cout会经过重复计算。
    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i=left;
        int j=mid+1;
        int t=0;
        while(i<=mid&&j<=right){
            //这个小于等于决定了归并排序是稳定的
            if (arr[i]<=arr[j]){
                temp[t++]=arr[i++];
            }else{
                temp[t++]=arr[j++];
                count+=mid-i+1;
            }
        }
        while (i<=mid){
            temp[t++]=arr[i++];

        }
        while(j<=right){
            temp[t++]=arr[j++];
        }
        t=0;
        while(left<=right){
            arr[left++]=temp[t++];
        }
    }
}

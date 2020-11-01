package sort;

import java.util.Arrays;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/10/28 14:40
 * @description：归并排序
 * @modified By：
 * @version: $
 */
public class MergeSort {


    /*
    * 算法描述
    1.把长度为n的输入序列分成两个长度为n/2的子序列；
    2.对这两个子序列分别采用归并排序；
    3.将两个排序好的子序列合并成一个最终的排序序列。

    性质：稳定性：稳定；    时间复杂度O(nlogn)
    * */
    public static void sort(int[] arr){
        int[] temp=new int[arr.length];
        sort(arr,0,arr.length-1,temp);
    }

    private static void sort(int[] arr,int left,int right,int[] temp){
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


    //再写一遍归并排序
    public static void merge1(int[] arr,int left,int mid,int right,int[] temp){
        int i=left;
        int j=mid+1;
        int t=0;
        while(i<=mid&&j<=right){
            if (arr[i]<=arr[j]){
                temp[t++]=arr[i++];
            }else{
                temp[t++]=arr[j++];
            }
        }
        while (i<=mid){
            temp[t++]=arr[i++];

        }
        while(j<=right){
            temp[t++]=arr[j++];
        }
        t=0;
        //这里是把temp赋值到arr的left到right中去。
        while(left<=right){
            arr[left++]=temp[t++];
        }
    }

    public static void sort1(int[] arr,int left,int right,int[] temp){
        //注意，这里是if，而不是while，如果是while就成死循环了
        if (left<right){
            int mid=(left+right)/2;
            sort1(arr,left,mid,temp);
            sort1(arr,mid+1,right,temp);
            merge1(arr,left,mid,right,temp);
        }
    }
    public static void main(String[] args) {

        int arr[]= {65,58,95,10,57,62,13,106,78,23,85};
        int[] temp=new int[arr.length];

        System.out.println("排序前："+ Arrays.toString(arr));

        sort1(arr,0,arr.length-1,temp);

        System.out.println("排序后："+Arrays.toString(arr));

    }
}

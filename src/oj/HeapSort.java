package oj;

import java.util.Arrays;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/2/25 21:23
 * @description：
 * @modified By：
 * @version: $
 */
public class HeapSort {
    public static void heapSort(int[] arr){
        int n=arr.length;
        //从第一个非叶子节点开始，从左到右，从下到上进行下沉调整
        //为什么n/2-1是第一个非叶子节点，因为堆是一个完全二叉树。
        for(int i=n/2-1;i>=0;i--){
            downAdjust(arr,i,n-1);

        }
        //经过上面的调整，该堆已经是一个大顶堆了 让堆顶与末尾元素进行交换
        for(int i=n-1;i>=0;i--){
            //与堆顶交换
            int temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp;
            //交换后要对堆顶进行，以保证它是一个大顶堆 这时len要改为i-1因为第i个已经被堆顶填充好了。
            downAdjust(arr,0,i-1);
        }
    }

    public static void downAdjust(int[] arr,int parent,int len){
        int temp=arr[parent];
        //调整以parent为堆顶的堆
        //从parent节点的左子树开始调整。
        int child=2*parent+1;
        while(child<=len){
            //如果有右孩子且右孩子比较大，则定位到右孩子
            if(child+1<=len&&arr[child+1]>arr[child]){
                child++;
            }
            //如果孩子节点小于等于父节点，则不用下沉了 现在child是左右子树的较大值 注意这里不是<arr[parent]而是小于temp，一定不要出错，
            if(arr[child]<=temp){
                break;
            }
            //否则，让子节点上来
            arr[parent]=arr[child];
            //更新父子节点的下标
            //parent为刚才的子节点
            parent=child;
            //child更新为其左子树节点
            child=2*parent+1;
        }
        //当循环退出时，最初的parent也找到了它该下沉到的位置,这就是所谓的下沉
        arr[parent]=temp;
    }
    public static void main(String[] args) {

        int arr[]= {65,58,95,10,57,62,13,106,78,23,85};

        System.out.println("排序前："+ Arrays.toString(arr));

        heapSort(arr);

        System.out.println("排序后："+Arrays.toString(arr));

    }

}

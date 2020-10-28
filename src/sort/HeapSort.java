package sort;

import java.util.Arrays;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/10/27 16:26
 * @description：
 * @modified By：
 * @version: $
 */
public class HeapSort {
    /*
    *
    * 性质：时间复杂度O(nlogn) 稳定性：不稳定 （
      比如：3 27 36 27，
      如果堆顶3先输出，则，第三层的27（最后一个27）跑到堆顶，然后度堆稳定，继续输出堆顶，是刚才内那个27，这样说明后面的27先于第容二个位置的27输出，不稳定。
      ） 比较次数和初始顺序无关
      堆的特点就是堆顶的元素是一个最值，大顶堆的堆顶是最大值，小顶堆则是最小值。
      堆排序就是把堆顶的元素与最后一个元素交换，交换之后破坏了堆的特性，我们再把堆中剩余的元素再次构成一个大顶堆，
      然后再把堆顶元素与最后第二个元素交换….如此往复下去，等到剩余的元素只有一个的时候，此时的数组就是有序的了。


    * */
    public static int[] headSort(int[] arr){
        int n=arr.length;
        //首先要先构建大顶堆
        //从第一个非叶子节点开始，从下至上，从右至左调整结构（因为叶子节点没有孩子，无法进行调整）从下往上让每一个节点都是一个大顶堆。
        for (int i=n/2-1;i>=0;i--){
            downAdjust(arr,i,n-1);
        }

        //把堆顶元素与末尾元素就行交换，每次交换后，都要重新调整前i-1个元素为大顶堆。
        for (int i=n-1;i>=1;i--){
            int temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp;
            //对头节点进行下沉  只需要执行一次downAdjust就可以使堆继续保持最大堆/ 因为一次downAdjust会有多次调整。
            downAdjust(arr,0,i-1);
        }
        return arr;
    }
    //todo 找一个固定的时间搞懂堆排序

    //downAdjust就是对parent节点进行调整，让它放到正确的位置
    public static void downAdjust(int[] arr,int parent ,int n){
        //临时保存要下沉的元素
        int temp=arr[parent];
        //定位左孩子节点的位置
        int child=2*parent+1;
        //开始下沉 孩子节点要在正常范围之内
        //如果是高层节点，那么，可能在这个循环里可能循着一直调整下去。
        while(child<=n){
            //如果有右孩子而且比左孩子大，则定位到右孩子
            if (child+1<=n&&arr[child]<arr[child+1]) child++;
            //如果孩子节点是小于等于父节点的，那不用下沉了
            if(arr[child]<=temp) break;

            //否则，  让子节点上来
            arr[parent]=arr[child];
            //更新父子节点的位置  让parent成为刚下方的那个位置。
            parent=child;
            child=2*parent+1;
        }
        //循环结束，parent位置获得了更新  所谓下沉，也就这一行代码有下沉
        arr[parent]=temp;

    }
    public static void main(String[] args) {

        int arr[]= {65,58,95,10,57,62,13,106,78,23,85};

        System.out.println("排序前："+ Arrays.toString(arr));

        headSort(arr);

        System.out.println("排序后："+Arrays.toString(arr));

    }
}

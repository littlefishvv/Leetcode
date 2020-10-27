package sort;

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
        for (int i=(n-2)/2;i>=0;i--){
            downAdjust(arr,i,n-1);
        }
        for (int i=n-1;i>=1;i--){
            int temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp;
            downAdjust(arr,0,i-1);
        }
        return arr;
    }
   //todo 找一个固定的时间搞懂堆排序
    public static void downAdjust(int[] arr,int parent ,int n){

    }
}

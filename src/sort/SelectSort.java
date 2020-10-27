package sort;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/10/27 16:04
 * @description：各种选择排序
 * @modified By：
 * @version: $
 */
public class SelectSort {

    //直接选择排序 （简单选择排序）记录下最小元素的下边（也就是选择的过程） 然后和前面的元素交换

    /*选择排序    两个选择排序都不稳定
过程简单描述：
首先，找到数组中最小的那个元素，其次，将它和数组的第一个元素交换位置(如果第一个元素就是最小元素那么它就和自己交换)。
其次，在剩下的元素中找到最小的元素，将它与数组的第二个元素交换位置。如此往复，直到将整个数组排序。这种方法我们称之为选择排序。
1.直接（简单）选择排序
性质：不稳定（如 4 2 4 1那么在找第一轮找到最小值1的时候进行和4交换，那么第一个4就跑到第二个4后面去了） 时间复杂度O(n^2)
 比较次数：n(n-1)/2 与数组初始顺序无关（因为每次都要从后面i-1个元素中找出最小值）
    *
    * */
    public static int[] selectSort(int[] a){
        if (a==null||a.length<=1) return a;
        int n=a.length;

        //从【i-n】中找到最小值（这是一个选择的过程）和i进行交换
        for (int i=0;i<n-1;i++){
            int min=i;
            //不断更新下标min
            for (int j=i;j<n;j++){
                if (a[min]>a[j]) min=j;
            }

            int temp=a[i];
            a[i]=a[min];
            a[min]=temp;
        }

        return a;
    }



    //堆排序也是一种选择排序 详见heapsort todo

}

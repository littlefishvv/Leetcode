package sort;

import java.util.Arrays;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/10/27 16:35
 * @description：交换排序，包括冒泡排序和快速排序
 * @modified By：
 * @version: $
 */
public class ExchangeSort {

    //1.冒泡排序 每经过一轮 把前n-i-1个元素的最大值交换到最后面去.这样，最后面的几个数据就是排好序的，这和选择排序中的直接选择恰好相反，
    //直接选择是经过几轮后，前面的几个元素都是排好序的
    /*
    * 稳定（因为在前一个比后一个大时才会交换位置）   时间复杂度：O(n^2)
比较次数和初始顺序有关，初始排好序时只需要第一遍的比较n-1,如果初始是完全杂乱的，就需要n(n-1)次比较
,所以它的走一趟,如果在这一趟中没有发生任何交换,它知道这个序列是排好序的,也就是n-1次,不过这个要在代码中判断,如果不加入判断的话,它还是一直比较下去,直到结束.（也就是说，如果没有发生交换，就跳出循环，这是需要新加代码的，下面这个代码并不会跳出，会一直比下去）


把第一个元素与第二个元素比较，如果第一个比第二个大，则交换他们的位置。接着继续比较第二个与第三个元素，如果第二个比第三个大，则交换他们的位置….

我们对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样一趟比较交换下来之后，排在最右的元素就会是最大的数。

除去最右的元素，我们对剩余的元素做同样的工作，如此重复下去，直到排序完成。
    *
    * */
    public static int[] bubbleSort(int[] arr){
        if (arr==null||arr.length<=1) return arr;
        int n=arr.length;
        //第一轮循环的i仅仅起一个控制下层循环的作用，并不指向实际的元素。 这里i小于n和小于n-1都可以。
        for (int i = 0; i < n-1; i++) {
            //我们只对前n-i-1个元素进行交换，因为每次我们都会把第n-i大的元素放到第n-i-1这个下标上去素放到最后去
            for (int j=0;j<n-i-1;j++){
                //如果后面的大于前面的，说明需要交换
                if (arr[j+1]<arr[j]){
                    int t=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=t;
                }
            }
        }
        return arr;
    }



    //交换排序2之快速排序  稳定性：不稳定
//todo 要掌握多种快速排序的实现方式。
    //首先要对整体进行一次partition，找出基准值的下标，然后，再对基准值的左右分别进行partition，执行起来就是对左右进行quickSort
    public static void quickSort(int[] arr,int left,int right){
        //一定要加这个判断 否则跳不出循环
        if (left<right){
            //一次partion的过程不仅排序了一次，也返回了基准值所在的位置
            int mid=partition(arr,left,right);
            //注意，这是递归的是quicksort，而不是partition。
            quickSort(arr,left,mid-1);
            quickSort(arr,mid+1,right);
        }

    }

    public static int partition(int[] arr,int left,int right){
        //选一个基准值
        int pivot=arr[left];

       /* //下面的代码一点点都不能动 尤其是=号
        while(true){
            //向右找到一个大于基准值的元素的位置
            while(i<=j&&arr[i]<=pivot) i++;
            //向左找到第一个小于基准值的元素的位置
            while(i<=j&&arr[j]>=pivot) j--;
            if (i>=j) break;
            //交换两个元素的位置，始得左边的元素不大于pivot，右边的元素不小于pivot
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
        //最后相遇时的值和基准值就行交换。这里交换回去的值是一定比arr[left]小的 因为第一轮循环只要大的都往左继续找了
        arr[left]=arr[j];
        arr[j]=pivot;
        return j;
*/
       //这样写会简单一些
       /* while(left<right){
            while(left<right&&arr[right]>=pivot){
                right--;
            }
            arr[left]=arr[right];
            while(left<right&&arr[left]<=pivot){
                left++;
            }
            arr[right]=arr[left];

        }
        arr[left]=pivot;*/
       while(left<right){
           while(left<right&&arr[right]>=pivot) right--;
           //找到右边需要交换的元素的下标，把它放到左边的位置  不必担心基准值会变，因为基准值已经记录下来了。
           arr[left]=arr[right];
           //找到需要交换的左边的元素的下标，把它交换到右边的位置。
           while(left<right&&arr[left]<=pivot) left++;
           arr[right]=arr[left];

       }
       //跳出循环后left==right，这时让这个值等于基准值。
       arr[left]=pivot;
        return left;

    }
    public static void main(String[] args) {

        int arr[]= {65,58,95,10,57,62,13,106,78,23,85};

        System.out.println("排序前："+ Arrays.toString(arr));

        bubbleSort(arr);

        System.out.println("排序后："+Arrays.toString(arr));

    }

}

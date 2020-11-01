package sort;

import java.util.Arrays;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/10/27 14:23
 * @description：
 * @modified By：
 * @version: $
 */

public class InsertSort {

    //1.直接插入排序
    /*
    * 性质：1、时间复杂度：O(n2)  2、空间复杂度：O(1)  3、稳定排序  4、原地排序
      * 如果给定的数组已经排好序了，那么时间复杂度为o(n)只需要每个元素比较一次就行了。
      * 因为比较一次就可以找到比自己小的元素，就不需要移动了
    * */
    public static int[] insertSort(int[] arr){

        if(arr==null||arr.length<=1) return arr;
        int n=arr.length;
        for (int i = 0; i < n; i++) {
            //这个就是要排序的数
            int temp=arr[i];
            //寻找插入位置
            int k=i-1;
            //寻找插入位置，从当前元素的前一个元素开始比较，如果后者大于前者，才继续往后找，这样能保证稳定性
            //要注意的是，k+1才是要插入位置的下标
            while(k>=0&&arr[k]>temp) k--;

            //找到插入下标k+1后，要把k+1后面的所有元素都往后移动一位
            for(int j=i;j>k+1;j--){
                arr[j]=arr[j-1];
            }
            //再次明确，k+1才是要插入的位置，直接赋值即可
            arr[k+1]=temp;
        }

        return arr;
    }


    //二.二分插入排序
    /*
    * 和直接插入排序的最大区别是，元素A[i]的位置的方法不一样；直接插入排序是从A[i-1]往前一个个比较，从而找到正确的位置；而二分插入排序，利用前i-1个元素已经是有序的特点结合二分查找的特点，找到正确的位置，从而将A[i]插入，并保持新的序列依旧有序；

        性质：稳定   时间复杂度:O(nlogn)  比较次数和初始排序无关

        注意。因为查找用的是二分查找，所以比较次数和初始排序无关。
    * */
    public static void binarySort(int[] arr){
        if (arr==null||arr.length<=1) return;
        int len=arr.length;
        for (int i = 0; i < len; i++) {
            int temp=arr[i];
            //在寻找插入位置上进行二分查找
            int low=0;
            int high=i-1;
            //最后一定会找到一个位置，mid=low=high 要插入的位置是high+1
            while(low<=high){
                int mid=(high+low)/2;
                //同样，只有大于的时候才继续往前找
                if (arr[mid]>temp) high=mid-1;
                //否则说明要插入的位置在后面那一段
                else low=mid+1;
            }

            //移动
            for(int j=i;j>high+1;j--){
                arr[j]=arr[j-1];
            }
            arr[high+1]=temp;
        }
    }

    //3.希尔排序 对整体进行分组，对每个分组进行插入排序，然后不断缩小分组之间的距离
    //性质：不稳定 （因为希尔排序涉及到多个简单插入排序，虽然对于一个简单插入排序来说是稳定的，但当多个时，他们之间是没有关系的，
    // 就有可能会有某个元素排到了另一个相等元素的前面）
    // 如3 2 2 3 5 时 第二个2在第一轮时就排到了第一个2的前面了 时间复杂度：未知
    public static int[] shellSort(int[] arr){
        if (arr==null||arr.length<=1) return arr;
        int len=arr.length;
        //每次都要缩小gap
        for (int gap=len/2;gap>0;gap=gap/2){
            //然后和普通的直接插入排序就一样了
            for(int i=gap;i<len;i++){
                int j=i;
                int cur=arr[i];
                //这里的j-gap就相当于上面的k  上面是先while循环找插入位置，再for循环移动数据。这里通过while循环一次性做完了
                //每次循环只完成一个数据的插入和交换 边比较边交换
                while(j-gap>=0&&arr[j-gap]>cur){
                    //再这个组，如果j-gap对应元素大于cur，那么把j-gap的值挪到j这个位置，然后让j-gap更新j  先赋值 再更新j
                    arr[j]=arr[j-gap];
                    j=j-gap;
                }
                //最后让要插入的那个元素放到最后更新完完毕后的j的位置。也就是判断出arr[j-gap]是小于等于cur，那么就不更新j也不移动元素了，j就是cur要方的位置
                arr[j]=cur;
            }
        }
        return arr;

    }
    //手写一遍希尔排序
    public static int[] shellSort1(int[] arr){
        if(arr==null||arr.length<=1) return arr;
        int n=arr.length;
        for (int gap=n/2;gap>0;gap=gap/2){
            for (int i=gap;i<n;i++){
                int j=i;
                int cur=arr[i];
                while(j-gap>=0&&arr[j-gap]>cur){
                    arr[j]=arr[j-gap];
                    j=j-gap;
                }
                arr[j]=cur;
            }

        }
        return arr;
    }
    public static void main(String[] args) {

        int arr[]= {65,58,95,10,57,62,13,106,78,23,85};

        System.out.println("排序前："+ Arrays.toString(arr));

        binarySort(arr);

        System.out.println("排序后："+Arrays.toString(arr));

    }

}

package Arrays;
import java.util.Arrays;

public class Problem215 {
    /*
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:

输入: [3,2,1,5,6,4] 和 k = 2
输出: 5*/

    //方法1 暴力法

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len - k];
    }

    //方法二，通过快速排序的partition多次定位  这个partition和我以前常用的快速排序的partition不太一样，理解起来更难，但是代码更简洁
    /*直观地理解如果每次规模为 nn 的问题我们都划分成 11 和 n - 1n−1，每次递归的时候又向 n - 1n−1 的集合中递归，这种情况是最坏的，时间代价是 O(n ^ 2)O(n
2)。我们可以引入随机化来加速这个过程，它的时间代价的期望是 O(n)O(n)，
*/
    public int partition(int[] nums,int left,int right){
        //以最右边的为基准值，维持一个循环不变量,在[1,j]区间小于等于基准值，在[j+1,i]区间大于基准值
        int x=nums[right],j=left+1;
        for(int i=1;i<right;i++){
            if(nums[i]<=x){
              j++;
              swap(nums,j,i);
            }
        }
        swap(nums,j,left);
        return j;
    }
    public void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    public int findKthLargest2(int[] nums,int k){
        int len=nums.length;
        int left=0;
        int right=len-1;
        //第k大元素的索引是len-k
        int target=len-k;
        while(true){
            int index=partition(nums,left,right);
            if(index==target){
                return nums[index];
            }else if(index<target){
                left=index+1;
            }else {
                right=index-1;
            }
        }

    }

}

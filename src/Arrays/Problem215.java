package Arrays;
import java.util.Arrays;
import java.util.PriorityQueue;

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
        int x=nums[right],j=left;
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
    public int findKthLargest1(int[] nums,int k){
        int len=nums.length;
        //新建一个长度为len的优先队列，其中第二个参数lamada表达式决定了这是一个优先队列
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(len,(a, b) -> b-a);
        //思路，既然是找第k的元素，那么我把前k-1大个元素全部poll，然后剩下的堆顶不就是第k大的元素了吗
        for (int i = 0; i < len; i++) {
            maxHeap.add(nums[i]);
        }
        for (int i=0;i<k-1;i++){
            maxHeap.poll();
        }
        return maxHeap.peek();
    }
    //上面的代码用了len个空间，这里还可以优化一下。
    //思路，最小堆把前len-k+1个小的元素排出，那堆顶就是第k大（第len-k小）的元素
    // 我先把前k个元素放到最小堆里（这样可以保证不会把第k大的元素给poll走），从第k+1个开始，入堆时，让堆去自动维护，再把堆顶给排除
    //使用这种思路的话不能使用大顶堆，只能使用小顶堆，因为大顶堆在出堆时无法保证出去的不是目标数据
    public int findKthLargest3(int[] nums, int k) {
        int len = nums.length;
        // 最小堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k + 1, (a, b) -> (a - b));
        for (int i = 0; i < k; i++) {
            priorityQueue.add(nums[i]);
        }
        for (int i = k; i < len; i++) {
            priorityQueue.add(nums[i]);
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }

}

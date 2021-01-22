package Hot100;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/21 16:14
 * @description：
 * @modified By：
 * @version: $
 */
public class Problem239 {
    //这种写法会超时
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        if (k>=n){
            Arrays.sort(nums);
            return new int[]{nums[n-1]};
        }
        int[] res=new int[n-k+1];
        for (int i=0;i<n-k;i++){
            int max=Integer.MIN_VALUE;
            for(int j=i;j<k;j++){
                if (nums[j]>max) max=nums[j];
            }
            res[i]=max;

        }
        return res;



    }
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n=nums.length;
        if(nums==null||nums.length<2) return nums;
        LinkedList<Integer> queue=new LinkedList();
        int[] res=new int[n-k+1];
        //解释一下为什么队列中要存放数组下标的值而不是直接存储数值，
        // 因为要判断队首的值是否在窗口范围内，由数组下标取值很方便，而由值取数组下标不是很方便
        for (int i = 0; i < nums.length; i++) {
            //要维护从大到小的关系，如果新结点要比队列中的结点大，就一直抛出队列中的这些元素，这个窗口一直维护保持队首元素最大，同时又要保证队首元素还在当前的窗口内。
            while(!queue.isEmpty()&&nums[queue.peekLast()]<=nums[i]){
                    queue.pollLast();
            }
            //把新元素添加进去,加进去的是下标
            queue.addLast(i);
            //判断当前队首是否有效.相当于peekFirst比如当前是i。那么这个窗口只能维护【i-k+1,i】这个区间内的元素，其他的都要
            if (queue.peek()<=i-k){
                queue.poll();
            }
            //因为队首就是当前的最大值，而且，当i+1等于k后，每一次的移动都代表一次滑动窗口的位移，需要更新res数组。
            if (i+1>=k){
                res[i+1-k]=nums[queue.peek()];
            }

        }


        return res;

    }
}

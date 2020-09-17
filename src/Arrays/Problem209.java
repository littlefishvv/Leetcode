package Arrays;

import java.util.Arrays;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/9/17 9:25
 * @description：给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0。
 *
 * 示例：
 *
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem209 {
    //暴力法，三重循环，时间复杂度很高 o(n^3) 但是可以用二维数组采用动态规划方法，来容纳i-j的和，然后再通过遍历动态规划数组找到最小长度
    //下面是滑动窗口解法，时间复杂度为o(n)  滑动窗口也可以用队列模拟
    public int minSubArrayLen(int s,int[] nums){
        //这里也用到了循环不变量 nums[l,r]为我们的滑动窗口  所以r设为了-1
        int l=0,r=-1;
        int sum=0;
        //res是返回值，我们取这个res和当前len的最小值
        int res=nums.length+1;
        while(l<nums.length){
            //这个r+1<nums.length是个细节。
            if (r+1<nums.length&&sum<s){
                //先进行r++操作 因为当前sum不能满足条件
                r++;
                sum+=nums[r];
            }else{
                sum-=nums[l];
                l++;
            }
            //我们通过滑动窗口找到了一个可行的连续子数组l
            if(sum>=s){
                res=Math.min(res,r-l+1);

            }
        }
        //如果res没有被更新，说明没有解，则返回0
        if(res==nums.length+1){
            return 0;
        }else{
            return res;
        }
    }
    //还有一种方法，叫前缀和+二分查找法
    //对于每一个前缀和，用二分查找法去找sum[i]+target所在的位置，然后动态更新长度即可
    public int minSubArrayLen1(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        // 为了方便计算，令 size = n + 1
        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
        // 以此类推
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

}

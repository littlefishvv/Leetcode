package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/9 16:41
 * @description：
 *
 * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 *
 * 示例:
 *
 * nums = [1, 2, 3]
 * target = 4
 *
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 *
 * 请注意，顺序不同的序列被视作不同的组合。
 *
 * 因此输出为 7。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem377 {
    //如果用回溯会超时
    int count=0;
    public int combinationSum4(int[] nums, int target) {
        List<Integer> list=new ArrayList<>();

        int  n=nums.length;

        backTrack(nums,target);
        return count;
    }
    private void backTrack(int[] nums, int target){
        if (target<0) return;
        if (target==0){
            count++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>target) continue;
            backTrack(nums,target-nums[i]);
        }


    }

    //这个问题可以看作是一个完全背包问题
    public int combinationSum45(int[] nums, int target) {
        int n=nums.length;
        if (n==0) return 0;
        //dp[n]代表对于目标和为n的数，再nums中对应有几个组合
        int dp[]=new int[target+1];
        //为什么要设置dp[0]==1而不是其他的 因为dp[n-n]表明一定可以凑成目标和为n的零钱，也就是要加一
        dp[0]=1;
        for (int i = 1; i <=target; i++) {
            for (int num:nums){
                if (num<=i){
                    //比如dp[4]就是dp[4-3]+dp[4-2]+dp[4-1]的组合加起来，因为从后面这些再加上当前的num中一定能凑成dp[4];
                    dp[i]=dp[i]+dp[i-num];
                }
            }
        }
        return dp[target];

    }

}

package dp;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/7 20:36
 * @description：给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 * 解释：
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * 一共有5种方法让最终目标和为3。
 *  
 *
 * 提示：
 *
 * 数组非空，且长度不会超过 20 。
 * 初始的数组的和不会超过 1000 。
 * 保证返回的最终结果能被 32 位整数存下。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem494 {
    //这一题最先考虑用回溯法
    int count;
    public int findTargetSumWays(int[] nums, int S) {
        backTrack(nums,S,0,0);
        return count;

    }
    public void backTrack(int[] nums,int S,int sum,int i){
        if (i==nums.length){
            if(sum==S){
                count++;
                return;
            }
            return;

        }
        backTrack(nums,S,sum+nums[i],i+1);
        backTrack(nums,S,sum-nums[i],i+1);

    }

    //方法2 用动态规划做，背包问题
    //这个问题可以转化为传统得01背包问题，目标和为s，假设所有数组总和为sum,那么就是说我需要在数组中找到
    //一些整数和，使得他们等于(sum+s)/2就行了，这就把问题转化为了一道经典的01背包问题
    //比如x+y+z-a-b=S 则s+b+c=x+y+z 则s+x+y+z+a+b=2(x+y+z) 即x+y+z=(sum+S)/2 相当于416题
    public int findTargetSumWays1(int[] nums, int S) {

        int n=nums.length;
        if (n==0) return 0;
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 绝对值范围超过了sum的绝对值范围则无法得到
        if (Math.abs(S) > Math.abs(sum)) return 0;
        if ((sum+S)%2==1) return 0;

        int target=(sum+S)/2;
        //转化为01背包问题的组合

        int[] dp=new int[target+1];
        dp[0]=1;
        for (int num:nums){
            for (int i=target;i>=num;i--){

                dp[i]=dp[i]+dp[i-num];
            }
        }
        /*
        这段代码和上面有什么区别？ 其实dp[0]也是要更新的，所以对于下面来说，dp[0]永远无法更新
        for (int num:nums){
            for (int i=target;i>=1;i--){
                if (num<=i){
                  dp[i]=dp[i]+dp[i-num];
                }

            }
        }*/
        return dp[target];




    }
}

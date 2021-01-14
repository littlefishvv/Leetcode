package dp;

import java.util.Arrays;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/8 11:23
 * @description：
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 *
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem198 {


    //自顶向下利用备忘录，一种比较直观的方式
    private int[] memo;
    public int rob0(int[] nums){

        memo=new int[nums.length];
        //Arrays.fill一次性填充数组
        Arrays.fill(memo,-1);
        return dp(nums,0);
    }
    private int dp(int[] nums,int start){
        if (start>=nums.length){
            return 0;
        }
        if (memo[start]!=-1){
            return memo[start];
        }
        int res=Math.max(dp(nums,start+1),nums[start]+dp(nums,start+2));
        memo[start]=res;
        return res;
    }

    //
    public int rob(int[] nums) {
        //考虑偷取[x,,,n-1]范围内的房子，dp[x]就是x到n-1
        //考虑状态转移方程，
        int n=nums.length;
        if (n==0) return 0;
        int[] dp=new int[n];
        //如果只能从最后一个房子开始偷，那么只能偷这一个
        dp[n-1]=nums[n-1];
        //考虑对于从i这个位置开始偷，到n-1房子这个位置 能偷的最大值
        //即可以从i,i+1等位置开始，然后加上后面能偷的最大值，进行比较
        for (int i=n-2;i>=0;i--){
            for(int j=i;j<n;j++){
                dp[i]=Math.max(dp[i],nums[j]+(j+2<n?dp[j+2]:0));
            }
        }
        //dp0就是考虑能得到的最大值
        return dp[0];
    }

    //上面是考虑从i到n-1的，现在考虑从0到i的
    public int rob1(int[] nums) {
        //考虑偷取[x,,,n-1]范围内的房子，dp[x]就是x到n-1
        //考虑状态转移方程，
        int n=nums.length;
        if (n==0) return 0;
        int[] dp=new int[n];
        dp[0]=nums[0];
        //每一个dp[i]都需要前面的dp[i-1]等等作为基础
        for (int i=1;i<n;i++){
            for(int j=i;j>=0;j--){
                dp[i]=Math.max(dp[i],nums[j]+(j-2>=0?dp[j-2]:0));

            }
        }

        return dp[n-1];
    }
    //还有一种方法可以更简单的判断。即要么不取i。则结果就是dp[i-1]如果取了i，则结果就是dp[i-2]+nums[i]
    public int rob3(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        int[] dp=new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);

        }
        return dp[n-1];

    }



}

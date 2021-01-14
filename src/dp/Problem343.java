package dp;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/7 17:30
 * @description：
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem343 {
    //这一题涉及到最大值问题，脑袋中要想到用动态规划解决
    public int integerBreak(int n) {
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for (int i=2;i<=n;i++){
            for (int j=1;j<i;j++){
                dp[i]=Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]));
            }

        }
        return dp[n];


    }
}

package dp;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/7 17:31
 * @description：
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */


public class Problem279 {
    //最少最值问题，考虑用动态规划
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        dp[1]=1;
        for (int i=2;i<=n;i++){
            dp[i]=i;
            for (int j=1;j*j<=i;j++){
                if (j*j==i){
                    dp[i]=1;
                }else{
                    dp[i]=Math.min(dp[i],1+dp[i-j*j]);
                }
            }


        }

        return dp[n];

    }



}

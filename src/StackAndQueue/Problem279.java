package StackAndQueue;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/11/10 16:34
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
    //找到一个不大于但最近n的平方和，然后让n减去这个，一直循环下去，直到n为0
    //动态规划方法
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        if (n==1) return 1;
        for (int i=1;i<=n;i++){
            dp[i]=i;
            for (int j=1;i-j*j>=0;j++){

                /*
    #   与 （完全平方数和为 i - j * j 的 最小个数 + 完全平方数和为 j * j(也就是1)的 最小个数）*/
                //注意，这里不能改成dp[i-j*j]+dp[j*j]因为j*j是有可能等于i的，那么dp[j*]在这个时候是等于j*j的
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }

}

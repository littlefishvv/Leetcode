package july27toAug2;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/7/30 8:56
 * @description：给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * @modified By：
 * @version: $
 */
public class Solution343 {
    public int integerBreak(int n){

        //dp[i]表示将正整数i拆分成至少两个正整数的和之后，这些正整数的最大乘积。0和1都不能拆分，因此dp[0]=dp[1]=0
        /*
        * 因为i可以拆分为j和i-j.而j的范围是1--i-1 因此dp[i]= max {max(j×(i−j),j×dp[i−j])} j属于1--i-1需要 i的范围是2--n故需要两重循环
        * */
        int[] dp=new int[n+1];
        //那么i从2开始，一直到n,注意这里能取到n 一个二重循环，能找到，dp[i]对应的值，也就是将整数i拆分成至少两个正整数的和后，这些正整数的最大乘积
        for(int i=2;i<=n;i++){
            int curMax=0;
            for(int j=1;j<i;j++){
                curMax=Math.max(curMax,Math.max(j*(i-j),j*dp[i-j]));
            }
            dp[i]=curMax;

        }
        return dp[n];


    }
}

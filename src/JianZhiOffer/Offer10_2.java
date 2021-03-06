package JianZhiOffer;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/2/1 17:01
 * @description：
 * @modified By：
 * @version: $
 */
public class Offer10_2 {
    public int numWays(int n) {
        if(n==0) return 1;
        if(n<=2) return n;
       /* int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for(int i=2;i<=n;i++){
            dp[i]=(dp[i-1]+dp[i-2])%1000000007;
        }
        return dp[n];*/
        //这些数的赋值有讲究，其中的i从3开始，那么sum初始应该是dp[2],b初始应该是dp[1] a是什么不重要，因为第一次循环不依赖a
        
        int a=1,b=1,sum=2;
        for(int i=3;i<=n;i++){
            a=b;
            b=sum;
            sum=(a+b)%1000000007;
        }
        return sum;

    }
}

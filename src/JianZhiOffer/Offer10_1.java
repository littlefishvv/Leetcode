package JianZhiOffer;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/2/1 16:33
 * @description：
 * @modified By：
 * @version: $
 */
public class Offer10_1 {
    //这一题也给我一个提醒，题目中明确说了要对结果取余1000000007
    //为什么是这个数？1e9+7这个数，满足[0,1e9+7)内所有数，两个数相加不爆int，两个数相乘不爆long long
    //
    //还有一点，由于1e9+7是质数，所以在[1,1e9+7)内所有数都存在关于1e9+7的逆元（这样就可以做除法）
    public int fib(int n) {
        if(n==0||n==1) return n;
        // else return fib(n-1)+fib(n-2);
        //但是这样写实在是太耗费时间了。
        //要加上记忆化搜索或者动态规划
        //但是，这样还会有几个问题，1，dp[i]只需要前两个数就行不需要这个数组，第二，如果n太大，数字会超出整形范围
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=(dp[i-1]+dp[i-2])%1000000007;

        }
        return dp[n];

    }
    public int fib2(int n) {
        if(n==0||n==1) return n;
        int a=0,b=1,sum=1;
        for (int i=2;i<n;i++){
            a=b;
            b=sum;
            sum=a+b;
        }
        return sum;
    }

    public static void main(String[] args) {
    }
}

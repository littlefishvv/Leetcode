package JianZhiOffer;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/8/21 9:51
 * @description：给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Offer14_1 {
    //可以通过数学证明得到当每段都是e时，乘积值最大。
    public int cuttingRope(int n) {
        if(n==1||n==2) return 1;
        if(n==3) return 2;
        int sum=1;
        //当n>4时，满足每段都是3 乘积最大
        while(n>4) {
            sum*=3;
            n-=3;
        }
        return sum*n;
    }
    //上面那种几乎不可能想到  下面这种用动态规划方法解决。 dp[i]代表长度为i的绳子所构成的乘积最大值
    //首先有几个特例。dp[2]如果按最大值是1*1=1，所以这里我们取2本身，同理dp[3]本来该等于1*2的，但是这里我们直接取2
    //只有当i>4时，我们的状态转移方程才生效。
    public int cuttingRope1(int n){
        if (n<=3) return n-1;
        int[] dp=new int[n-1];
        dp[2]=2;
        dp[3]=3;
        for (int i = 4; i < n; i++) {
            for (int j=1;j<=i/2;j++){
                //在循环中不断更新dp[i]
                dp[i]=Math.max(dp[j]*dp[i-j],dp[i]);
            }
        }
        return dp[n];
    }

}

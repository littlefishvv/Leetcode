package dp;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/9 13:17
 * @description：
 * @modified By：
 * @version: $
 */
public class Knapsack01  {
    //w 为物品重量，v为物品价值 ，c为背包容量
    public int knapsack(int[] w,int[] v,int c){
        int n=w.length;
        if (n==0 || c==0) return 0;
        //之所以要c+1是为了表示 0- c dp[i][j]是考虑将i个物品放入容量为j的背包（并不是将前n个都放入，也不是将第n个放入，而是考虑多种情况后得到的一个最大值），使得价值最大
        int[][] dp=new int[n][c+1];
        //初始化第一行
        for (int j=0;j<=c;j++){
            dp[0][j]=(j>=w[0]?v[0]:0);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < c; j++) {
                if (w[i]<=j){
                    //是放价值大还是不放价值大？如果放进去，那么就是容量要减去这个w[i]价值就加上该物品的价值
                    //优化空间复杂度写法 因为我们用到的不是第0行就是第一行，只需要开辟两个空间 第i只依附于第i-1行
                   // dp[i%2][j]=Math.max(dp[(i-1)%2][j],dp[(i-1)%2][j-w[i]]+v[i])

                    //还可更进一步优化，让只需要开辟一个一维数组
                   /* int[] d=new int[c+1];
                    for (int j=0;j<=c;j++){
                        d[j]=(j>=w[0]?v[0]:0);
                    }
                    for (int i1 = 1; i1 < n; i1++) {
                        for (int i2 = c; i2 >= w[i1]; i2--) {
                            d[i2]=Math.max(d[i2],d[i2-w[i1]]+v[i1]);

                        }
                    }
                    return d[c]
                    */
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-w[i]]+v[i]);
                }else{
                    //如果重量比容量还大，就不能放，直接就是上次一次的价值
                    //优化写法 因为我们用到的不是第0行就是第一行，只需要开辟两个空间 第i只依附于第i-1行
                    //dp[i%2][j]=dp[(i-1)%2][j];
                    dp[i][j]=dp[i-1][j];
                }

                /*
                * 如果上面的if else换成这个，就变成了完全背包问题
                * for (int k = 0; k * V[i] <= j; k++){
                    dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j-k * V[i]] + k * P[i]);
                }
                还有多重背包问题


                * */
            }

        }

      //  return dp[(n-1)%2][c];
        return dp[n-1][c];




    }
}

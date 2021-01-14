package dp;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/8 11:26
 * @description：
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem309 {
   /*
   * 我们目前持有一支股票，对应的「累计最大收益」记为 f[i][0]

我们目前不持有任何股票，并且处于冷冻期中，对应的「累计最大收益」记为 f[i][1]

我们目前不持有任何股票，并且不处于冷冻期中，对应的「累计最大收益」记为 f[i][2]

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/zui-jia-mai-mai-gu-piao-shi-ji-han-leng-dong-qi-4/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   *
   * */
    public int maxProfit(int[] prices) {

        int n = prices.length;
        if (n == 0) return 0;
        int[][] dp = new int[n][3];
        //第一天持有股票，对应负收益
        dp[0][0] = -prices[0];

        /*   识别状态，列出状态转移方程，
        *   f[i][0]: 手上持有股票(购买了股票，股票没有卖出，买入股票的当天)的最大收益
            f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益（股票已经卖出的当天）
            f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益（股票至少在前两天已经卖出）

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/zui-jia-mai-mai-gu-piao-shi-ji-han-leng-dong-qi-4/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
        * */
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < n; ++i) {
            //手上持有股票又分为两种情况
            /*
            * 我们目前持有的这一支股票可以是在第 i-1(昨天)天就已经持有的，对应的状态为 f[i-1][0]
            * 或者是第 i天（今天）买入的，那么第 i-1天就不能持有股票并且不处于冷冻期中，对应的状态为 f[i−1][2]
            * 加上买入股票的负收益 prices[i]。
       * */

            //为什么不能是dp[i-1][1]-prices因为这时候已经是冷冻期了，说明刚卖出，
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            System.out.println(i+"0"+dp[i][0]);

            /*
            *
            * 对于 f[i][1]f[i][1]，我们在第 ii 天结束之后处于冷冻期的原因是在当天卖出了股票，那么说明在第 i-1i−1 天时我们必须持有一支股票，
            * 对应的状态为 f[i-1][0]f[i−1][0] 加上卖出股票的正收益 {\it prices}[i]prices[i]。因此状态转移方程为
            * */
            dp[i][1] = dp[i - 1][0] + prices[i];
            System.out.println(i+"1"+dp[i][1]);

            /*
            * 对于 f[i][2]f[i][2]，我们在第 ii 天结束之后不持有任何股票并且不处于冷冻期，
            * 说明当天没有进行任何操作，即第 i-1i−1 天时不持有任何股票：如果处于冷冻期，
            * 对应的状态为 f[i-1][1]f[i−1][1]；如果不处于冷冻期，对应的状态为 f[i-1][2]f[i−1][2]。因此状态转移方程为
            * */
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            System.out.println(i+"2"+dp[i][2]);
        }
        return Math.max(dp[n-1][1],dp[n-1][2]);




    }

    //纪念第一个自己写出来的比较复杂的动态规划问题
    public int maxProfit2(int[] prices) {
        int n=prices.length;
        if (n<=1) return 0;
        int[][] dp=new int[n][5];


        // 1买入状态   2 卖出状态  3冷却期状态  4未持有但非冷却期状态  5持有但无操作状态
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        dp[0][2]=0;
        dp[0][3]=0;
        dp[0][4]=-prices[0];

        for (int i=1;i<prices.length;i++){
            //0:买入状态 那么需要未持有和冷却期中选一个然后减去当前价格
            dp[i][0]=Math.max(dp[i-1][2]-prices[i],dp[i-1][3]-prices[i]);

            System.out.println(i+"0="+dp[i][0]);
            //1：卖出状态 从买入状态和持有但无操作状态选一个 加上当前价格
            dp[i][1]=Math.max(dp[i-1][0]+prices[i],dp[i-1][4]+prices[i]);
            System.out.println(i+"1="+dp[i][1]);
            //2：冷却期状态 前面肯定是卖出状态
            dp[i][2]=dp[i-1][1];
            System.out.println(i+"2="+dp[i][2]);
            //3：未持有非冷却期状态 从冷却状态和未持有非冷却状态选一个
            dp[i][3]=Math.max(dp[i-1][2],dp[i-1][3]);
            System.out.println(i+"3="+dp[i][3]);
            //4：持有但无任何操作状态 从买入状态和持有但未操作状态中选一个
            dp[i][4]=Math.max(dp[i-1][0],dp[i-1][4]);
            System.out.println(i+"4="+dp[i][4]);

        }
        //返回最大值
        return Math.max(dp[n-1][1],Math.max(dp[n-1][2],Math.max(dp[n-1][3],dp[n-1][4])));

    }

    public static void main(String[] args) {

        Problem309 p=new Problem309();
        p.maxProfit2(new int[]{3,3});
    }
}

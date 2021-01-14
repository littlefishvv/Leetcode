package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/9 16:40
 * @description：
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 *  
 *
 * 示例 1：
 *
 =* 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @modified By：
 * @version: $
 */
public class Problem322 {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        if(n<=0) return -1;
        int[] dp=new int[amount+1];
        int max=amount+1;
        Arrays.fill(dp,max);
        if (coins[0]<=amount){
            dp[coins[0]]=1;
        }

        for (int i=0;i<n;i++){
            for(int j=amount;j>=0;j--){
                if(coins[i]==j){
                    dp[j]=1;
                }
                if(coins[i]<j){
                    dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
                }
            }

        }
        return dp[amount];

    }
    List<Integer> res;
    public int coinChange1(int[] coins, int amount) {
        int n = coins.length;
        if (n <= 0) return -1;
        if(amount==0) return 0;
        if(amount<0) return -1;
        int[][] dp=new int[n][amount+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],amount+1);
        }


        for (int j=0;j<=amount;j++){
            for (int k = 0; k * coins[0] <= j; k++){
                if (k*coins[0]==j) {
                    dp[0][j]=k;
                    System.out.println("j"+j+" "+dp[0][j]);
                }

            }
        }




        for (int i=1;i<n;i++){
            for (int j=0;j<=amount;j++){
                for (int k = 0; k * coins[i] <= j; k++){
                    if (k*coins[i]==j) dp[i][j]=k;
                    else if (k*coins[i]<j){
                        dp[i][j]=Math.min(dp[i][j],Math.min(dp[i-1][j],dp[i-1][j-k*coins[i]]+k));
                    }
                    System.out.println("i j"+i+" "+j+" ="+dp[i][j]);
                }



            }
        }
        return dp[n-1][amount]==amount+1?-1:dp[n-1][amount];
        /*res=new ArrayList<>();
        res.add(amount+1);
        int n = coins.length;
        if (n <= 0) return -1;
        if(amount==0) return 0;
        if(amount<0) return -1;
        backTrack(coins,amount,0,0);
        return res.get(0);
*/
    }
    public void backTrack(int[] coins,int amount,int index,int count){
        System.out.println("刚进入的amout:"+amount);
        //System.out.println("刚进入的i: "+index);
        System.out.println("刚进入的count:"+(count));

        if(amount==0) {
            System.out.println("-----------------加入count:"+count);
          //  System.out.println("index"+index);
            System.out.println();
            if(count<=res.get(0)){

                res.remove(0);
                res.add(count);
            }
            return;
        }
        if (amount<0) return;

        for (int i=index;i<coins.length;i++){
            if (coins[i]<=amount){
         //       System.out.println("amout:"+amount);
        //        System.out.println("i: "+i);
                System.out.println("amount-coins[i]: "+(amount-coins[i])+"  count+1:"+(count+1));
                backTrack(coins,amount-coins[i],i,count+1);
                System.out.println("返回后的amout:"+amount);
       //         System.out.println("返回后的i: "+i);
                System.out.println("返回后的count:"+(count));
            }else{
                continue;
            }


        }
        System.out.println("退出的amout:"+amount);
       // System.out.println("退出的i: "+index);
        System.out.println("退出的count:"+(count));

    }

    public static void main(String[] args) {
        Problem322 p=new Problem322();
        System.out.println("res"+p.coinChange1(new int[]{2,5,10,1},27));;
    }


}
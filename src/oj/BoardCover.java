package oj;

import java.util.Arrays;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/3/2 21:46
 * @description：
 * @modified By：
 * @version: $
 */
//OJ题目宠物屋涂色
public class BoardCover {
    //思路，n个工人把数组分为n段，求这些n段段和的最大值的最小值

    public static int getMaxBoard(int[] arr,int k){
        int n=arr.length;
        //dp[x][y]代表前x段分给y个人能取得的段最大值
        int[][] dp=new int[n+1][k+1];
        //赋予初值，
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        //计算前缀和
        int[] sum=new int[n+1];
        for(int i=1;i<=n;i++){
            sum[i]=sum[i-1]+arr[i-1];
        }

        //
        for(int i=1;i<=n;i++){
            for(int j=1;j<=Math.min(i,k);j++){
                //当只有一个人时，dp[i][j]就是前缀和
                if(j==1){
                    dp[i][j]=sum[i];
                }else{
                    //最大分割不能超过墙壁个数 把分割i分变成了分割i-1份（最大值为dp[t][j-1]）和剩余的sum[i]-sum[t]这一份，计算两个的较大值，然后记录这些值的较小值
                    for(int t=0;t<=i-1;t++){
                        dp[i][j]=Math.min(dp[i][j],Math.max(dp[t][j-1],sum[i]-sum[t]));
                    }
                }
            }
        }
        return dp[n][k];

    }

    public static void main(String[] args) {
        System.out.println(getMaxBoard(new int[]{10,10,10,10},2));
    }


}

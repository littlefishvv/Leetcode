package oj;

import java.util.Arrays;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/2/26 21:04
 * @description：
 * @modified By：
 * @version: $
 */
public class PartiBook {
   // 给定一个数组，和一个值k，数组分成k段。要求这k段子段和最大值最小。求出这个值。

    //题意理解
    //有N本书，每本书有P页，要分给M个学生，在所有分法中每个页数的最大值，再在这些最大值里面选最小值,每个同学只能被分连续的书。
    //此题可以想象成把数据按顺序装入桶中，M即是给定的桶数（这些桶的容量是相同的），问桶的容量至少应该为多少才能恰好把这些数装入M个桶中（按顺序装的）。
   //m本书，分给n个同学
    public static int partiBook(int[] pages,int bookCount,int studentCount){
        //考虑用动态规划解决
        //dp[m][n]代表m本书分给n个人所有分法能得到的最大值中的最小值。
        if(studentCount>bookCount){
            return 0;
        }
        Arrays.sort(pages);
        int h=pages[0];
        int l=pages[0];
        //初始化l为最大页数，h为页数之和 t 即桶的容量首先不能小于书页数的最大值，但最大容量也就是所有页数之和
        for(int i=1;i<bookCount;i++){
            l=Math.max(l,pages[i]);
            h+=pages[i];
        }
        while(l<h){
            //二分法计算桶容量
            int bucketSize=l+(h-l)/2;
            int bucketCount=getBucketCount(pages,bucketSize);
            //如果在当前bucketSize下得到的桶的数量比学生多，那么就说明桶容量太少了 就试着让桶容量加1 如果在当前bucketSize下得到的桶的数量等于学生数量，说明桶现在是刚刚好，但是依然有可能是大容量
            //故取容量的左半部分。如果如果在当前bucketSize下得到的桶的数量小于学生数量，那么说明桶容量过大，则缩小桶容量，直到l=h此时桶数量等于学生数量且刚好是最小的容量。
            /*
            * 如果计算需要的桶数量小于等于k，说明桶容量可能大了（也可能正好是要找的最小桶容量），不管怎样，该桶容量之后的桶容量肯定不用考虑了（肯定大于最小桶容量），这样再次缩小查找的范围，继续循环直到终止，终止时，当前的桶容量既是最小的桶容量。*/

            //有一个问题是为什么最小值等于页数相加而不是ii
           if(bucketCount>studentCount){
                l=bucketSize+1;
            }else{
                h=bucketSize;
            }
        }
        return l;


    }
    public static int partiBook(int[] nums,int k){
        int n=nums.length;
        //dp[m][n]代表前m个数分成n份能得到的最大分法的最小值
        //初始化dp[m][1]=sum[m]即分成一份就是前缀和
        int[] sum=new int[n+1];
        int[][] dp=new int[n+1][k+1];
        for(int i=1;i<=n;i++){
            sum[i]=sum[i-1]+nums[i];

        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=Math.min(i,k);j++){
                //状态转移方程dp[i][j]=Math.min(dp[i][j],Math.max(dp[i-k][j-1],sum[i]-sum[k]))
                if(j==1){
                    dp[i][j]=sum[i];
                }else{
                    for(int d=1;d<i;d++){
                        dp[i][j]=Math.min(dp[i][j],Math.max(dp[k][j-1],sum[i]-sum[k]));
                    }
                }

            }
        }
        return dp[n][k];


    }
    //在当前size下，能装完pages至少需要多少桶
    private static int getBucketCount(int[] pages,int bucketSize){

        int bucketCount=1;
        int crrSize=0;
        for(int i=0;i<pages.length;i++){

            crrSize+=pages[i];
            //当超过桶容量时，就让桶加一，并更新当前容量
            if(crrSize>bucketSize){
                crrSize=pages[i];
                ++bucketCount;
            }
        }
        return bucketCount;
    }

}

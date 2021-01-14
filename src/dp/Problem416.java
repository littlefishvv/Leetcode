package dp;

import java.util.Arrays;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/9 15:26
 * @description：
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *  
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem416 {

    //这一题可以看作是一个01背包问题 可以转化为，是否能找到这些物品，使得他们的和等于sum/2

    //用回溯也是可以判断的，但是会超时
    int count=0;
    public boolean canPartition(int[] nums) {
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        //如果是奇数，那么一定不满足条件
        if (sum%2!=0) return false;

        //使用回溯判断一些
        tryPartition(nums,0,sum/2);
        return count!=0;



    }
    public void tryPartition(int[] nums,int index,int sum){
        if (sum<0||index>=nums.length){
            return ;
        }
        if (sum==0){
            if (index<nums.length){

               count++;
               return;
            }
        }
        for (int i=index;i<nums.length;i++){
            tryPartition(nums,i+1,sum-nums[i]);
        }

    }


    //判断数组中某个组和是否能等于某个值是一个01背包问题
    /*
    * 传统的「0-10−1 背包问题」要求选取的物品的重量之和不能超过背包的总容量，这道题则要求选取的数字的和恰好等于整个数组的元素和的一半
    * */
    public boolean canPartition1(int[] nums) {
        int n=nums.length;

        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        if (sum%2!=0) return false;
        //dp[i][c]表示使用索引[0...i]的这些元素，是否可以完全填充一个容量为c的背包。
        //-1表示未计算，0表示不可以填充，1表示可以填充

        //


        //优化空间解法

        boolean[] dp=new boolean[sum/2+1];
        if(nums[0]<=sum/2){
            dp[nums[0]]=true;
        }
        //优化只能优化空间复杂度不能优化时间复杂度
        //注意这里只能从i=1开始，如果从i=0开始会报错 因为我们已经给第一行附过值了，
        for (int i = 1; i < n; i++) {
            for(int j=sum/2;j>=0;j--){
                if(nums[i]==j){
                    dp[j]=true;

                }else if(nums[i]<j){
                    dp[j]=dp[j]||dp[j-nums[i]];
                }
            }
        }




/*
        for (int i=1;i<n;i++){
            for(int j=0;j<=sum/2;j++){
                if (nums[i]==j) dp[i][j]=true;
                else if (nums[i]<j){

                    //判断第i个需不需要加进去，如果不加，那就判断0-i-1是否有组合放进去了，如果加进去，那就看前i-1组合组成j-nums[i]的情况
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i]];
                }

            }
        }*/
        return dp[sum/2];

    }

    public static void main(String[] args) {
        Problem416 p=new Problem416();
        System.out.println( p.canPartition(new int[]{1,2,5}));
    }

}

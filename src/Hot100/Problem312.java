package Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/24 15:50
 * @description：
 * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 *
 * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
 *
 * 求所能获得硬币的最大数量。
 *
 *  
 *
 * 示例 1：
 * 输入：nums = [3,1,5,8]
 * 输出：167
 * 解释：
 * nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
 * coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
 * 示例 2：
 *
 * 输入：nums = [1,5]
 * 输出：10
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem312 {
    //动态规划题目
    //如果用回溯怎么写
    public int maxCoins(int[] nums) {
        int len=nums.length;
        int[] newNums = new int[len + 2];
        newNums[0] = 1;
        System.arraycopy(nums, 0, newNums, 1, len);
        newNums[len + 1] = 1;
        int n=len+2;
        int[][] dp=new int[n][n];
        for (int i=len-1;i>=0;i--){
            for (int j=i+2;j<=len+1;j++){
                for (int k=i+1;k<j;k++){
                    dp[i][j]=Math.max(dp[i][j],(dp[i][k] + dp[k][j] + newNums[i] * newNums[k] * newNums[j]));
                }
            }
        }
        return dp[0][len+1];




    }
    private void backTrack(int[] nums, List<Integer> r ,boolean[] t, List<Integer> list){
        if (list.size()==nums.length-2){

            return ;
        }


    }

    public static void main(String[] args) {
        Problem312 p=new Problem312();
        p.maxCoins(new int[]{3,1,5,8});
    }

}

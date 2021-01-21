package Hot100;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/15 14:56
 * @description：
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem152 {
    //imax表示以当前节点为终结节点的最大连续子序列乘积 imin表示以当前节点为终结节点的最小连续子序列乘积
    public int maxProduct(int[] nums) {

        //这一题必须把当前的最大值和最小值都记录下来，因为当前的最大最小值都可以影响后一个的最大值和最小值。
        // dp[i][0]：以 nums[i] 结尾的连续子数组的最小值
        // dp[i][1]：以 nums[i] 结尾的连续子数组的最大值

        int len=nums.length;
        if (len==0){
            return 0;
        }
        int[][] dp=new int[len][2];
        dp[0][0]=nums[0];
        dp[0][1]=nums[0];


        //而且如果dp得到的最大值或最小值还不如nums[i]自身大或者小，那么就从nums[i]自身开始另起炉灶
        for (int i = 1; i < len; i++) {
            if(nums[i]>=0){
                dp[i][0]=Math.min(nums[i],nums[i]*dp[i-1][0]);
                dp[i][1]=Math.max(nums[i],nums[i]*dp[i-1][1]);
            }else {
            //如果nums是负数，那么负数乘以最小值就是最大值，乘以最大值就是最小值。
            dp[i][0] = Math.min(nums[i], nums[i] * dp[i - 1][1]);
            dp[i][1] = Math.max(nums[i], nums[i] * dp[i - 1][0]);
        }


        }

        // 只关心最大值，需要遍历
        int res = dp[0][1];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, dp[i][1]);
        }
        return res;
    }

    /*int sum=0;
        for (int num:nums){
            if (sum>0)
                sum+=num;
            else
                //重新确认序列首相为当前元素 从而会继续更新sum
                sum=num;

            res=Math.max(res,sum);
        }
    *
    * */



}

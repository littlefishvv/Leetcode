package Hot100;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/15 15:28
 * @description：
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem53 {
    public int maxSubArray(int[] nums) {
        int res=nums[0];
        // 假设sum<=0，那么后面的子序列肯定不包含目前的子序列，所以令sum = num；
        // 如果sum > 0那么对于后面的子序列是有好处的，所有sum要把当前的num加上。res = Math.max(res, sum)保证可以找到最大的子序和
        /*
        * 对于含有正数的序列而言,最大子序列肯定是正数,所以头尾肯定都是正数.我们可以从第一个正数开始算起,每往后加一个数便更新一次和的最大值;
        * 当当前和成为负数时,则表明此前序列无法为后面提供最大子序列和,因此必须重新确定序列首项.
        * */
        int sum=0;
        for (int num:nums){
            if (sum>0)
                sum+=num;
            else
                //重新确认序列首相为当前元素 从而会继续更新sum
                sum=num;

            res=Math.max(res,sum);
        }

        return res;

    }
}

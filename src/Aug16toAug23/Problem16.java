package Aug16toAug23;

import java.util.Arrays;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/8/20 14:42
 * @description：给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/3sum-closest 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem16 {
    //这个题可以说是滑动窗口+双指针   这样可以把时间复杂度由三次方降到二次方
    public int threeSunClosest(int[] nums,int target){
        Arrays.sort(nums);
        int ans=nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length-2; i++) {
            //开始滑动窗口
            int start=i+1,end=nums.length-1;
            //这个while循环可以确定一趟以i开头的三个数的最接近target
            while(start<end){
                int sum=nums[start]+nums[end]+nums[i];
                if (Math.abs(target-sum)<Math.abs(target-ans)){
                    ans=sum;
                }
                if (sum>target) end--;
                else if (sum<target) start++;
                else return ans;
            }
        }
        return ans;
    }

}

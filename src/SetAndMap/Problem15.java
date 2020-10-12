package SetAndMap;

import java.util.*;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/10/11 15:06
 * @description：
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem15 {
    //答案不可以包含重复的list。
    //这一题的首先思路是通过map。让三重循环变为2重循环，在循环过程中判断map是否含有0-nums[i]-nums[i1]但这样做的问题很大，因为涉及到了不能重复的问题
    //这一题既然没有考虑下标，那么要有意让nums排序  然后用双指针来做。
    public List<List<Integer>> threeSum(int[] nums) {
       List<List<Integer>> ans=new ArrayList<>();
       int len=nums.length;
       if(nums==null||len<3) return ans;
       Arrays.sort(nums);
       //每次寻找以i开头的三个数串。而且是一次性找完
       for (int i = 0; i < len; i++) {
            //如果最前面那个数字大于0 那么一定三数之和大于0
            if (nums[i]>0) break;
            //去重  比如[-1,-1,0,1,2]  -1,0,1是一个，-1，-1，2是一个  如果不进行判断 那么当起始为第二个-1时，会再重复一遍-1,0,1  因为第一个-1已经把以-1为开头的满足串都判断完了
            if (i>0&&nums[i]==nums[i-1]) continue;
            int L=i+1;
            int R=len-1;
            while(L<R){
                int sum=nums[i]+nums[L]+nums[R];
                //当一组为0时，要左右指针向中间移动寻找下一组
                if (sum==0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    //去重
                    while(L<R&&nums[L]==nums[L+1]){
                        L++;
                    }
                    //去重
                    while(L<R&&nums[L]==nums[R-1]){
                        R--;
                    }
                    L++;
                    R--;

                }
                else if(sum<0) L++;
                else if (sum>0) R--;
            }
       }




        return ans;
    }

}

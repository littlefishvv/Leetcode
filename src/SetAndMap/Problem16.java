package SetAndMap;


import java.util.Arrays;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/10/11 15:14
 * @description：
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 * @modified By：
 * @version: $
 */
public class Problem16 {
    public int threeSumClosest(int[] nums, int target) {
        //先排序
        Arrays.sort(nums);
        //计算每一个i开头的所能组合的最接近target的数

        int res=nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length; i++) {
            int l=i+1,r=nums.length-1;

            while(l<r){
                int v=nums[i]+nums[l]+nums[r];
                //找最接近的那个res
                if (Math.abs(v-target)<Math.abs(res-target)) res=v;
                if(v>target){
                    r--;
                }else if (v<target){
                    l++;
                }else{
                    return target;
                }
            }

        }
        return res;

    }
}

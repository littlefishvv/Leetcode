package Hot100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/22 18:38
 * @description：
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 *  
 *
 * 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 *
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem128 {

    //用sort，但是这样排序要消耗大于On的时间复杂度，
    public int longestConsecutive(int[] nums) {
        int res=1;
        int len=0;
        int n=nums.length;
        if(n<=1){
            return n;
        }
        Arrays.sort(nums);
        for (int i = 1; i < n; i++) {
            if (nums[i]==nums[i-1]+1){
                res++;
            }else if (nums[i]==nums[i-1]){
                continue;
            }
            else{
                len=Math.max(len,res);
                res=1;
            }
        }
        //如果res一直加到最后则不会更len，所以需要再判断一次。
        return len<res?res:len;

    }

    //但是题目要求是o(n)的空间复杂度，有一个思路就是，如果不能用滑动窗口和动态规划，这么低的时间复杂度只能用空间复杂度来换了
    public int longestConsecutive1(int[] nums) {
        //其实我们用set把这些去重之后，就可以通过set中是否右有按顺序的值来进行无需排序的判断序列，
        //对于每一个元素，我们看它是否有下一个元素，对于匹配的过程，暴力的方法是 O(n)O(n) 遍历数组去看是否存在这个数，
        // 但其实更高效的方法是用一个哈希表存储数组中的数，这样查看一个数是否存在即能优化至 O(1)O(1) 的时间复杂度。

        Set<Integer> numset=new HashSet<Integer>();
        //最长连续序列的长度和重复元素没有关系
        for (int num:nums){
            numset.add(num);
        }
        int longest=0;
        for (int num:numset){
            //只有是连续序列的第一个元素时才进行最长连续序列的判断
            if (!numset.contains(num-1)){
                int curNum=num;
                int curLong=1;

                //判断set中是否有连续序列
                while(numset.contains(curNum+1)){
                    curNum=curNum+1;
                    curLong=curLong+1;
                }

                //更新最长序列
                longest=Math.max(longest,curLong);
            }
        }
        return longest;


    }
}

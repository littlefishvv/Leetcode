package SetAndMap;

import java.util.HashMap;
import java.util.Map;


/*
*
* 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。

 

示例 1:

输入: nums = [1,2,3,1], k = 3
输出: true

* */
public class Problem219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }else{
                if(i-map.get(nums[i])<=k){
                    return true;
                }else{
                    //如果是重复元素，但不满足小于k，要在map中更新下标
                    map.put(nums[i],i);
                }
            }
        }
        return false;

    }
}

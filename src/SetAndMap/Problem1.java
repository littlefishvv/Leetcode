package SetAndMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/9/23 17:48
 * @description：
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *  
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem1 {
    //相比于209题。这一题不涉及连续数组，所以不能滑动窗口来解决
    //方法1 暴力法
    /*public int[] twoSum(int[] nums,int target){
       //这里的nums不能直接排序，因为我们要返回的是下标，如果排序了下标顺序就改变了  所以当返回的数据是下标而不是元素时，就不好用数组排序了
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            int temp=target;
            int n=temp-nums[i];
            //对右边的数据进行二分查找
            int res=binarySearch(nums,i+1,nums.length-1,n);
            if (res>=0){
                return new int[]{i,res};
            }
        }
        return null;
    }
    int binarySearch(int[] arr,int l,int r,int target){

        //我们在循环中明确了一个循环不变量，也就是说，虽然l和r在变
        //但是我们待寻找的target在l和r的闭区间中是不变的  [l,r]
        //一但我们明确了上面的意义，那这里l=r也是有意义的
        while(l <= r){
            int mid=(l+r)/2;
            if (arr[mid]==target){
                return mid;
            }
            if (target>arr[mid]){
                l=mid+1;
            }else{
                r=mid-1;
            }

        }
        return -1;
    }*/

    //用map，空间换时间。
    public int[] twoSum(int[] nums,int target){
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement=target-nums[i];
            if (map.containsKey(complement)&&map.get(complement)!=i){
                return new int[]{i,map.get(complement)};
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Problem1 problem1=new Problem1();
        //int[] temp=problem1.twoSum(new int[]{3,2,4},6);
    }

}

package JianZhiOffer;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/31 15:49
 * @description：
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *  
 *
 * 限制：
 *
 * 2 <= n <= 100000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Offer03 {
    /*  public int findRepeatNumber(int[] nums) {
        Set<Integer> set=new HashSet();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return nums[i];
            }else{
                set.add(nums[i]);
            }
        }
        return -1;

    }
    //上面这种方法开辟了n个空间 这种方法则用了lgn的时间复杂度
    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        //首先第一个肯定不是重复的元素
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                return nums[i];
            }

        }
        return -1;


    }*/
    public int findRepeatNumber1(int[] nums) {
        //明确一点就是nums中的所有数据都是小于len的。

        for(int i=0;i<nums.length;i++){
            //这里为什么要用while而不是if？？因为这个循环的意思是我尽量去找到符合nums[i]=i的坑位，如果不符合我必须继续再找，在找的过程中会发现nums[i]==nums[nums[i]] 就要返回。
            //while循环时，看似是给当前这个坑找萝卜，其实是给每一个经过这个坑的萝卜找坑！每次交换都会往nums[nums[i]]这个位置放入一定是正确的元素。那么一直循环下去，如果有重复的数子，就会得到等于的条件 。如果满足nums[i]=i呢就说明它在合适的位置，就往下继续找。

            while (nums[i]!=i){
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                int temp=nums[i];
                nums[i]=nums[temp];
                nums[temp]=temp;
            }
        }

        return -1;

}
    //上面那种解法虽然很秒，但是改变了数组中的元素，下面这种解法，不需要改变数组元素，且不需要开辟新的空间
    public int findRepeatNumber(int[] nums) {
        int min=0;
        int max=nums.length-1;
        while(min<max){
            //取中值
            int mid=(max+min)>>1;
            int count=countRange(nums,min,mid);
            if(count>mid-min+1){
                max=mid;
            }else{
                min=mid+1;
            }
        }
        return min;
    }
    private int countRange(int[] nums,int min,int max){
        int count=0;
        for(int num:nums){
            if(num>=min&&num<=max){
                count++;
            }
        }
        return count;
    }
}

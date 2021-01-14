package Hot100;

import java.util.Arrays;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/13 10:03
 * @description：
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 *
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * 示例 4：
 *
 * 输入：nums = [1]
 * 输出：[1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem31 {

    /*
    *
    * 从后向前查找第一个相邻升序的元素对 (i,j)，满足 A[i] < A[j]。此时 [j,end) 必然是降序
在 [j,end) 从后向前查找第一个满足 A[i] < A[k] 的 k。A[i]、A[k] 分别就是上文所说的「小数」、「大数」
将 A[i] 与 A[k] 交换
可以断定这时 [j,end) 必然是降序，逆置 [j,end)，使其升序
如果在步骤 1 找不到符合的相邻元素对，说明当前 [begin,end) 为一个降序顺序，则直接跳到步骤 4

作者：imageslr
链接：https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n < 2) return ; //特判
        int min = n-1; //较大值中的最小值的下标初始化为n-1
        boolean flag = false; //用于判断是不是递减序列
        for (int i = n -1; i >0 ; i--) {
            if (nums[i] > nums[i-1]) { //从后往前遍历，遇到更小数就开始下一步比如13742只有到了37那里才会进行下面的操作 i就是7的下标，i-1就是3的下标
                while (nums[i-1]>=nums[min]){//while循环用于找到较大数中的最小数所在的索引min 比如在13742中就是找到4所在的那个索引
                    min--;
                }
                change(nums,i-1,min);//先交换，交换之后索引大于i-1的元素一定是降序的（因为min后面的一定比min要小，而min后面的也是降序的）。
                //上面变成了14732 那么732要变成升序的237也就是要反转 7对应的下标为。
                reverse(nums,i);//再反转（从i开始）
                flag = true;//有交换就不是递减数组
                break;
            }
        }
        if (!flag) Arrays.sort(nums); //flag没变说明是递减数组，那就递增排nums
    }
    //交换位置i和j的值
    public void change(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    //反转nums中start位置到最后部分
    //这里学到一个反转数组的操作。
    public void reverse(int[] nums, int start){
        int n = nums.length;
        int end = n-1;
        while (end > start){
            change(nums,start,end);
            end--;start++;
        }
    }
}

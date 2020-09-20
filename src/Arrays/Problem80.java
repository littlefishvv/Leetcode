package Arrays;

public class Problem80 {
    /*给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

示例 1:

给定 nums = [1,1,1,2,2,3],

函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。

你不需要考虑数组中超出新长度后面的元素。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
    public int removeDuplication(int[] nums){
        if (nums.length<=0) return nums.length;
        int index=2;
        for(int i=2;i<nums.length;i++){
            //有了前面的思路，我们可以知道这里的index就是要返回的长度，也就是满足条件的个数，同时因为i
            //一直在动，我们可以动态的更新nums[index]而不用管i是多少
            //而且，所有的题目都是在更新index（j）而不是更新i
            if(nums[i]!=nums[index-2]){
                //相当于重新构造这个数组，i就是不断往后读寻找可以加入的新元素，index就是元素加入的位置，判断如果nums[i]不和index前2个元素重复，这样就
                //构不成三个连续的串，那么，我们就把这个i对应的元素加到index这个位置。然后让index指向下一个位置  刚好这就是长度，
                nums[index]=nums[i];
                index++;
            }
        }
        return index;
    }
}

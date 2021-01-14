package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/11 17:05
 * @description：
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 *
 * 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 *
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 *
 * 示例 1:
 *
 * 输入: [1,7,4,9,2,5]
 * 输出: 6
 * 解释: 整个序列均为摆动序列。
 * 示例 2:
 *
 * 输入: [1,17,5,10,13,15,10,5,16,8]
 * 输出: 7
 * 解释: 这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]。
 * 示例 3:
 *
 * 输入: [1,2,3,4,5,6,7,8,9]
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wiggle-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem376 {
    //最长摆动子序列
    public int wiggleMaxLength(int[] nums) {
        /*int n=nums.length;
        if (n<=1) return n;
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            if (nums[i]!=nums[i+1]){
                list.add(nums[i]);

            }
        }
        list.add(nums[n-1]);
        int t=list.size();
        if (t<=2) return t;

        int[] dp=new int[t];
        //只有n大于3的时候才有意义
        //dp[i]为选择当前为摆动序列的最后一个元素时能构成的长度 那么只需要考虑最后三个元素就好了
        //但是要先去掉连续的重复，否则，相乘为负就更新就不是重复必要条件了 因为我们要对三个不同的元素进行操作
        dp[0]=1;
        dp[1]=2;
        for(int i=2;i<t;i++){
            if ((list.get(i)-list.get(i-1))*(list.get(i-1)-list.get(i-2))<0){
                dp[i] =dp[i-1]+1;
            }else{
                dp[i]=dp[i-1];
            }
            System.out.println("i"+i+" :"+dp[i]);
        }
        return dp[t-1];*/
        //下面用一种不破坏数据元素的写法。
        //down和up表示最后两个是在增还是在减
        int down = 1, up = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                up = down + 1;
            else if (nums[i] < nums[i - 1])
                down = up + 1;
        }
        return nums.length == 0 ? 0 : Math.max(down, up);


    }

    public static void main(String[] args) {
        Problem376 p=new Problem376();
        p.wiggleMaxLength(new int[]{3,3,3,2,5});

    }
}

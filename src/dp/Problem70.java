package dp;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/7 16:32
 * @description：
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem70 {

    //方法1用回溯法，但是超出了时间限制。
    int count=0;
    public int climbStairs(int n) {
        backTrack(n);
        return count;

    }
    public void backTrack(int n){
        if(n<0) return;
        if (n==0){
            count++;
            return;
        }

        for (int i=1;i<=2;i++){
            backTrack(n-i);
        }

    }

    //方法2动态规划法

}

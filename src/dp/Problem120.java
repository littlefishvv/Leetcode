package dp;

import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/7 17:00
 * @description：
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 示例 2：
 *
 * 输入：triangle = [[-10]]
 * 输出：-10
 *  
 *
 * 提示：
 *
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem120 {

    //最值问题，考虑用动态规划  动态规划数组用什么，一维数组还是二维数组，每个代表什么意思，这要考虑清楚
    // 用二维数组dp[i][j]表示从三角形顶部走到位置（i,j）的最小路径和。
    //        /*
    //        * 因此要想走到位置 (i, j)(i,j)，上一步就只能在位置 (i - 1, j - 1)(i−1,j−1) 或者位置 (i - 1, j)(i−1,j)。
    //        * 我们在这两个位置中选择一个路径和较小的来进行转移，状态转移方程为：
    //f[i][j]=min(f[i−1][j−1],f[i−1][j])+c[i][j]
    // 当j=0 时，f[i-1][j-1] 没有意义，因此状态转移方程为：
    //f[i][0]=f[i−1][0]+c[i][0]
    //
    //当 j=i时，f[i-1][j]没有意义，因此状态转移方程为：
    //
    //f[i][i] = f[i-1][i-1] + c[i][i]
    //
    //即当我们在第 ii 行的最右侧时，我们只能从第 i-1 行的最右侧移动过来。因为题目中说triangle[i].length == triangle[i - 1].length + 1
    //
    //f[i][j]= f[i−1][0]+c[i][0],j=0
    //         f[i−1][i−1]+c[i][i],j=i
    //         min(f[i−1][j−1],f[i−1][j])+c[i][j],otherwise
    //
    //        * */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp=new int[n][n];
        dp[0][0]=triangle.get(0).get(0);
        for (int i=1;i<n;i++){
            //j=0 时 f[i][j]= f[i−1][0]+c[i][0]
            dp[i][0]=dp[i-1][0]+triangle.get(i).get(0);

            //      f[i][j]=min(f[i−1][j−1],f[i−1][j])+c[i][j],otherwise
            for (int j=1;j<i;j++){
                dp[i][j]=Math.min(dp[i-1][j-1],dp[i-1][j])+triangle.get(i).get(j);
            }
            // f[i][j]= f[i−1][i−1]+c[i][i],j=i
            dp[i][i]=dp[i-1][i-1]+triangle.get(i).get(i);

        }
        int min=dp[n-1][0];
        for (int i=1;i<n;i++){
            min=Math.min(min,dp[n-1][i]);
        }

        return min;

    }
}

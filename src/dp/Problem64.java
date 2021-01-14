package dp;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/7 17:02
 * @description：
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem64 {
    //涉及到最小问题，考虑用动态规划

    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                if (i==0&&j!=0) dp[i][j]=dp[i][j-1]+grid[i][j-1];
                else if (i!=0&&j==0) dp[i][j]=dp[i-1][j]+grid[i-1][j];
                else grid[i][j]=Math.min(dp[i-1][j]+grid[i-1][j],dp[i][j-1]+grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];

    }
}

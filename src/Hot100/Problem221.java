package Hot100;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/15 17:23
 * @description：
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 *
 *
 * @modified By：
 * @version: $
 */
public class Problem221 {
    //上 左 左上为true的话，或者右 下 右下全是1的话，就说明这是正方向的一个组成1
    public int maximalSquare(char[][] matrix) {
        //dp[i][j]代表以第i行第j列为右下角的正方形的最大长度 等同于点i-1 j-1对应的对打最大边长
        int m=matrix.length;
        if (m<1) return 0;
        int n=matrix[0].length;
        int max=0;
        //为避免边界溢出，就开拓 m和n+1个空间 这相当于对外边多加一层0

        int[][] dp=new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i-1][j-1]=='1'){
                    //这里的dp11就是指结点00为右下角的根结点所组成的正方向
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                    max=Math.max(max,dp[i][j]);

                }
            }
        }

        return max;




    }

}


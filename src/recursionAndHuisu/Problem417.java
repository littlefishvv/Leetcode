package recursionAndHuisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/6 11:33
 * @description：
 * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 *
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 *
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 *
 *  
 *
 * 提示：
 *
 * 输出坐标的顺序不重要
 * m 和 n 都小于150
 *  
 *
 * 示例：
 *
 *  
 *
 * 给定下面的 5x5 矩阵:
 *
 *   太平洋 ~   ~   ~   ~   ~
 *        ~  1   2   2   3  (5) *
 *        ~  3   2   3  (4) (4) *
 *        ~  2   4  (5)  3   1  *
 *        ~ (6) (7)  1   4   5  *
 *        ~ (5)  1   1   2   4  *
 *           *   *   *   *   * 大西洋
 *
 * 返回:
 *
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pacific-atlantic-water-flow
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem417 {

    /**
     建立两个矩阵Atlantic和Pacific, 当Atlantic[i][j]和Pacific[i][j]同时为true时表示该位置可以同时到达Atlantic和Pacific
     便历时的技巧为: 只需要从四个边界开始遍历即可(类似泛洪的思想, 只要可以从边界出发到达, 就说明该位置的水可以流向对应的海洋)

     也是正常的泛洪，只不过泛洪的条件是 下一个（无论哪个）要比当前值小，这样的点才会被标记。
     **/
    boolean[][] pac;
    boolean[][] atl;
    boolean[][] vis;
    int m,n;
    int[] dx={-1,1,0,0};
    int[] dy={0,0,-1,1};

    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        m=matrix.length;
        if (m<1) return res;
        n=matrix[0].length;
        pac=new boolean[m][n];
        atl=new boolean[m][n];
        List<Integer> list=new ArrayList<>();
        //对于那些从某个洋的边界出发，能够到达的点，就说明该点也能到达该海洋。
        for (int i=0;i<m;i++){
            //最左边一行  可以得出那些能流到左边的太平洋
            dfs(matrix,i,0,pac,matrix[i][0]);
            //最右边一行  可以得出那些能流到右边的大西洋
            dfs(matrix,i,n-1,atl,matrix[i][n-1]);

        }
        for (int i=0;i<n;i++){
            //最上面一行 可以得出那些能流到上面的太平洋
            dfs(matrix,0,i,pac,matrix[0][i]);
            //最下面一行 可以得出那些能流下面的大西洋
            dfs(matrix,m-1,i,atl,matrix[m-1][i]);
        }

        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j)
                if(pac[i][j] && atl[i][j])
                    res.add(new ArrayList<>(Arrays.asList(i,j)));
        }

        return res;

    }
    private void dfs(int[][] m,int x,int y,boolean[][] visit,int pre){
        if (x<0||y<0||x>=m.length||y>=m[0].length||visit[x][y]||m[x][y]<pre)
            return;
        visit[x][y]=true;
        for (int i = 0; i < 4; i++) {
            int newx=x+dx[i];
            int newy=y+dy[i];
            dfs(m,newx,newy,visit,m[x][y]);
        }


    }



}

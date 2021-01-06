package recursionAndHuisu;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/6 11:33
 * @description：
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 *  
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem200 {
    //这一题用广度优先，深度优先都能做。
    int m,n;
    int count=0;
    boolean[][] vis;
    int[] dx={-1,1,0,0};
    int[] dy={0,0,-1,1};


    public int numIslands(char[][] grid){
        m=grid.length;
        if (m<=0) return 0;
        n=grid[0].length;
        vis=new boolean[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j]=='1'&&vis[i][j]==false){
                    infect(grid,i,j);
                    count++;
                }

            }
        }
        return count;

    }



    public void infect(char[][] grid,int x,int y){
        if (x>=m||x<0||y>=n||y<0||grid[x][y]=='0'||vis[x][y]==true) return;
        vis[x][y]=true;
        for (int i=0;i<4;i++){
            int newx=x+dx[i];
            int newy=y+dy[i];
            infect(grid,newx,newy);
        }

        return;

    }


    //用广度优先做
    /*
    * public int numIslands(char[][] grid){
        int len1=grid.length;
        if(len1<=0) return 0;
        int len2=grid[0].length;
         Queue<int[]> queue=new LinkedList<>();
        int count=0;
        //这一题用广度优先的话，就不需要把所有1都加进去，因为要计算个数
        for(int i=0;i<len1;i++){
            for(int j=0;j<len2;j++){
                if(grid[i][j]=='1'){

                grid[i][j]='2';
                queue.add(new int[]{i,j});
                count++;

                while(!queue.isEmpty()){
                int[] tmp=queue.poll();
                int m=tmp[0];
                int n=tmp[1];

                int[] dx={-1,1,0,0};
                int[] dy={0,0,-1,1};
                for(int k=0;k<4;k++){
                    int newx=m+dx[k];
                    int newy=n+dy[k];
                    if(newx>=0&&newx<len1&&newy>=0&&newy<len2&&grid[newx][newy]=='1')                                     {
                        grid[newx][newy]='2';
                        queue.add(new int[]{newx,newy});
                    }
                }
                }
                }
            }
        }
        return count;
    *
    *
    * */
}

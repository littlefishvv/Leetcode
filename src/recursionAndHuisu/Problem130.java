package recursionAndHuisu;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/6 11:33
 * @description：
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 *
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surrounded-regions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem130 {
    //从边界开始找大偶进行深度有点遍历，然后标记一下已经访问过 下次再遍历时跳过这些大0
    int m,n;
    boolean[][] vis;
    boolean[][] isBj;
    int[] dx={-1,1,0,0};
    int[] dy={0,0,-1,1};
    public boolean isBj(int x,int y){
        if (x==m-1||x==0||y==n-1||y==0){
            return true;
        }
        return false;
    }
    public void solve(char[][] board){
        m=board.length;
        if (m<=0) return;
        n=board[0].length;
        vis=new boolean[m][n];
        isBj=new boolean[m][n];


        for (int i=0;i<m;i++){
            for (int j = 0; j < n; j++) {
                //标记边界大O
                if (board[i][j]=='O'&&isBj(i,j)&&vis[i][j]==false){
                    isBj(board,i,j);
                }
                //只有当不是边界时才改变
                if (board[i][j]=='O'&&vis[i][j]==false){
                    dfs(board,i,j);
                }


            }
        }





    }
    //
    public void dfs(char[][] board,int i,int j){

        //如果是边界
        if (i>=m||i<0||j>=n||j<0||board[i][j]=='X'||vis[i][j]==true) return;

        vis[i][j]=true;
        board[i][j]='X';
        for (int a=0;a<4;a++){
            int newx=i+dx[a];
            int newy=j+dy[a];
            dfs(board,newx,newy);

        }

    }
    public void isBj(char[][] board,int i,int j){
        if (i>=m||i<0||j>=n||j<0||board[i][j]=='X'||vis[i][j]==true) return;
        vis[i][j]=true;
        for (int a=0;a<4;a++){
            int newx=i+dx[a];
            int newy=j+dy[a];
            isBj(board,newx,newy);

        }

    }

    public static void main(String[] args) {

        Problem130 p=new Problem130();
        p.solve(new char[][]{{'O','O'},{'O','O'}});
    }



}

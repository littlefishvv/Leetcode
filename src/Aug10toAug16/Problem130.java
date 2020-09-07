package Aug10toAug16;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/8/11 9:11
 * @description：给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。  找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * @modified By：
 * @version: $
 */
public class Problem130 {
    //这个思路非常巧妙
    //思路，首先对 边界 （而不是内部）上的每一个‘O’做深度优先搜索，将与其相连的所有‘O’改为‘_’然后
    //遍历矩阵，将所有的‘O’（即不和边界相连的‘O’）变为‘X’，然后将整个矩阵的所有‘_’改为‘O’
    public void solve(char[][] board){
        int row=board.length;
        if(board==null||row==0) return;
        int col=board[0].length;
        //对边界进行深度优先遍历  相当于左边的竖和下边的横
        for(int i=0;i<row;i++){
            dfs(board,i,0);
            dfs(board,i,col-1);
        }
        //对边界进行深度优先遍历 相当于右边的竖和上面的横
        for (int j=0;j<col;j++){
            dfs(board,0,j);
            dfs(board,row-1,j);
        }
        //对整个矩阵进行查找改动
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (board[i][j]=='O') board[i][j]='X';
                if (board[i][j]=='_') board[i][j]='O';
            }
        }
    }

    public void dfs(char[][] board,int i,int j){
        //如果是在范围内的X直接return  如果超过了范围也直接return
       if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]!='O') return;

        board[i][j]='_';
        dfs(board,i+1,j);
        dfs(board,i-1,j);
        dfs(board,i,j+1);
        dfs(board,i,j-1);

    }
}

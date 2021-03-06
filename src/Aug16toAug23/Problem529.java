package Aug16toAug23;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/8/20 9:15
 * @description：给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
 * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
 * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
 * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
 * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
 * 输入:
 *
 * [['E', 'E', 'E', 'E', 'E'],
 *  ['E', 'E', 'M', 'E', 'E'],
 *  ['E', 'E', 'E', 'E', 'E'],
 *  ['E', 'E', 'E', 'E', 'E']]
 *
 * Click : [3,0]
 *
 * 输出:
 *
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'M', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minesweeper
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem529 {
    //方法1，广度优先，实际上如果仅仅是遍历改变值，用广度和深度都行，但深度优先的代码明显更简单。
    public char[][] updateBoard(char[][] board,int[] click){
        int a=click[0];
        int b=click[1];
        if (board[a][b]=='M'){
            board[a][b]='X';
            return board;
        }
        Queue<int[]> queue=new LinkedList<>();
        ((LinkedList<int[]>) queue).push(click);
        int row=board.length;
        int col=board[0].length;
        //这个用来标记当前位置是否已经加入队列以免重复计算
        boolean[][] bo =new boolean[row][col];
        for (int j = 0; j < row; j++) {
            for (int k = 0; k < col; k++) {
                while(!queue.isEmpty()){
                    int[] tmp=queue.poll();
                    int x=tmp[0];
                    int y=tmp[1];
                    bo[x][y]=true;
                    int[] dx={-1,1,0,0,-1,1,-1,1};
                    int[] dy={0,0,-1,1,-1,-1,1,1,};
                    int count=0;
                    for (int i = 0; i < 8; i++) {
                        int newX=x+dx[i];
                        int newY=y+dy[i];
                        //记录炸弹的数量

                        if (newX>=0&&newX<row&&newY>=0&&newY<col){
                            if (board[newX][newY]=='M'){
                                count++;
                            }
                        }


                    }
                    if (count==0) {
                        board[x][y] = 'B';
                        for (int i = 0; i < 8; i++) {
                            int newX=x+dx[i];
                            int newY=y+dy[i];

                            if (newX>=0&&newX<row&&newY>=0&&newY<col&&board[newX][newY]=='E'&&bo[newX][newY]==false){
                                queue.offer(new int[]{newX,newY});
                                bo[newX][newY]=true;
                            }


                        }

                    }
                    //如果count》0
                    else board[x][y]=(char) (count+'0');



                }


            }
        }
        return board;

    }
    //方法2 深度优先
    int[] dirX = {0, 1, 0, -1, 1, 1, -1, -1};
    int[] dirY = {1, 0, -1, 0, 1, -1, 1, -1};

    public char[][] updateBoard2(char[][] board,int[] click){
        int x=click[0],y=click[1];
        if (board[x][y]=='M'){
            board[x][y]='X';

        }
        else{
            dfs(board,x,y);
        }
        return board;
    }

    public void dfs(char[][] board,int x,int y){
        int cnt=0;
        for (int i = 0; i < 8; i++) {
            int tx = x + dirX[i];
            int ty = y + dirY[i];
            if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length) {
                continue;
            }
            if (board[tx][ty]=='M') ++cnt;


        }
        if (cnt > 0) {
            // 规则 3
            board[x][y] = (char) (cnt + '0');
        } else {
            // 规则 2
            board[x][y] = 'B';
            for (int i = 0; i < 8; ++i) {
                int tx = x + dirX[i];
                int ty = y + dirY[i];
                // 这里不需要在存在 B 的时候继续扩展，因为 B 之前被点击的时候已经被扩展过了
                if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length || board[tx][ty] != 'E') {
                    continue;
                }
                dfs(board, tx, ty);
            }
        }

    }
}

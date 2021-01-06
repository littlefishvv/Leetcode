package recursionAndHuisu;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/6 10:32
 * @description：
 *
给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。



示例:

board =
[
['A','B','C','E'],
['S','F','C','S'],
['A','D','E','E']
]

给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false
 * @modified By：
 * @version: $
 */
public class Problem79 {
    boolean[][] vis;
    int[] dx=new int[]{-1,1,0,0};
    int[] dy=new int[]{0,0,-1,1};
    //m,n代表长和宽
    int m,n;

    //从board[startx][starty]位置开始寻找word[index..word.size]这个字符串，如果能找到就返回true，否则返回false
    public boolean searchWord(char[][] board, String word,int index,int startx,int starty){

            if (index==word.length()-1){
                return board[startx][starty]==word.charAt(index);
            }
            if (board[startx][starty]==word.charAt(index)){
                vis[startx][starty]=true;
                //从startx,starty 向四个方向寻找
                for (int i=0;i<4;i++){
                    int newx=startx+dx[i];
                    int newy=starty+dy[i];
                    if (inArea(newx,newy)&&!vis[newx][newy]){
                        if (searchWord(board,word,index+1,newx,newy))
                            return true;
                    }

                }
            //当上面没有return true时，说明当前的startxy对应的坐标元素无法继续下去，那么就回溯到上面，这个就需要把状态重置，为了以后还可能用到。
            vis[startx][starty]=false;
        }


        return false;
    }
    public boolean inArea(int x,int y){
        return x>=0&&x<m&&y>=0&&y<n;

    }

    public boolean exist(char[][] board, String word) {
        m=board.length;
        if (board.length>0) n=board[0].length;
        vis=new boolean[m][n];
        //对所有元素开头都进行回溯遍历，只要有一个满足条件的就返回true
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[i].length;j++){
                if (searchWord(board,word,0,i,j))
                    return true;
            }
        }
        return false;


    }

}

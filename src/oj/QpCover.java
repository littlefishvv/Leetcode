package oj;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/3/2 19:52
 * @description：
 * @modified By：
 * @version: $
 */
//棋盘覆盖问题
/**
 * 棋盘覆盖问题
 * dr  左上角方格行号
 * dc  左上角方格列号
 * tr  特殊方格行号
 * tc  特殊方格列号
 * size  2的正整数次方
 */
public class QpCover {
    //分治法，三步骤：1.划分问题，2.递归求解 3.合并问题
    //arr是一个2^n*2^n的数组
    static int tile=1;
    static int[][] board;
    //t相同的在一个L型数组里。
    public void chessBoard(int dr, int dc, int tr, int tc, int size){
        //(x,y)为第一个奇异点
        if(size==1) return;
        //棋盘分割后的长度
        int s=size/2;
        int t=tile++;
        /*
        *
        * 左上的子棋盘若不存在特殊方格，将该子棋盘右下角的那个方格覆盖为特殊方格
右上的子棋盘若不存在特殊方格，将该子棋盘左下角的那个方格覆盖为特殊方格
左下的子棋盘若不存在特殊方格，将该子棋盘右上角的那个方格覆盖为特殊方格
右下的子棋盘若不存在特殊方格，将该子棋盘左上角的那个方格覆盖为特殊方格 至此，每个小棋盘都有一个特殊方格，然后递归调用，就可以解决问题了。

————————————————
版权声明：本文为CSDN博主「silenceyawn」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_15060345/article/details/100533974
        * */
        //如果特殊方格在左上角的小棋盘中
        if(tr<dr+s&&tc<dc+s){
            chessBoard(dr,dc,tr,tc,s);
        }else{
            //如果特殊方格不在左上角
            board[dr+s-1][dr+s-1]=t;
            chessBoard(dr,dc,dr+s-1,dc+s-1,s);
        }
        //
        // 判断特殊方格是否在右上角的小棋盘中
        if(tr<dr+s&&tc>=dc+s){
            chessBoard(dr,dc+s,tr,tc,s);

        }else{
            //如果不在
            board[dr + s - 1][dc + s] = t;
            chessBoard(dr, dc + s, dr + s - 1, dc + s, s);
        }

        //判断特殊方格是否在左下角的小棋盘中
        if(tr>=dr+s&&tc<dc+s){
            chessBoard(dr+s,dc,tr,tc,s);
        }else{
            board[dr + s][dc + s - 1] = t;
            chessBoard(dr + s, dc, dr + s, dc + s - 1, s);
        }


        //判断是否在右下角的小棋盘中
        if(tr>=dr+s&&tc>=dc+s){
            chessBoard(dr+s,dc+s,tr,tc,s);
        }else{
            board[dr+s][dc+s]=t;
            chessBoard(dr+s,dc+s,dr+s,dc+s,s);
        }



    }
}

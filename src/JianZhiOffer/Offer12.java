package JianZhiOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/8/21 11:02
 * @description：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子
 * 。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。 [["a","b","c","e"], ["s","f","c","s"], ["a","d","e","e"]]  但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @mge'ziodified By：
 * @version: $
 */
public class Offer12 {
    //深度优先+剪枝（回溯）
    //感觉这题有点难，我没有完全搞清楚
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if(k == word.length - 1) return true;
        char tmp = board[i][j];
        //其实这就是省了一个数组visited，正常情况下我们需要一个数组判断是否访问过，这里直接改了，但是如果回溯过来，后面会再改回来。
        board[i][j] = '/';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        //这是个复原的过程，为什么要复原呢，我认为是因为有很多选择，毕竟和普通的深度优先不同，这个深度优先是要进行判断的，如果判断出错，需要回去重新深度优先，而重新的过程，需要原来的数据
        board[i][j] = tmp;
        return res;
    }




}

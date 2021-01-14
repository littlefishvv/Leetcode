package tanxin;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/12 10:22
 * @description：
 *
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 进阶：
 *
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 * 致谢：
 *
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem392 {
    //这一题有很多种解法，我先按最长公共子序列的动态规划解法解一下，然后比较最长公共子序列是否和s的长度相同
    public boolean isSubsequence(String s, String t) {

        if (s == null || s.length() <= 0 ||s == null || s.length() <= 0) {
            return false;
        }

        int length1 = s.length();
        int length2 = s.length();
        int[][] dp = new int[length1 + 1][length2 + 1];

        /*
            遍历两个字符串:
                1、若 当前两个字符 相等：
                    当前状态 = 两个元素的前一个状态 + 1
                2、若 当前两个字符 不等：
                    当前状态 = 两个元素任一元素的前一个状态 的 最大值
         */
        char[] chars1 = s.toCharArray();
        char[] chars2 = s.toCharArray();
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[length1][length2]==length1;


    }

    //用双指针+贪心的算法更为简洁
    //本题询问的是，ss 是否是 tt 的子序列，因此只要能找到任意一种 ss 在 tt 中出现的方式，即可认为 ss 是 tt 的子序列。
    //
    //而当我们从前往后匹配，可以发现每次贪心地匹配靠前的字符是最优决策。
    //
    public boolean isSubsequence1(String s, String t) {
        int m = s.length(), n = t.length();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;

            }
            j++;
        }
        return i == m;

    }
}

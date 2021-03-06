package Hot100;

import java.nio.channels.CompletionHandler;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/25 11:52
 * @description：
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 *  
 * 示例 1：
 *
 * 输入：s = "aa" p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入：s = "aa" p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3：
 *
 * 输入：s = "ab" p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4：
 *
 * 输入：s = "aab" p = "c*a*b"
 * 输出：true
 * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5：
 *
 * 输入：s = "mississippi" p = "mis*is*p*."
 * 输出：false
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 20
 * 0 <= p.length <= 30
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 保证每次出现字符 * 时，前面都匹配到有效的字符
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem10 {
    public boolean isMatch(String s, String p) {
        /*

        这一题的状态转移方程如下

        * 1.如果 p.charAt(j) == s.charAt(i) : dp[i][j] = dp[i-1][j-1]；这种属于刚好匹配
        2.如果 p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1]；如果p[j]是. ，那么可以匹配任意字符，故直接等于dp[i-1][j-1]


        3.如果 p.charAt(j) == '*'：
        3.1如果 p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2] //这就相当于如果直接把b*去点，相当于匹配0个吗，故是j-2。

        3.2 如果 p.charAt(j-1) == s.charAt(i) or p.charAt(j-1) == '.'：
        //如果*的前一个字符等于s[i]那么，如果这个s[i]属于重复的字符，比如bbb 和b*,就可以判断为dp[i-1][j] 即一旦匹配，s后面再添个0也不多。
        dp[i][j] = dp[i-1][j] //in this case, a* counts as multiple a
        //如果这个*只能匹配单个的字符 比如b和b*，那么就是dp[i][j-1] 也就是把*去掉看匹配不匹配
        or dp[i][j] = dp[i][j-1] // in this case, a* counts as single a
        //如果这个*和*前面的字符对整体匹配用不到，比如a 和ab*那么就是dp[i][j-2] 相当于去掉*和它前面的字符，代表0次匹配。
        or dp[i][j] = dp[i][j-2] // in this case, a* counts as empty

        *
        * */
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;//dp[i][j] 表示 s 的前 i 个是否能被 p 的前 j 个匹配
        for (int i = 0; i < p.length(); i++) { // here's the p's length, not s's
            //dp[0][i]都是为了判断如何匹配空字符串。这里的意思就是比如a*a*a*这种，a*可以去点，故当dp[0][i-1]==true时，dp[0][i+1]也等于true
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                System.out.println(i-1);
                System.out.println(dp[0][i-1]);
                dp[0][i + 1] = true; // here's y axis should be i+1

            }
        }
        /*
        * 很奇怪为什么当i等于0时，那个i-1不会越界，下面这种写法似乎更容易理解。
        * //"" 和p的匹配关系初始化，a*a*a*a*a*这种能够匹配空串，其他的是都是false。
        //  奇数位不管什么字符都是false，偶数位为* 时则: dp[0][i] = dp[0][i - 2]
        for (int i = 2; i <= n; i+= 2) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        * */
        for (int i = 1; i < s.length(); i++) {
            for (int j = 1; j < p.length(); j++) {
                if (p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i-1)) {//如果是任意元素 或者是对于元素匹配
                    dp[i][j] = dp[i-1][j-1];
                }
                if (p.charAt(j-1) == '*') {
                    //j前面那么字符不和i匹配，且不为任意元素，那么该状态就等于没有这个a*，把前i+1个元素和前j-1个元素进行匹配
                    if (p.charAt(j - 2) != s.charAt(i-1) && p.charAt(j - 2) != '.') {//如果前一个元素不匹配 且不为任意元素
                            dp[i][j] = dp[i][j - 2];
                    } else {
                        //如果不是上面那种情况，说明有一个字符或者多个字符可以匹配 那么该状态就等于匹配单个字符dp[i][j-1]也就是把p中的*去点看是否和前面匹配dp[i + 1][j]的情况或者
                        //或者匹配前面多个字符，既然匹配多个字符了，那么把这个多字符去掉一个也能匹配，也就是dp[i][j+1] 如果不是这两种情况说明不匹配，那么就是把这个a*去掉dp[i+1][j-1]
                        dp[i][j] = (dp[i][j-1] || dp[i-1][j] || dp[i][j -2]);
                            /*
                            dp[i][j] = dp[i-1][j] // 多个字符匹配的情况
                            or dp[i][j] = dp[i][j-1] // 单个字符匹配的情况
                            or dp[i][j] = dp[i][j-2] // 没有匹配的情况
                             */

                    }
                }
            }
        }
        return dp[s.length()][p.length()];

    }

    public static void main(String[] args) {
        Problem10 p=new Problem10();

        LinkedList<Integer> list=new LinkedList<>();
        list.addFirst(1);
        System.out.println(list.removeFirst());
        list.add(2);
        list.add(3);
        System.out.println(list.peek());
    }
}


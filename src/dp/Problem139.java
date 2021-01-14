package dp;

import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/11 10:52
 * @description：
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem139 {

    //首先明确这是一个完全背包的ture false问题
    //其实从这一题可以看出，不是所有的题都可以通过一个公式严格套过去，套路是用来节省时间的，当套路走不通时，要考虑变通。
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s==null) return false;
        int n=s.length();
        boolean[] dp=new boolean[n+1];
        //因为对于一个通式来说，dp【0】=true是必要的。
        dp[0]=true;

        for (int i=1;i<=n;i++){
            for (int j=0;j<i;j++){
                //如果s的前j个字符能够由wordDict组成，那么worddict中也包含j- i-1个字符的元素，说明dp[i]也可以由worddict构成
                if (dp[j]&&wordDict.contains(s.substring(j,i))){
                    dp[i]=true;
                }
            }
        }

        return dp[n];





    }
}

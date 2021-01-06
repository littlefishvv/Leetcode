package recursionAndHuisu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/4 9:49
 * @description：
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem93 {

    /*
    * 思想还是那个思想 partition(String s)=s[0-index-1]+partition(s[index,len]) 构造出第一个，一直回溯就行了
    * */
    List<List<String>> res=new ArrayList<>();
    public List<List<String>> partition(String s) {
       List<String> list=new ArrayList<>();
       if (s!=null&&s.length()>0){
           backStr(s,0,list);
       }
       return res;

    }

    public void backStr(String s,int index, List<String> list){
        if (index==s.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        //这里的i之所以可以等于length。就是因为substring不会取右
        for(int i=index+1;i<=s.length();i++){
            String str=s.substring(index,i);
            //想一想为什么这里改成非之后，Continue再add,而不是直接为true后add就可以通过了呢？因为如果不continue，
            //会继续向下执行，就会导致无条件执行backStr,实际上，backstr是需要list add后才能执行的
            if (!isH(str)) continue;
            list.add(str);
            backStr(s,i,list);
            list.remove(list.size()-1);
        }


    }


    /*
    * 每一次都得使用“两边夹”的方式验证子串是否是回文子串。于是“用空间换时间”，利用「力扣」第 5 题：
    * 最长回文子串 的思路，利用动态规划把结果先算出来，这样就可以以 O(1)O(1) 的时间复杂度直接得到一个子串是否是回文。

         boolean[][] dp = new boolean[len][len];
        // 状态转移方程：在 s[i] == s[j] 的时候，dp[i][j] 参考 dp[i + 1][j - 1]
        for (int right = 0; right < len; right++) {
            // 注意：left <= right 取等号表示 1 个字符的时候也需要判断
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }

    * */
    boolean isH(String s){
        if (s==null||s.length()<=1) return true;
        int l=0;
        int r=s.length()-1;
        while(l<r){
            if (s.charAt(l)!=s.charAt(r))
                return false;
            l++;
            r--;

        }
        return true;

    }



    public static void main(String[] args) {
        Problem93 p=new Problem93();
        p.partition("aah");
    }
}

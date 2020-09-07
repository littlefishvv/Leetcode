package july27toAug2;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/7/27 18:43
 * @description：给定字符串 s 和 t ，判断 s 是否为 t 的子序列。  你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * @modified By：
 * @version: $
 */
public class MaxContainStr {
    //双指针法，这样，我们初始化两个指针 ii 和 jj，分别指向 ss 和 tt 的初始位置。
    // 每次贪心地匹配，匹配成功则 ii 和 jj 同时右移，匹配 ss 的下一个位置，匹配失败则 jj 右移，ii 不变，尝试用 tt 的下一个字符匹配 ss。
    //

    public boolean isSubsequence(String s, String t) {
        int m=s.length(),n=t.length();
        int i=0,j=0;
        while(i<m&&j<n){
            if(s.charAt(i)==t.charAt(j)){
                i++;

            }
            j++;
        }
        return i==m;

    }
}

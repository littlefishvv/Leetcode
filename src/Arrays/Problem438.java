package Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/9/17 14:49
 * @description：
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 *
 * 输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 输出:
 * [0, 6]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 *
 * 输入:
 * s: "abab" p: "ab"
 *
 * 输出:
 * [0, 1, 2]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem438 {
    //很明显，这一题也能用滑动窗口解决  其实当不满足条件时。r和l是一起走的
    public List<Integer> findAnagrams(String s,String p){
        //但是这一题也很绕
        char[] arrS=s.toCharArray();
        char[] arrP=s.toCharArray();
        List<Integer> ans=new ArrayList<>();
        //因为字符串中只有小写字符 那把对应的ascii码放到26种，有几个下标对应的值就是几
        int[] needs=new int[26];
        //这个用来记录滑动窗口中元素出现的次数
        int[] window=new int[26];
        for(int i=0;i<arrP.length;i++){
            needs[arrP[i]-'a']+=1;
        }
        int left=0;
        int right=0;
        //右边界不断滑动
        while (right<arrS.length){
            int curR =arrS[right]-'a';
            right++;
            window[curR]+=1;
            //这个时候代表我遇到一个目标数组中没有或者多于目标数组的元素 说明目前的字串一定不满足条件 那么左边界开始向右移动
            while (window[curR]>needs[curR]){
                int curL=arrS[left]-'a';

                window[curL]-=1;
                left++;
            }
            //子串满足条件了
            if (right-left==arrP.length){
                ans.add(left);
            }
        }

        return ans;
    }
    //我们可以牺牲一些空间，让代码更易懂一些
    public List<Integer> findAnagrams1(String s,String p){
        int[] freq=new int[128];
        int[] np=new int[128];
        int l=0,r=-1;//滑动窗口s[l...r]
        //need代表我现在有几个一样的了
        int need=0;
        List<Integer> list=new ArrayList<>();
        for (int i=0;i<p.length();i++){
            np[p.charAt(i)]++;
        }
        while(l<s.length()){
           if(r+1<s.length()&&np[s.charAt(r+1)]>0) {
               need++;
               r++;
               np[s.charAt(r)]--;
               //我们不用去考虑比如edecba这种会有bug，因为当我们加了need，加了np后，下一次的判断if肯定满足，那么会把need和np复原的。也就是说。以后再考虑
               //这类问题可以直接按右指针满足的条件去考虑，然后考虑不满足右指针（也就是else)时左指针的移动。如果需要的话要想着如何能复原。其实只要不满足右指针移动的条件，每移动一次做指针，下一次一定会移动右指针
           }else{
               np[s.charAt(l)]++;
               l++;
               need--;
           }
           if (need==p.length()){
               list.add(l);
           }

        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list=new Problem438().findAnagrams1("edabcbafe","abc");
    }



}

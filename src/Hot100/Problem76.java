package Hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/22 11:02
 * @description：
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem76 {
    //滑动窗口题目
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<Character, Integer>();
        HashMap<Character, Integer> window = new HashMap<>();
        //need保存了t中所有的字符和次数
        for (char c :  t.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);

        int left = 0, right = 0;
        int valid = 0;
        // 记录最小覆盖字串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 判断取出的字符是否在字串中
            if (need.containsKey(c)) {
                //现在需要往窗口容器中放入遍历到的字符。，
                window.put(c, window.getOrDefault(c,0) + 1);
                //如果某个字符的次数达到了，那么valid++，
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 判断是否需要收缩（已经找到合适的覆盖串）也就是说，如果依然包含那个串，就一直收缩下去（left++） 等到收缩到不满足条件了，就让right再++ 就这样一直收缩扩张
            //当valid==need.size时说明已经找到了能覆盖的字串，这时候要缩小窗口，直至不满足也就是不覆盖。
            while (valid == need.size()) {
                //更新窗口长度
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char c1 = s.charAt(left);
                left++;
                //如果在左边往右缩小的过程中遇到了t中的字符，那么就让vaild--，意义是可以让它不满足条件，从而继续右边向右扩大窗口。
                if (need.containsKey(c1)) {
                    if (window.get(c1).equals(need.get(c1))) {
                        valid--;
                    }
                    window.put(c1, window.getOrDefault(c1, 0) - 1);
                }

            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    private int getStart(String s,String t,int start){
        while(start<s.length()){
            if (t.indexOf(s.charAt(start))>=0){
                System.out.println(start);
                return start;
            }
            else{
                start++;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        Problem76 p=new Problem76();
        System.out.println(p.minWindow("a"
                ,"b"));
    }
}

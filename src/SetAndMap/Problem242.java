package SetAndMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/9/23 17:38
 * @description：
 *
 *
 * 有效的字母异位词
 *
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
 * @modified By：
 * @version: $
 */

public class Problem242 {
    //这种解法很慢
    public boolean isAnagram(String s ,String t){
        Map<Character ,Integer> map=new HashMap<>();
        if (s.length()!=t.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            //integer好像不能++？？？
            if (map.containsKey(s.charAt(i))) {
                 map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }
            else
                map.put(s.charAt(i),1);

        }
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) map.put(t.charAt(i), map.get(t.charAt(i))-1);
            else  return false;
        }
        for (Map.Entry<Character,Integer> entry:map.entrySet()){
            if (entry.getValue()!=0) return false;
        }
        return true;
    }
    //解法2 直接排序  异构字符排好序后一定是相同的
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
    //解法3  既然是字符串，而且是26个字符，我们只需要26个长度的数组就行了 代替map
    public boolean isAnagram3(String s,String t){
        if (s.length()!=t.length()) return false;
        int[] counter=new int[26];
        for (int i=0;i<s.length();i++){
            counter[s.charAt(i)-'a']++;
            counter[t.charAt(i)-'a']--;
        }
        for (int count:counter){
            if (count!=0){
                return false;
            }
        }
        return true;
    }



}

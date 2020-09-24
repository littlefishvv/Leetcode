package SetAndMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/9/23 17:41
 * @description：
 * 单词规律
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem290 {
    //这道题也是map  而且限定了字符
    public boolean wordPattern(String pattern,String s){
        String[] strings=s.split(" ");
        Map<Character,String> map=new HashMap<>();
        //这个判断别忘了
        if(pattern.length()!=strings.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            if (!map.containsKey(pattern.charAt(i))){
                if(map.containsValue(strings[i])){
                    return false;
                }
                map.put(pattern.charAt(i),strings[i]);
            }else{
                if (!map.get(pattern.charAt(i)).equals(strings[i])){
                    return false;
                }
            }
        }

        return true;
    }

}

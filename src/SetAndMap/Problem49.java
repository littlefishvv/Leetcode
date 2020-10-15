package SetAndMap;

import java.util.*;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/10/11 16:09
 * @description：
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem49 {
    public List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> lists = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            List<String> list=new ArrayList<>();
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String key=String.valueOf(ch);

            //

            if (!map.containsKey(key)) map.put(key,new ArrayList<>());
            map.get(key).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

}

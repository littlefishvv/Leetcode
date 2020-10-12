package SetAndMap;

import java.util.*;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/9/23 17:47
 * @description：
 * 根据字符出现频率降序排序（大小写敏感）
 *
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * 示例 1:
 *
 * 输入:
 * "tree"
 *
 * 输出:
 * "eert"
 *
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 *
 * 输入:
 * "cccaaa"
 *
 * 输出:
 * "cccaaa"
 *
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem451 {
    public String frequencySort(String s){
        char[] chars=s.toCharArray();
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])){
                map.put(chars[i],map.get(chars[i])+1);

            }else{
                map.put(chars[i],1);
            }
        }
        //对hashmap进行排序  降序排序   1先把map放到list中去，   2对list进行排序  3取出list，然后拼接成字符串
        List<Map.Entry<Character,Integer>> list = new LinkedList<Map.Entry<Character,Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        StringBuffer stringBuffer=new StringBuffer("");
        for (Map.Entry<Character,Integer> aa:list){
            for (Integer integer = 0; integer < aa.getValue(); integer++) {
                stringBuffer.append(aa.getKey());
            }
        }


        return String.valueOf(stringBuffer);
    }


}


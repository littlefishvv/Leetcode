package SetAndMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/9/23 17:46
 * @description：
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem205 {
    public boolean isIsomorphic(String s,String t){
        int a=0,b=0;
        Map<Character ,Character> map=new HashMap<>();
        while (a<s.length()&&b<t.length()){
            if (!map.containsKey(s.charAt(a))){
                    map.put(s.charAt(a),t.charAt(b));

                }else if (!(map.get(s.charAt(a))==t.charAt(b))){
                    return  false;
            }
            a++;
            b++;
        }
        //双向验证
        a=0;
        b=0;
        Map<Character ,Character> map1=new HashMap<>();
        while (a<s.length()&&b<t.length()){
            if (!map1.containsKey(t.charAt(a))){
                map1.put(t.charAt(a),s.charAt(b));

            }else if (!(map1.get(t.charAt(a))==s.charAt(b))){
                return  false;
            }
            a++;
            b++;
        }
        return true;
    }
    public boolean isIsomorphic2(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                //如果没有这个键，但是有这个值，说明对应关系出错了  比如说 ab   aa  不仅要键唯一，键对应的值也唯一
                if(map.containsValue(t.charAt(i)))
                {
                    return false;
                }
                //如果没有这个键也没有这个值，就把这个键值对放进去
                map.put(s.charAt(i), t.charAt(i));
            }else{
                //否则说明，已经有这个键了，但如果这个键对应的值不同，说明也是错的。
                if(map.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }
        }

        return true;
    }

}

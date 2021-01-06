package recursionAndHuisu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/3 16:47
 * @description：
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * @modified By：
 * @version: $
 */
/*
O(3的m次方*4的n次方)，其中 mm 是输入中对应 33 个字母的数字个数（包括数字 22、33、44、55、66、88），nn 是输入中对应 44 个字母的数字个数（包括数字 77、99），m+nm+n 是输入数字的总个数。当输入包含 mm 个对应 33 个字母的数字和 nn 个对应 44 个字母的数字时，不同的字母组合一共有 3^m \times 4^n3
        m
        ×4
        n
        种，需要遍历每一种字母组合。

        作者：LeetCode-Solution
        链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/dian-hua-hao-ma-de-zi-mu-zu-he-by-leetcode-solutio/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
public class Problem17 {
    Map<String,String> phone = new HashMap<String,String>();
    List<String> res = new ArrayList<>();
    //

    public List<String> letterCombinations(String digits) {
        phone.put("2", "abc");
        phone.put("3", "def");
        phone.put("4", "ghi");
        phone.put("5", "jkl");
        phone.put("6", "mno");
        phone.put("7", "pqrs");
        phone.put("8", "tuv");
        phone.put("9", "wxyz");
        if (digits.length()!=0){
            backNum(digits,0,"");
        }
        return res;
    }

    //s保存了从digits【0-index-1】所组合而成的字符串
    public void backNum(String digits,int index,String s){
        //如果组合到最后一个字符了，就加入结果集中去  记得退出回溯  之所以等于length退出，因为参数index实际上是代表当前正在组合字符下标的元素。所以要等到等于length时表示最后一个元素 已经 组合完成了
        //只有等到s==length 时才保存了0-length-1下标的所有元素
        if (index==digits.length()){
            res.add(s);
            //这里记得退出回溯
            return ;
        }
        //否则，就回溯地向下进行组合 取出index对应地数字，然后遍历数组地组合，加到s上去。
        String str=phone.get(String.valueOf(digits.charAt(index)));


        for (int i=0;i<str.length();i++){

            backNum(digits,index+1,s+str.charAt(i));

        }


    }



}

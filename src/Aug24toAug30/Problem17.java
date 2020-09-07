package Aug24toAug30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/8/26 8:43
 * @description：给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。  给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * @modified By：
 * @version: $
 */
public class Problem17 {
    //这一题不能用多重循环做，因为你根本无法控制到底有几层循环。
    Map<String,String> phone=new HashMap<String,String>(){{
        put("2","abc");
        put("3","def");
        put("4","ghi");
        put("5","jkl");
        put("6","mno");
        put("7","pqrs");
        put("8","tuv");
        put("9","wxyz");


    }

    };
    List<String> output=new ArrayList<String>();
    public void backtrack(String combination,String next_digits){

        if (next_digits.length()==0) output.add(combination);
        else{
            String digit=next_digits.substring(0,1);
            String letters=phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter=phone.get(digit).substring(i,i+1);
                backtrack(combination+letter,next_digits.substring(1));
                //这个不用撤销选择，因为一般的选择都是list，这个list是公用的，如果不撤销选择相当于直接向后加了，而这里用的是字符串，combination+letter是新字符串，没调用一次方法就变了
            }
        }
    }
    public List<String> letterCombinations(String digits){
        if (digits.length()!=0) backtrack("",digits);
        return output;
    }
}

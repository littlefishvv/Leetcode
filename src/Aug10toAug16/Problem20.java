package Aug10toAug16;

import java.util.Stack;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/8/16 10:41
 * @description：给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：  左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。 注意空字符串可被认为是有效字符串。

 * @modified By：
 * @version: $
 */
public class Problem20 {
    public boolean isVaild(String s){
        if (s.length()==0) return true;
        Stack<Character> sk=new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);

            if (c=='('||c=='{'||c=='['){
                sk.push(c);
            }
            else if (c==')'){
                if (!sk.isEmpty()&&sk.peek()=='(') sk.pop();
                else return false;
            }
            else if(c==']') {
                if (!sk.isEmpty()&&sk.peek()=='[') sk.pop();
                else return false;
            }
            else if(c=='}') {
                if (!sk.isEmpty()&&sk.peek()=='{') sk.pop();
                else return false;
            }
        }
        return true;
    }
}

package StackAndQueue;

import java.util.Stack;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/11/8 9:49
 * @description：
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem20 {
    public boolean isValid(String s) {
        if (s==null|| s.length()==0 ) return true;
        if (s.length()%2!=0) return false;
        int n=s.length();
        Stack<Character> stack=new Stack<Character>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }else if (s.charAt(i)==')'){
                if (!stack.isEmpty()&&stack.peek()=='(')
                    stack.pop();
                else
                    return false;
            }else if (s.charAt(i)=='}'){
                if (!stack.isEmpty()&&stack.peek()=='{')
                    stack.pop();
                else
                    return false;
            }else if (s.charAt(i)==']'){
                if (!stack.isEmpty()&&stack.peek()=='[')
                    stack.pop();
                else
                    return false;
            }
        }

        if (!stack.empty()) return false;
        else return true;
    }
}

package StackAndQueue;

import java.util.Stack;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/11/8 9:49
 * @description：
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

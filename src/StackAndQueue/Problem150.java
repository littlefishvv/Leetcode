package StackAndQueue;

import SetAndMap.Problem1;

import java.util.Stack;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/11/8 10:28
 * @description：
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 *  
 *
 * 说明：
 *
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *  
 *
 * 示例 1：
 *
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @modified By：
 * @version: $
 */
public class Problem150 {
    //注意，这题用==在idea中能通过，但是在leetcode中不能通过，以后字符串相等判断最好都用.equals
    public int evalRPN(String[] tokens) {
        int n=tokens.length;
        String t;
        Stack<String> stack=new Stack<String>();
        for (int i = 0; i < n; i++) {
            String s=tokens[i];
            String s1;
            String s2;

            if (s=="+"){
                s1=stack.pop();
                s2=stack.pop();
                t=String.valueOf(Integer.valueOf(s1)+Integer.valueOf(s2));
                stack.push(t);
            }else if (s=="-"){
                s1=stack.pop();
                s2=stack.pop();
                t=String.valueOf(Integer.valueOf(s2)-Integer.valueOf(s1));
                stack.push(t);
            }else if (s=="*"){
                s1=stack.pop();
                s2=stack.pop();
                t=String.valueOf(Integer.valueOf(s1)*Integer.valueOf(s2));
                stack.push(t);
            }else if (s=="/"){
                s1=stack.pop();
                s2=stack.pop();
                t=String.valueOf(Integer.valueOf(s2)/Integer.valueOf(s1));
                stack.push(t);
            }else{
                stack.push(s);
            }

        }
        return Integer.valueOf(stack.pop());

    }

    public static void main(String[] args) {
        Problem150 p=new Problem150();
        String[] tokens={"2","1","+","3","*"};
        System.out.println(p.evalRPN(tokens));

    }
}

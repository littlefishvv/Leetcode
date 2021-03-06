package Hot100;

import java.util.*;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/24 20:41
 * @description：
 *删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
 *
 * 说明: 输入可能包含了除 ( 和 ) 以外的字符。
 *
 * 示例 1:
 *
 * 输入: "()())()"
 * 输出: ["()()()", "(())()"]
 * 示例 2:
 *
 * 输入: "(a)())()"
 * 输出: ["(a)()()", "(a())()"]
 * 示例 3:
 *
 * 输入: ")("
 * 输出: [""]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-invalid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem301 {
    //这个题目应该是用回溯法来解决。
    //BFS解法
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s.equals("()") || s.equals("")) {
            result.add(s);
            return result;
        }

        Deque<String> queue = new ArrayDeque<>();
        queue.offer(s);
        HashSet<String> set = new HashSet<>();  //用于存储裁剪后的元素，防止重复元素加入队列
        boolean isFound = false;    //判断是否找到了有效字符串

        while (!queue.isEmpty()) {  //队列不为空
            String curr = queue.poll();
            //尽可能地删除最小地括号 找到后直接加进去而不再裁剪。
            if (isValid(curr)) {

                result.add(curr);
                isFound = true;
            }
            if (isFound) {  //找到后不再进行裁剪就
                continue;
            }
            //裁剪过程
            /*
            * 我们做BFS，上一层level和下一层level之间的关系为：
            * 把所有上一层level中的每个元素都拿出来，列举出在删除一个括号后的所有可能的情况。(不管删除以后是否合法），添加到下一个level中的元素。

。*/
            //尝试对当前字符串的每一个位置都进行裁剪。把裁剪后的字符串入栈，
            for (int i = 0; i < curr.length(); i++) {

                if (curr.charAt(i) == '(' || curr.charAt(i) == ')') {   //只对'('或')'进行裁剪
                    String str;
                    if (i == curr.length()-1) {
                        str = curr.substring(0, curr.length()-1);
                    } else {
                        str = curr.substring(0, i) + curr.substring(i+1);
                    }
                    //
                    if (set.add(str)) { //如果集合中还未有该字符串
                        queue.offer(str);
                    }
                }
            }
        }

        if (result.isEmpty()) {
            result.add("");
        }
        return result;
    }
    private boolean isValid(String t){
        Deque stack=new ArrayDeque();
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i)=='(') stack.addLast(t.charAt(i));
            else if (t.charAt(i)==')'){
                if (!stack.isEmpty()){
                    stack.pollLast();
                }else{
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }

    public static void main(String[] args) {
        Problem301 p=new Problem301();
        p.removeInvalidParentheses("()())()");

    }
}

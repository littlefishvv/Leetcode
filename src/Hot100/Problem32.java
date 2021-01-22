package Hot100;

import java.util.Stack;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/21 14:24
 * @description：
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 *
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 *
 * 输入：s = ""
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem32 {
    //用栈辅助判断哪些括号是不必要的，
    public int longestValidParentheses(String s) {
        if (s==null||s.length()==0) return 0;
        Stack<Integer> stack=new Stack<>();
        int[] mark=new int[s.length()];
        //下面的操作把非法括号的下标标记为1
        for (int i = 0; i < s.length(); i++) {
            //碰到左括号，让左括号入栈，
            if (s.charAt(i)=='(') stack.push(i);
            else{
                //碰到右括号，就让左括号出战进行匹配，如果栈中没有左括号，说明这是一个错误的右括号
                if (stack.isEmpty()) mark[i]=1;
                else stack.pop();
            }
        }
        //如果左括号匹配完还剩没有匹配的，说明，这些左括号是多余的，也没有用。
        while(!stack.isEmpty()){
            //stack.peek的得到的是没用的左括号的下标。
            mark[stack.peek()]=1;
            stack.pop();
        }
        //寻找标记与标记之间的最大长度
        int len=0,ans=0;
        for (int i = 0; i < s.length(); i++) {
            if (mark[i]==1){
                len=0;
                continue;
            }
            len++;
            ans=Math.max(ans,len);
        }
        return ans;

    }

}

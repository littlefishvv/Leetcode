package Hot100;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/13 16:03
 * @description：
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 *
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 *
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 *
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem394 {
    //思路:数字存放在数字栈，字符串存放在字符串栈，。就是逆波兰式那种题
    public String decodeString(String s) {
        StringBuffer ans=new StringBuffer();

        //数字栈
        Stack<Integer> multiStack=new Stack<>();
        //字符串栈 用于存储【之前的组成的字符串
        Stack<StringBuffer> ansStack=new Stack<>();
        int multi=0;
        for(char c:s.toCharArray()){
            //如果是数字，得到数字值，注意可能超过10
            if(Character.isDigit(c))multi=multi*10+c-'0';
            //如果是左括号 把【前面的字符加入占中，把前面的数字也加入占中
            else if(c=='['){
                ansStack.add(ans);
                multiStack.add(multi);

                //重置字符串和数子
                ans=new StringBuffer();
                multi=0;
            }
            //如果是字符，先进行组合，一直是字符则一直组合
            else if(Character.isAlphabetic(c)){
                ans.append(c);

            //如果是右括号 说明最近的这个字符串已经可以输出然后根据数字进行构造了 把两个栈首的元素输出构造字符串
            }else if(c==']'){
                //这是已经存在的
                StringBuffer ansTmp=ansStack.pop();
                //弹出数字栈
                int tmp=multiStack.pop();
                //根据已经存在的对新字符串进行多次组合。
                for(int i=0;i<tmp;i++)ansTmp.append(ans);
                ans=ansTmp;
            }
        }
        return ans.toString();


    }

    public static void main(String[] args) {
        Problem394 p=new Problem394();
        p.decodeString( "3[a2[c]]");
    }

}



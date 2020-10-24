package ListNode;

import java.util.Stack;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/10/21 15:50
 * @description：
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 *  
 *
 * 进阶：
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 *  
 *
 * 示例：
 *
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem445 {
    //思路1 先按problem206的思路对两个链表进行反转，然后按problem2的思路对两个链表进行相加，然后再对相加得到的链表
    //进行反转，最后就是结果要求的链表


    //思路2 把两个链表的值都装到stack中，后进先出，然后进行出栈进位相加的操作
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        while(l1!=null){
            stack1.push(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            stack2.push(l2.val);
            l2=l2.next;
        }
        int carry=0;
        ListNode head=new ListNode(0);

        while(!stack1.isEmpty()||!stack2.isEmpty()){
            int sum=carry;
            sum+=stack1.isEmpty()?0:stack1.pop();
            sum+=stack2.isEmpty()?0:stack2.pop();
            ListNode node=new ListNode(sum%10);
            //然后进行头插入。
            node.next=head;
            head=node;
            carry=sum/10;
        }
        //如果最后还有进位，就把进位相加。
        if(carry>0) {
            ListNode node=new ListNode(carry);
            //然后进行头插入。
            node.next=head;
            head=node;
        }
        return head;
    }


    }

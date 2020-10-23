package ListNode;

import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/10/21 15:04
 * @description：
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 说明: 1 ≤ m ≤ n ≤ 链表长度。  示例:  输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * @modified By：
 * @version: $
 */
public class Problem92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        ListNode superior=dummyHead;
        //先找到要反转的开头的前一个节点
        for (int i=1;i<m;i++){
            superior=superior.next;
        }

        //下面是进行和206完全一样的反转链表
        ListNode prev=null;
        //要反转片段的头节点
        ListNode cur=superior.next;
        //[n--m]
        for (int i=0;i<=n-m;i++){
            ListNode next=cur.next;

            cur.next=prev;
            prev=cur;
            cur=next;
        }
        //superior.next相当于最开始的cur
        superior.next.next=cur;
        //最后把super的指针指向后面拼接的两段
        superior.next=prev;


        return head ;

    }
}

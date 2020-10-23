package ListNode;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/10/21 17:06
 * @description：
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @modified By：
 * @version: $
 */
public class Problem19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head==null) return null;
        int k=0;
        ListNode cur=head;
        while(cur!=null){
            cur=cur.next;
            k++;
        }
        if (k<n) return head;
        //如果不设置虚拟头节点，就需要返回head.next
        if (k==n) return head.next;
        ListNode cur2=head;
        //找到第k-n个节点
        int t=k-n;
        while (t>1&&cur!=null){
            cur2=cur2.next;
            t--;
        }
        cur2.next=cur2.next.next;

        return head;
    }
    //双指针写法 只需遍历一遍链表
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        //和删除相关的一般需要设立虚拟头节点
        ListNode thead=new ListNode(0);
        thead.next=head;
        ListNode p=thead;
        ListNode q=thead;
        //让q移动到n这个位置 p和q之间相差了n+1
        for (int i=0;i<n+1;i++){
            q=q.next;
        }
        //然后双指针移动，当q移动到末尾时，p就移动到了要删除节点的前一个节点
        while(p!=null&&q!=null){
            p=p.next;
            q=q.next;

        }
        p.next=p.next.next;
        return thead.next;


    }

}

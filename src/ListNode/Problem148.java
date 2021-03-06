package ListNode;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/10/21 16:34
 * @description：
 * 在o(nlogn)的时间复杂度内对链表进行排序
 * @modified By：
 * @version: $
 */
public class Problem148 {
    //插入排序
    public ListNode sortList(ListNode head) {

        if(head==null||head.next==null) return head;
        ListNode dummyNode=new ListNode(0);
        dummyNode.next=head;
        ListNode pre=null;
        while(head!=null&&head.next!=null){
            while(head.val<=head.next.val) {
                head=head.next;
                continue;
            }
            pre=dummyNode;
            while(pre.next.val<head.next.val){
                pre=pre.next;
            }
            //cur就是要插的节点
            ListNode cur=head.next;
            head.next=head.next.next;

            //进行节点的插入
            cur.next=pre.next;
            pre.next=cur;

        }
        return dummyNode.next;

    }

   //下面用归并排序
    public ListNode sortList1(ListNode head) {
        // 1、递归结束条件
        if (head == null || head.next == null) {
            return head;
        }

        // 2、找到链表中间节点并断开链表 & 递归下探
        ListNode midNode = middleNode(head);
        ListNode rightHead = midNode.next;
        midNode.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // 3、当前层业务操作（合并有序链表）
        return mergeTwoLists(left, right);
    }

    //  找到链表中间节点（876. 链表的中间结点）
    private ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // 合并两个有序链表（21. 合并两个有序链表）
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentry = new ListNode(-1);
        ListNode curr = sentry;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        curr.next = l1 != null ? l1 : l2;
        return sentry.next;
    }
}

package sort;

public class NodeMergeSort {

    //注意，这样可不算完，这不是链表的归并排序，这只是合并两个有序的链表（特地强调有序）！！！！
    public static ListNode  nodeMergeSort(ListNode head){


        if (head==null||head.next==null) return head;
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        ListNode n=dummyHead;

        ListNode fast=head;
        ListNode slow=head;
        ListNode last=null;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;

        }
        last=slow.next;
        slow.next=null;
        while(head!=null&&last!=null){
            if (head.val<=last.val){
                n.next=head;
                head=head.next;
            }
            else{
                n.next=last;
                last=last.next;
            }
            n=n.next;
        }

        if(last!=null){
            n.next=last;
            n=n.next;
        }

        if(head!=null){
            n.next=head;
            n=n.next;
        }
        return dummyHead.next;
    }



    //下面才是真正的归并排序！！！！

    public ListNode sortList(ListNode head) {
        // 1、递归结束条件
        if (head == null || head.next == null) {
            return head;
        }

        // 2、找到链表中间节点并断开链表 & 递归下探
        ListNode midNode = middleNode(head);
        ListNode rightHead = midNode.next;
        midNode.next = null;
        //对左边链表进行排序
        ListNode left = sortList(head);
        //对右边链表进行排序
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
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
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

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
}

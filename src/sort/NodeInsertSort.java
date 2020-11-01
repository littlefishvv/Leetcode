package sort;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/11/1 16:37
 * @description：
 * 对链表进行插入排序
 * @modified By：
 * @version: $
 */
public class NodeInsertSort {

    public ListNode insertListNode(ListNode head){
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=dummyHead;
        ListNode pre=null;

        while(head!=null&&head.next!=null){
            //head指向的是已经排好序的最后一个元素的指针，初始为头节点，用head表示 随着循环进行，在不断更新。
            //head.next就是需要进行插入排序的节点
            if (head.next.val>=head.val) {
                head=head.next;
                continue;
            }

            pre=dummyHead;

            while(pre.next.val<head.next.val) pre=pre.next;
            //先用cur保存要插入的节点
            ListNode cur=head.next;
            //把要插入的节点移走，但是链表不能断，要连上要插入节点的next
            head.next=cur.next;
            //把要插入的节点放到新的位置，两个步骤 1.让要插入的节点的next等于要插入位置的next 2.要让要插入位置的前节点和要插入的节点连上
            cur.next=pre.next;   //1
            pre.next=cur;        //2

        }
        return dummyHead.next;
    }
}

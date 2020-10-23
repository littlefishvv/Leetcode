package ListNode;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/10/21 16:10
 * @description：
 * @modified By：
 * @version: $
 */
public class Problem24 {
    public ListNode swapPairs(ListNode head) {
        ListNode p=new ListNode(-1);
        p.next=head;
        ListNode thead=p;
        while(p.next!=null&&p.next.next!=null){
            //带上p总共四个节点  因为要维护三个指针的指向
            ListNode n1=p.next;
            ListNode n2=n1.next;
            ListNode next=n2.next;

            //开始改变四个节点的对应关系
            n2.next=n1;
            n1.next=next;
            p.next=n2;

            //改变了一轮，更新p   (p就是要交换的两个节点的上一个节点)
            p=n1;

        }

        return thead.next;
    }

    //递归写法
    public ListNode swapPairs2(ListNode head) {
        //1.中止条件
        if (head==null || head.next==null) return head;
        //2.调用单元 现在有三个节点 head--->head.next--->swap(head.next.next)
        //我们需要把他变成head.next--->head--->swap(head.next.next)
        ListNode firstNode=head;
        ListNode secondNode=head.next;

        //开始重组
        firstNode.next=swapPairs2(secondNode.next);
        secondNode.next=firstNode;

        return secondNode;

    }
}

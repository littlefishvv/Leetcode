package ListNode;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/10/21 16:32
 * @description：
 * @modified By：
 * @version: $
 */
public class Problem25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev=null;
        ListNode cur=head;
        ListNode check=head;
        int canProceed=0;
        int count=0;

        //检查链表长度是否满足可以反转的条件
        while(canProceed<k&&check!=null){
            check=check.next;
            canProceed++;
        }
        ListNode next=null;
        //满足条件，开始反转 每次反转k个
        if(canProceed==k){
            while(count<k&&cur!=null){
                next=cur.next;
                cur.next=prev;
                prev=cur;
                cur=next;
                count++;
            }
            //如果next为空，说明到头了或者最后一个已经不满足条件了
            if(next!=null){
                head.next=reverseKGroup(next,k);
            }
            return prev;
        }else{
            return head;
        }


    }
}

package ListNode;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/10/21 15:52
 * @description：
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * @modified By：
 * @version: $
 */
public class Problem203 {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return null;
        ListNode dummyHead=new ListNode(val+1);
        dummyHead.next=head;
        ListNode cur=dummyHead;
        while(cur.next!=null){
            /*

            这两行代码很秒，意思是只要当前节点的下一个是val，那就cur.next更新，但cur不更新，这样cur.next就可以循环判断
            * if(cur.next.val==val){
                cur.next=cur.next.next;
                *
            * */
            if(cur.next.val==val){
                cur.next=cur.next.next;
            }else{
                //否则把当前节点更新
                cur=cur.next;
            }

        }
        return dummyHead.next;
    }
    //方法2 递归
    public ListNode removeElements1(ListNode head, int val) {
        if(head==null) return head;
        if(head.val==val){
            return removeElements(head.next,val);
        }else{
            head.next=removeElements(head.next,val);
            return head;
        }

    }
}

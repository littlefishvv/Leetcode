package ListNode;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/10/15 10:54
 * @description：
 * @modified By：
 * @version: $
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(){};
    public ListNode(int val){
        this.val=val;
    }
    public ListNode(int val,ListNode next){
        this.val=val;
        this.next=next;
    }
}

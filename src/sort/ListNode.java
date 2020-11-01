package sort;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/11/1 16:13
 * @description：
 * @modified By：
 * @version: $
 */
public class ListNode {
    public ListNode next;
    public int val;
    public ListNode(int val){
        this.val=val;
    }
    public ListNode(int val,ListNode next){
        this.val=val;
        this.next=next;
    }
}

package ListNode;

import javafx.beans.binding.ListBinding;

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
    //通过数组创建链表
    ListNode createLinkedList(int[] arr,int n){
        if (n==0) return null;
        ListNode head=new ListNode(arr[0]);
        ListNode cur=head;
        for (int i = 1; i < n; i++) {
            cur.next=new ListNode(arr[i]);
            cur=cur.next;
        }
        return head;
    }


}

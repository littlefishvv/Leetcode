package ListNode;

import java.util.LinkedList;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/10/21 17:39
 * @description：
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem143 {
    //方法1 使用双端队列，但空间复杂度爆炸，违背了你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
    public void reorderList(ListNode head) {
        //双端队列
        LinkedList<ListNode> queue=new LinkedList<>();
        if(head==null||head.next==null) return;
        ListNode cur=head;
        while(cur!=null){
            queue.add(cur);
            cur=cur.next;
        }
        while(!queue.isEmpty()){
            //
            if(cur==null){
                cur=queue.pollFirst();
            }else{
                cur.next=queue.pollFirst();
                cur=cur.next;
            }
            //如果队列已经为空了，那么poll出来的也是空
            cur.next=queue.pollLast();
            cur=cur.next;

        }
        //再把cur后面多余的去掉
        if(cur!=null){
            cur.next=null;
        }


    }

    //方法二 传统方法
    //思路 先用双指针找到链表中点，中点.next即是第二段 中点.next=null是第一段
    //然后反转第二段链表  然后进行链表拼接，声明一个节点
    /*
    * while(head!=null&&p!=null){
    * r.next=head;
    * head=head.next;
    * r=r.next;
    *
    * r.next=p;
    * p=p.next;
    * r=r.next;}
    * if(head!=null){
    *
    * r.next=head.next;}
    *
    * if(p!=null){
    * r.next=p.next;
    *
    *
    *
    *
    *
    * }
    * */

    public void reorderList1(ListNode head) {
        if (head==null||head.next==null) return;
        ListNode p=head;
        ListNode q=head;
        //这行代码很神奇，改动了就会出现空指针异常，一个对应奇数，一个对应偶数。都是对q进行判断。
        while(q.next!=null&&q.next.next!=null){
            p=p.next;
            q=q.next.next;
        }
        //后半段的头节点
        ListNode last=p.next;
        p.next=null;


        //反转后半段链表 prev
        ListNode prev=null;
        while(last!=null){
            ListNode temp=last.next;
            last.next=prev;
            prev=last;
            last=temp;

        }

        ListNode cur1=new ListNode(0);
        ListNode cur=cur1;
        ListNode head1=head;
        //拼接两端链表
        while(prev!=null&&head1!=null){
            //每次都要更新cur head1 prev
            cur.next=head1;
            cur=cur.next;
            head1=head1.next;


            cur.next=prev;
            prev=prev.next;
            cur=cur.next;
        }

        //拼接剩余的
        if(prev!=null){
            cur.next=prev;
        }
        if(head1!=null){
            cur.next=head1;
        }



    }




}

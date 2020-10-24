package ListNode;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/10/21 16:07
 * @description：
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *  
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode res=new ListNode(0);
        ListNode d=res;

        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                d.next=l1;
                d=d.next;
                l1=l1.next;
            }else{
                d.next=l2;
                d=d.next;
                l2=l2.next;
            }
        }


        //下面的这两个循环直接.next而不是依次.next  但奇怪的是这样居然超出了时间限制
        while(l1!=null){
            d.next=l1;

        }
        while(l2!=null){
            d.next=l2;

        }

        return res.next;
    }



}

package ListNode;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/10/21 16:06
 * @description：给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem82 {
    //注意，这个链表是排好序的
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        if(head.val==head.next.val){
            int val=head.val;
            //注意，在任何head.val之前都要判断是否为空
            while(head!=null&&head.val==val){
                head=head.next;
            }
            return deleteDuplicates(head);
        }else{
            head.next=deleteDuplicates(head.next);
            return head;
        }

    }


}

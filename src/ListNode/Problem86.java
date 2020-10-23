package ListNode;

import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/10/21 15:46
 * @description：
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 *  
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem86 {
    //空间复杂度O(1)我们一直通过改变指针进行操作，除了两个头节点我们没有占用任何空间
    public ListNode partition(ListNode head, int x) {
       //双指针法 这个双指针思路告诉我们没有必要拘泥于其本身的双指针，这样也不需要开拓新空间。
        ListNode beforeHead=new ListNode(0);
        ListNode afterHead=new ListNode(0);
        ListNode before=beforeHead;
        ListNode after=afterHead;
        //让head不断移动，一直移动到尾部下一个节点
        while(head!=null){
            if (head.val<x){
                before.next=head;
                before=before.next;
            }else{
                after.next=head;
                after=after.next;
            }
            head=head.next;
        }
        after.next=null;
        before.next=afterHead.next;

        return beforeHead.next;
    }
}

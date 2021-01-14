package Hot100;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/13 14:45
 * @description：
 *
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 *
 * 说明：不允许修改给定的链表。
 *
 * 进阶：
 *
 * 你是否可以使用 O(1) 空间解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem142 {
    public ListNode detectCycle(ListNode head) {
        if (head==null) return null;
        Set<ListNode> set=new HashSet<ListNode>();
        while(head!=null){
            if (set.contains(head)){
                return head;
            }else{
                set.add(head);
            }
            head=head.next;
        }

        return null;

    }

        //如果要求以o(1)的空间复杂度解决 这题难就难在要找到这个环形链表入口的相对位置  双指针法，如果在第一轮相遇时，得到的slow和fast未必是环开始的结点

        //如果存在环，如何判断环的长度呢？方法是，快慢指针相遇后继续移动，直到第二次相遇。两次相遇间的移动次数即为环的长度。
        public ListNode detectCycle1(ListNode head) {
            ListNode fast = head, slow = head;
            //慢指针走了s步，快指针走了2s步，同时，既然能重合，那么快指针就要比慢指针多走n圈=nb，则能推导出s=nb,
            //假设慢指针这个时候想走到环形入口处还需要再走a步，即总数是a+nb步。而从头节点到入口结点所有可能的步数为c+nb步，从而推到出 a=c.也就是说再适用双指针让这两个结点相等时就得到了环形结点入口的相对位置

        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }




}

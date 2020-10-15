package ListNode;

import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/10/15 10:53
 * @description：反转链表
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem206 {
    public ListNode reverseList(ListNode head) {
        ListNode cur=head;
        ListNode prev=null;
        //这里我们cur.next放到了下面的循环体中，这样从循环时就单独判断，就不用单独判断了
        while(cur!=null){
            //需要先保存一下下一个节点，否则会失去联系
            ListNode nextTemp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=nextTemp;
        }
        //注意，这里return的是prev，而不是cur，因为cur到最后会变成null，prev才是最终的头节点！！！一定要注意。
        return prev;
        /*这是当时写的注释
        * //南大的课后题
        ListNode prev=null;//前指针节点
        ListNode cur=head;//当前指针节点
        //每次循环都将当前节点指向它前面的节点，然后当前节点和前节点后移。
        while(cur!=null){
            ListNode nextTemp=cur.next;//临时节点，暂存当前节点的下一个节点
            cur.next=prev;//将当前节点指向它前面的节点
            prev=cur;//前指针后移
            cur=nextTemp;  //当前节点后移，最后移到null那个位置

        }
        return prev;
        * */
    }
}

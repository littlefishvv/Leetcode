package ListNode;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/10/21 17:39
 * @description：
 *
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem61 {

    public ListNode rotateRight(ListNode head, int k) {
        //思路，把head找到最后，和头节点连起来形成环，然后找到count-k的位置，记录下该位置的next，再让next为空即可

        if(head==null||head.next==null) return head;
        ListNode p=head;
        int count=1;
        while(p.next!=null){
            p=p.next;
            count++;
        }
        k=k%count;
        if(k==0) return head;
        //形成环
        p.next=head;
        int n=count-k;
        //找到要旋转的位置
        for (int i = 0; i < n; i++) {
            p=p.next;
        }
        //这个位置的下一个就是要返回链表的头节点
        ListNode resHead=p.next;
        //让这个位置的下一个为null，即断开环
        p.next=null;
        return resHead;

    }
}

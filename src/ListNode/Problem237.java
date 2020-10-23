package ListNode;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/10/21 16:35
 * @description：
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
 *
 *  
 *
 * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
 *
 *
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [4,5,1,9], node = 5
 * 输出：[4,1,9]
 * 解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 *
 * @modified By：
 * @version: $
 */
public class Problem237 {
    public void deleteNode(ListNode node) {
        if(node==null) return;
        //如果node的下一个节点为空，说明这个最后一个节点。
        if (node.next==null){
            node=null;
            return;
        }
        //就是对node本身进行操作，直接改变值和next即可。也相当于让这个要删除的节点，通过改变val和next变成了下一个节点。
        //这样的话node这个节点的确改变了，而在链表中，这个node改变了，那么.next是node也跟着改变，也就把整个链表改变了
        node.val=node.next.val;
        ListNode delNode=node.next;
        node.next=delNode.next;

    }
}

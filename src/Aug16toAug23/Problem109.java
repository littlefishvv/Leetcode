package Aug16toAug23;

import sun.reflect.generics.tree.Tree;

import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/8/18 17:03
 * @description：给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem109 {
    //平衡二叉搜索树的中序遍历是升序的，这里相当于通过一个中序序列反向得到平衡二叉树
    //因此我们可以以升序序列中的任一个元素作为根节点，以该元素左边的升序序列构建左子树，
    // 以该元素右边的升序序列构建右子树，这样得到的树就是一棵二叉搜索树啦～
    // 又因为本题要求高度平衡，因此我们需要选择升序序列的中间元素作为根节点奥～
    //

    public TreeNode sortedListToBST(ListNode head){
        if (head==null) return null;
        if (head.next==null) return new TreeNode(head.val);
        ListNode fast=head;
        ListNode slow=head;
        ListNode pre=head;
        while (fast.next!=null&&fast!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        while (pre.next!=slow){
            pre=pre.next;
        }
        //这个也是很重要的，有了这个pre.next=null之后，head指向的链表就是中间结点之前的了。
        pre.next=null;
        TreeNode treeNode=new TreeNode(slow.val);
        treeNode.left=sortedListToBST(head);
        treeNode.right=sortedListToBST(slow.next);
        return treeNode;
    }

}

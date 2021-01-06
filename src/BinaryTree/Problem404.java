package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/11/22 18:28
 * @description：
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem404 {
    public int sumOfLeftLeaves(TreeNode root) {
         if (root==null||root.left==null) return 0;

         if(root.left.left==null) return root.left.val;
         return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
    }

    //如果是用广度优先搜索
    public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        //这个广度优先不涉及轮数，只要求遍历，故也不必在内部再设置一个循环。
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (isLeafNode(node.left)) {
                    ans += node.left.val;
                } else {
                        queue.offer(node.left);
                }
            }
            if (node.right != null) {
                //如果右节点是叶子节点我们也没必要加进去了，直接返回，
                if (!isLeafNode(node.right)) {
                    queue.offer(node.right);
                }
            }
        }
        return ans;
    }

    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

}

package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/11/22 16:11
 * @description：
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 * @modified By：
 * @version: $
 */
public class Problem111 {
    public int minDepth(TreeNode root) {
        if (root==null) return 0;
        if (root.left==null) return 1+minDepth(root.right);
        if (root.right==null) return 1+minDepth(root.left);
        else return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
    //用广度优先搜索 需要在遍历到一个无左右子树节点时跳出循环，所谓跳出循环，就是直接返回值， 就是最小深度
    public static int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int level = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.poll();
                if (cur.right == null && cur.left == null){
                    return level;
                }
                if (cur.left!=null){
                    deque.offer(cur.left);
                }
                if (cur.right!=null){
                    deque.offer(cur.right);
                }
            }
            level++;
        }
        return level;
    }
}

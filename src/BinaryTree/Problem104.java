package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/11/22 15:52
 * @description：
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem104 {
    //最大深度 max(左子树最大深度，右子树最大深度)+1
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        else return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    //也可以用广度优先遍历的轮数来做。
    public int maxDepth1(TreeNode root) {
        if (root==null) return 0;
        int layer=0;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            layer++;
            int n=queue.size();
            while(n>0){
                TreeNode t=queue.poll();
                if (t.left!=null) queue.add(t.left);
                if (t.right!=null) queue.add(t.right);
                n--;
            }
        }
        return layer;
    }
}

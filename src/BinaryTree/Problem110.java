package BinaryTree;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/11/22 18:03
 * @description：
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 *
 *
 * @modified By：
 * @version: $
 */
public class Problem110 {
    public int getHeight(TreeNode root){
        if(root==null) return 0;

        else return 1+Math.max(getHeight(root.left),getHeight(root.right));

    }
    public boolean isBalanced(TreeNode root) {
        if (root==null) return true;
        //需要同时满足，左右子树高度差为1以内，以及左右子树都是一个平衡二叉树，并递归判断高低要写再判断左右子树前面
        else return  Math.abs(getHeight(root.left)-getHeight(root.right))<=1&&isBalanced(root.left)&&isBalanced(root.right);
    }
}

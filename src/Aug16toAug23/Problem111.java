package Aug16toAug23;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/8/21 8:58
 * @description：给定一个二叉树，找出其最小深度。 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。  说明: 叶子节点是指没有子节点的节点。
 * @modified By：
 * @version: $
 */
public class Problem111 {
    //这题和求最大深度的套路一样，就是求左右子树的最小值加1，但是值得注意的是，当左右子树有一个为空时，最小深度就是右子树的最小深度加一了。
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.right==null&&root.left==null) return 1;
        if(root.left==null&&root.right!=null) return minDepth(root.right)+1;
        if(root.right==null&&root.left!=null) return minDepth(root.left)+1;

        return Math.min(minDepth(root.left),minDepth(root.right))+1;

    }
}

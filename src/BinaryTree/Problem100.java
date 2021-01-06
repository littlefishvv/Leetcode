package BinaryTree;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/11/22 16:42
 * @description：
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem100 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmertric(root.left, root.right);
    }

    //这个相当于抛弃了根节点，只对两颗独立的子树进行判断，除了递归参数的顺序，其他的和判断两颗树是否相同没什么两样。
    private boolean isSymmertric(TreeNode t1,TreeNode t2) {
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        if(t1.val != t2.val) return false;
        return isSymmertric(t1.left, t2.right) && isSymmertric(t1.right, t2.left);
    }
}

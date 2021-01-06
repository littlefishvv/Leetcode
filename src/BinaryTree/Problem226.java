package BinaryTree;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/11/22 16:29
 * @description：
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem226
{
    public TreeNode invertTree(TreeNode root) {
        if (root==null) return root;
        TreeNode t=root.left;
        root.left=root.right;
        root.right=t;
        invertTree(root.left);
        invertTree(root.right);
        return root;

        /**方法2
         * 这是自底向上递归
         if (root == null) {
         return null;
         }
         TreeNode right = invertTree(root.right);
         TreeNode left = invertTree(root.left);
         root.left = right;
         root.right = left;
         return root;

         **/
    }

}

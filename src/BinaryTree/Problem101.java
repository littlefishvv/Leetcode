package BinaryTree;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/11/22 16:42
 * @description：
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/same-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem101 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null&&q==null) return true;
        if (p==null||q==null) return false;

       /* 这里用这种方法是得不到正确的结果，
       if (p.val==q.val) return true;
       必须要用
       if(p.val!=q.val) return false;
       为什么？？？
       因为如果用了上面的那么在第一轮比较的过程中，已经返回true了，再没有进行下面的代码
       */
        if(p.val!=q.val) return false;
        //直到两颗树的左子树右子树都为空了，就能判断为true 了
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }

}

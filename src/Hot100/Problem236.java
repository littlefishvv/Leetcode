package Hot100;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/13 19:50
 * @description：
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return root;
        }
        if (root == p || root == q) {
            return root;
        }

        //在左子树中寻找p和q的公共祖先
        TreeNode left=lowestCommonAncestor(root.left,p,q);

        //在右子树中寻找p和q的公共祖先
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        //如果左子树和右子树中都能找到公共祖先，说明这都并不是最大祖先；如果在某子树中找不到公共祖先，比如右子树中返回了null，则说明在左子树中找到的就是公共祖先，
        if (left!=null&&right!=null){
            return root;
        }else if (left!=null){
            return left;
        }else if(right!=null){
            return right;
        }

        return null;
    }
}

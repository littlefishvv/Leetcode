package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/11/28 18:04
 * @description：
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 *  * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *  *
 *  *  * 示例：
 *  *  *
 *  *  * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *  *  *
 *  *  *       10
 *  *  *      /  \
 *  *  *     5   -3
 *  *  *    / \    \
 *  *  *   3   2   11
 *  *  *  / \   \
 *  *  * 3  -2   1
 *  *  *
 *  *  * 返回 3。和等于 8 的路径有:
 *  *  *
 *  * 1.  5 -> 3
 *  * 2.  5 -> 2 -> 1
 *  * 3.  -3 -> 11
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem437 {

    //这样写是错误的，因为要求是任意路径，根节点不必从头开始，结尾也不一定是叶子节点
    /*public int pathSum(TreeNode root, int sum) {
        if (root==null) return 0;
        Queue<Object> queue=new LinkedList<>();
        queue.add(root);
        queue.add(root.val);
        int n=0;
        int count=0;
        while(!queue.isEmpty()){
            root= (TreeNode) queue.poll();
            n= (int) queue.poll();
            if(root.left==null&&root.right==null){
               if (n==sum) count++;
            }
            if (root.left!=null){
                int t=n+root.left.val;
                queue.add(root.left);
                queue.add(t);
            }
            if (root.right!=null){
                int t=n+root.right.val;
                queue.add(root.right);
                queue.add(t);
            }


        }

        return count;
    }
*/

    public int dfs(TreeNode node,int sum){
        if(node==null) return 0;
        //这里不能直接返回1.因为如果根节点等于sum，也存在其路径还等于sum的可能。
        int count=0;
        if(node.val==sum) count=1;
        //以右子树开头的等于sum-node.val的序列，以左子树开头的su'm-node.val的序列
        count+=dfs(node.left,sum-node.val)+dfs(node.right,sum-node.val);
        return count;
    }
    //在 一个递归算法中调用另一个递归算法。
    public int pathSum(TreeNode root, int sum) {
        if(root==null) return 0;
            //dfs是头节点是否满足，然后不断判断root.left是否满足，root.right是否满足。
        int  res=dfs(root,sum);
        //然后递归判断每个节点的路径个数 这里的sum是不会变的，而dfs的sum是会变的
        res+=pathSum(root.left,sum)+pathSum(root.right,sum);
        return res;
    }
}

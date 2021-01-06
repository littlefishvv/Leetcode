package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/11/28 16:40
 * @description：
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 示例 2:
 *
 * 输入: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem129 {

    //同时入队两个元素的方法笨笨的，但是可以解决几乎所有和二叉树条件路径相关的问题。
    public int sumNumbers(TreeNode root) {
        if (root==null) return 0;
        Queue<Object> queue=new LinkedList<>();
        List<Integer> list=new ArrayList<>();
        queue.add(root);
        queue.add(root.val);
        int n=0;
        while(!queue.isEmpty()){
            root= (TreeNode) queue.poll();
            n= (int) queue.poll();
            if(root.left==null&&root.right==null){
                list.add(n);
            }
            if (root.left!=null){
                int t=n*10+root.left.val;
                queue.add(root.left);
                queue.add(t);
            }
            if (root.right!=null){
                int t=n*10+root.right.val;
                queue.add(root.right);
                queue.add(t);
            }


        }

        for (int t:list){
            n+=t;
        }
        return n;

    }
    //如果采用递归地深度优先遍历
    /*
    * 从根节点开始，遍历每个节点，如果遇到叶子节点，则将叶子节点对应的数字加到数字之和。
    * 如果当前节点不是叶子节点，则计算其子节点对应的数字，然后对子节点递归遍历。*/
    //preSum表示，在加上当前节点之前所有的路径和
    public int dfs(TreeNode root,int preSum) {
        if(root==null) return 0;
        int sum=preSum*10+root.val;
        //如果是叶子
        if(root.left==null&&root.right==null){
            return sum;
        }else{
            //左子树对应的路径总和值加上右子树对应的路径总和的值 当前值已经存在sum里了
            return dfs(root.left,sum)+dfs(root.right,sum);
        }
    }
}


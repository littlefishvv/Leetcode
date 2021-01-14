package dp;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/8 16:40
 * @description：
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 示例 1:
 *
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 *
 * 输入: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem337 {

    //这类问题就是分为抢和不抢两种选择   这是自顶向下运用备忘录和递归，其实这是一种比较直接的想法 要比直接用动态规划想法要简单一下
    public int rob(TreeNode root){
        HashMap<TreeNode,Integer> memo=new HashMap<>();
        return robInternal(root,memo);

    }
    public int robInternal(TreeNode root,HashMap<TreeNode,Integer> memo){
        if (root==null) return 0;
        if (memo.containsKey(root)) return memo.get(root);
        int money=root.val;
        //抢这一家 那么下次只能去下下家
        int do_it=root.val+(root.left==null?0:robInternal(root.left.left,memo)+robInternal(root.left.right,memo))+
                (root.right==null?0:robInternal(root.right.left,memo)+robInternal(root.right.right,memo));
        //不抢这家，那么就抢左子树右子树上的
        int not_do=robInternal(root.left,memo)+robInternal(root.right,memo);
        int res=Math.max(do_it,not_do);
        memo.put(root,res);
        return res;
        //
    }
    public int rob1(TreeNode root){
        //自顶向下思考。
        if(root==null) return 0;
        if (root.left==null&&root.right==null) return root.val;
        int res=Math.max(root.val,rob(root.left)+rob(root.right));
        return res;

    }



}

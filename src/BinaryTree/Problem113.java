package BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/11/28 15:52
 * @description：
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem113 {
    //这一题用257题的套路来做。
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res=new ArrayList<>();
        if (root==null) return res;
        if (root.val==sum&&root.left==null&&root.right==null) {
            res.add(new ArrayList<>(Arrays.asList(root.val)));
            return res;
        }
        //pathSum(root.left,sum-root.val)是已经取得的满足条件的左子树路径列表，我们只需要对每个加入根节点，然后再添加到res中即可
        if(root.left!=null){
            for(List list:pathSum(root.left,sum-root.val)){
                list.add(0,root.val);
                res.add(list);
            }
        }
        if(root.right!=null){
            for(List list:pathSum(root.right,sum-root.val)){
                list.add(0,root.val);
                res.add(list);
            }
        }

        return res;

    }

}

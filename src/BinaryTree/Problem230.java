package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/11/29 16:59
 * @description：
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 * 示例 2:
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem230 {
    public int kthSmallest(TreeNode root, int k) {
        //思路，遍历二叉树，放到堆中，可以一边遍历，一边放堆，
        //非递归中序遍历
        int res=0;
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> list=new ArrayList<>();
        int count=0;
        while (root!=null||!stack.isEmpty()){
            if (root!=null){
                stack.push(root);
                root=root.left;
            }else{
                root=stack.pop();
                count++;
                if (count==k-1) res=root.val;
                list.add(root.val);
                root=root.right;
            }
        }

        return res;

    }
}

package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/11/29 16:41
 * @description：
 * @modified By：
 * @version: $
 */
public class Problem98 {
    //这样写是错误，因为这样不能保证，其左子树的每一个值都可以小于根节点
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        if (root.left!=null&&root.left.val>=root.val){
           return false;
        }

        if (root.right!=null&&root.right.val<=root.val){
            return false;
        }

        return isValidBST(root.left)&&isValidBST(root.right);
    }

    //思路1 中序遍历，然后判断是否是递增序列
    List<Integer> list=new ArrayList<>();
    public void inorder(TreeNode root){
        if (root!=null){
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }
    }
    public boolean isValidBST1(TreeNode root) {
        if (root==null) return true;
        inorder(root);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i-1)>=list.get(i))
                return false;
        }
        return true;
    }

    //对思路1的一种改进，


    //对思路一使用中序遍历，不适用递归，在进行时直接进行遍历即可
    public boolean isValidBST3(TreeNode root) {
        if (root==null) return true;
        Stack<TreeNode> stack=new Stack<>();
        long pre=Long.MIN_VALUE;
        while (root!=null||!stack.isEmpty()){
            if (root!=null){
                stack.push(root);
                root=root.left;
            }else{
                root=stack.pop();
                if (root.val<=pre) return false;
                root=root.right;
            }
        }
        return true;
    }

    //使用上下届的递归操作 没有看懂这个 todo
    class Solution {
        public boolean isValidBST(TreeNode root) {
            return helper(root, null, null);
        }

        public boolean helper(TreeNode node, Integer lower, Integer upper) {
            if (node == null) {
                return true;
            }

            int val = node.val;
            if (lower != null && val <= lower) {
                return false;
            }
            if (upper != null && val >= upper) {
                return false;
            }

            if (!helper(node.right, val, upper)) {
                return false;
            }
            if (!helper(node.left, lower, val)) {
                return false;
            }
            return true;
        }
    }


}

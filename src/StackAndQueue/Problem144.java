package StackAndQueue;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/11/8 15:05
 * @description：
 * 非递归前序遍历二叉树
 * @modified By：
 * @version: $
 */
public class Problem144 {
    public List<Integer> preorderTraversal(TreeNode root){
        if (root==null) return null;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        List<Integer> list=new ArrayList<Integer>();
        //先把根节点放进去
        stack.push(root);
        while(!stack.isEmpty()){
            //输入栈顶元素
            root=stack.pop();
            list.add(root.val);
            //然后让右子树，左子树依次进栈，注意一定是右子树先进栈，左子树后进栈，因为后进先出，就能先输出左子树
            if (root.right!=null){
                stack.push(root.right);
            }

            if (root.left!=null){
                stack.push(root.left);
            }

        }
        return list;
    }
    //自己再写一遍
    public List<Integer> preorderTraversal1(TreeNode root){
        List<Integer> list=new ArrayList<>();
        if (root==null) return list;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode t=stack.pop();
            list.add(t.val);
            if (t.right!=null) stack.push(t.right);
            if (t.left!=null) stack.push(t.left);
        }

        return list;

    }
}

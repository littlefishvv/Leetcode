package StackAndQueue;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/11/8 16:01
 * @description：
 * 二叉树的后序遍历非递归
 * @modified By：
 * @version: $
 */
public class Problem145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
        if(root==null) return list;
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();

        s1.push(root);

        ////s1根据  根（根节点出栈后再压左右） 左 右压栈，那么就出栈就是根  右 左 把这个顺序放入s2就是 根 右 左，那么出栈顺序就是左右根
        while(!s1.isEmpty()){
            root=s1.pop();
            s2.push(root);
            if (root.left!=null){
                s1.push(root.left);
            }
            if (root.right!=null){
                s1.push(root.right);
            }
        }

        while(!s2.isEmpty()){
            list.add(s2.pop().val);
        }
        return list;
    }

    //再写一遍后续遍历
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
        if(root==null) return list;
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        //下面这段和先序遍历差不多
        s1.push(root);
        while(!s1.isEmpty()){
            root=s1.pop();
            s2.push(root);
            if (root.left!=null){
                s1.push(root.left);
            }
            if (root.right!=null){
                s1.push(root.right);
            }
        }
        while (!s2.isEmpty()){
            list.add(s2.pop().val);
        }
        return list;


    }
}

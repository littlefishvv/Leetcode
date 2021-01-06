package StackAndQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/11/8 15:22
 * @description：
 * 二叉树的中序遍历非递归实现
 * @modified By：
 * @version: $
 */
public class Problem94 {
   //就是一个持续的左链入栈的过程,
    public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> list=new ArrayList<>();
       if (root==null) return list;
       Stack<TreeNode> stack=new Stack<TreeNode>();
       //注意，这时候stack是空的，所以我们要判断当栈不等于空且root也不为空才能跳出循环
       while(!stack.isEmpty()||root!=null){
           //如果当前节点不为空，就把当前节点压入栈，然后访问左孩子 即左链入栈  不满足左链入栈再进行其他操作
           if (root!=null){
               stack.push(root);
               root=root.left;

           //如果左孩子为空了，说明不能再访问了，就输出栈顶，然后访问右孩子
           }else{
               root=stack.pop();
               list.add(root.val);
               //访问右孩子并不需要立刻把右孩子压入栈，需要继续把右孩子的左孩子进行左链入栈。
               root=root.right;
           }
       }
       return list;
    }

    //再写一遍中序遍历
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if (root==null) return list;
        Stack<TreeNode> stack=new Stack<>();
        while(!stack.isEmpty()||root!=null){
            if (root!=null){
                stack.push(root);
                root=root.left;
            }else{
                root=stack.pop();
                list.add(root.val);
                root=root.right;
            }
        }
        return list;

    }



}

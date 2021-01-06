package StackAndQueue;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/11/8 17:40
 * @description：
 * 二叉树的层次遍历
 * @modified By：
 * @version: $
 */
public class Problem102 {
    //层次遍历是一个广度优先遍历的过程，需要用到队列而不是栈。
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists=new ArrayList<>();
        if (root==null) return lists;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> list=new ArrayList<>();
            int n=queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode t=queue.poll();
                list.add(t.val);
                //注意，顺序不能反，因为需要顺序输出。
                if (t.left!=null) queue.add(t.left);
                if (t.right!=null) queue.add(t.right);
            }
            lists.add(list);
        }
        return lists;
     }
     //重新写一遍二叉树的层次遍历
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> lists=new ArrayList<>();
        if (root==null) return lists;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int n=queue.size();
            List<Integer> list=new ArrayList<>();
            for (int i = 0; i < n; i++) {
                root=queue.poll();
                list.add(root.val);
                if (root.left!=null) queue.add(root.left);
                if (root.right!=null) queue.add(root.right);
            }
            lists.add(list);
        }
        return lists;
    }
 }

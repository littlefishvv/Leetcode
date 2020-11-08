package StackAndQueue;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/11/8 17:40
 * @description：
 * 二叉树的层次遍历
 * @modified By：
 * @version: $
 */
public class Problem102 {
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
                if (t.left!=null) queue.add(t.left);
                if (t.right!=null) queue.add(t.right);
            }
            lists.add(list);
        }
        return lists;
     }
}

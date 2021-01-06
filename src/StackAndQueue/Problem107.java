package StackAndQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/11/8 17:54
 * @description：
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * @modified By：
 * @version: $
 */
public class Problem107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists=new ArrayList<>();
        if (root==null) return lists;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> list=new ArrayList<>();
            //这个循环很重要，while循环控制了全部的结束，这个循环控制了当前层次的结束。
            int n=queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode t=queue.poll();
                list.add(t.val);
                if (t.left!=null) queue.add(t.left);
                if (t.right!=null) queue.add(t.right);
            }
            lists.add(list);
        }
        List<List<Integer>> res=new ArrayList<>();
        for (int i = lists.size()-1; i >=0 ; i--) {
            res.add(lists.get(i));
        }
        return res;
    }
//这是官方解法，使用了linkedlist数据结构，可以头插入。比较优雅
    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> levelOrder = new LinkedList<List<Integer>>();
        if (root == null) {
            return levelOrder;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                TreeNode left = node.left, right = node.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            //linkedlist头插入，避免了反转链表
            levelOrder.add(0, level);
        }
        return levelOrder;
    }


}

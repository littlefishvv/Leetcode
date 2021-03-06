package oj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/3/3 9:51
 * @description：
 * @modified By：
 * @version: $
 */

//层次遍历二叉树并排序
public class LevelTree {
    public static List<List<Integer>> levelSort(TreeNode root) {
        //没什么意思，不写了
        List<List<Integer>> list = new ArrayList();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list1 = new ArrayList();
            int n = queue.size();
            //把队列中的节点都放出来
            for (int i = 0; i < n; i++) {
                TreeNode t = queue.poll();
                //把放出来的节点加到list1里面去
                list1.add(t.val);
                //然后把左右节点加到栈里面去（如果有的话）
                if (t.left != null) {
                    queue.add(t.left);

                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            list.add(list1);
        }
        return list;


    }

    //补充，根据一个数组层次遍历构造一颗二叉树  这里没有考虑空节点，实际上上面题目并没有放入空值。
    public TreeNode createTree(int[] nums) {
        //需要用到队列
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        int i = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (++i < nums.length) {
                cur.left = new TreeNode(nums[i]);
                queue.offer(cur.left);
            }
            if (++i < nums.length) {
                cur.right = new TreeNode(nums[i]);
                queue.offer(cur.right);
            }
        }
        return root;

    }

}

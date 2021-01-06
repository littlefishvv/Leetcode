package StackAndQueue;

import java.util.*;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/11/10 14:59
 * @description：
 *给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem103 {
    //先从左往右，再从右往左进行遍历、
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists=new ArrayList<>();
        if (root==null) return lists;
        //这个是单端队列，只能从队列尾部插入
       // Queue<TreeNode> queue = new LinkedList<>();
        //LinkedList是双端队列，可以队首或者队尾插入。
        LinkedList<TreeNode> queue=new LinkedList<>();
        boolean orderLeft=false;
        queue.add(root);
        int c=0;
        while(!queue.isEmpty()){
            int n=queue.size();
            List<Integer> list=new ArrayList<>();
            for (int i = 0; i < n; i++) {
                root=queue.poll();
                list.add(root.val);
                if(root.left != null) queue.offer(root.left);
                if(root.right != null) queue.offer(root.right);
            }
            if (orderLeft) Collections.reverse(list);
            orderLeft=!orderLeft;

            lists.add(list);
        }
        return lists;

    }

    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> lists=new ArrayList<>();
        if (root==null) return lists;
        //这个是单端队列，只能从队列尾部插入
        // Queue<TreeNode> queue = new LinkedList<>();
        //LinkedList是双端队列，可以队首或者队尾插入。
        LinkedList<TreeNode> queue=new LinkedList<>();
        boolean orderLeft=true;
        queue.add(root);
        int c=0;
        while(!queue.isEmpty()){
            int n=queue.size();
            List<Integer> list=new ArrayList<>();
            for (int i = 0; i < n; i++) {
                //对于不同的顺序有不同的输出和进去的步骤
                //如果是从左向右输入，那么就需要把节点取出后，他的子节点以尾插入的形式进行从左向右的插入（就是正常的队列插入），但下一轮需要倒序输出（尾输出），即pollLast
                if (orderLeft){
                    root=queue.pollFirst();
                    list.add(root.val);
                    if(root.left != null) queue.addLast(root.left);
                    if(root.right != null) queue.addLast(root.right);


                }else{
                    //要从右向左，需要进行倒序输出（尾输出）
                    root=queue.pollLast();
                    list.add(root.val);

                    //然后对于每一个尾输出的节点，需要按先右后左的形式进行头插入（这样会行成一个正序的序列），以便下一轮进行正常的队列输出（即先进先出）
                    if(root.right != null) queue.addFirst(root.right);
                    if(root.left != null) queue.addFirst(root.left);

                }

            }
            //改变标识符
            orderLeft=!orderLeft;
            lists.add(list);
        }
        return lists;

    }
}

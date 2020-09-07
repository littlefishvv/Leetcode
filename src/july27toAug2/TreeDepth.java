package july27toAug2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/7/28 8:37
 * @description：给定一个二叉树，找出其最大深度。 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * @modified By：
 * @version: $
 */
public class TreeDepth {
    //方法一：递归法 说是递归，其实也算是深度优先搜索
/*
    时间复杂度：O(n)O(n)，其中 nn 为二叉树节点的个数。每个节点在递归中只被遍历一次。
    空间复杂度：o(height)， 表示二叉树的高度。递归函数需要栈空间，而栈空间取决于递归的深度，因此空间复杂度等价于二叉树的高度。
*/

    public int max(int a,int b){
        if(a>b) return a;
        return b;
    }
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        else return 1+max(maxDepth(root.left),maxDepth(root.right));
    }
    //方法2 广度优先 广度的话就是一轮轮的轮数,经过几轮之后能把节点遍历完，那么深度就是几
    public int maxDepth2(TreeNode root){
        int ans=0;
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        //入队
        queue.offer(root);
        //开始广度优先遍历。一个遍历一个队列的
        while (!queue.isEmpty()){
            int size=queue.size();
            while(size>0){
                TreeNode node=queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);

                }
                size--;

            }
            ans++;
        }


        return ans;

    }
}

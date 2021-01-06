package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/11/28 10:30
 * @description：
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem257 {
    public List<String> binaryTreePaths1(TreeNode root) {
        List<String> res=new ArrayList<>();
        if(root==null) return res;
        solve(root,"",res);
        return res;
    }
    //有点类似于回溯 递归方式1
    public void solve(TreeNode root,String cur,List<String> ret){
        if(root!=null){
            StringBuffer str=new StringBuffer(cur);
            str.append(String.valueOf(root.val));
            //如果该节点不是根节点
            if (root.left!=null||root.right!=null){
                //则深度优先遍历
                //这一点挺巧妙地，先把该节点放进去，只有当该节点不是根节点时才接上->
                str.append("->");
                solve(root.left,str.toString(),ret);
                solve(root.right,str.toString(),ret);
            }else{
                ret.add(str.toString());
            }
        }
    }
    //递归方式2
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> res = new LinkedList<>();
        if (root == null)
            return res;
        //到达叶子节点，把路径加入到集合中  这里return res是为了让后面遍历。
       if (root.left == null && root.right == null) {
            res.add(root.val + "");
            return res;
        }
        //遍历左子节点的路径
        for (String path : binaryTreePaths2(root.left)) {
            res.add(root.val + "->" + path);
        }
        //遍历右子节点的路径
        for (String path : binaryTreePaths2(root.right)) {
            res.add(root.val + "->" + path);
        }
        return res;
    }


    //这又提供了另一种思路 非递归方式  这是层次遍历
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null)
            return res;
        //队列，节点和路径成对出现，路径就是从根节点到当前节点的路径
        Queue<Object> queue = new LinkedList<>();
        //成对出现，也成对取出，这是重点！！！！
        queue.add(root);
        queue.add(root.val + "");
        while (!queue.isEmpty()) {
            //成对取出
            TreeNode node = (TreeNode) queue.poll();
            String path = (String) queue.poll();
            //如果到叶子节点，说明找到了一条完整路径
            if (node.left == null && node.right == null) {
                res.add(path);
            }

            //右子节点不为空就把右子节点和路径存放到队列中  也成对放入
            if (node.right != null) {
                queue.add(node.right);
                queue.add(path + "->" + node.right.val);
            }

            //左子节点不为空就把左子节点和路径存放到队列中
            if (node.left != null) {
                queue.add(node.left);
                queue.add(path + "->" + node.left.val);
            }
        }
        return res;
    }



}

package Hot100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/23 10:55
 * @description：
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 示例: 
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem297 {
    //需要记录下来每个结点的层数，因为对于这个结点而已，非最大层数而且他的左子树和右子树为
    //空的话，需要在序列化中把这个空记录下来，
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null) return "";
        // int h=getHeight(root);
        // System.out.println(h);
        StringBuffer sf=new StringBuffer("");

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        int th=0;
        while (!queue.isEmpty()){

            TreeNode cur=queue.remove();
            if (cur==null){
                sf.append("null,");
            }else {
                //相比于传统的层次遍历在于，这里不对左右子树是否为空做出判断，只要cur不为空，就把他的左右子树放到栈中。
                sf.append(cur.val + ",");
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        //把最后一个逗号去掉
        sf.setLength(sf.length()-1);

        return sf.toString();

    }
    private int getHeight(TreeNode root){
        if (root==null) return 0;
        else return 1+Math.max(getHeight(root.left),getHeight(root.right));
    }


    //如何反序列化呢，我们上面通过层次遍历得到了这个序列化结果，那么我们的结果也应当是层次遍历的。
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null||data.length()<=0) return null;

        Queue<String> nodes=new LinkedList<>(Arrays.asList(data.split(",")));
        TreeNode root=new TreeNode(Integer.parseInt(nodes.poll()));
        //用parent队列来存储已经遍历到的结点
        Queue<TreeNode> parents=new LinkedList<>();
        //把第一个根节点加到parent队列中去
        parents.add(root);
        //通过parent队列进行
        while(!parents.isEmpty()&&!nodes.isEmpty()){
            TreeNode node=parents.poll();
            //如果左子树不空    如果是空的就跳过，但也要把空 poll出去，以进行下一个结点的放入。                                                                                                                                                                                                                                                                                   不是空
            if (!nodes.peek().equals("null")){
                //把取到的左子树结点放到parent中去
                TreeNode left=new TreeNode(Integer.valueOf(nodes.poll()));
                node.left=left;
                parents.add(node.left);

            }else{
                nodes.poll();
            }
            //如果右子树不空
            if (!nodes.peek().equals("null")){
                //把取到的右子树结点放到parent中去。
                TreeNode right=new TreeNode(Integer.valueOf(nodes.poll()));
                node.right=right;
                parents.add(node.right);
            }else{
                nodes.poll();
            }
        }

        return root;

    }

    public static void main(String[] args) {
        Problem297 p=new Problem297();
        TreeNode node=new TreeNode(1);
        node.left=null;
        node.right=new TreeNode(2);
        System.out.println(p.serialize(node));
    }
}

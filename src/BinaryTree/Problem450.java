package BinaryTree;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/11/29 16:56
 * @description：
 * @modified By：
 * @version: $
 */
public class Problem450 {
    //首先明白，二叉搜素树的前驱和后继是指 中序遍历后的前面和后面的那个节点，而不是左子树和右子树节点
    //一 找后继节点，先找右子树(首先要有右子树)再找其左子树（如果有的话一直左子树）
    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) root = root.left;
        return root.val;
    }
    //二 找前驱节点 先找左子树 然后一直右子树（如果有的话）
    public int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) root = root.right;
        return root.val;
    }
    //deleteNode(TreeNode root, int key) 的意思是从root为根的这棵树中删除值为key的节点。
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null) return null;
        if (key>root.val) root.right=deleteNode(root.right,key);
        else if (key<root.val) root.left=deleteNode(root.left,key);

        else{
            //如果是叶子节点
            if (root.right==null&&root.left==null) root=null;
            else if (root.right!=null){
                //找后继
                root.val=successor(root);
                //删除后继
                root.right=deleteNode(root.right,root.val);
            }else{
                //找前驱
                root.val=predecessor(root);
                //删除前驱
                root.left=deleteNode(root.left,root.val);
            }
        }
        return root;


    }




}

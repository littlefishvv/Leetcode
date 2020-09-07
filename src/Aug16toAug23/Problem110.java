package Aug16toAug23;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/8/17 9:29
 * @description：给定一个二叉树，判断它是否是高度平衡的二叉树。 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * @modified By：
 * @version: $
 */
public class Problem110 {

    //方法一 自顶向下的递归  时间复杂度o(n2)
   public boolean isBalanced(TreeNode root){
       if (root==null) return true;
       else
           //后面需要街上isBalanced(root.left)&&isBalanced(root.right) 要对其每一个左子树和右子树进行递归判断
       return Math.abs(getHeight(root.left)-getHeight(root.right))<=1&&isBalanced(root.left)&&isBalanced(root.right);
   }
    public int getHeight(TreeNode root){
        if(root==null) return 0;

        else return 1+Math.max(getHeight(root.left),getHeight(root.right));
    }
    //方法2 自顶向上的递归
    //类似于后序遍历，对于当前遍历到的节点，先递归的判断其左右子树是否平衡，再判断以当前节点为根的字子树是否平衡，如果一颗
    //子树是平衡的，则返回其高度，否则返回-1，如果存在一颗子树不平衡，则整个二叉树一定不平衡。
    //也就是在返回高度之前先判断是否平衡。可以减少计算
    public int height(TreeNode root){
       if (root==null) return 0;
       int leftHeight=height(root.left);
       int rightHeight=height(root.right);
       //leftheight和rightheight的值就可以判断左右子树是否平衡。Math.abs(leftHeight-rightHeight)>1判断当前节点是否平衡
       if (leftHeight==-1||rightHeight==-1||Math.abs(leftHeight-rightHeight)>1) return -1;
       else return Math.max(leftHeight,rightHeight)+1;
    }
    public boolean isBalanced1(TreeNode root){
       return height(root)>=0;
    }
}

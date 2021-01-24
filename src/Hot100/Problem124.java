package Hot100;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/22 14:54
 * @description：
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem124 {
    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        //在递归中不断地更新maxSUm
        maxGain(root);
        return maxSum;

    }

    //自底向上出发就是，对于一个结点，它要么加上左孩子和自身然后向上走，要么加上右孩子和自身，然后向上走，要么就是把自身和左孩子右孩子连起来不往上走了
    //因为最大路径并不一定经过根结点，所以函数的返回值不能当作结点，而是需要动态的更新这个全局变量。
    /*
    * 首先，考虑实现一个简化的函数 maxGain(node)，该函数计算二叉树中的一个节点的最大贡献值，
    * 具体而言，就是在以该节点为根节点的子树中寻找以该节点为起点的一条路径，使得该路径上的节点值之和最大

      根据函数 maxGain 得到每个节点的最大贡献值之后，如何得到二叉树的最大路径和？
      对于二叉树中的一个节点，该节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值，如果子节点的最大贡献值为正，
      则计入该节点的最大路径和，否则不计入该节点的最大路径和。维护一个全局变量 maxSum 存储最大路径和，在递归过程中更新 maxSum 的值，最后得到的 maxSum 的值即为二叉树中的最大路径和


    * */
    private int maxGain(TreeNode node){
        if (node==null){
            return 0;
        }
        //只有在最大贡献大于0时，才会选取对应结点，否则认为该结点对整体的贡献为0
        int leftGain=Math.max(maxGain(node.left),0);
        int rightGain=Math.max(maxGain(node.right),0);

        //下面这两行代码就是为了动态更新最大路径和，这个是再递归的过程中动态更新的。
        //该结点的最大路径和（这个值是一定要经过该节点的）等于该结点的值与左右子树的最大贡献之和
        int price=node.val+leftGain+rightGain;
        //更新答案，因为答案就是所有结点中，选出的那个最大路径和。
        maxSum=Math.max(maxSum,price);
        //返回结点的最大贡献值 因为这是路径，路径只能选左或者右。而最大路径和可以是该结点然后再加上左右的贡献，
        return node.val+Math.max(leftGain,rightGain);

    }

}

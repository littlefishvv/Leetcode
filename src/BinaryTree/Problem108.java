package BinaryTree;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/11/29 16:58
 * @description：
 *
将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:

给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

0
/ \
-3   9
/   /
-10  5
 * @modified By：
 * @version: $
 */
public class Problem108 {
    //既然是平衡二叉搜索树
    //用分治的思想去做
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums,0,nums.length-1);
    }
    public TreeNode sortedArrayToBST(int[] nums,int l ,int r) {
        if (l>r) return null;
        //这里最好写成l+(r-l)/2 因为l+r/2有溢出的风险。因为两个数相加超过最大值后会有溢出的风险。
        int mid=l+(r-l)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=sortedArrayToBST(nums,l,mid-1);
        root.right=sortedArrayToBST(nums,mid+1,r);
        return root;

    }

}

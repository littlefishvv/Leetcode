package Hot100;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/13 18:45
 * @description：
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem105 {
    //隐约感觉可以通过递归来做 其实就是通过某个子序列来构造子树。
    //优化写法：我们可以用一个HashMap把中序遍历数组的每个元素的值和下标存起来，这样寻找根节点的位置就可以直接得到了。
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       return build(preorder,inorder,0,preorder.length,0,inorder.length);

    }
    //注意下边的两个指针指向的数组范围是包括左边界，不包括右边界。
    public TreeNode build(int[] preorder, int[] inorder ,int ps,int pe,int is,int ie){
        if (ps==pe) return null;
        int rootval=preorder[ps];
        TreeNode root=new TreeNode(rootval);
        int index=0;
        //找根节点所在中序数组中的位置，那么就可以得到，这个位置左边的都是该根结点的左子树，这个位置右边的都是该根节点的右子树。
        for (int i=is;i<ie;i++){
            if (rootval==inorder[i]){
                index=i;
                break;
            }
        }
        //记录左子树元素数量
        int leftNum=index-is;
        //对于先序遍历来说，ps后面紧跟着的leftNum个元素就是左子树 对中序遍历来说，is和index【取不到】之间构成了左子树
        root.left= build(preorder,inorder,ps+1,ps+leftNum+1,is,index);
        //右子树同理。
        root.right=build(preorder,inorder,ps+leftNum+1,pe,index+1,ie);
        return root;

    }

}

package JianZhiOffer;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/2/1 9:35
 * @description：
 * @modified By：
 * @version: $
 */
public class Offer07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        //由前序和中序遍历构建二叉树
        return getTree(preorder,0,preorder.length,inorder,0,inorder.length);

    }
    //pe 和ie都是取不到的。相当于[ps,pe)
    public TreeNode getTree(int[] preorder,int ps,int pe, int[] inorder ,int is,int ie){
        //递归出口 因为pe是取不到的，所以当ps等于pe时，就说明已经没有元素可以取了
        if(ps==pe) return null;
        TreeNode node=new TreeNode(preorder[ps]);
        //得到中序遍历数组中的下标，其实可以用一个map数据结构快速得到
        int index=getIndex(inorder,preorder[ps]);

        //左子树的数量 index-is，得到这个数据之后就可以知道在先序遍历数组中，左子树的范围应该截到哪里
        int leftNum=index-is;
        //下面的getTree就是根据这些数据范围得到一颗子树，
        node.left=getTree(preorder,ps+1,ps+1+leftNum,inorder,is,index);
        node.right=getTree(preorder,ps+leftNum+1,pe,inorder,index+1,ie);

        return node;

    }
    private int getIndex(int[] nums,int t){
        for(int i=0;i<nums.length;i++){
            if(t==nums[i]){
                return i;
            }
        }
        return -1;
    }
}

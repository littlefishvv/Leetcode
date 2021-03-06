package JianZhiOffer;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/2/1 11:47
 * @description：
 * @modified By：
 * @version: $
 */
public class Offer08 {
    //parent指针可以得到该节点的parent
    public static BinaryTreeNode getNext(BinaryTreeNode node){
        if(node==null) return null;
        //如果有右子树，就一直遍历右子树的左子树，得到的就是下一个节点
        BinaryTreeNode next=null;
        if (node.rightNode!=null){
            BinaryTreeNode b=node.rightNode;
            while(b.leftNode!=null){
                b=b.leftNode;
            }
            next=b;
        }else{
            //用t记录下node的更新
            BinaryTreeNode t=node;
            //如果右子树为空，找父子树的左子树为当前节点，那么这个父子书就是next
            while(node.parentNode!=null){
                node=node.parentNode;
                if (node.leftNode==t){
                    next=node;
                    break;
                }else{
                    t=node;


                }
            }

        }
        return next;

    }
}

package Aug4toAug9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/8/9 15:24
 * @description：二叉搜索树中的两个节点被错误地交换。 请在不改变其结构的情况下，恢复这棵树
 * @modified By：
 * @version: $
 */
public class Problem99 {

    public void recoverTree(TreeNode root){
        List<Integer> nums=new ArrayList<>();
        inOrder(root,nums);
        int[] n=findTwoSwapped(nums);
        recover(root,2,n[0],n[1]);
    }

    //中序遍历把节点放到一个列表里
    public void inOrder(TreeNode root,List<Integer> nums){
        if(root==null) return ;
        inOrder(root.left,nums);
        nums.add(root.value);
        inOrder(root.right,nums);
    }
    //从中序遍历的那个列表里找到需要交换的那两个节点 记录其值，放到一个数组中去
    public int[] findTwoSwapped(List<Integer> nums){
        int n=nums.size();
        int x=-1,y=-1;
        for(int i=0;i<n-1;i++){
            if (nums.get(i+1)<nums.get(i)){
                y=nums.get(i+1);
                if(x==-1){
                    x=nums.get(i);
                }else{
                    break;
                }
            }
        }
        return new int[]{x,y};
    }
    //找到需要交换的节点之后，进行交换节点的操作
    public void recover(TreeNode root,int count,int x,int y){
        if(root!=null){
            if(root.value==x||root.value==y){
                root.value=root.value==x?y:x;
                if(--count==0) return;

            }

        }
        //进行左右子树的判断
        recover(root.left,count,x,y);
        recover(root.right,count,x,y);

    }


}

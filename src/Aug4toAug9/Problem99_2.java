package Aug4toAug9;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/8/9 16:07
 * @description：对99题的优化
 * @modified By：
 * @version: $
 */
public class Problem99_2 {
    //上面那个解答需要把中序遍历的结果存入list中，实际上，在遍历时，我们可以动态的找出需要交换的那两个位置，可以降低空间复杂度
    public void recoverTree(TreeNode root){
        Deque<TreeNode> stack=new ArrayDeque<TreeNode>();
        TreeNode x=null,y=null,pred=null;
        //非递归形式进行中序遍历
        while(!stack.isEmpty()||root!=null){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            //当没有在左子树了
            root=stack.pop();
            //进行需要交换位置的判断
            if(pred!=null&&root.value<pred.value){
                y=root;
                if(x==null){
                    x=pred;
                }else{
                    break;
                }
            }
            pred=root;
            root=root.right;
        }
        swap(x,y);
    }
    public void swap(TreeNode x,TreeNode y){
        int tmp=x.value;
        x.value=y.value;
        y.value=tmp;
    }
}

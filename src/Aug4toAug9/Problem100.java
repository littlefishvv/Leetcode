package Aug4toAug9;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/8/8 10:58
 * @description：定两个二叉树，编写一个函数来检验它们是否相同。 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的
 * @modified By：
 * @version: $
 */
public class Problem100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
       /* List<Integer> list1=new ArrayList<>();
         List<Integer> list2=new ArrayList<>();
        preOrderPrint(p,list1);
         preOrderPrint(q,list2);
        if(list1.size()!=list2.size()) return false;
        int len=list1.size();
        for(int i=0;i<len;i++){
            if(list1.get(i)!=list2.get(i)) return false;
        }
        return true;*/
        //找递归出口，不仅有false的出口，还得有true的出口。
        if(p==null&&q==null) return true;
        if(p==null||q==null) return false;
        if(p.value!=q.value) return false;
        else return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);

    }
}

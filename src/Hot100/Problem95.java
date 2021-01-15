package Hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/15 10:11
 * @description：
 *
给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。



示例：

输入：3
输出：
[
[1,null,3,2],
[3,2,null,1],
[3,1,null,null,2],
[2,1,3],
[1,null,2,null,3]
]
解释：
以上的输出对应以下 5 种不同结构的二叉搜索树：

1         3     3      2      1
\       /     /      / \      \
3     2     1      1   3      2
/     /       \                 \
2     1         2                 3
 * @modified By：
 * @version: $
 */
public class Problem95 {
    List<TreeNode> res;
    public List<TreeNode> generateTrees(int n) {
        if (n==0) return new LinkedList<>();
        return generateTree(1,n);


    }

    private List<TreeNode> generateTree(int s,int e){
        res=new LinkedList<>();
       // if (s>e) return null;
        if (s>e) {
            res.add(null);
            return res;
        }

        for (int i=s;i<=e;i++){
            List<TreeNode> leftTree=generateTree(s,i-1);
            List<TreeNode> rightTree=generateTree(i+1,e);


            //得到左右子树列表后，穷尽所有的左右子树组合【相当于第96题的乘法】
            for (TreeNode left:leftTree){
                for (TreeNode right:rightTree){
                    //以i为根节点
                    TreeNode root=new TreeNode(i);
                    root.left=left;
                    root.right=right;
                    res.add(root);
                }
            }
        }
        return res;


    }
}

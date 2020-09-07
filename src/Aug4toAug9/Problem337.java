package Aug4toAug9;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/8/6 17:04
 * @description：在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
 * 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。  计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/house-robber-iii 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem337 {
    //方法一 暴力法
    public int rob(TreeNode root){
        if(root==null) return  0;
        int money=root.value;
        if (root.left!=null) money+=rob(root.left.left)+rob(root.left.right);
        if (root.right!=null) money+=rob(root.right.left)+rob(root.right.right);
        //money是爷爷加上四个孙子偷的钱  rob(root.left)+rob(root.right)是两个儿子偷的钱，这两者中的最大值就是最大的利润
        return Math.max(money,rob(root.left)+rob(root.right));
    }
    //方法2 上面那种方法 在计算爷爷时同时计算了两个儿子和四个孙子，那么在儿子当爷爷时，就会重复计算 一遍子孙节点
    //二叉树不适合拿数组当缓存，我们使用哈希表来存储结果，TreeNode当作key，能偷的钱当作value
    public int rob1(TreeNode root){
        HashMap<TreeNode,Integer> memo=new HashMap<>();
        return robInternal(root,memo);
    }
    public int robInternal(TreeNode root, HashMap<TreeNode,Integer> memo){
        if(root==null) return 0;
        //这是递归的退出条件
        if(memo.containsKey(root)) return memo.get(root);
        int money = root.value;
        if(root.left!=null) money+=robInternal(root.left.left,memo)+robInternal(root.left.right,memo);
        if(root.right!=null) money+=robInternal(root.right.left,memo)+robInternal(root.right.right,memo);
        int result=Math.max(money,robInternal(root.left,memo)+robInternal(root.right,memo));
        //代表在root这个树以root为根节点的情况下其对应的最大值为result
        memo.put(root,result);

        return result;
    }
    //方法3 动态规划解法 每个节点有两种状态，偷与不偷。
    //1.当前节点选择不偷[0]：当前节点能偷的最大钱数=左孩子能偷的最大钱+右孩子能偷的最大钱。
    //2.当前节点选择偷[1]：当前节点能偷的最大钱数=左孩子选择自己不偷时能偷的最大钱数+右孩子选择不偷时能偷的最大钱数+当前节点的钱数
    public int rob2(TreeNode root){
        int[] result=robInternal2(root);
        return Math.max(result[0],result[1]);

    }
    public int[] robInternal2(TreeNode root){
        if(root==null) return new int[2];
        //用一个数组来表示偷与不偷
        int[] result=new int[2];
        //math.max(left[0],left[1])就是以左孩子为根节点能偷的最多的钱 result[0]就是当前节点不偷时能得到的最大的钱
        //result[1]是当前节点偷时能得到的最大的钱。
        int[] left=robInternal2(root.left);
        //math.max(right[0],right[1])就是以右孩子为根节点能偷的最多的钱
        int[] right=robInternal2(root.right);
        //
        result[0]=Math.max(left[0],left[1])+ Math.max(right[0],right[1]);
        result[1]=left[0]+right[0]+root.value;
        return result;
    }
}

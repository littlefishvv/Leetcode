package Hot100;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/14 9:41
 * @description：
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 *
 * @version: $
 */
public class Problem96 {

    //初始递归

    public int numTrees1(int n) {

       return count(1,n);

    }

    //闭区间的se能组成count(s,e)种二叉树
    int count(int s,int e){
        //空二叉树也是二叉搜素树
        if (s>e) return 1;
        int res=0;
        //对s到e之间任何可能的组合进行计算
        for (int i = s; i <=e; i++) {
            int leftNums=count(s,i-1) ;
            int right=count(i+1,e);
            res+=leftNums*right;

        }

        return res;

    }

    //带备忘录的递归
    int[][] memo;
    public int numTrees2(int n) {
        memo=new int[n+1][n+1];

        return count2(1,n);

    }

    //闭区间的se能组成count(s,e)种二叉树
    int count2(int s,int e){
        //空二叉树也是二叉搜素树
        if (s>e) return 1;

        if (memo[s][e]!=0){
            return memo[s][e];
        }
        int res=0;
        //对s到e之间任何可能的组合进行计算
        for (int i = s; i <=e; i++) {
            int leftNums=count(s,i-1) ;
            int right=count(i+1,e);
            res+=leftNums*right;

        }
        //放入备忘录
        memo[s][e]=res;

        return res;

    }


    //以k为根节点的BST种类数=左子树BST种类树*右子树BST种类数。问题变成不同k之下，等号右边的乘机，进行累加
    //而且连着的数，如果参与构建的个数一样，那么构造的树个数也一样,这一点特别重要，这样可以把思路不必纠结到具体子树的值。


    public int numTrees(int n) {
        int[] dp=new int[n+1];
        //dp[i]意思是1-i这i个结点能构成的BST数量
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i <= n; i++) {
            //子树用掉 j 个，则右子树用掉 i-j-1 个，能构建出 dp[j] * dp[i-j-1] 种不同的BST   j的范围是0--i-1
            for (int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
   /* public int helper(int begin,int end){
        if (){

        }
    }*/

}

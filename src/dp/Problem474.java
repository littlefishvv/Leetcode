package dp;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/9 16:42
 * @description：
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 *  *
 *  * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 *  *
 *  * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *  *
 *  *  
 *  *
 *  * 示例 1：
 *  *
 *  * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 *  * 输出：4
 *  * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 *  * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 *  * 示例 2：
 *
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1
 * 输出：2
 * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ones-and-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem474 {

    //这是一个多维的01背包问题
    //既然说是最多包含m个0和n个1，那么只要是再m和n内的都可以算为子集，找这些子集的最大长度
    public int findMaxForm(String[] strs, int m, int n) {
        int len=strs.length;
        if (len<=0) return 0;
        //int[] dp=new int[len+1]; dp[i][j]代表i个0和j个1的最大子集长度
        int[][] dp=new int[m+1][n+1];


        //对于每一个str，分析出他有几个0和几个1，然后把
        for (String str:strs){
            int[] tmp=getOneAndZero(str);
            for (int i=m;i>=tmp[0];i--){
                for (int j=n;j>=tmp[1];j--){

                    dp[i][j]=Math.max(dp[i][j],dp[i-tmp[0]][j-tmp[1]]+1);


                }
            }
        }
        return dp[m][n];

    }
    public int[] getOneAndZero(String str){
        int[] tmp=new int[2];
        if (str==null) return null;
        int n=str.length();
        for (int i=0;i<n;i++){
            if (str.charAt(i)=='0') tmp[0]=tmp[0]+1;
            if (str.charAt(i)=='1') tmp[1]=tmp[1]+1;
        }
        return tmp;

    }
    public static void main(String[] args) {
        Problem474 p=new Problem474();
        p.findMaxForm(new String[]{"10","0","1"},1,1);
    }
}

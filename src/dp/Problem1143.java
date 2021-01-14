package dp;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/11 17:19
 * @description：最长公共子序列
 * @modified By：
 * @version: $
 */
public class Problem1143 {
    public int longestCommonSubsequence(String text1, String text2) {

        int m=text1.length();
        int n=text2.length();
        if (m==0||n==0) return 0;
        int[][] dp=new int[m][n];
       /* for (int i = 0; i < n; i++) {
            if (text1.charAt(0)==text2.charAt(i)){
                dp[0][i]=1;
            }else if (i!=0){
                dp[0][i]=dp[0][i-1];
            }
            System.out.println("0j"+i+" :"+dp[0][i]);
        }
        for (int i = 0; i < m; i++) {
            if (text2.charAt(0)==text1.charAt(i)){
                dp[i][0]=1;
            }else if (i!=0){
                dp[i][0]=dp[i-1][0];
            }
            System.out.println("0j"+i+" :"+dp[0][i]);
        }*/
       if (text1.charAt(0)==text2.charAt(0)){
           dp[0][0]=1;
       }
       for (int i=1;i<m;i++){
           if(text2.charAt(0)==text1.charAt(i))
               dp[i][0]=1;
           else
               dp[i][0]=dp[i-1][0];
       }

        for (int i=1;i<n;i++){
            if(text1.charAt(0)==text2.charAt(i))
                dp[0][i]=1;
            else
                dp[0][i]=dp[0][i-1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (text1.charAt(i)==text2.charAt(j)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int res=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res=Math.max(res,dp[i][j]);
            }
        }
       return res;
    }

    public int longestCommonSubsequence1(String text1, String text2) {
        if (text1 == null || text1.length() <= 0 || text2 == null || text2.length() <= 0) {
            return 0;
        }

        int length1 = text1.length();
        int length2 = text2.length();
        //length+1后，就不要考虑下标越界和赋予初始值的问题了
        int[][] dp = new int[length1 + 1][length2 + 1];

        /*
            遍历两个字符串:
                1、若 当前两个字符 相等：
                    当前状态 = 两个元素的前一个状态 + 1
                2、若 当前两个字符 不等：
                    当前状态 = 两个元素任一元素的前一个状态 的 最大值
         */
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[length1][length2];
    }


    public static void main(String[] args) {
        Problem1143 p=new Problem1143();
        p.longestCommonSubsequence("abcde","ace");
    }
}

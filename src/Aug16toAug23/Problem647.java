package Aug16toAug23;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/8/19 8:58
 * @description：给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 * @modified By：
 * @version: $
 */
public class Problem647 {
    //方法一 暴力法时间复杂度n^3 枚举所有字串+判断是否为回文
    public int countSubstrings(String s){
        int len=s.length();
        if (len<=1) return len;
        int count=0;
        for (int i = 0; i < len; i++) {
            for (int j=i;j<len;j++){
                if (isRev(s.substring(i,j+1))==true) count++;
            }
        }
        return count;

    }
    public boolean isRev(String s){
        if (s.length()<=1) return true;
        StringBuffer sb=new StringBuffer(s);
        String res=String.valueOf(sb.reverse());
        if (res.equals(s)) return true;
        else return false;
    }
    //暴力法的时间复杂度实在是太高了

    //用中心拓展法 中心拓展分为奇数串和偶数串。
    int num=0;
    public int countSubStrings(String s){
        for (int i = 0; i < s.length(); i++) {
            count(s,i,i);//从当前字符本身开始拓展奇数串
            count(s,i,i+1);//从当前字串和下一个字符开始，偶数个字串进行拓展
        }
        return num;
    }
    public void count(String s,int start,int end){
        //只有当前是回文串时再num++  一点有某个字符不相等，后面就不用再循环了因为一个字串不是回文，再拓展的也一定不是回文
        while (start>=0&&end<s.length()&&s.charAt(start)==s.charAt(end)){
            num++;
            start++;
            end++;
        }
    }
    //方法3 动态规划法
    public int countSubStrings2(String s){
        int count=0;
        int len=s.length();
        if (len<=1) return len;
        //默认都为false
        boolean[][] dp=new boolean[len][len];
        for (int j=0;j<len;j++){
            for (int i=0;i<=j;i++){
                if (i==j){
                    //单个字符
                    dp[i][j]=true;
                    count++;
                }
                //为什么需要判断两个字符呢，因为如果是两个字符，dp[i+1][j-1]会出错，并没有这个dp[][] 只有大于等于三个字符时才有这个
                else if (j-i==1&&s.charAt(i)==s.charAt(j)){
                    //如果是两个字符 相等时就是回文
                    dp[i][j]=true;
                    count++;
                }else if (j-i>1&&s.charAt(i)==s.charAt(j)&&dp[i+1][j-1]){
                    dp[i][j]=true;
                    count++;
                }
            }
        }
        return count;
    }

}

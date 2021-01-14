package tanxin;

import java.util.Arrays;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/12 9:40
 * @description：
 *
 * @modified By：
 * @version: $
 */
public class Problem455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int m=g.length-1;
        int n=s.length-1;
        int res=0;
        while(m>=0&&n>=0){
            //如果想让更多的孩子开心，就尽量不让大的饼干浪费
            //把最大的饼干分给最贪心的小朋友，否则把次大的饼干分为当前最贪心的小朋友
            if (s[n]>=g[m]){
                res++;
                m--;
                n--;
            }else{
                m--;
            }

        }
        return res;

    }
}

package Aug10toAug16;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/8/10 11:33
 * @description：给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。 重复出现的子串要计算它们出现的次数。  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/count-binary-substrings 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem696 {
    //last用来记录上一个数字的个数，last用来记当前数字的个数，当last>cur时，res++.
    public int countSubString(String s){
        int last=0,cur=1,res=0;
        for(int i=1;i<s.length();i++){
            //如果当前字符等于上一个字符，则cur++.
            if(s.charAt(i)!=s.charAt(i-1)){
                last=cur;
                cur=0;
                cur++;
            }else{

                cur++;
            }
            if(last>=cur) res++;
        }
        return res;
    }


}


package Aug24toAug30;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/8/24 8:44
 * @description：给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * @modified By：
 * @version: $
 */
public class Problem459 {
    public boolean repeatSubstringPattern(String s){
        int n=s.length();
        //对于任意的i输入后面的字串，都有s[i]=s[i-n']
        for (int i=1;i*2<=n;++i){
            //只对有整数个i的字符串进行判断
            if (n%i==0){
                boolean match=true;
                for(int j=i;j<n;j++){
                    if (s.charAt(j)!=s.charAt(j-i)){
                        match=false;
                        break;
                    }
                }
                if(match) return true;

            }
        }

        return false;
    }
    //拼接起来，去找s，如果是没有重复的，那么去掉第一个字符，indexof返回的位置是s的长度，如果有重复，则返回的不是这个
    public boolean repeatedStr(String s){
        return (s+s).indexOf(s,1)!=s.length();
    }
}

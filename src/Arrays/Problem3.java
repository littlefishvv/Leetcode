package Arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/9/17 10:33
 * @description：给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:  输入: "abcabcbb" 输出: 3  解释: 因为无重复字符的最长子串是 "abc"，所以其长度为
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：siyuan gao
 * @version: $
 */
public class Problem3 {

    //暴力法
    public int lengthOfLongestSubstring(String s){

        int sum=1;
        /* int size,i=0,k,j,max=0;
        size=s.length();
        for(j=0;j<size;j++){
            //这一层的循环是从前往后循环，思路非常巧妙，平常都是被动去查，这种思路是主动出击。
            for(k=i;k<j;k++){
                //如果从前往后找到一个字符和目前正在访问的字符相等，说明出现重复的了，要重新找出下标，这里的下标更新为k+1即出现相等后的下一个下标
               if(s.charAt(k)==s.charAt(j)){
                   i=k+1;
                   break;
               }

            }
            //如cadba经过上一层的循环后还要判断从出现重复字符后面开始到当前访问字符的长度是否是最长的长度，即使更新最长长度

            if(j-i+1>max)
                  max=j-i+1;
        }
       return max;*/

        return sum;
    }
    //滑动窗口解法
    public int lengthOfLongestSubstring1(String s){
        //扩展的ASCII总共有256个字符。 遇到一个s的字符，就把该数组对应的位置值+1，代表出现了一次
        int[] freq=new int[256];

        int l=0,r=-1;//滑动窗口s[l...r]
        int res=0;
        //比如aabb
        while(l<s.length()){
            //r+1,而不是r说明右边界还能拓展。 这里要对r+1设定一个范围
            if(r+1<s.length()&&freq[s.charAt(r+1)]==0){
                r++;
                freq[s.charAt(r)]++;
                //否则说明右边界无法拓展，这个时候要缩小窗口 缩小窗口的操作为让l所在下标数组元素--,然后l++
            }else{
                //别忘了把下标元素存在标注复原
                 freq[s.charAt(l)]--;
                 l++;
            }
            //经过了上面的滑动窗口，我们获得了一个无重复字符的字串
            res=Math.max(res,r-l+1);
        }
        return res;



    }
    public int lengthOfLongestSubstring2(String s){
        //扩展的ASCII总共有256个字符。 遇到一个s的字符，就把该数组对应的位置值+1，代表出现了一次
        //如果想不起来用这个256数组，可以用set来代替  但是很奇怪，用set之后，速度变得很慢，这是因为数组的长度是固定的那么时间复杂度就是o(1)而set的长度却可以随着
        //s的长度无限延申，极端情况下时间复杂度会变成o(n^2)
        Set<Character > set=new HashSet<>();
        int l=0,r=-1;
        int res=0;

        while(l<s.length()){
            //这个r++是由技巧的，正常情况下，r都应该++，因为r不加，后面就无法进行下去了
            if(r+1<s.length()&&!set.contains(s.charAt(r+1))&&r<s.length()-1){
                r++;
                set.add(s.charAt(r));
                //否则说明右边界无法拓展，这个时候要缩小窗口 缩小窗口的操作为让l所在下标数组元素--,然后l++
            }else{
                //把左边界元素移出set，左边界+1，然后继续右循环，这时候就可以把右边的元素放到set里去了
                set.remove(s.charAt(l));
                l++;
            }
            res=Math.max(res,r-l+1);
        }

        return res;



    }

}

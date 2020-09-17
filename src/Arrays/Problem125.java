package Arrays;

public class Problem125 {
    /*给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:

输入: "race a car"
输出: false
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-palindrome
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
    //注意 对于字符串的题绕不开几个问题  1.空字符串  2.大小写  3.空格
   /* public boolean isPalindrome(String s){
        //暴力法
        String a="";

        for(int i=0;i<s.length();i++){
            if(Character.isLetterOrDigit(s.charAt(i)))
            {
                //字符的相加并不是字符串相加,而是asci码对应的字符。
                a+=String.valueOf(s.charAt(i));

            }
        }
      a=a.toLowerCase();
        String s2=new StringBuffer(a).reverse().toString();
        if(a.equals(s2)) return true;
        else return false;}*/
   /*可以看到暴力法使用了多个库函数 1.Character.isLetterOrDigit(char) 2 String.toLowerCase
    3.StringBuffer.reverse()反转字符串
    */
    //如果使用碰撞指针呢
    public boolean isPalindrome(String str){
        String s=str.toLowerCase();
        int l=0;
        int r=s.length();
        while (l<r){
            if (Character.isLetterOrDigit(s.charAt(l))&&Character.isLetterOrDigit(s.charAt(r))){
                if (!(s.charAt(l)==s.charAt(r))){
                    return false;
                }
                //这里不能用else
                l++;
                r--;

            }
            if (!Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }
            if (!Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }
        }
        return true;
    }
}

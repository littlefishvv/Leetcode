package Aug10toAug16;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/8/16 11:27
 * @description：给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 示例 1:输入: num1 = "123", num2 = "456" 输出: "56088"
 * @modified By：
 * @version: $
 */
public class Problem43 {
    public String multiply(String num1,String num2){
        if (num1.equals("0")||num2.equals("0")) return "0";
        int l1=num1.length();
        int l2=num2.length();
        int len=l1+l2;
        char[] ans=new char[len];
        char[] c1=num1.toCharArray();
        char[] c2=num2.toCharArray();
        for (int i=l1-1;i>=0;i--){
            //根据asci码来得到这个数值，很巧妙

            //一开始ans存储的是一个一个的乘积，并没有进位这个操作。
            int c=c1[i]-'0';
            for (int j=l2-1;j>=0;j--){
                int cc=c2[j]-1;
                ans[i+j+1]+=c*cc;
            }
        }
        //再把数组中的数转换成正常的数
        //开始处理进位，大于9时开始进位,前一个位置+ans[i]/10，同时，当前位置保留进位后的值（ans[i]%10）。
        for(int i=len-1;i>0;--i){
            if (ans[i]>9){
                ans[i-1]+=ans[i]/10;
                ans[i]%=10;
            }
        }
        //如果是12*34最后结果是3位数，相当于0408，第一个0不算进去。如果是12*90=1080这样就是正好四位数
        StringBuffer sb=new StringBuffer();
        int i=0;
        //这里i加到了第一个不为0的数
        for(;;++i) if(ans[i]!=0) break;
        //(char)ans[i]+'0'相当于把数字转化为了字符。
        for (;i<ans.length;++i) sb.append((char) (ans[i]+'0'));
        return sb.toString();

    }

}

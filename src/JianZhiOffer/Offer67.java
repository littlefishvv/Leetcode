package JianZhiOffer;

import SetAndMap.Problem1;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/2/17 15:49
 * @description：
 * @modified By：
 * @version: $
 */
public class Offer67 {
    public int strToInt(String str) {
        if(str==null) return 0;
        int index=0;
        while(str.charAt(index)==' '){
            index++;
        }
        if(str.substring(0,index+1).length()==0) return 0;
        long res=0;
        boolean bigThanZero=true;

        while(str.charAt(index)=='-'||str.charAt(index)=='+'){
            //如果是以符号为开头的。
            if(str.charAt(index)=='-'){
                bigThanZero=!bigThanZero;
            }
            index++;
        }
        //从index开始 如果是数字则继续循环
        while(str.charAt(index)>=48&&str.charAt(index)<=57){
            res=res*10+(str.charAt(index)-'0');
            index++;
        }
        return (int)res;

    }

    public static void main(String[] args) {
        Offer67 of=new Offer67();
        System.out.println(of.strToInt("42"));

    }
}

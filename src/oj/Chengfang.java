package oj;

import org.omg.CORBA.INTERNAL;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/3/3 8:57
 * @description：
 * @modified By：
 * @version: $
 */
//序号乘方，计算1^2+2^2+...最多能加到几不大于p
public class Chengfang {
    //1到N的平方和推导：1²+2²+3²+。。。+n²=n（n+1)（2n+1）/6
    public static int cf(int k){
        long t=0;
        int c=1;
        while(k>0){
            t=c*c;
            if(t> Integer.MAX_VALUE) break;
            k= (int) (k-t);
            c++;
        }
        return c-1;

    }//这一题用二分法是不是更快一点

    public static void main(String[] args) {

        System.out.println(cf(14));
    }
    //补充一道快速计算pow(x,n)的leetcode习题

    public double myPow(double x, int n) {
        if(n==0) return 1;
        if(n == 1) return x;

        if(n == -1) return 1/x;

        double half=myPow(x,n/2);
        double mod=myPow(x,n%2);
        return half*half*mod;

    }

}

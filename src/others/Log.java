package others;

import java.math.BigDecimal;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/12/4 20:59
 * @description：
 * 进行对数计算
 * @modified By：
 * @version: $
 */
public class Log {

    public static void main(String[] args) {
        Fenshu f=new Fenshu(1);

        System.out.println(f.a);
        int k=0;
        f.test();
//        for (double i = 1; i < 100; i++) {
//
//            double t=-2*Math.log(10)/Math.log(2)+Math.log(i)/Math.log(2);
//            double sum=-i*t/100;
//            BigDecimal b   =   new   BigDecimal(t);
//            BigDecimal c   =   new   BigDecimal(sum);
//            double   f1   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
//            double   f2   =   c.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
//            if (k==4) {
//                System.out.println();
//                k=1;
//            }
//            else k++;
//            System.out.print("| log0."+String.valueOf((int)i)+"="+f1+":"+"-*="+f2+" | ");
//        }
    }


}

package others;

import java.math.BigDecimal;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/12/10 21:33
 * @description：
 * @modified By：
 * @version: $
 */
 public class Fenshu {
    public  static int t=0;
    public  int a=1;

    public void draw(){
        System.out.println("父类画"+a);
    }
    public Fenshu(int a) {
        this.draw();
        System.out.println("父类的a"+a);
    }

    public void fenshu(int n){
        while(n>=2){
            for (int i = 1; i < n; i++) {
                BigDecimal b=new BigDecimal((double)i/n);
                double r=b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();

                System.out.println(i+"/"+n+"=="+r);
            }
            n--;
        }


    }

    protected void test(){
        System.out.println("nihao");
    }
    public static void main(String[] args) {
        Fenshu f=new Fenshu(1);

    }
}

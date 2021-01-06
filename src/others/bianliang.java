package others;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/12/23 10:39
 * @description：
 * @modified By：
 * @version: $
 */
public class bianliang {
    static Integer change(Boolean f,Integer n){
        f=false;
        //n=new Integer(5);
        n=5;
        return n;
    }

    public static void main(String[] args) {
       /* Boolean f=true;
        Integer n=new Integer(5);
        Integer a=new Integer(5);
        Integer d=Integer.valueOf(5);
        Integer b=5;
        System.out.println(a==n);
        System.out.println(b==n);
        Integer c=change(f,n);
        System.out.println(c==n);
        System.out.println(String.format("%1$b,%2$d",f,n));*/
        System.out.println("------------------------");
            Integer t=Integer.valueOf(12);
            Integer a = 1;
            Integer b = 2;
            Integer c = 3;
            Integer d = 3;
            Integer e = 321;
            Integer f = 321;
            Long g = 3L;
            Long h = 2L;

            System.out.println(c==d);//true
            System.out.println(e==f);//false
            System.out.println(c==(a+b));//true
            System.out.println(c.equals(a+b));//true
            System.out.println(g==(a+b));//true
            System.out.println(g.equals(a+b));//这里之所以返回false，是因为equals首先判断的类型，a+b是integer类型而不是long类型
            System.out.println(g.equals(a+h));//这里返回true,是因为向上转型为long了对于a+h，先自动触发拆箱，就变成了int类型和long类型相加，这个会触发类型晋升，结果是long类型的，然后会触发装箱过程，就变成Long了。因此比较结果是true

            int t1=3;
            long t2=3;
            System.out.println(t1==t2);
            String s1=new String("abc");
            String s2=new String("abc");
            String s3="abc";
            System.out.println(s1.equals(s2));
            System.out.println(s1==s2);
            System.out.println(s3==s1);

            String s4="ab"+"c";
            String s5="a"+"bc";
            System.out.println(s3==s4);
            System.out.println(s4==s5);
        String s6 = "ab" + "cd";

        String s7 = "abc" + "d";

        System.out.println( s6 == s7);
        System.out.println(("ab" + "cd" )== s7);


        }

}

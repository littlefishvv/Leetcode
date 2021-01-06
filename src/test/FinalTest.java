package test;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/12/17 11:09
 * @description：
 * @modified By：
 * @version: $
 */
public class FinalTest {
    private final static Value v=new Value(2);

    public static void main(String[] args) {
        FinalTest ff=new FinalTest();
        System.out.println(v.toString());


    }
}

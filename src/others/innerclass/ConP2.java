package others.innerclass;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/12/17 19:52
 * @description：
 * @modified By：
 * @version: $
 */
public class ConP2 implements Product{
    @Override
    public void method1() {
        System.out.println("p2的方法1");
    }

    @Override
    public void method2() {
        System.out.println("p2的方法2");
    }
    public static Factory factory=new Factory() {
        @Override
        public Product getProduct() {
            return new  ConP2();
        }
    };
}


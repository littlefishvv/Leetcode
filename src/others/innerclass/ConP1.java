package others.innerclass;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/12/17 19:51
 * @description：
 * @modified By：
 * @version: $
 */
public class ConP1 implements Product {
    @Override
    public void method1() {
        System.out.println("p1的方法1");
    }

    @Override
    public void method2() {
        System.out.println("p1的方法2");
    }
    //这个匿名内部类和具体工厂属于同样的效果
    public static Factory factory=new Factory() {
        @Override
        public Product getProduct() {
            return new  ConP1();
        }
    };
}

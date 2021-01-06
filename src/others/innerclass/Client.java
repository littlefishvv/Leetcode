package others.innerclass;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/12/17 19:58
 * @description：
 * @modified By：
 * @version: $
 */
public class Client {

    public static void productCom(Factory f){
        Product p=f.getProduct();
        p.method1();
        p.method2();
    }

    public static void main(String[] args) {
        //给productCom传入一个工厂，这个工厂知道生产什么产品，可以通过这个工厂获得产品
        productCom(ConP1.factory);
        productCom(ConP2.factory);
    }
}

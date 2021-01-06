package others.oo;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/12/19 10:02
 * @description：
 * @modified By：
 * @version: $
 */
public class B {
    //这样是能影响实参的
    public void aname(A a){
        a.name = "nihao";
    }

    //这样是不能影响实参的
    public void aname1(A a){
        a=new A("test");
    }

    public static void main(String[] args) {
        A aa=new A();
        aa.name="cc";
        B b=new B();
        //不管aa还是a指向的都是同一个对象，一个变了另一个也要变。
        b.aname(aa);
        System.out.println(aa.name);
        A aa1=new A("cds");
        //这个a指向了另一个对象，故不会对实参做出改变  同理如果在方法内使a=null也只是摧毁了这个引用，不让他指向这个对象而已
        b.aname1(aa1);
        System.out.println(aa1.name);
    }
}

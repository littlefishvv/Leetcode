package others;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/12/17 17:01
 * @description：
 * @modified By：
 * @version: $
 */
public class OuterClass {
    class innerClass{
        innerClass(){
            System.out.println("内部类");
        }
        public OuterClass getout(){
            return OuterClass.this;
        }
   }
    //匿名内部类
    public Contents content(){
        return new Contents(){
            private int i=1;
            public int value(){
                return i;
            }
        };
    }
    //如果contents需要构造函数参数的匿名内部类
    public Contents content(int x){
        return new Contents(x){
            private int i=1;
            public int value(){
                return i;
            }
        };
    }
    public innerClass getin(){
        return new innerClass();
    }
    public static void main(String[] args) {
        OuterClass o=new OuterClass();
        OuterClass.innerClass in=o.getin();
        OuterClass.innerClass in1=o.new innerClass();

    }
}

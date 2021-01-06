package test;

import others.Fenshu;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/12/17 10:22
 * @description：
 * @modified By：
 * @version: $
 */
public class Son1 extends Fenshu {
    int a=5;
    public Son1(){
        super(1);
        draw();
    }

    @Override
    public void draw() {
        System.out.println("子类画"+a);
    }

    public static void main(String[] args) {
        Son1 s=new Son1();
        System.out.println("你好");
    }
}

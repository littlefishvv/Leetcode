package JianZhiOffer;

import java.util.LinkedList;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/2/1 15:23
 * @description：
 * @modified By：
 * @version: $
 */
//用两个栈模拟一个队列 栈先进后出，队列先进先出
public class Offer09 {
    LinkedList<Integer> stack1;
    LinkedList<Integer> stack2;

    public Offer09() {
        stack1=new LinkedList();
        stack2=new LinkedList();
    }

    //入队
    public void appendTail(int value) {
        stack1.add(value);

    }
    //出队
    public int deleteHead() {
        //当两个栈都是空，就返回-1
        if(stack2.isEmpty()){
            if(stack1.isEmpty()){
                return -1;
            }
            //如果栈1不空，但是栈2是空的，就把栈1内的所有元素都放入栈2中 这样栈2的pop就是栈1的头部，在这期间栈1依然正常放入
            while(!stack1.isEmpty()){
                stack2.add(stack1.pop());
            }
            return stack2.pop();
        }else{
            //如果栈2不空，就直接返回栈2的上面，当栈2为空了，再把这期间插入栈1的元素再放入栈2中，
            return stack2.pop();
        }

    }
    //用两个队列模拟一个栈，
}

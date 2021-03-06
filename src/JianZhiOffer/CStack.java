package JianZhiOffer;

import javafx.css.CssMetaData;

import java.util.LinkedList;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/2/1 15:33
 * @description：
 * @modified By：
 * @version: $
 */
//用两个队列模拟一个栈 栈后进先出
public class CStack {
    //这一题的关键在于始终让一个队列保持为空，非空的队列往空栈里迁移

    LinkedList<Integer> queue1;
    LinkedList<Integer> queue2;
    public CStack(){
        queue1=new LinkedList<>();
        queue2=new LinkedList<>();

    }
    public void appendTail(int value) {
        if (!queue1.isEmpty()){
            queue1.addLast(value);
            System.out.println("队1加入了"+value);
        }else{
            queue2.addLast(value);
            System.out.println("队2加入了"+value);
        }

    }
    //每次模拟出栈都要让那个有元素的队列迁移到空队列中，最后只含一个元素，让这个元素出队，出队后，则只有一个队列是有
    //元素的，那么入栈就是入这个有元素的队列。
    public int deleteTail() {
        //如果删除栈尾元素  这里的queue要加入到末尾来模拟队列
        //把一个队列中的元素出队放到另一个队列中，然后生的哪一个出队就相当于出栈
        if (!queue1.isEmpty()){
            while(queue1.size()!=1){
                queue2.addLast(queue1.poll());
            }
            return queue1.poll();


        }else if (!queue2.isEmpty()){
            while(queue2.size()!=1){
                queue1.addLast(queue2.poll());
            }
            return queue2.poll();

        }else{
            //如果都为空则返回-1
            return -1;
        }


    }

    public static void main(String[] args) {
        CStack c=new CStack();

        c.appendTail(2);

        c.appendTail(3);
        System.out.println(c.deleteTail());
        c.appendTail(4);
        System.out.println(c.deleteTail());
        System.out.println(c.deleteTail());
        System.out.println(c.deleteTail());

    }
}

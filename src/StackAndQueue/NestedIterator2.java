package StackAndQueue;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/11/21 16:24
 * @description：用组合模式实现nest迭代器
 * @modified By：
 * @version: $
 */
public class NestedIterator2 implements Iterator<Integer> {

    Stack stack=new Stack();
    public NestedIterator2(Iterator iterator){
        stack.push(iterator);
    }
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Integer next() {
        return null;
    }
}

package StackAndQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/11/8 16:59
 * @description：
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 *
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-nested-list-iterator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
//todo 学好组合模式后，再用组合模式重构一遍
public class NestedIterator implements Iterator<Integer> {
    private int cursor=0;
    private ArrayList<Integer> stack;
    private int maxCursor=0;



    public NestedIterator(List<NestedInteger> nestedList) {
        stack=new ArrayList<Integer>();
        for (int i = 0; i < nestedList.size(); i++) {
            addNestToStack(nestedList.get(i));
        }
    }

    public void addNestToStack(NestedInteger nestedInteger){
        if (nestedInteger.isInteger()){
            stack.add(nestedInteger.getInteger());
            maxCursor++;
        }else{
            List<NestedInteger> list=nestedInteger.getList();
            for (NestedInteger nestedInteger1:list){
                addNestToStack(nestedInteger1);
            }
        }
    }

    @Override
    public boolean hasNext() {

        return cursor<maxCursor;
    }

    @Override
    public Integer next() {

        return stack.get(cursor++);
    }
}

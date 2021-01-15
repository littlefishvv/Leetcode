package StackAndQueue;

import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/11/8 17:02
 * @description：
 * @modified By：
 * @version: $
 */
public interface NestedInteger {
          // @return true if this NestedInteger holds a single integer, rather than a nested list.
     public boolean isInteger();

          // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
     public Integer getInteger();
              // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
     public List<NestedInteger> getList();

}
package others.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/12/19 14:11
 * @description：
 * @modified By：
 * @version: $
 */
public class ListTest {
    public static void main(String[] args) {
        ArrayList<Integer> a=new ArrayList<>(Arrays.asList(1,3,5));
        a.add(4);
        print(a);
    }
    public static void print(List<Integer> l){
        for (Integer n:l){
            System.out.println(n);
        }
    }
}

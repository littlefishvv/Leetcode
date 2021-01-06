package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/12/26 15:36
 * @description：
 * @modified By：
 * @version: $
 */
public class Transfer {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>(Arrays.asList(1,2,3,4,5));
        Iterator it=list.iterator();
        while (it.hasNext()){
           int a= (int) it.next();
        }
    }
}

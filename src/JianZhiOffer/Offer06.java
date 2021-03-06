package JianZhiOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/31 21:59
 * @description：
 * @modified By：
 * @version: $
 */
public class Offer06 {
    public int[] reversePrint(ListNode head) {
        if(head==null) return new int[0];
        //这里用栈更好
        List<Integer> list=new ArrayList();
        while(head!=null){
            list.add(head.val);

            head=head.next;
        }
        int[] res=new int[list.size()];
        for(int i=list.size()-1;i>=0;i--){
            res[list.size()-i-1]=list.get(i);
        }
        return res;

    }
    
}

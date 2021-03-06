package oj;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/2/25 21:16
 * @description：
 * @modified By：
 * @version: $
 */
public class MergeKNode {
    public ListNode mergeKLists(ListNode[] lists){
        if(lists.length==0) return null;
        if(lists.length==1) return lists[0];
        int n=lists.length;
        //小根堆
        Queue<ListNode> queue=new PriorityQueue<>(new Comparator<ListNode>(){


            public int compare(ListNode o1, ListNode o2){
                return o1.val-o2.val;
            }
        });

        for(int i=0;i<n;i++){
            //在往queue里放入之前都要先判断以下
            if(lists[i]!=null){
                queue.offer(lists[i]);
            }

        }
        ListNode res=new ListNode(-1);
        ListNode head=res;
        while(!queue.isEmpty()){
            ListNode node=queue.poll();
            head.next=node;
            head=head.next;
            //在往queue里放入之前都要先判断以下 不为空才放入
            if(node.next!=null){
                queue.offer(node.next);
            }

        }
        return res.next;

    }
}

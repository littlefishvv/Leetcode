package ListNode;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/10/21 15:46
 * @description：
 *
给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

示例 1:

输入: 1->1->2
输出: 1->2
示例 2:

输入: 1->1->2->3->3
输出: 1->2->3
 * @modified By：
 * @version: $
 */
public class Problem83 {
    public ListNode deleteDuplicates(ListNode head) {

        //只有有next的地方，都要判断是否为空
        if(head==null) return head;
        //用双指针 前指针用于寻找下一个不相等的数，后指针用于更新指向返回结果
        ListNode cur=head.next;
        ListNode res=head;
        while(cur!=null){
            //寻找和后指针不一样的节点，然后更新后指针的指向
            if (res.val!=cur.val){
                //找到了，更新后指针的指向
                res.next=cur;
                //让后指针成为当前指针
                res=res.next;
                //让当前指针后移，进行下一步的判断。
                cur=cur.next;
            }else{
               cur=cur.next;
               //这里要再判断一个，因为如果只有上面的判断条件，当最后那几个为相同时，节点的res的指向不会进行更新。
               if(cur==null){
                   res.next=null;
               }
            }
        }


        return head;

    }
    //用递归来解决这一题
    public ListNode deleteDuplicates1(ListNode head) {
        //终止条件
        if(head==null||head.next==null) return head;


        //看似是对前两个节点的操作，实际上是做所有节点的操作
        if (head.next.val==head.val){
            return deleteDuplicates1(head.next);
        }else{
            head.next=deleteDuplicates1(head.next);
            return head;
        }
    }
}

package ListNode;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/10/21 15:49
 * @description：
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead=new ListNode(0);
        ListNode p=dummyHead;
        int t=0;
        while(l1!=null||l2!=null){
            //val是取整过后的 t是余数
            int val=0;
            //对三种情况都要判断，然后取整和区域
            if (l1!=null&&l2!=null){

                val=(l1.val+l2.val+t)%10;
                t=(l1.val+l2.val+t)/10;
                l1=l1.next;
                l2=l2.next;
            }else if(l1!=null&&l2==null){
                val=(l1.val+t)%10;
                t=(l1.val+t)/10;
                l1=l1.next;
            }else{
                val=(l2.val+t)%10;
                t=(l2.val+t)/10;
                l2=l2.next;
            }


            p.next=new ListNode(val);
            p=p.next;


        }
        if (t!=0) p.next=new ListNode(t);

        return dummyHead.next;
    }
}

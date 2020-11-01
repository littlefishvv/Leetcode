package ListNode;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/10/21 16:33
 * @description：
 * 对链表就行插入排序
 *  * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *  示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @modified By：
 * @version: $
 */
public class Problem147 {
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode hair=new ListNode(Integer.MIN_VALUE);
        hair.next=head;
        ListNode temp=head.next;
        head.next=null;

        while(head!=null){
            ListNode q=hair;
            //一趟插入
            while (q!=null&&head.val>q.val){
                q=q.next;
            }
            q.next=head;
            temp=head.next;
            head.next=null;
            head=temp;
        }

        //没有必要判断什么时候 该值在某两个值的中间，只需要一直循环判断该值是否大于某值，然后一直next.当该值不在大于那个节点next的值时。就找到了

        return hair.next;

    }



    //下面这个方法，是保持head一直不断。
    public ListNode insertionSortList1(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode dummyHead=new ListNode(0);
        ListNode pre=null;
        dummyHead.next=head;

        while (head!=null&&head.next!=null){
            //找需要寻找插入位置的节点 最后head停在要插入节点得前一个节点上，也就是head.next就是那个未排序得node
            //head就是插入后节点的
            if (head.val<=head.next.val){
                head=head.next;
                //加个continue是为了不执行下面的代码，直接进行下次的循环。
                continue;
            }
            //pre指针每次从表头遍历寻找插入位置。每次都要更新pre到最前面的节点
            pre=dummyHead;
            //寻找插入位置的前节点  最后得到的是 pre.next就是要接上head.next的
            while (pre.next.val<head.next.val) pre=pre.next;
            //head是原要插入节点的前节点  现在把这个节点用cur记录下来以便插入
            ListNode curr=head.next;
            //移除curr这个节点 去插到另一个地方，但又保持head节点不断
            head.next=curr.next;
            //让当前节点插入pre的后面
            curr.next=pre.next;
            //把pre和当前节点连上
            pre.next=curr;

        }
        return dummyHead.next;


    }
    //方法2 归并排序
    //思路，寻找链表中点，形成两段链表，然后合并两端链表
    public ListNode sortList1(ListNode head){

        return head==null? null:mergeSort(head);
    }
    //
    public ListNode mergeSort(ListNode head){
        if(head.next==null){
            return head;
        }
        ListNode p=head,q=head,pre=null;

        while(q!=null&&q.next!=null){
            p=p.next;
            q=q.next.next;
        }

        pre=p.next;
        p.next=null;

        ListNode l=mergeSort(head);
        ListNode r=mergeSort(pre);
        return merge(l,r);
    }
    public ListNode merge(ListNode l,ListNode r){
        ListNode dummyHead=new ListNode(0);
        ListNode cur=dummyHead;
        while(l!=null&&r!=null){
            if (l.val<r.val){
                cur.next=l;
                cur=cur.next;
                l=l.next;
            }else{
                cur.next=r;
                cur=cur.next;
                r=r.next;
            }

        }
        if (l!=null) cur.next=l;
        if(r!=null) cur.next=r;

        return dummyHead.next;
    }

}

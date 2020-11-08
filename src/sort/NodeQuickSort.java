package sort;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/11/2 8:38
 * @description：链表快速排序
 * @modified By：
 * @version: $
 */
public class NodeQuickSort {


    //这个解法是错误的噢 todo
    public static  ListNode quickSort(ListNode head,ListNode end){
        if (head==null||head.next==null) return head;
        ListNode head1,head2,end1,end2;
        head1=head2=end1=end2=null;
        //p是随着主链表一起移动，pre1随着小于key的链接（以head1为开头的链接）一起移动，pre2随着大于等于key的链接（以head2为开头的链接一起移动）
        ListNode p,pre1,pre2;
        p=pre1=pre2=null;
        int key=head.val;//记录下基准值

        p=head.next;
        head.next=null;//把head节点孤立出来
        while(p!=null){
            //构建小于key的链表
            if (p.val<key){
                //先给head1赋予头节点
                if(head1==null){
                    head1=p;
                    //让pre1等于head1的移动下标
                    pre1=p;

                }else
                //当head1不为空了，在往后加节点
                {
                    pre1.next=p;
                    pre1=p;
                }
                p=p.next;
                pre1.next=null;
            }else{
                //同上
                if (head2==null){
                    head2=p;
                    //让pre2等于head2的移动下标
                    pre2=p;
                }else{
                    pre2.next=p;
                    pre2=p;
                }
                p=p.next;
                pre2.next=null;
            }

        }

        end1=pre1;
        end2=pre2;


        //对左右两个链表进行快排
        quickSort(head1,end1);
        quickSort(head2,end2);

        //以基准值为中心进行拼接
        if (end1!=null&&head2!=null){
            end1.next=head;
            head.next=head2;
            head=head1;
            end=end2;
        }else if (end1!=null&&head2==null){
            end1.next=head;
            end=head;
            head=head1;
        }
        else if (head2!=null&&head1==null){
            head.next=head2;
            end=end2;

        }

        return head;


    }

    public static void quicksort(ListNode start_pre, int len, ListNode end){
        if (len <= 1)
            return;
        ListNode start = start_pre.next;
        int pivot_val = start.val;
        //用split_position记录下基准值一次partitoon后的位置。
        int split_position = 0;

        //temp0是基准值前面的节点的末尾节点 temp1是基准值后面的节点的末尾节点
        ListNode temp0 = start;
        ListNode temp1 = start.next;
        for (int i = 1; i < len; i ++){
            //如果该节点值大于基准值，那么应该放到基准值的右边
            if (temp1.val > pivot_val){ //放到链表末尾
                if (temp1 != end){
                    //这三句是把temp1独立出来。以便接入到end后面去。
                    temp0.next = temp1.next;
                    temp1.next = end.next;
                    end.next = temp1;
                    end = temp1;
                    temp1 = temp0.next;
                }
            }
            else{
                temp1 = temp1.next;
                temp0 = temp0.next;

                split_position ++;
            }
        }
        ListNode pivot_node = start;
        if (temp0 != start){
            start_pre.next = pivot_node.next;
            temp0.next = pivot_node;
            pivot_node.next = temp1;
        }
        quicksort(start_pre, split_position, temp0);
        quicksort(pivot_node, len - split_position - 1, end);
    }

    public ListNode sortList(ListNode head){
        return quickSort1(head);
    }
    public static ListNode quickSort1(ListNode head){
        if (head==null||head.next==null) return head;
        int pivot=head.val;

        //ls和rs分别是左端和有段的头节点  l，r分别是左端右端的尾节点
        ListNode ls=new ListNode(-1);
        ListNode rs=new ListNode(-1);
        ListNode l=ls,r=rs,cur=head;
        while(cur!=null){
            if (cur.val<pivot){
                l.next=cur;
                l=l.next;
            }
            else{
                r.next=cur;
                r=r.next;
            }
            cur=cur.next;
        }

        //把左右节点拼接起来
        l.next=rs.next;
        r.next=null;


        //先重排后面的，再把指针置空，再重排左边的
        ListNode right=quickSort1(head.next);
        right.next=null;
        ListNode left=quickSort1(ls.next);
        cur=left;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=right;
        return left;
    }


    static void printList(ListNode head){
        ListNode curNode=head;
        StringBuffer s=new StringBuffer();
        while (curNode!=null){
            s.append(curNode.val).append("--->");

            curNode=curNode.next;
        }
        System.out.println(s.toString());
    }
    public static void main(String[] args) {
        ListNode head=new ListNode(4);
        head.next=new ListNode(2);
        head.next.next=new ListNode(1);
        head.next.next.next=new ListNode(3);
        head.next.next.next.next=null;
        ListNode end=head.next.next.next;
        ListNode pre=new ListNode(0);
        pre.next=head;
        printList(head);
        quicksort(pre,4,end);
        printList(pre.next);

    }
}

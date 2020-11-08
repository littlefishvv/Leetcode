package sort;

public class NodeMergeSort {

    //注意，这样可不算完，这不是链表的归并排序，这只是合并两个有序的链表（特地强调有序）！！！！
    public static ListNode  nodeMergeSort(ListNode head){


        if (head==null||head.next==null) return head;
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        ListNode n=dummyHead;

        ListNode fast=head;
        ListNode slow=head;
        ListNode last=null;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;

        }
        last=slow.next;
        slow.next=null;
        while(head!=null&&last!=null){
            if (head.val<=last.val){
                n.next=head;
                head=head.next;
            }
            else{
                n.next=last;
                last=last.next;
            }
            n=n.next;
        }

        if(last!=null){
            n.next=last;
            n=n.next;
        }

        if(head!=null){
            n.next=head;
            n=n.next;
        }
        return dummyHead.next;
    }



    //下面才是真正的归并排序！！！！
/*
*
对数组做归并排序的空间复杂度为 O(n)O(n)，分别由新开辟数组O(n)O(n)和递归函数调用O(logn)O(logn)组成，而根据链表特性：

数组额外空间：链表可以通过修改引用来更改节点顺序，无需像数组一样开辟额外空间；
递归额外空间：递归调用函数将带来O(logn)O(logn)的空间复杂度，因此若希望达到O(1)O(1)空间复杂度，则不能使用递归。
根据链表特性：

数组额外空间：链表可以通过修改引用来更改节点顺序，无需像数组一样开辟额外空间；
递归额外空间：递归调用函数将带来O(logn)O(logn)的空间复杂度，因此若希望达到O(1)O(1)空间复杂度，则不能使用递归。
* */
    public ListNode sortList(ListNode head) {
        // 1、递归结束条件
        if (head == null || head.next == null) {
            return head;
        }

        // 2、找到链表中间节点并断开链表 & 递归下探
        ListNode midNode = middleNode(head);
        ListNode rightHead = midNode.next;
        midNode.next = null;
        //对左边链表进行排序
        ListNode left = sortList(head);
        //对右边链表进行排序
        ListNode right = sortList(rightHead);

        // 3、当前层业务操作（合并有序链表）
        return mergeTwoLists(left, right);
    }

    //  找到链表中间节点（876. 链表的中间结点）
    private ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // 合并两个有序链表（21. 合并两个有序链表）
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentry = new ListNode(-1);
        ListNode curr = sentry;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        curr.next = l1 != null ? l1 : l2;
        return sentry.next;
    }


    //但是有一点，有时候面试官会让会迭代方法写归并排序，要求空间复杂度为o（1）todo 所以我们需要用迭代的方式实现常数级的时间复杂度。
    public ListNode sortList1(ListNode head) {
        int length = getLength(head);
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        for(int step = 1; step < length; step*=2){ //依次将链表分成1块，2块，4块...
            //每次变换步长，pre指针和cur指针都初始化在链表头
            ListNode pre = dummy;
            ListNode cur = dummy.next;
            while(cur!=null){
                ListNode h1 = cur; //第一部分头 （第二次循环之后，cur为剩余部分头，不断往后把链表按照步长step分成一块一块...）
                ListNode h2 = split(h1,step);  //第二部分头  在split中 h1最后指向了null
                cur = split(h2,step); //剩余部分的头  同时h2在最后指向了空，那么下面就能进行合并操作了
                ListNode temp = merge(h1,h2); //将一二部分排序合并 同时cur会继续循环下去
                pre.next = temp; //将前面的部分与排序好的部分连接
                while(pre.next!=null){
                    pre = pre.next; //把pre指针移动到排序好的部分的末尾
                }
            }
        }
        return dummy.next;
    }
    public int getLength(ListNode head){
        //获取链表长度
        int count = 0;
        while(head!=null){
            count++;
            head=head.next;
        }
        return count;
    }
    public ListNode split(ListNode head,int step){
        //断链操作 返回第二部分链表头
        if(head==null)  return null;
        ListNode cur = head;
        for(int i=1; i<step && cur.next!=null; i++){
            cur = cur.next;
        }
        ListNode right = cur.next;
        cur.next = null; //切断连接
        return right;
    }
    public ListNode merge(ListNode h1, ListNode h2){
        //合并两个有序链表
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while(h1!=null && h2!=null){
            if(h1.val < h2.val){
                p.next = h1;
                h1 = h1.next;
            }
            else{
                p.next = h2;
                h2 = h2.next;
            }
            p = p.next;
        }
        if(h1!=null)    p.next = h1;
        if(h2!=null)    p.next = h2;

        return head.next;
    }

}

#五.在链表中穿针引线，
这个针线，就是next指针，我们对链表的操纵，就是在操纵这个指针指向哪里和怎么指向。
题目顺序：206  96 83 86 328 2 445  203 82 21
24 25 147 148

小技巧，建立一个虚拟头节点。
不仅仅是穿针引线 237
双指针，对撞指针技巧19 61 143

再获得某个节点的val和next之前，一定要考虑当前节点是否为空。
当有p.next=x时。要习惯性的写上p=p.next以便更新指针，。

还有链表的插入，有头插入和尾插入 要灵活应用
如果是尾插汝，就是
ListNode head=null;
ListNode node=new ListNode();
node.next=head;
head=node;


还有就是，有些困难的链表（尤其是关于重复节点的问题），用递归法反而更简单，比如203 82 83

还有一些耍小聪明的比如链表转数组然后sort再转链表之类的，这种面试不能通过。


147题没有太搞懂。

找中间节点
如果while(q.next!=null&&q.next.next!=null){
              p=p.next;
              q=q.next.next;
          }
          找到的p为中间的前一个，如1234找到的是2
          
          
 如果是
 while(q!=null&&q.next!=null){
               p=p.next;
               q=q.next.next;
           }
           这样找到的p是后一个，1234找到的是3
           
           
  对于链表来说，非常建议用前者，因为链表最重要的就是找到前面那个节点。
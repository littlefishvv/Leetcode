package Hot100;

import java.util.*;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/14 11:20
 * @description：
 * @modified By：
 * @version: $
 */
public class Problem146 {

    //首先明确用什么数据结构存储 需要用到一个哈希表和一个双向链表
    /*时间复杂度：对于 put 和 get 都是 O(1)O(1)。

空间复杂度：O(\text{capacity})O(capacity)，因为哈希表和双向链表最多存储 \text{capacity} + 1capacity+1 个元素。

    *我们首先使用哈希表进行定位，找出缓存项在双向链表中的位置，随后将其移动到双向链表的头部，即可在 O(1)O(1) 的时间内完成 get 或者 put 操作。具体的方法如下：
    哈希表和链表都存储了所有的键值对，哈希表提供一个快速的get操作，但是它不能用来确切的删除哪一个，那么双向链表的作用就是维护最该删除的放在最末尾，然后获取末尾元素，再从哈希表中删除这个元素。

    * */

    //构造一个双向链表数据结构
    class LinkedNode{
        int key ;
        int value;
        //前指针
        LinkedNode prev;
        //后指针
        LinkedNode next;
        public LinkedNode(){}
        public LinkedNode(int key,int value){
            this.key=key;
            this.value=value;
        }
    }

    //用于存储
    Map<Integer,LinkedNode> cache=new HashMap<>();
    //size是变化的，代表有多少元素
    int size;
    //capacity是不变的
    int capacity;



    //定义一个伪首部和伪尾部
    private LinkedNode tail,head;



    public Problem146(int capacity) {
        this.capacity=capacity;
        this.size=0;
        head=new LinkedNode();
        tail=new LinkedNode();
        //首尾双向链路
        head.next=tail;
        tail.prev=head;
   }

    public int get(int key) {
        LinkedNode node=cache.get(key);

        if (node==null){
           return -1;
        }
        //把key对应的结点移动到头部这里是moveto 而不是addto，因为我们需要删除这个结点再重新添加
        moveToHead(node);
        return node.value;


    }

    public void put(int key, int value) {
        LinkedNode node=cache.get(key);
        if(node==null){
            //如果是新结点
            LinkedNode newNode=new LinkedNode(key,value);
            cache.put(key,newNode);
            //添加到头节点
            addToHead(newNode);

            ++size;
            if (size>capacity){
                //如果容量不够了就删除尾部结点，尾部是最近一直都没有访问的结点
                LinkedNode tail=removeTail();
                //根据key删除结点
                cache.remove(tail.key);
                --size;

            }

        }else{
            //如果该结点已经存在。则更新该结点，并移动到头部 这个结点改变了其实cache中也会改变的。
            node.value=value;
            moveToHead(node);
        }

    }

    //添加到头部，需要更新四个链接
    private void addToHead(LinkedNode node){
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
    }
    //返回删除的尾部结点
    private LinkedNode removeTail(){
        //ta/////////】il.prev一定是尾部结点。
        LinkedNode res=tail.prev;
        removeNode(res);
        return res;
    }
    //删除尾部结点
    private void removeNode(LinkedNode node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    //移动到头部，需要把当前结点删除【一定不要忘了在链表中删除当前结点】，然后再插入到头部，而不是顺着指针移动到头部
    private void moveToHead(LinkedNode node){
        removeNode(node);
        addToHead(node);
    }

}

package oj;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/2/24 21:42
 * @description：
 * @modified By：
 * @version: $
 */

//合并k个有序数组
public class MergeKArr {
    public static void main(String[] args) {
        int[] a={1,2,5};
        int[] b={2,3,6};
        int[] c={1,6,8};
        int[][] arrs=new int[3][3];
        arrs[0]=a;
        arrs[1]=b;
        arrs[2]=c;
        mergekArr(arrs);

        
    }
    static class Node{
        int value;
        int index;
        public Node(int value,int index){
            this.value=value;
            this.index=index;
        }

    }

    public static  void mergekArr(int[][] arrs){
        int m=arrs.length;
        if(m==0) return;
        int n=arrs[0].length;
        /*
        * 创建一个大小为n*k的数组保存最后的结果
     创建一个大小为k的最小堆，堆中元素为k个数组中的每个数组的第一个元素
     重复下列步骤n*k次：
     每次从堆中取出最小元素（堆顶元素），并将其存入输出数组中
     用堆顶元素所在数组的下一元素将堆顶元素替换掉，
     如果数组中元素被取光了，将堆顶元素替换为无穷大。每次替换堆顶元素后，重新调整堆n*mlogn */

        //申请一个m*n大小的数组保存结果
        int[] res=new int[m*n];
        //申请一个大小为m的小根堆 默认就是小根堆
        Queue<Node> queue=new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.value-o2.value;
            }
        });
        //用index[i]来记录取出的是第i行现在是已经遍历到哪一个元素下标了 从堆中取出的元素是node，那么node.index就是其对应的行
        //相应的index[node.index]应当加1
        int[] index=new int[n];

        //map(value,row)
        for(int i=0;i<m;i++){
            Node node=new Node(arrs[i][index[i]++],i);
            queue.offer(node);
        }
        //经过了上面的循环，index数组所有都处于下标为1的位置
        int k=0;
        while(k<m*n){
            Node min=queue.poll();
            //把当前堆顶放入结果数组
            res[k++]=min.value;
            //堆顶对应行的元素下标应当加一
            if(index[min.index]<n){
                queue.offer(new Node(arrs[min.index][index[min.index]],min.index));
                index[min.index]++;
            }
        }
        System.out.println(Arrays.toString(res));





    }

}

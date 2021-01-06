package StackAndQueue;

import java.util.*;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/11/10 17:45
 * @description：
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * @modified By：
 * @version: $
 */
public class Problem347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int[] res=new int[k];
        /*一个比较简便的写法是这样的
        *  Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }
        */
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }

        });
        for (int i=0;i<k;i++){
            res[i]=list.get(i).getKey();
        }


        return res;

    }


    //当然也可以用优先队列来做 从执行速度上来说，优先队列的速度要远远高于上面那个写法 面试的时候用这种方法。
    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //构建最小堆
        PriorityQueue<int[]> queue=new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            int num=entry.getKey(),count=entry.getValue();
            if(queue.size()==k){
                if (queue.peek()[1]<count){
                    queue.poll();
                    queue.offer(new int[]{num,count});
                }
            }else{
                queue.offer(new int[]{num,count});
            }
        }
        int[] res=new int[k];
        for (int i = 0; i < k; i++) {
            res[i]=queue.poll()[0];
        }
        return res;
    }

}

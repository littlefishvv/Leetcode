package oj;

import java.util.*;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/3/2 21:11
 * @description：
 * @modified By：
 * @version: $
 */
public class SortByNumCounts {
    //好像是计数排序
    public static void sort(int[] nums){
        //方法1 用map记录每个元素个数，并对map按value进行排序
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>(){

            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {

                return o2.getValue()-o1.getValue();
            }
        });
        List<Integer> res=new ArrayList<>();
        for(Map.Entry<Integer,Integer> m:list){

            for(int i=0;i<m.getValue();i++){
                res.add(m.getKey());
            }
        }
        int[] ret=new int[res.size()];
        for(int i=0;i<res.size();i++){
            ret[i]=res.get(i);
        }
        System.out.println(Arrays.toString(ret));




    }

    public static void main(String[] args) {
        sort(new int[]{2,3,4,1,2,2,3});
    }
    //方法2
}


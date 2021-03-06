package oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/3/2 8:40
 * @description：
 * @modified By：
 * @version: $
 */
//oj第二题，和为定值的子数组组合，不要求连续。
public class KsumNums {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> getKsumList(int[] arr,int k){
        int n=arr.length;
        List<Integer> list=new ArrayList<>();
        Arrays.sort(arr);
        boolean[] isVis=new boolean[n];
        backTrack(arr,k,0,list,isVis);
        return res;


    }
    public void backTrack(int[] arr,int k,int index,List<Integer> list,boolean[] isVis){
        if(k<0) return;
        if(k==0){
            res.add(new ArrayList<>(list));
        }
        //如果不加任何限制，这样找出来的组合在形式上是有可能重复的（仅仅是形式上重复，并不是错）
        for(int i=index;i<arr.length;i++){
            if(arr[i]<=k){
                //加了这个可以保证在形式上不重复
                if(i>0&&arr[i]==arr[i-1]&&isVis[i-1]==false) continue;
                list.add(arr[i]);
                isVis[i]=true;
                backTrack(arr,k-arr[i],i+1,list,isVis);
                list.remove(list.size()-1);
                isVis[i]=false;
            }else{
                break;
            }
        }
    }

    public static void main(String[] args) {
       //int[] arr=new int[]{10 ,2 ,3 ,4 ,5 ,7 ,8};
       int[] arr=new int[]{0 ,0 ,2 ,1 ,1 };

        KsumNums p=new KsumNums();

        List<List<Integer>> res=p.getKsumList(arr,3);
        System.out.println(res.toString());

    }


}

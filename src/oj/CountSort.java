package oj;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/2/22 20:54
 * @description：
 * @modified By：
 * @version: $
 */
//计数排序适用于基数大，但是范围小得数据
public class CountSort {
    //13 24 3 56 34 3 78 12 29 49 84 51 9 100
    public static void problem(int[] arr){
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            max=Math.max(max,arr[i]);
        }
        int[] count=new int[max+1];
        for(int num:arr){
            count[num]++;
        }
        int index=0;
        for(int i=0;i<=max;i++){
            for(int j=0;j<count[i];j++){
                arr[index++]=i;
            }
        }

    }


}

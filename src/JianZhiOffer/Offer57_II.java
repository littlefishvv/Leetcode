package JianZhiOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/31 16:15
 * @description：
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *  
 *
 * 限制：
 *
 * 1 <= target <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Offer57_II {
    //首先，这一题使用回溯方法是错误的
    List<List<Integer>> resList=new ArrayList<>();
    public int[][] findContinuousSequence(int target){
        int[] nums=new int[target];
        for (int i = 0; i < target; i++) {
            nums[i]=i+1;
        }

        if (target<=2) return null;
        List<Integer> list=new ArrayList<>();
       //backNums(nums,target,list,0);
        backTrack(nums,target,list,0);
        //把list转化为数组
        int[][] res=new int[resList.size()][];
        for (int i = 0; i < resList.size(); i++) {
            int[] t=new int[resList.get(i).size()];

            for (int i1 = 0; i1 < resList.get(i).size(); i1++) {
                t[i1]=resList.get(i).get(i1);
            }
            res[i]=t;
        }
        System.out.println("长度为"+res.length);
        return res;

    }
    //
    public void backTrack(int[] nums, int target,List<Integer> list,int num){
        if (target<0) return;
        if (target==0){
            resList.add(new ArrayList<>(list));
            System.out.println(1);
            return;
        }

        for(int i=num;i<nums.length;i++){
            if (nums[i]>target){
                break;
            }
            list.add(nums[i]);
            backTrack(nums,target-nums[i],list,i);
            list.remove(list.size()-1);
        }


    }
    public void backNums(int[] candidates, int target,List<Integer> list,int num){

        if (target<0) return;
        if (target==0){
            resList.add(new ArrayList<>(list));
            System.out.println("新加入的list是：");
            return;
        }

        for (int i=num;i<candidates.length;i++){
            if (candidates[i]>target) {
                System.out.println("cand:"+candidates[i]+" target"+target+" 跳出循环 当前backnum结束进入移除阶段");
                break;
            }
            //如果小于或者等于，就加入集合
            list.add(candidates[i]);
            System.out.println("num:"+num+" i"+i+" target:"+target+" 添加："+candidates[i]);
            //这里重新传入的是i，而不是num一定要注意，因为nums是不变的，而i是会变的
            backNums(candidates,target-candidates[i],list,i);
            System.out.println("移除 :"+list.get(list.size()-1)+"当前target:"+target);
            list.remove(list.size()-1);

        }




    }

    //思路，滑动窗口

    public static void main(String[] args) {
        Offer57_II o=new Offer57_II();
        o.findContinuousSequence(3);
    }
    public int[][] findContinuousSequence1(int target){
        //双指针
        if (target<=2) return null;
        int l=1,r=2;
        int sum=l+r;
        List<int[]> res=new ArrayList<>();
        while(l<=r&&r<target){
            if(sum<target){
                r++;
                sum+=r;
            }else if(sum>target){
                //这里的细节在于，当左窗口缩小时，应该先减去原来的值才能缩小，而右窗口增大时，应该先增大才能加上右窗口的值。
                sum-=l;
                l++;

            }else{
                int[] arr=new int[r-l+1];
                for (int i = l; i <= r; i++) {
                    arr[i-l]=i;
                }
                res.add(arr);
                // 左边界向右移动或者右窗口向左移动
                //这里还有一个细节就是当窗口满足条件时为了保证窗口的移动要从一个方向破坏窗口
                r++;
                sum += r;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}


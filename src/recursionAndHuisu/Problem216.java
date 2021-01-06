package recursionAndHuisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/5 16:49
 * @description：
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem216 {

    List<List<Integer>> res=new ArrayList<>();
    boolean[] vis;
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] candidates=new int[]{1,2,3,4,5,6,7,8,9};
        vis=new boolean[candidates.length];
        List<Integer> list=new ArrayList<>();
        Arrays.sort(candidates);
        if (candidates!=null){
            backNums(candidates,n,list,0, k);
        }
        return res;
    }
    public void backNums(int[] candidates,int target,List<Integer> list,int num,int k){
        if (target<0||list.size()>k) return;
        if (target==0&&list.size()==k){
            res.add(new ArrayList<>(list));
            System.out.println("新加入的list是：");
            return;
        }
        //先找1开头的所有组合，等于1开头的+back(2开头的)【退出之后】或back3开始的，
        for (int i=num;i<candidates.length;i++){

            if (candidates[i]>target) {
                System.out.println("cand:"+candidates[i]+" target"+target+" 跳出循环");
                break;
            }

            list.add(candidates[i]);
            System.out.println("num:"+num+" i"+i+" target:"+target+" 添加："+candidates[i]);
            backNums(candidates,target-candidates[i],list,i+1,k);
            System.out.println("移除 :"+list.get(list.size()-1)+"当前back:"+i);
            list.remove(list.size()-1);
        }

    }

    public static void main(String[] args) {
        Problem216 p=new Problem216();
        p.combinationSum3(3,9);
    }
}

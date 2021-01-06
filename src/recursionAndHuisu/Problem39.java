package recursionAndHuisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/5 10:52
 * @description：
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *  *  *   [7],
 *  *  *   [2,2,3]
 *  *  * ]
 *  *  * 示例 2：
 *  *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *  
 *
 * 提示：
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem39 {
    List<List<Integer>> res=new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list=new ArrayList<>();
        Arrays.sort(candidates);
        if (candidates!=null){
            backNums(candidates,target,list,0);
        }
        return res;

    }

    public void backNums(int[] candidates, int target,List<Integer> list,int num){

        if (target<0) return;
        if (target==0){
            res.add(new ArrayList<>(list));
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

    public static void main(String[] args) {
        Problem39 p=new Problem39();
        p.combinationSum(new int[]{2,3,6,7},7);
    }

}

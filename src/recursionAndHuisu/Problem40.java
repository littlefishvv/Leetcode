package recursionAndHuisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/5 10:52
 * @description：
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem40 {
    List<List<Integer>> res=new ArrayList<>();
    boolean[] vis;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        vis=new boolean[candidates.length];
        List<Integer> list=new ArrayList<>();
        Arrays.sort(candidates);
        if (candidates!=null){
            backNums(candidates,target,list,0);
        }
        return res;
    }
    public void backNums(int[] candidates,int target,List<Integer> list,int num){
        if (target<0) return;
        if (target==0){
            res.add(new ArrayList<>(list));
        }
        for (int i=num;i<candidates.length;i++){
            //这个去重操作可以参考第47题 但是这里只能写成continue而不能写成break 因为如果continue当重复时，开头会继续遍历后面的，但是如果break了就不再以后面为开头了
            if (candidates[i]>target||(i>0&&candidates[i]==candidates[i-1]&&vis[i-1]==false)) continue;
            vis[i]=true;
            list.add(candidates[i]);

            backNums(candidates,target-candidates[i],list,i+1);
            vis[i]=false;
            list.remove(list.size()-1);
        }

    }
}

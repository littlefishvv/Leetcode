package recursionAndHuisu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/4 9:52
 * @description：
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem46{
    List<List<Integer>> res=new ArrayList<>();


    List<List<Integer>> permute(int[] nums) {

        List<Integer> list=new ArrayList<>();
        if (nums.length>0){
            backNums(nums,list);
        }
        return res;
    }

    //这个不用设置index。因为在这里面index没有意义
    void backNums(int[] nums,List<Integer> list){
        if (list.size()==nums.length){
            //直接res.add list是不行的，为什么？因为，所有的list都是同一个list,这个时候是加进来了，但是后面会remove,最后会把list
            //中的元素都remove掉，所以要把加入的list赋值给另外一个list再加进去,这样，加入的list就不会变了
            res.add(new ArrayList<Integer>(list));
        }
        for(int i=0;i<nums.length;i++){
            //这里可以优化的是，判断是否为已用，用布尔标志，后面再重新复位没有访问
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            backNums(nums,list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        Problem46 p46=new Problem46();
        p46.permute(new int[]{1,2,3});
    }






}

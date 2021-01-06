package recursionAndHuisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/5 16:49
 * @description：
 * 给你一个整数数组 nums ，返回该数组所有可能的子集（幂集）。解集不能包含重复的子集。
 *
 *  
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem78 {

    //这一题可以分为四部分，1.空白；2单个 3全部  4.各个长度的组合，其中4可以通过多次的执行回溯来完成，把问题简化为，数组分为k位组合的添加进去。
    //当然，上面的思想很笨，没有get到回溯的精髓
    List<List<Integer>> res=new ArrayList<>();

    boolean[] vis;
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list=new ArrayList<>();
        Arrays.sort(nums);
        int len=nums.length;
        vis=new boolean[len];
        if(len>1){
            for (int i=0;i<len;i++){
                res.add(new ArrayList<>(Arrays.asList(nums[i])));
            }
        }

        res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        res.add(new ArrayList<>());
        for (int i=2;i<len;i++){
            backNums(nums,list,0,i);
        }



        return res;
    }
    //对k位长度的组合
    public void backNums(int[] nums,List<Integer> list,int index,int k){
        if (list.size()==k){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i=index;i<nums.length;i++){
            //去重
            if (vis[i]==true||(i>0&&nums[i]==nums[i-1]&&vis[i-1]==false)) continue;
            list.add(nums[i]);
            vis[i]=true;
            backNums(nums,list,i+1,k);
            vis[i]=false;
            list.remove(list.size()-1);
        }

    }




    //真正的回溯是这样写的   这也给了我一个教训，写了那么多回溯题，遇到那么多刁钻的条件，面对这个最本质的回溯题，却乱了手脚，还是没有学到回溯的本质
    public List<List<Integer>> subsets1(int[] nums) {
        backtrack(0,nums,new ArrayList<>());
        return res;
    }
    void backtrack(int index, int[] nums, ArrayList<Integer> tmp) {
        //任何条件都会加入res中 也不用return，也就是说tmp一直在变，但是每一个变的都会加入到res中去
        res.add(new ArrayList<>(tmp));
        for (int i=index;i<nums.length;i++){
            //当然也没有需要绕过的
            tmp.add(nums[i]);
            backtrack(i+1,nums,tmp);
            tmp.remove(tmp.size()-1);
        }
    }



}

package recursionAndHuisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/5 20:09
 * @description：
 * @modified By：
 * @version: $
 */
public class Problem90 {

    List<List<Integer>> res=new ArrayList<>();
    boolean[] vis;
    //真正的回溯是这样写的   这也给了我一个教训，写了那么多回溯题，遇到那么多刁钻的条件，面对这个最本质的回溯题，却乱了手脚，还是没有学到回溯的本质
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        vis=new boolean[nums.length];
        backtrack(0,nums,new ArrayList<>());
        return res;
    }
    void backtrack(int index, int[] nums, ArrayList<Integer> tmp) {
        //任何条件都会加入res中 也不用return，也就是说tmp一直在变，但是每一个变的都会加入到res中去
        res.add(new ArrayList<>(tmp));
        for (int i=index;i<nums.length;i++){
            if (vis[i]==true||(i>0&&nums[i]==nums[i-1]&&vis[i-1]==false)) continue;
            vis[i]=true;
            tmp.add(nums[i]);
            backtrack(i+1,nums,tmp);
            vis[i]=false;
            tmp.remove(tmp.size()-1);
        }
    }
}

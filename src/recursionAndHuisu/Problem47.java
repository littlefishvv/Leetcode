package recursionAndHuisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/4 11:11
 * @description：
 * @modified By：
 * @version: $
 */
public class Problem47 {

    List<List<Integer>> res=new ArrayList<>();
    boolean[] vis;


    List<List<Integer>> permute(int[] nums) {
        vis=new boolean[nums.length];

        List<Integer> list=new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length>0){
            backNums(nums,list);
        }

        return res;
    }

    //这个不用设置index。因为在这里面index没有意义
    void backNums(int[] nums,List<Integer> list){
        if (list.size()==nums.length){
            //            //直接res.add list是不行的，为什么？因为，所有的list都是同一个list,这个时候是加进来了，但是后面会remove,最后会把list
            //中的元素都remove掉，所以要把加入的list赋值给另外一个list再加进去,这样，加入的list就不会变了
            res.add(new ArrayList<Integer>(list));
            return;
        }

        //想一想什么情况下才需要去重？比如排好序后的1 1 2 第一次的112不需要任何限制，但当访问第二个1为开头时，就需要判断112是重复的
        //也就是说
        for(int i=0;i<nums.length;i++){
            //这里可以优化的是，判断是否为已用，用布尔标志，后面再重新复位没有访问  如果想在要访问的数字没有被访问过，但它的前面还有一个相同的数字，这个相同的数字还没有被访问，那么就不用访问了直接跳出 因为这意味着是重复的
            //那如果是前面那个想相同元素访问过呢就说明这个是第一次访问，比如说112 ，第一次是112 第二次以第二个1为开头 就可以判断和第一个易是同样的效果就可以从这直接剪枝
            // continue就是剪枝的过程 所谓剪枝，就是不再让以这个为开头的分支继续回溯下去  其他的都和正常的全排列一样。
            if(vis[i]==true||(i>0&&nums[i]==nums[i-1]&&vis[i-1]==false)) continue;
            list.add(nums[i]);
            vis[i]=true;
            backNums(nums,list);
            vis[i]=false;
            list.remove(list.size()-1);
        }
    }
}

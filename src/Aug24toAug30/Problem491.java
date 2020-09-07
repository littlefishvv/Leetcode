package Aug24toAug30;

import com.sun.javafx.image.IntPixelGetter;
import sun.rmi.server.InactiveGroupException;

import java.util.*;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/8/25 8:42
 * @description：给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem491 {
    List<List<Integer>> ans=new ArrayList<>();
    List<Integer> temp=new ArrayList<Integer>();
    public List<List<Integer>> findSubsequences(int[] nums){
        //首先要对nums进行排序
       dfs(0,Integer.MIN_VALUE,nums);
       return ans;
    }
    //开始回溯+剪枝   其实我实在无法理解这种解法
    public void dfs(int cur,int last,int[] nums){
        if (cur==nums.length){
            if (temp.size()>=2){
                ans.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        if (nums[cur]>=last){
            temp.add(nums[cur]);
            //遍历下一个，last是当前
            dfs(cur+1,nums[cur],nums);
            //为什么要remove，因为这个temp是定义在外面的，如果是定义在这个方法内部，应该就不需要remove了
            temp.remove(temp.size()-1);
        }
        //这下面的意思是，如果又查了一个小于（不大于也不等于）last，那继续往下查
        if(nums[cur]!=last){
            dfs(cur+1,last,nums);
        }
    }



    //如果使用回溯模板来做
    List<List<Integer>> res=new ArrayList<>();
    //set用来判断路径是否重复
    Set<List<Integer>> set=new HashSet<>();
    public List<List<Integer>> findSubsequences1(int[] nums){

        return null;
    }

    private void backTracking(List<Integer> path,int[] nums,int begin){

        if (path.size()>=2&&(!set.contains(path))){
            List<Integer> tmp=new ArrayList<>(path);
            res.add(tmp);
            set.add(tmp);
        }
        if (begin>=nums.length) return;
        //路径列表
        for (int i = begin; i < nums.length; i++) {
            //做选择
            if (path.size()==0||nums[i]>=path.get(path.size()-1)){
                path.add(nums[i]);
                //回溯
                backTracking(path,nums,i+1);
                //撤销选择
                path.remove(path.size()-1);
            }else{
                continue;
            }
        }
    }
}

package recursionAndHuisu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/4 21:08
 * @description：
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem77 {
    List<List<Integer>> res=new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list=new ArrayList<>();
        backNums(n,k,list,1);
        return res;

    }
    public void backNums(int n,int k,List<Integer> list,int num){

        if(list.size()==k){
            res.add(new ArrayList<>(list));
            return;
        }

        //优化，可以从n-k那么位置开始剪枝 不用进行搜索
        for(int i=num;i<=n-(k-list.size())+1;i++){
            list.add(i);
            backNums(n,k,list,i+1);
            list.remove(list.size()-1);
        }
    }
}

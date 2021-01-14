package tanxin;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/12 10:49
 * @description：
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 *
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * 输出: 1
 *
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 *
 * 输入: [ [1,2], [1,2], [1,2] ]
 *
 * 输出: 2
 *
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 *
 * 输入: [ [1,2], [2,3] ]
 *
 * 输出: 0
 *
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem435 {
    //暴力的话，找出所有子区间的组合，之后判断他们是否重叠，那么这个时间复杂度就是O（2^n*n) 每个区间我们都可以选择留下不留下，也就是有两种选择，然后还得判读某个组合是否没有重叠

    //这一题像极了最长上升子序列，就用动态规划方法，判断某个区间是否能在他的前面
    //但是对这个二维数组要排序，才好判断是否重叠
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        if(n==0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        int[] dp=new int[n];
        Arrays.fill(dp,1);

        //dp[i]代表以intervals[i]为结尾的那个区间代表的不重叠区间最大长度
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                //因为结束大于另一个的开头 说明不重叠
                if(intervals[j][1]<=intervals[i][0]){
                    dp[i]=Math.max(dp[i],1+dp[j]);
                }

            }
            System.out.println("dpi:"+i+" "+dp[i]);
        }
        int res=0;
        for (int i = 0; i < dp.length; i++) {
            res=Math.max(res,dp[i]);
        }
        return n-res;


    }

    //贪心算法，按区间的结尾排序，每次选择结尾最早的，且和前一个区间不重叠的区间，可以通过反证法证明有贪心选择性质。
    /*证明:假设某次选择是si fj,其中fi是当前所有选择中结尾最早且不重叠的，好，我现在假设这个选择不是最优的，也就是说，如果这个问题的最优解为k。则这个选择
    得到的解最多为k-1,假设最优解在这一步的选择为sj fj，fj一定是大于fi的。那么显然可以将si,fi替换sj fj。而不影响最优解后续的区间选择【因为这是排好序的，既然最后解后面不会
    和sj fj重叠，sk一定大于fj.那么也一定大于fi,所以一定不会和si fi重叠】。那么可以说明 si fi其实就可以充当最优解
*/
    public int eraseOverlapIntervals2(int[][] intervals) {
        int n=intervals.length;
        if(n==0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        //开始贪心
        int res=1;
        int pre=0;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0]>=intervals[pre][1]){
                res++;
                pre=i;
            }
        }
        return n-res;


    }

    public static void main(String[] args) {
        Problem435 p=new Problem435();
        p.eraseOverlapIntervals(new int[][]{{0,2},{1,3},{2,4},{3,5},{4,6}});
    }
}

package Hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/14 16:24
 * @description：
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem560 {
    //这一题强调连续  用dp[i][j]代表i-j的和，最后看一下和有几个等于k就行了
    //但是使用了二维数组，空间复杂度会超过
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int[][] dp=new int[n][n];
        for (int i=1;i<n;i++){
            for (int j=i;j<n;j++){
                if (i==j) dp[i][j]=nums[j];
                dp[i][j]=dp[i][j-1]+nums[j];
            }
        }
        int res=0;
        for (int i=1;i<n;i++){
            for (int j=1;j<n;j++){
                if (dp[i][j]==k)
                    res++;
            }
        }
        return res;

    }


    //因为涉及到连续的和，考虑用前缀和
    public int subarraySum1(int[] nums, int k) {
        int n=nums.length;
        int[] sums=new int[n+1];
        sums[0]=0;
        for (int i=0;i<n;i++){
            sums[i+1]=sums[i]+nums[i];
        }
        int count=0;


        for (int i = 0; i < n; i++) {
            if (nums[i]==k) count++;
            for (int j = 0; j < i; j++) {
                if (sums[i+1]-sums[j]==k) count++;

            }
        }
        return count;




    }

    //前缀和的优化

    /*
    * 计算从第0个元素到当前元素的和，用哈希表保存出现过的累积和sum的次数。比如1 -1 0 1 3sum为0其实应该是2次
    * 如果sum - k在哈希表中出现过，则代表从当前下标i往前有连续的子数组的和为sum
    * */
    public int subarraySum2(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);

        int sum=0,ret=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if (map.containsKey(sum-k)){
                ret+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ret;


    }

}

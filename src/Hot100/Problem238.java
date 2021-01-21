package Hot100;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/16 14:19
 * @description：
 * @modified By：
 * @version: $
 */
public class Problem238 {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        if (n<=1) return nums;
        int[] res=new int[n];
        //定义一个前缀积，定义一个后缀积
        int[] t1=new int[n];
        int[] t2=new int[n];
        t1[0]=nums[0];
        t2[n-1]=nums[n-1];
        for (int i = 1; i < n; i++) {
            t1[i]=t1[i-1]*nums[i];

        }
        for (int i = n-2; i >=0; i--) {
            t1[i]=t1[i+1]*nums[i];

        }
        res[0]=t2[1];
        res[n-1]=t1[n-2];
        for (int i = 1; i < n-1; i++) {
            res[i]=t1[i-1]*t2[i+1];
        }

        return res;

    }
    //下面是一种优化的写法，不需要单独开辟空间记录
    public int[] productExceptSelf2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int len = nums.length;
        int[] res = new int[len];

        int left = 1;
        //乘以左前缀
        for (int i = 0; i < len; i++) {
            // 防止越界
            if (i > 0) {
                left = left * nums[i - 1];
            }
            res[i] = left;
        }

        int right = 1;
        //乘以右前缀
        for (int i = len - 1; i >= 0; i--) {
            // 防止越界
            if (i < len - 1) {
                right = right * nums[i + 1];
            }
            res[i] *= right;
        }
        return res;
    }
}

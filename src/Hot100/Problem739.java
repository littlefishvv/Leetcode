package Hot100;

import java.util.Stack;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/13 11:04
 * @description：
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem739 {

    //暴力解法
    public int[] dailyTemperatures(int[] T) {
        int n=T.length;
        int[] res=new int[n];
        for (int i = 0; i < n; i++) {
            int temp=1;
            for (int j = i+1; j < n; j++) {
                if (T[j]<=T[i]) {
                    temp++;

                }else{
                    break;
                }

            }
            if (temp==n-i) temp=0;
            res[i]=temp;
        }
        return res;

    }

    //单调栈解法  维护一个单点递减栈，栈顶元素就是当前遍历到的最小温度的下标 每当遇到比栈顶小的温度就把下标入栈，否则就对栈顶元素出战求差值，再把较大的那个入栈
    public int[] dailyTemperatures1(int[] T) {
        Stack<Integer> stack=new Stack<>();
        int length=T.length;
        int[] res=new int[length];
        //遍历这个数组
        for (int i = 0; i < length; i++) {
            //有条件的遍历单调栈。如果最后单调栈中还有剩余，说明始终没有找到比这个下标要大的温度。也不必担心，因为res默认为0
            while(!stack.isEmpty()&&T[i]>T[stack.peek()]){
                //当前栈顶元素就是pre，如果该元素比栈中的一个又一个pre都要大，那就一起把pre对应的res填入。
                int pre=stack.pop();
                res[pre]=i-pre;
            }
            //如果比栈顶元素还小，就把当前下标放进去。成为栈顶，这样，当遇到比栈顶温度大的，就可以直接相减填入res
            stack.add(i);
        }

        return res;



    }


}

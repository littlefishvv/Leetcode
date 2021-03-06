package Hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/24 10:09
 * @description：
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * @modified By：
 * @version: $
 */
public class Problem85 {
    /*
     * 最原始地，我们可以列举每个可能的矩形。我们枚举矩形所有可能的左上角坐标和右下角坐标，并检查该矩形是否符合要求。
     * 然而该方法的时间复杂度过高，不能通过所有的测试用例，因此我们必须寻找其他方法。

     * */
    public int maximalRectangle(char[][] matrix) {
        /*
         * 这一题的算法本质上和84题Largest Rectangle in Histogram一样，对每一行都求出每个元素对应的高度，
         * 这个高度就是对应的连续1的长度，然后对每一行都更新一次最大矩形面积。
         * 那么这个问题就变成了Largest Rectangle in Histogram。本质上是对矩阵中的每行，均依次执行84题算法。*/

        //对每一行把自下网上的1放置好。
        int m=matrix.length;
        if (m==0) return 0;
        int n=matrix[0].length;
        //用heighe数组记录下数组每一行的值
        int[] height=new int[n];
        int res=0;
        for (int i = 0; i < m; i++) {

            //对于每一行，都不断对数组进行更新。
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j] += 1;
                } else {
                    height[j] = 0;
                }

            }
            res=Math.max(res,largestRectangleArea2(height));

        }




        return res;
    }
    public int largestRectangleArea2(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }

        if (len == 1) {
            return heights[0];
        }

        int res = 0;

        int[] newHeights = new int[len + 2];
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, len);
        newHeights[len + 1] = 0;
        len += 2;
        heights = newHeights;

        Deque<Integer> stack = new ArrayDeque<>(len);
        // 先放入哨兵，在循环里就不用做非空判断 相当于是左边界为0，而最后再置0是为了防止全部都是增，最后是0可以把一直递增的也算出来。
        stack.addLast(0);
        //核心思想就是，再遇到一个比自己低的木板之后，我就可以计算当前模板的最大面积，然后这个最高的模板就没有用了，可以让他退化为次高的模板 然后在计算次高的面积。，
        for (int i = 1; i < len; i++) {
            //单调栈的栈首维护的是当前最大的元素的下标。
            while (heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                //curHight实际上是i-1的高度,这样i实际上是其右边界，经过了pollLast之后，peelast实际上是其左边界。那么有边界-左边界-1就是当前i-1为高度的宽度。
                int curWidth = i - stack.peekLast() - 1;
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }
        return res;



    }

}


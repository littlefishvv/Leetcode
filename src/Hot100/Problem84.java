package Hot100;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/24 10:35
 * @description：
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 *
 * @modified By：
 * @version: $
 */
public class Problem84 {

    //暴力法，会超时
    public int largestRectangleArea(int[] heights) {
        int maxarea = 0;
        for (int i = 0; i < heights.length; i++) {
            //记录下当前的最小高度
            int minheight = Integer.MAX_VALUE;
            //在j往右的过程中不断地更新最小长度。
            for (int j = i; j < heights.length; j++) {
                minheight = Math.min(minheight, heights[j]);
                maxarea = Math.max(maxarea, minheight * (j - i + 1));
            }
        }
        return maxarea;
    }

    //方法2  计算以柱子i为高的最大矩形面积，强制要求该柱子为高 这个也会超时。
    public int largestRectangleArea1(int[] heights) {

       /* int n=heights.length;
        int res=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            //i这个柱子为高
            int l=i-1,r=i+1;
            while(l>=0&&heights[l]>=heights[i]){
                l--;
            }
            while(r<n&&heights[r]<=heights[i]){
                r++;
            }

            int len=l-r+1;
            res=Math.max(res,len*heights[i]);

        }
        return res;*/
        int area = 0, n = heights.length;
        // 遍历每个柱子，以当前柱子的高度作为矩形的高 h，
        // 从当前柱子向左右遍历，找到矩形的宽度 w。
        for (int i = 0; i < n; i++) {
            //这个w非常巧妙，因为如果再重新定义left和right，不管是让它等于i-1还是等于i都不合适，因为这涉及到不管循环是否执行，都要计算宽度，而且
            //如果左右相等，循环都要执行，会对宽度的计算产生混论，而通过单独设置j然后再通过w进行宽度的变化可以很多好的解决矛盾。
            int w = 1, h = heights[i], j = i;
            //这里的--j也很巧妙 如果这里设置j=i-1然后判断让j--,实际上会出错，因为如果heghtp[j]如果等于h，那么宽度应当是2，
            while (--j >= 0 && heights[j] >= h) {
                w++;
            }
            //right从i开始。
            j = i;
            while (++j < n && heights[j] >= h) {
                w++;
            }
            area = Math.max(area, w * h);
           /* 用下面这种方法应该也可以，相当于在（t,v）这个开区间里面。也就是宽度为t-v-1
           int t=i=1;
            while (t>= 0 && heights[t] >= h) {
                t--;
            }
            int v=i+1;
            while (v<n && heights[v] >= h) {
                v--;
            }
            area = Math.max(area, (v-t-1) * h);*/
        }

        return area;


    }
    //单调栈，on的时间复杂度
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
        // 先放入哨兵，在循环里就不用做非空判断 相当于是左边界为0这样所有的结点都比0大都可以放入进去，，而最后再置0是为了防止全部都是增，最后是0可以把一直递增的也算出来。
        stack.addLast(0);
        //核心思想就是，再遇到一个比自己低的木板之后，我就可以计算当前模板的最大面积，然后这个最高的模板就没有用了，可以让他退化为次高的模板 然后在计算次高的面积。，
        for (int i = 1; i < len; i++) {
            //单调栈的栈首维护的是当前最大的元素的下标。而且如果栈内元素大于heghti那么说明heighti也是这个元素的有边界，这样就可以不断计算那么为高的最大面积。
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

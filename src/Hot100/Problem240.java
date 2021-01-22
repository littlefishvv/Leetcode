package Hot100;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/21 10:10
 * @description：
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        //第一种思路，对每个数组进行二分查找
        int m=matrix.length;
        if (m==0) return false;
        int n=matrix[0].length;
        for (int i = 0; i < m; i++) {
            int[] t=matrix[i];
            int left=0;
            int right=n-1;
            while(m<=n){
                int mid=(left+right)>>1;
                if (t[mid]==target) return true;
                if (t[mid]>target){
                    right=mid-1;
                }else{
                    left=right+1;
                }
            }
        }
        return false;

    }

    //第二种思路，
    public boolean searchMatrix1(int[][] matrix, int target) {
        //第一种思路，对每个数组进行二分查找
        int m=matrix.length;
        if (m==0) return false;
        int n=matrix[0].length;


        int t=n-1;
        for (int i = 0; i < m; i++) {
            int[] p=matrix[i];
            //循环不变量[0,t] t是大于target的那个下标
            for (int j = 0; j <=t; j++) {
                if (p[j]==target) return true;
                if (p[j]>target) {
                    t=j;
                    break;
                }

            }
        }
        return false;
    }

    //减治法
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix==null||matrix.length==0) return false;
        int m=0;
        int n=matrix[0].length;
        //从左下角那个元素开始。
        while(m<matrix.length&&n>=0){
            if (matrix[m][n]==target){
                return true;
            }
            //如果当前元素大于目标值，那么就往右边移动一行。否则，就往上移动一行
            /*
            *
            * 若左下角元素等于目标，则找到
若左下角元素大于目标，则目标不可能存在于当前矩阵的最后一行，问题规模可以减小为在去掉最后一行的子矩阵中寻找目标
若左下角元素小于目标，则目标不可能存在于当前矩阵的第一列，问题规模可以减小为在去掉第一列的子矩阵中寻找目标*/
            else if (matrix[m][n]>target){
                n--;
            }else{
                m++;
            }
        }
        return true;
    }
}

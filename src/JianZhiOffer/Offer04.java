package JianZhiOffer;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/31 21:27
 * @description：
 * @modified By：
 * @version: $
 */
public class Offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m=matrix.length;
        if (m==0) return false;
        int n=matrix[0].length;
        if (n==0) return false;
        //从（m-1,0)这个位置开始
        int k=0;
        int t=m-1;
        //时间复杂度o(m+n)
        while(t>=0&&k<n){
            if (matrix[t][k]==target){
                return true;
            }else if (matrix[t][k]>target){
                t--;
            }else{
                k++;
            }

        }
        return false;

    }

}

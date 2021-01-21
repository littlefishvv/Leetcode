package Hot100;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/19 11:49
 * @description：
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 *
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/counting-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem338 {
    public int[] countBits(int num) {
        int[] res=new int[num+1];
        for (int i = 0; i <= num; i++) {
            res[i]=getBinay(i);


        }


        return res;
    }

    //把一个数字转成二进制数
    private int  getBinay(int n){

        int count=0;
        while(n>=0){
            int i=n%2;
            n=n/2;

            if (i==1) count++;
            if (n==0) break;
        }
        return count;
    }

    public int[] countBits1(int num) {
        int[] res=new int[num+1];
        for (int i = 0; i < num; i++) {
            if (i==0) {
                res[i]=0;
            }
            else if (i==1) {
                res[i]=1;
            }
            else if (i==2) {
                res[i]=1;
            }
            //如果是2的次幂。就让他等于1
            else if ( (i&(i-1))==0){
                res[i]=1;
            }
            else {
                //得到最近的2的次方值，然后动态规划
                int a=getClose(i);
                res[i]=res[a]+res[i-a];
            }
        }
        return res;
    }
    private int getClose(int n){
       int i=0;
       while(i<n){
           if (Math.pow(2,i)>=n){
               return i;
           }
           i++;
       }
       return i;
    }



    //下面是一种最简单的o(n)时间复杂度的做法。i & (i - 1)可以去掉i最右边的一个1（如果有），因此 i & (i - 1）是比 i 小1的，
    // 而且i & (i - 1)的1的个数已经在前面算过了，所以i的1的个数就是 i & (i - 1)的1的个数加上1
    public int[] countBits2(int num) {
        int[] res = new int[num + 1];
        for(int i = 1;i<= num;i++){  //注意要从1开始，0不满足
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }


    public static void main(String[] args) {
        Problem338 p=new Problem338();
        p.getBinay(4);
    }
}

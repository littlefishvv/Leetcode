package SetAndMap;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/9/23 17:40
 * @description：
 * 快乐数
 *
 *
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 *
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 *
 *  
 *
 * 示例：
 *
 * 输入：19
 * 输出：true
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 *
 */
public class Problem202 {
    public boolean isHappy(int n){
        //递归之后，return了，但只是从这个递归调用栈的这一层返回，会进入下面的代码，比如第四层等于1 然后返回true，意味着可以往下面的代码进行了
        // 然后下面的代码return后，会进入下一层递归调用栈，而不是真正的返回。
        if (n==1) return true;
        n=powSum(n);
        isHappy(n);
        return false;

    }
    int powSum(int n){
            int res=0;
            while(n>=1){
                int t=(n%10)*(n%10);
                n=n/10;
                res+=t;
            }
            return res;
    }
    //用hashSet或者双指针  因为
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy1(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    public static void main(String[] args) {
        Problem202 problem202=new Problem202();
        boolean b=problem202.isHappy(19);
    }
}

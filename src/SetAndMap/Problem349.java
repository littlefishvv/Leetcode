package SetAndMap;

import java.util.HashSet;
import java.util.Set;

/*给定两个数组，编写一个函数来计算它们的交集。

 

示例 1：

输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]
示例 2：

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]
 

说明：

输出结果中的每个元素一定是唯一的。
我们可以不考虑输出结果的顺序。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Problem349 {
    //用一个set容纳nums1,因为答案表明结果中的每一个元素是唯一的，那么用另一个set容纳结果，然后把结果转为数组
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        Set<Integer> res=new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])){
                res.add(nums2[i]);
            }
        }
        Integer[] temp=res.toArray(new Integer[]{});
        int[] r=new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            r[i]=temp[i];
        }
        return r;
    }
}

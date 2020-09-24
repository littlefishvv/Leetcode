package SetAndMap;

import java.util.*;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/9/23 10:33
 * @description：
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 *
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem350 {

    public int[] intersection1(int[] nums1, int[] nums2) {
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        List<Integer> list3=new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            list1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            list2.add(nums2[i]);
        }
        //这个时间复杂度是o(n^2)
        for (int i = 0; i < list2.size(); i++) {
            if (list1.contains(list2.get(i))){
                list3.add(list2.get(i));
                list1.remove(list1.indexOf(list2.get(i)));
            }

        }
        int[] res=new int[list3.size()];
        for (int i = 0; i < list3.size(); i++) {
            res[i]=list3.get(i);
        }
        return res;
    }
    //用哈希表实现   时间复杂度o(m+n)  为什么这里不用ascii数组呢，因为ascii是对于char字符的，这里是整形，需要先转为char字符

    public int[] intersection(int[] nums1, int[] nums2) {
        /*List<Integer> list1=new ArrayList<>();
        int[] arr=list1.stream().mapToInt(Integer::intValue).toArray();*/
        //这样是为了降低空间复杂度，map所占的是较短的长度  并不能降低空间复杂度
        if (nums1.length>nums2.length){
            return intersection(nums2,nums1);
        }
        Map<Integer,Integer> map1=new HashMap<>();
        for(int value:nums1){
            if (map1.get(value)==null){
                map1.put(value,1);
            }else{
                map1.put(value,map1.get(value)+1);
            }
        }
        List<Integer> ls=new ArrayList<>();
        for (int value:nums2){
            if (map1.get(value)!=null&&map1.get(value)>0){
                ls.add(value);
                map1.put(value,map1.get(value)-1);
            }
        }

        return ls.stream().mapToInt(Integer::intValue).toArray();
    }
    //下面是用双指针，其实经过上周数组的学习，这一题你应该独立自主的用这种方式解决。这种是最优雅的，时间复杂度也是最低的o(min(n,m))
    public int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0;
        int j=0;
        int index=0;
        int[] result=new int[nums1.length];
        while(i<nums1.length&&j<nums2.length){
            if (nums1[i]==nums2[j]){
                result[index]=nums1[i];
                i++;
                j++;
                index++;
            }else if(nums1[i]<nums2[j]) i++;
            else  j++;
        }
        return nums1;
    }

    public static void main(String[] args) {
        Problem350 p=new Problem350();
        p.intersection1(new int[]{1,2,2,1},new int[]{2,2});
    }
}

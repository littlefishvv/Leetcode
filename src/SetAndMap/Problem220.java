package SetAndMap;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Problem220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        List<Integer> list=new ArrayList<>();
        //维护一个长度为k-1的窗口，然后判断窗口内是否有|nums[i]-nums[j]|<=t
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
            for (int i1 = 0; i1 < list.size()-1; i1++) {
                System.out.println(nums[i]+"nums[i]"+list.get(i1));
                System.out.println(((long)nums[i]-(long)list.get(i1)));
                //为了解决整型溢出的问题，我们需要把nums[i]和list.get(i)都转化为long型。
                if(Math.abs((long)nums[i]-(long)list.get(i1) )<=t){
                    return true;
                }
            }
            //确保下一个元素的长度在k的范围内
            if(list.size()==k+1){
                list.remove(0);
            }

        }
        return false;
    }
    //上面那种方法实际上是可以解的，在执行最后几个测试用例时时间超时了，这里我们用treeSet实现
    //TreeSet.ceiling(E e) 方法返回在这个集合中大于或者等于给定元素的最小元素，如果不存在这样的元素,返回null.
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        // 滑动窗口结合查找表，此时滑动窗口即为查找表本身（控制查找表的大小即可控制窗口大小）
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 边添加边查找
            // 查找表中是否有大于等于 nums[i] - t 且小于等于 nums[i] + t 的值
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= ((long) nums[i] + (long) t)) {
                return true;
            }
            // 添加后，控制查找表（窗口）大小，移除窗口最左边元素
            set.add((long) nums[i]);
            if (set.size() == k + 1) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Problem220 p=new Problem220();
        p.containsNearbyAlmostDuplicate(new int[]{-2147483648,2147483647},1,1);
    }
}

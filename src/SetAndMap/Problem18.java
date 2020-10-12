package SetAndMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/10/11 15:13
 * @description：
 * @modified By：
 * @version: $
 */
public class Problem18 {

    //这一题似乎不能用传统的map来做，因为要返回的是每一个具体的列表而不是个数
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //这个是完完全全仿照 那个三数和的解法，只是这个是先进行两重循环。
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 4)
            return lists;
        int a, b, c, d;
        for (a = 0; a <= nums.length - 4; a++) {
            if (a > 0 && nums[a] == nums[a - 1])
                continue;
            for (b = a + 1; b <= nums.length - 3; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1])
                    continue;
                c = b + 1;
                d = nums.length - 1;
                while (c < d) {
                    if (nums[a] + nums[b] + nums[c] + nums[d] < target)
                        c++;
                    else if (nums[a] + nums[b] + nums[c] + nums[d] > target) {
                        d--;
                    } else {

                        List<Integer> list = new ArrayList<>();
                        list.add(nums[a]);
                        list.add(nums[b]);
                        list.add(nums[c]);
                        list.add(nums[d]);
                        lists.add(list);
                        //否则判断下面是否还有相等的
                        while (c < d && nums[c + 1] == nums[c])      //确保nums[c] 改变了
                            c++;
                        while (c < d && nums[d - 1] == nums[d])      //确保nums[d] 改变了
                            d--;
                        c++;
                        d--;
                    }
                }
            }
        }
        return lists;
    }
}

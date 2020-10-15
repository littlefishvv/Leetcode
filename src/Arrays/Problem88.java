package Arrays;

public class Problem88 {
    /*给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

 

说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 

示例:

输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
    //TODO 还没有解题
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //双指针解法 从数组1中的m+n-1这个下标位置开始，从大到小逐个填
        int k=m+n-1;
        int i=m-1;
        int j=n-1;
        while(i>=0&&j>=0){
            if (nums1[i]<nums2[j]){
                nums1[k]=nums2[j];
                k--;
                j--;
            }else{
                nums1[k]=nums1[i];
                k--;
                i--;
            }
            //因为是nums1比较长，如果最后j还没比完，就把j再依次放到nums1中去。
            while(j>=0) nums1[k--]=nums2[j--];
        }

    }
}

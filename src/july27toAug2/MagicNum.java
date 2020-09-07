package july27toAug2;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/7/31 8:52
 * @description：魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，\
 * 若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
 *

 * @modified By：
 * @version: $
 */
public class MagicNum {
    //如果直接用暴力法，那么如果索引值比较大，就会遍历整个数组
    //因为是有序数组，所以这个程序还是可以优化的 用二分查找进行优化，每次对一半的数组进行findMagicIndex

    public int findMagicIndex(int[] nums){
        int len=nums.length;
        for (int i = 0; i < len; i++) {
            if(nums[i]==i){
                return i;
            }
        }
        return -1;
    }
    //可以用二分查找法来优化
    public int getAnswer(int[] nums,int left,int right){
        if(left>right) return -1;
        int mid=(right-left)/2+left;
        int leftAnswer=getAnswer(nums,left,mid-1);

        if(leftAnswer!=-1){
            return leftAnswer;
        }
        else if (nums[mid]==mid){
            return mid;
        }
        return getAnswer(nums,mid+1,right);
    }
}

package Arrays;
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
public class Problem283 {

    //思路一  遍历一遍找出非0元素存起来，按顺序放回原数组，再把后面补0就行  但是这样做会有多余的时间复杂度
    //思路二  遍历过程中找出非0元素，定义一个指针j代表当前找到的非0元素个数，同时一边找一边把当前非0元素个数那个下标改动为当前找到的非0元素
    //最后把j到n下标全部变为0
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        if(n<=1) return;
        int j=0;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                nums[j]=nums[i];
                j++;
            }
        }
        for(int k=j;k<n;k++){
            nums[k]=0;
        }
    }
    //说实话下面这种解法我没怎么理解
    public void moveZeroes2(int[] nums) {
        int n=nums.length;
        if(n<=1) return;
        int j=0;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }

    }
}

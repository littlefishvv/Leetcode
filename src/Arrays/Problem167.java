package Arrays;

public class Problem167 {
    //从一个已经排好序的数组中找到和两个下标，其对应数值之和为target
    public int[] twoSum(int[] numbers, int target) {
        //使用对撞指针
        int l=0;
        int r=numbers.length-1;
        while(l<r){
            if(numbers[l]+numbers[r]==target){
                return new int[]{l,r};
            }else if (numbers[l]+numbers[r]>target){
                r--;
            }else{
                l++;
            }
        }
        return null;
    }
}

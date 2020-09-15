package Arrays;

public class Problem167 {
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

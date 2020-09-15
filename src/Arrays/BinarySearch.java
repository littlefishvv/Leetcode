package Arrays;

public class BinarySearch {
    //二分查找   有序数组arr  n个数，找target的下标
    int binarySearch(int[] arr,int n,int target){
        int l=0,r=n-1;//在[l...r]范围内寻找target
        //我们在循环中明确了一个循环不变量，也就是说，虽然l和r在变
        //但是我们待寻找的target在l和r的闭区间中是不变的
        //一但我们明确了上面的意义，那这里l=r也是有意义的
        while(l <= r){
            int mid=(l+r)/2;
            if (arr[mid]==target){
                return mid;
            }
            if (target>arr[mid]){
                l=mid+1;
            }else{
                r=mid-1;
            }

        }
        return -1;
    }
    public static void main(String[] args) {

    }
}

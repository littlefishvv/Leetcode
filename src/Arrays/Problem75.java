package Arrays;

public class Problem75 {
    /*给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

注意:
不能使用代码库中的排序函数来解决这道题。

示例:

输入: [2,0,2,1,1,0]
输出: [0,0,1,1,2,2]
进阶：

一个直观的解决方案是使用计数排序的两趟扫描算法。
首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sort-colors
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
    public void sortColors(int[] nums) {
        if(nums.length<=1) return ;
        //计数排序
        int n1=0,n2=0,n3=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) n1++;
            if(nums[i]==1) n2++;
            if(nums[i]==2) n3++;
        }
        for(int i=0;i<n1;i++){
            nums[i]=0;
        }
        for(int i=n1;i<n1+n2;i++){
            nums[i]=1;
        }
        for(int i=n1+n2;i<nums.length;i++){
            nums[i]=2;
        }
        /*//上面这样写不够优雅
        int index=0;
        for(int i=0;i<n1;i++){
            nums[index++]=0;
        }
        for(int i=0;i<n2;i++){
            nums[index++]=1;
        }
        for(int i=0;i<n3;i++){
            nums[index++]=2;
        }*/
    }
    //下面引入一个非常牛逼的算法，三路快排，其中arrays.sort()利用的就是三路快排
    //这道题用的是三路快排的partion过程
    public void sortColors1(int[] nums) {
        //首先明确循环不变量  [0,zero]==0 [two,n-1]==2 那么中间的就是1
        //根据循环不变量，我们把zero的初始值设为-1，two的初始值设为n
        int zero=-1;
        int two=nums.length;
        //这里的for循环不能对i进行++操作
        //对于遍历到的每一个下标为i的元素
        for(int i=0;i<nums.length;){
            //当元素为1， [0,zero]==0 [two,n-1]==2 这些都不会有变化，直接i++
            if(nums[i]==1) i++;
            //当遍历到的元素的值为2，那把当前元素与two前面那个元素交换位置，然后让two-1以维持循环不变量
            else if(nums[i]==2) {
                two--;
               swap(nums,i,two);
            }else{
                //如果遍历到的元素为0，则把当前元素与zero后面那个元素进行交换，zero++
                zero++;
                swap(nums,i,zero);
            }
        }

    }
    public void swap(int[] nums,int n,int m){
       int temp=nums[n];
       nums[n]=nums[m];
       nums[m]=temp;
    }
}

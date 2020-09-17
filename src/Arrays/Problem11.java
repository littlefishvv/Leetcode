package Arrays;

public class Problem11 {
    /*给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
    找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/container-with-most-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/


    //尝试用动态规划去做 以失败告终
    /*public int maxArea(int[] height){
        int n=height.length;
        int[] dp=new int[n];
        dp[0]=Math.min(height[0],height[1]);
        for (int i=1;i<n;i++){
            dp[i]=Math.max(dp[0],Math.max(i*Math.min(height[0],height[i]),Math.min(height[i-1],height[i])));
        }
        return dp[n-1];
    }*/
    //用暴力法去做 时间复杂度o（n^2）
    //int index=0;

    //这一题也是滑动窗口思想啊
     /*  int max=0;
       int index=0;


       //水的容量取决于最低的那个木板如果从left到i，i-left+1  *  min >max 则更新max和left，最后返回这个max
       for(int i=0;i<height.length;i++){
               //当循环下一个i时，记得给原来的min一个初始值
               int min=height[i];
           for(int j=i;j<height.length;j++){

               if(height[j]<=height[i]){
                   min=height[j];
               }else{
                   min=height[i];
               }
               if((j-i)*min>max){
                   max=(j-i)*min;
               }

           }
       }
       return max;*/
     //使用对撞指针
    //思想，我们不用对每一个能构成的组合都遍历一遍，我们只遍历那些可能的组合
    public int maxArea(int[] height){
        int size = height.length;
        int left=0;
        int right=size-1;
        int ans=0;
        while(left<right){
            ans=Math.max(ans,(right-left)*Math.min(height[left],height[right]));
            if (height[left]>height[right]) --right;
            else ++left;
        }
        return ans;
    }

}

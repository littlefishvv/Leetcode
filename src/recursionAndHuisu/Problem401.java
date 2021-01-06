package recursionAndHuisu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/5 20:10
 * @description：
 *
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 *
 *  
 *
 * 示例：
 *
 * 输入: n = 1
 * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 *  
 *
 * 提示：
 *
 * 输出的顺序没有要求。
 * 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
 * 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
 * 超过表示范围（小时 0-11，分钟 0-59）的数据将会被舍弃，也就是说不会出现 "13:00", "0:61" 等时间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-watch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem401 {


    private String getTime(int hour,int min){
        StringBuilder ans = new StringBuilder();
        ans.append(hour).append(":");
        if(min<10){
            ans.append(0);
        }
        ans.append(min);
        return ans.toString();
    }
    //这一题可以转化为在【1,2,4,8 ,1,2,4,8,16,32】中任取n位。可以构成的组合。然后判断取的是小时还是分钟，再分别相加
    List<String> res=new ArrayList<>();
    public List<String> readBinaryWatch(int num) {
        //判断输入
        if(num<0)
            return res;
        //LED灯，前四个为小时，后六个为分钟
        int[] nums=new int[]{8,4,2,1,32,16,8,4,2,1};
        backTrack(num,nums,0,0,0);
        return res;

    }

    public void backTrack(int num,int[] nums,int start,int hour ,int minute){
        System.out.println("当前start为"+start+"当前hour为"+hour+"minute为"+minute);
        if (num==0){
            if(hour>11||minute>59){
                System.out.println("从"+start+"处return,当前hour为"+hour+"minute为"+minute);
                return;

            }
            StringBuffer tmp=new StringBuffer();
            tmp.append(hour);
            tmp.append(":");
            if(minute<10){
                tmp.append(0);
            }
            tmp.append(minute);
            res.add(new String(tmp));
            System.out.println("res.add："+"从"+start+"处return,当前hour为"+hour+"minute为"+minute);
            return;
        }
        for (int i=start;i<nums.length;i++){

            
            if (i<4){
                hour+=nums[i];
                System.out.println("当前i为"+i+"当前hour为"+hour+"minute为"+minute);
            }
            else{
                minute+=nums[i];
                System.out.println("当前i为"+i+"当前hour为"+hour+"minute为"+minute);
            }
            backTrack(num-1,nums,i+1,hour,minute);
            System.out.println("当前start为"+start+"当前hour为"+hour+"minute为"+minute+"上一个back刚往下执行");
            //撤销选择
            if (i<4){
                System.out.println("当前i为"+i+"当前hour为"+hour+"minute为"+minute+"hour做减法");
                hour-=nums[i];

            }else{
                System.out.println("当前i为"+i+"当前hour为"+hour+"minute为"+minute+"min做减法");
                minute-=nums[i];

            }
        }
    }

    public static void main(String[] args) {
        Problem401 p=new Problem401();
        p.readBinaryWatch(2);
    }
}

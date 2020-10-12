package SetAndMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/10/11 16:19
 * @description：
 * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 *
 * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
 *
 * 示例:
 *
 * 输入:
 * [[0,0],[1,0],[2,0]]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-boomerangs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem447 {
    public int numberOfBoomerangs(int[][] points) {
        //对于二维数组中的每一个i点，用map存储每一个点到i点的距离，让距离为key，每多一个这样的距离，value就加1
        int res=0;

        for (int i = 0; i < points.length; i++) {
            //每一轮都要更新map，这点一定要注意噢
            Map<Integer,Integer> map=new HashMap<>();
            for (int i1 = 0; i1 < points.length; i1++) {
                if(i!=i1){
                    int d=distance(points[i],points[i1]);
                    if (!map.containsKey(d)){
                        map.put(d,1);
                    }else{
                        map.put(d,map.get(d)+1);
                    }
                }
                //每查完一轮后，进行res的更新。只有2个以上相同距离的才能算是正确的回旋镖。



            }
            for (Integer key:map.keySet()){
                if (map.get(key)>=2) res+=map.get(key)*(map.get(key)-1);
            }

        }


        return res;

    }
    public int distance(int[] a,int[] b){
        return (b[0]-a[0])*(b[0]-a[0])+(b[1]-a[1])*(b[1]-a[1]);
    }

}

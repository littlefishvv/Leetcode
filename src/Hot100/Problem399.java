package Hot100;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/19 20:32
 * @description：
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 *
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 *
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
 *
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * 解释：
 * 条件：a / b = 2.0, b / c = 3.0
 * 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * 结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/evaluate-division
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class Problem399 {


    //这一题可以通过floiyd算法多源最短路径来做，也可以通过并查集来做
    /*
    *  //k为中间点
    for(k = 0; k < G.vexnum; k++){
        //v为起点
        for(v = 0 ; v < G.vexnum; v++){
            //w为终点
            for(w =0; w < G.vexnum; w++){
                if(D[v][w] > (D[v][k] + D[k][w])){
                    D[v][w] = D[v][k] + D[k][w];//更新最小路径
                    P[v][w] = P[v][k];//更新最小路径中间顶点
                }
            }
        }
    }
    * */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        int count=0;
        //map用于统计出现的所有字符，并赋予对应的index
        Map<String,Integer> map=new HashMap<>();
        for (List<String> list:equations){
            for (String s:list){
                if(!map.containsKey(s)){
                    //a,0  b,1 c2 count先放入才能加一
                    map.put(s,count++);
                }
            }
        }

        //构建一个矩阵来代替图结构
        double[][] graph=new double[count+1][count+1];

        //初始化  让对角线值为1
        for (String s:map.keySet()){
            int x=map.get(s);
            graph[x][x]=1.0;
        }
        int index=0;
        for (List<String> list:equations){
            String a=list.get(0);
            String b=list.get(1);
            //通过字符得到下标
            int aa=map.get(a);
            int bb=map.get(b);
            double value=values[index++];
            //根据valus的值更新初始矩阵。两个值都要更新
            graph[aa][bb]=value;
            graph[bb][aa]=1/value;
        }

        //通过Floyd算法进行运算
        int n=count+1;
        //i为中间跳板点
        for (int i=0;i<n;i++){
            //起点
            for (int j=0;j<n;j++){
                //终点
                for (int k=0;k<n;k++){
                    if(j==k||graph[j][k]!=0) continue;
                    //如果j可以走到i，并且i可以走到k，就尝试更新j到k的路径。
                    if(graph[j][i]!=0&&graph[i][k]!=0){
                        //不是+  而是*
                        graph[j][k]=graph[j][i]*graph[i][k];
                    }
                }
            }
        }

        //直接通过查询矩阵得到答案
        double[] res=new double[queries.size()];
        for (int i=0;i<res.length;i++){
            List<String> q=queries.get(i);
            String a=q.get(0);
            String b=q.get(1);
            if(map.containsKey(a)&&map.containsKey(b)){
                double ans=graph[map.get(a)][map.get(b)];
                res[i]=(ans==0?-1.0:ans);
            }else {
                res[i]=-1.0;
            }
        }
        return res;


    }
   /* private boolean isIn(List<List<String>> equations,List<String> queries){
        boolean a=false;
        boolean b=false;
        for (int i = 0; i < equations.size(); i++) {
            if (equations.get(i).contains(queries.get(0))){
                a=true;
            }
            if (equations.get(i).contains(queries.get(1))){
                b=true;
            }
        }
        return a&&b;

    }*/
}

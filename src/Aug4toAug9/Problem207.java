package Aug4toAug9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/8/4 16:57
 * @description：你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 * @version: $
 */
/*输入: 2, [[1,0],[0,1]]
        输出: false
        解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/course-schedule
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Problem207 {
    //这一题其实就是拓扑排序，画个图更直观，从入度为0的课程开始算起，当最后所有课程都是入度为0时说明可以学习，如果最后还有课程的入度不为0，说明有环，也就说明选修课程矛盾
    //如果是以入度为切入点，那么其实就是多源广度优先搜索
    //如果以出度为切入点，就是深度优先搜索
   //如果课程安排为有向无环图，就说明课程安排正确

    //方法一：广度优先搜索
    public boolean canFinish(int numCourses,int[][] prerequisites){
        //定义一个入度表
        int[] indegrees=new int[numCourses];
        //定义一个邻接表
        List<List<Integer>> adjacency=new ArrayList<>();
        //定义一个队列当节点的入度为0把这个从队列中去除
        Queue<Integer> queue=new LinkedList<>();
        //初始化邻接表
        for (int i=0;i<numCourses;i++){
            adjacency.add(new ArrayList<>());
        }
        //这是构建邻接表的过程，indegree[i]为i节点的入度值。adjacency.get(i)是一个list，代表i节点对应的临界表，是指从i出发，可以直接到达的节点
        //这个挺巧妙的 下标就是节点。indegree[i] 和adjacency.get(i)都有其特殊的意义，而是还是直接赋值的
        for(int[] cp:prerequisites){
            indegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }
        //得到所有入度为0的节点 存入队列中
        for(int i=0;i<numCourses;i++){
            if(indegrees[i]==0){
                ((LinkedList<Integer>) queue).add(i);
            }
        }
        while (!queue.isEmpty()){
            int pre=queue.poll();
            numCourses--;
            //让这个顶点所对应的邻接顶点的入度减一
            for (int cur:adjacency.get(pre)){
                //如果入度变成了0就把这个顶点也加进去
                if (--indegrees[cur]==0) ((LinkedList<Integer>) queue).add(cur);
            }

        }



        return numCourses==0;

    }

    //方法2：深度优先搜索
    public  boolean canFinish2(int numCourses,int[][] prerequisites){
        List<List<Integer>> adjacency = new ArrayList<>();
        //初始化邻接表
        for (int i=0;i<numCourses;i++){
            adjacency.add(new ArrayList<>());
        }
        int[] flags=new int[numCourses];
        for (int[] cp:prerequisites){
            adjacency.get(cp[1]).add(cp[0]);
        }
        //对0--i门课程进行遍历  当访问到
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjacency,flags,i)) return false;
        }
        return true;
    }
    private boolean dfs(List<List<Integer>> adjacency,int[] flags,int i){
        if (flags[i]==1) return false;
        if (flags[i]==-1) return true;
        flags[i]=1;
        //开始深度优先
        for (Integer j:adjacency.get(i))
            if (!dfs(adjacency,flags,j)) return false;
        //当当前节点没有其他分叉节点时就设置为-1 说明已经被访问过
        flags[i]=-1;
        return true;
    }


}

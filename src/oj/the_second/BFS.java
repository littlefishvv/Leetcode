package oj.the_second;

import java.util.*;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/3/6 9:43
 * @description：
 * @modified By：
 * @version: $
 */

//oj上面的图的深度优先遍历，要注意的一点就是需要自己处理输入
public class BFS {
	static int d=-1,ans=0;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		while (sc.hasNext()){
			int t=sc.nextInt();
			//测试用例的个数
			for(int i=0;i<t;i++){
				//这两个分别是点的个数，和起使节点
				int n=sc.nextInt();
				String beginPoint=sc.next();
				HashMap<String,Integer> nameToIndex=new HashMap<>(n);
				HashMap<Integer,String> indexToname=new HashMap<>(n);
				//这一行是那几个结点
				for(int j=0;j<n;j++){
					String edgeName=sc.next();
					//形成点到索引的映射
					nameToIndex.put(edgeName,j);
					indexToname.put(j,edgeName);
				}
				int[][] edges=new int[n][n];
				for(int j=0;j<n;j++){
					//第一个字符是结点名
					String curEdge=sc.next();
					//取出结点名对应的索引
					int curIndex=nameToIndex.get(curEdge);
					//获得点之间的联系
					for(int k=0;k<n;k++){
						edges[curIndex][k]=sc.nextInt();
					}
				}
				//int res= problem(beginPoint, edges, nameToIndex, indexToname);
				//System.out.println(res);
				BFS b=new BFS();
				boolean[] visit=new boolean[edges.length];
				System.out.println(getDepth(nameToIndex.get(beginPoint),edges,visit));;

			}



		}

	}
	//下面就可以写出。根据邻接矩阵和起使点，以及结点名称的映射，广度优先遍历图
	private static List<String> problem1(String beginPoint, int[][] edges
			, HashMap<String, Integer> NameToIndexMap, HashMap<Integer, String> IndexToNameMap) {
		int beginIndex=NameToIndexMap.get(beginPoint);
		HashSet<Integer> visited=new HashSet<>();
		Queue<Integer> queue=new LinkedList<>();
		queue.offer(beginIndex);
		List<String> res=new ArrayList<>(edges.length);
		while (!queue.isEmpty()){
			//顶点对应的下标
			int curIndex=queue.poll();
			if(visited.contains(curIndex)){
				continue;
			}
			visited.add(curIndex);
			String curName=IndexToNameMap.get(curIndex);
			res.add(curName);
			//对当前邻接矩阵行行进行遍历
			for (int i=0;i<edges.length;i++){
				//如果和i下标对应的结点是联通的，就放入队列中
				if(edges[curIndex][i]==1){
					queue.offer(i);
				}
			}


		}
		return res;
	}
	private static int problem(String beginPoint, int[][] edges
			, HashMap<String, Integer> nameToIndexMap, HashMap<Integer, String> indexToNameMap) {
		int beginIndex = nameToIndexMap.get(beginPoint);
		HashSet<Integer> visited = new HashSet<>();

		return dfs(beginIndex, edges, indexToNameMap, visited, 0);

	}


	//该方法得到的是以i为起使结点的最大深度。
	//用depth来记录当前深度 这个当前深度是相对于起使结点的当前深度
	private static int dfs(int beginIndex, int[][] edges
			,  HashMap<Integer, String> IndexToNameMap,HashSet<Integer> hashSet,int depth) {
        //这里返回时为了防止产生环路而进入死循环
		System.out.println("当前深度--"+depth);
		if (hashSet.contains(beginIndex)){
			return depth;
		}
		hashSet.add(beginIndex);
		//只要这个点可以遍历，就让depth+1 这个是为了让没有结点可以遍历的那些有1的深度
		int curDepth=depth+1;
		//遍历可以连接的点，计算能连接的点可以构成的最大深度max(dfs(1),dfs(2)) 不断地更新curDepth
		for (int i=0;i<edges.length;i++){
			if (edges[beginIndex][i]==1){
				//这里要传入depth+1是因为进入下个结点，当前深度加一
				curDepth=Math.max(dfs(i,edges,IndexToNameMap,hashSet,depth+1),curDepth);
			}
		}
		return curDepth;


	}
    //说实话，这一题浪费了我大量的时间，实际上，是完全可以写出来的，如果面试连这种都写不出来，就完蛋了
	private  static int  getDepth(int a,int[][] edges,boolean[] visit){

        if(a>edges.length) return 0;
        visit[a]=true;
		int max=1;
		//思路就是不断以能访问到的点为下一个结点，找下一个结点的最大高度，并更新最大高度
		for(int i=0;i<edges.length;i++){
			if(edges[a][i]==1&&visit[i]==false){
				visit[i]=true;
				int temp=1+getDepth(i,edges,visit);
				if (temp>max)
					max=temp;
				//记得取消选中，因为当一个结点被访问后，其余结点依然要访问它
				visit[i]=false;
			}
		}
		return max;
	}


}

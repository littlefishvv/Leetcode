package Aug10toAug16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/8/16 15:25
 * @description：给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。  图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node
 * @modified By：
 * @version: $
 */
public class Problem133 {
    //题目给的是，一个  无向图节点 的引用  这个节点有他自己的val和邻居节点，同时每个邻居节点有他们的值和他们的邻居节点 也是一个node数据结构
    //既然是深拷贝，其中的节点不再是原来节点的引用，那就是所有的节点和临界节点都要new出来
    //既然是无向图，如果不对访问过的节点做标记，则会陷入死循环中。这个hashmap就是把访问的节点存储起来，
    //不使用哈希表时，A克隆它的相邻节点B，而B同样克隆他的相邻节点A，会陷入死循环
    //key是node（原有的node），value是克隆的node（新建的node）。
    private HashMap<Node,Node> visited=new HashMap<>();
    public Node cloneGraph(Node node){
        if (node==null) return node;
        //如果该节点访问过了，则直接从哈希表中取出对应的clone节点返回
        if(visited.containsKey(node)) return visited.get(node);
        //如果该节点没有访问过，则new一个节点，值相同，邻居节点为空，
        Node cloneNode=new Node(node.val,new ArrayList<>());
        //把这个节点放到已访问过的节点中去，
        //注意：在进入递归之前，必须先创建克隆节点并保存在哈希表中。如果不保证这种顺序，可能会在递归中再次遇到同一个节点，再次遍历该节点时，陷入死循环。
        visited.put(node,cloneNode);
        //遍历原node的邻居节点，把其邻居节点也加入到该new的节点中，那么填加邻居节点时，也要有克隆操作
        for (Node neighbor:node._neighbors){
            cloneNode._neighbors.add(cloneGraph(neighbor));
        }
        return  cloneNode;
    }

    //如果用广度优先，
    public Node cloneGraph2(Node node){
       if (node==null) return node;
       HashMap<Node,Node> visited=new HashMap<>();
       //
        LinkedList<Node> queue=new LinkedList<>();
        queue.add(node);
        visited.put(node,new Node(node.val,new ArrayList<>()));
        while (!queue.isEmpty()){
            Node n=queue.remove();
            for (Node neightbor:n._neighbors){
                if (!visited.containsKey(neightbor)){
                    visited.put(neightbor,new Node(neightbor.val,new ArrayList<>()));
                    queue.add(neightbor);
                }
            }
        }
        return visited.get(node);
    }
}

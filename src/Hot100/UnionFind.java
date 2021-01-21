package Hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/20 10:53
 * @description：
 * 实现一个并查集
 * @modified By：
 * @version: $
 */
public class UnionFind {
    //（x,y）代表x的父节点是y
    private Map<Integer,Integer> father;
    //对于省份那道题而言，我们需要记录下联通分量也就是集合的数量
    private int numOfSets=0;
    public UnionFind(){
        father=new HashMap<Integer, Integer>();
        numOfSets=0;
    }
    //默认添加单独的结点，其父节点为kong
    public void add(int x){
        if (!father.containsKey(x)){
            father.put(x,null);
            //添加时让集合加一
            numOfSets++;
        }
    }

    //并查集的合并，如果父节点一致，就合并，让x指向y
    public void merge(int x,int y){
        int rootX=find(x);
        int rootY=find(y);

        if (rootX!=rootY){
            father.put(rootX,rootY);
            //合并时让集合减一
            numOfSets--;
        }
    }


    //并查集的查找父节点。如果该并查集中没有该元素，那么返回当前元素，而不是返回空，这点很重要。
    public int find(int x){
        int root=x;
        //一直循环查找父节点
        while(father.get(root)!=null){
            root=father.get(root);
        }
        //进行路径压缩
        /*
        * 如果我们树很深，比如说退化成链表，那么每次查询的效率都会非常低。所以我们要做一下路径压缩。也就是把树的深度固定为二。

这么做可行的原因是，并查集只是记录了节点之间的连通关系，而节点相互连通只需要有一个相同的祖先就可以了。

路径压缩可以用递归，也可以迭代。这里用迭代的方法。

        * */
        //这里是把已经找到的父节点为root的那一整条路径上的所有结点的父节点通过迭代都设置为root。
        while(x!=root){
            //那条路径上的第一个父节点，单独找出来。
            int ori_father=father.get(x);
            //构造高度为2的关系。
            father.put(x,root);
            x=ori_father;
        }
        return root;
    }

    //如果两个根节点的父节点相当，说明这两个结点在一个集合里，是联通的。
    public boolean isConnected(int x,int y){
        return find(x)==find(y);
    }
    public int getNumOfSets() {
        return numOfSets;
    }

}

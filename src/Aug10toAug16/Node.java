package Aug10toAug16;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/8/16 15:22
 * @description：一个图的节点 数据结构
 * @modified By：
 * @version: $
 */
public class Node {
    public int val;
    public List<Node> _neighbors;
    public Node(){

    }
    public Node(int val){

    }
    public Node(int _val, ArrayList<Node> neighbors){
        val=_val;
        neighbors= (ArrayList<Node>) _neighbors;
    }


}

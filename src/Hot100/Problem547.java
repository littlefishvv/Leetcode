package Hot100;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Union;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/20 11:41
 * @description：
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 *
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 *
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 *
 * 返回矩阵中 省份 的数量。
 *输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2

 * @modified By：
 * @version: $
 */
public class Problem547 {
    public int findCircleNum(int[][] isConnected) {
        UnionFind uf=new UnionFind();
        for (int i = 0; i < isConnected.length; i++) {
            //add(i)是把第i个省份加进去，那么numOfSets++ 如果i已经存在就不加了。
            uf.add(i);
            //遍历这个省份的关系。
            for (int j = 0; j < i; j++) {
                //如果ij是连着的，就让i和j合并，合并会让numOfsets减一。
                if (isConnected[i][j]==1){
                    uf.merge(i,j);
                }
            }
        }
        //返回集合的数量。
        return uf.getNumOfSets();
    }
}

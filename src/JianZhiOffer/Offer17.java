package JianZhiOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/2/6 18:00
 * @description：
 * @modified By：
 * @version: $
 */
public class Offer17 {
    // 用于存储满足条件的字符串
    private List<Integer> list;

    public int[] printNumbers(int n) {
        // 存储符合条件的'数'  '数'的类型是字符串
        list = new ArrayList<>();
        dfs(n, 0, new StringBuilder());
        int[] res = new int[list.size()];
        // 存入数组
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void dfs(int n, int index, StringBuilder sb) {
        // 递归结束的条件
        if (index == n) {
            while (sb.length() != 0 && sb.charAt(0) == '0') {
                // 将左边多余的0删除
                sb.deleteCharAt(0);
            }
            // 将字符串形式的'数'，转化为整数
            if (sb.length() != 0) {
                list.add(Integer.valueOf(sb.toString()));
            }
            return;
        }
        for (int j = 0; j < 10; j++) {
            // 深度搜索下一位
            sb.append(j);
            dfs(n, index + 1, sb);
            if (sb.length() != 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

}

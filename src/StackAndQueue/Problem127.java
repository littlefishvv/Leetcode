package StackAndQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2020/11/10 17:21
 * @description：
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */

public class Problem127 {
    //辅助判断可以转换的函数
    public boolean canChange(String s,String t){
        int len=s.length();
        int diff=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)!=t.charAt(i)) diff++;
        }
        return diff==1;
    }
    //todo 这个广度优先搜索有很大的优化空间，以后再说
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        //标记位
        boolean[] marked=new boolean[wordList.size()-1];
        //就是找在第几轮能找到目标元素，返回这个轮数。
        int layer=1;
        while(!queue.isEmpty()){
            layer++;
            int size=queue.size();
            while(size>0){
                String cur=queue.poll();
                for (int i = 0; i < wordList.size(); i++) {
                    if(marked[i]) continue;
                    String dic=wordList.get(i);
                    if (canChange(dic,cur)){
                        if (dic.equals(endWord)) return layer;
                        queue.add(dic);
                        marked[i]=true;
                    }


                }
                size--;
            }
        }
        return 0;
    }
}

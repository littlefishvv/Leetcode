package Hot100;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/19 17:52
 * @description：
 * 实现一个前缀树
 * @modified By：
 * @version: $
 */
public class Trie {

    private boolean is_string=false;
    //对26个字母都建立前缀树 abcd分别对应0--25的下标。TrieNode* next[26]中保存了对当前结点而言下一个可能出现的所有字符的链接，因此我们可以通过一个父结点来预知它所有可能子结点的值：
    private Trie[] next = new Trie[26];

    public Trie(){}


    /*
    * 首先从根结点的子结点开始与 word 第一个字符进行匹配，一直匹配到前缀链上没有对应的字符，
     * 这时开始不断开辟新的结点，直到插入完 word 的最后一个字符，同时还要将最后一个结点isEnd = true;，表示它是一个单词的末尾。
    * */
    public void insert(String word){
        //从当前前缀树开始
        Trie root=this;
        char w[]=word.toCharArray();
        for (int i = 0; i < w.length; i++) {
            //如果为空，就在次新建前缀树 其实在哪里有前缀树，就说明这个前缀树代表的是哪个字母。然后进入这个前缀树，继续新建前缀树。
            if (root.next[w[i]-'a']==null) root.next[w[i]-'a']=new Trie();
            //进入这颗前缀树
            root=root.next[w[i]-'a'];
        }
        //表示，这就是单词的终点
        root.is_string=true;
    }

    //前缀树 查找
    public boolean search(String word){
        //当前前缀树
        Trie root=this;
        char[] w=word.toCharArray();
        //只要中间有一个字母不满足，就返回false
        for (int i = 0; i < w.length; i++) {
            if (root.next[w[i]-'a']==null) return false;
            root=root.next[w[i]-'a'];
        }
        //如果整个字符串都满足，但如果不是终点，也返回false
        return root.is_string;
    }


    //前缀树前缀 逻辑和查找一样，但唯一区别是不需要判断是不是终点。
    public boolean startsWith(String p){
        Trie root=this;
        char[] w=p.toCharArray();

        for (int i = 0; i < w.length; i++) {
            if (root.next[w[i]-'a']==null) return false;
            root=root.next[w[i]-'a'];
        }
        //不需要判断这是不是终点，可以直接返回false 因为无论是不是终点，只要包含了就可以返回true
        return true;
    }


}

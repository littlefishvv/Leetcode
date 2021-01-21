package Hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/19 17:44
 * @description：
 * @modified By：
 * @version: $
 */
public class Tire {
    List<String> list;
    public Tire() {
        list=new ArrayList<>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        list.add(word);

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
       return list.contains(word);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        for (int i = 0; i < list.size(); i++) {
            //这里是等于0而不是大于0  因为是开头
            if (list.get(i).indexOf(prefix)==0) return true;
        }
        return false;
    }
}

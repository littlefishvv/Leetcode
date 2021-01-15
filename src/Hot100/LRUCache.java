package Hot100;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/1/14 14:19
 * @description：
 * @modified By：
 * @version: $
 */
public class LRUCache extends LinkedHashMap {
    private int capacity;
    public LRUCache(int capacity){
        super(capacity,0.75F,true);
        this.capacity=capacity;
    }

    public int get(int key){
        return (int) super.getOrDefault(key,-1);

    }

    public void put(int key,int value){
        super.put(key,value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size()>capacity;
    }
}

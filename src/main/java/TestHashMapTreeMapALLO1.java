import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

/**
 * @description: 描述
 * @author: dekai.kong (dekai.kong@luckincoffee.com)
 * @date: 2018-10-27 10:50
 */


public class TestHashMapTreeMapALLO1 {
    static TreeMap<Integer, HashSet<Object>> vkMap = new TreeMap<Integer, HashSet<Object>>();
    static HashMap<String,Integer> kvMap  = new HashMap<>();

    public static void main(String[] args) {
        inc("hello");
        inc("goodbye");
        inc("hello");
        inc("hello");
        System.out.println(getMaxKey());
        inc("leet");
        inc("code");
        inc("leet");
        dec("hello");
        inc("leet");
        inc("code");
        inc("code");
        System.out.println(getMaxKey());
        System.out.println(getMinKey());
    }

    /**
     * 核心在于构建两个索引,一个是 key-fre,一个是fre-set(key) 这样才能实现快速的查找
     * treemap 是一个可以排序key的map
     */
    /***
     * 其实这个treemap的方式并不是O(1),而是红黑树,O(logn).但是数据量小的时候体现不出来,数据量大了红黑树又特别快 所以过了OJ
     * 可以使用List的new ArrayList().listIterator();Iterator,实现双向链表,从而达到O(1)
     *
     */


    /** Initialize your data structure here. */
    public TestHashMapTreeMapALLO1() {
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */

    public static void inc(String key) {
        if (kvMap.containsKey(key) == false){
            kvMap.put(key,1);
            if(vkMap.containsKey(1) == false)
                vkMap.put(1,new HashSet<Object>());
            vkMap.get(1).add(key);
        } else{
            int currentCounts = kvMap.get(key);
            vkMap.get(currentCounts).remove(key);
            // 这里必须要做remove,因为treemap要直接firstkey()或者lastkey,下面dec同理
            if(vkMap.get(currentCounts).size() == 0){
                vkMap.remove(currentCounts);
            }
            if(vkMap.containsKey(currentCounts + 1) == false){
                vkMap.put(currentCounts + 1,new HashSet<>());
            }
            kvMap.put(key,currentCounts + 1);
            vkMap.get(currentCounts + 1).add(key);
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public static void dec(String key) {
        if(kvMap.containsKey(key)){
            int currentCounts = kvMap.get(key);
            vkMap.get(currentCounts).remove(key);
            if(vkMap.get(currentCounts).size() == 0){
                vkMap.remove(currentCounts);
            }
            if(currentCounts == 1){
                kvMap.remove(key);
            } else{
                if(vkMap.containsKey(currentCounts - 1) == false){
                    vkMap.put(currentCounts - 1,new HashSet<>());
                }
                vkMap.get(currentCounts -1).add(key);
                kvMap.put(key,currentCounts - 1);
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    public static Object getMaxKey() {
        if (kvMap.size() == 0 ) return "";
        return vkMap.get(vkMap.lastKey()).iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public static Object getMinKey() {
        if (kvMap.size() == 0 ) return "";
        return vkMap.get(vkMap.firstKey()).iterator().next();
    }

}

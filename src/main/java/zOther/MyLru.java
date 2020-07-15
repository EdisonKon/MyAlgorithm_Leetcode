package zOther;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dekai.kong
 * @difficult
 * @create 2020-07-15 14:31
 * @from
 **/
public class MyLru {
    //大小为5的数组
    private int[] lru = new int[5];
    private Map<Integer,Integer> mapx = new HashMap(5);
    private Map<Integer,Integer> mapIndex = new HashMap(5);
    public MyLru() {

    }

    public void put(int key,int val){
        if(mapIndex.get(key)==null&&mapIndex.size()==5){
            int last = lru[5];
            mapx.remove(last);
            mapIndex.remove(last);
            order(0,lru.length);
            lru[0] = key;
            mapIndex.put(key,0);
            mapx.put(key,val);
        }else if(mapIndex.get(key)==null){
            mapx.put(key,val);
            int cur = 5-mapIndex.size()-1;
            lru[cur] = key;
            mapIndex.put(key,cur);
        }else{
            //todo 有值重排序
        }
    }

    public void order(int from,int to){
        //遍历向后排
        for (int i = from; i < to-1; i++) {
            lru[i+1] = lru[i];
            mapIndex.put(lru[i],i+1);
        }
    }

    public int get(int key){
        Integer val = mapx.get(key);
        return val==null?-1:val;
    }

    @Test
    public void test() {
        MyLru myLru = new MyLru();
        myLru.put(1,1);
        myLru.put(2,1);
        myLru.put(3,1);
        myLru.put(4,1);
        myLru.put(5,1);
        System.out.println(myLru.get(1));
    }
}

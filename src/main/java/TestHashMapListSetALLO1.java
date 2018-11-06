import java.util.*;

/**
 * @description: 描述
 * @author: dekai.kong (dekai.kong@luckincoffee.com)
 * @date: 2018-10-27 10:50
 */


public class TestHashMapListSetALLO1 {
    static Map<String,Integer> kvMap = new HashMap<>();
    static List<HashSet<Object>> vkList = new LinkedList<HashSet<Object>>();
    static int minIndex = 1;
    static int maxIndex = 1;
    static int minTempIndex = 1;

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
        System.out.println("minIndex");
        System.out.println(getMaxKey());
        System.out.println(getMinKey());
        System.out.println(kvMap);
    }

    public static void inc(String key){
        int keyVal = kvMap.getOrDefault(key,0);
        if(keyVal!=0){
            if(keyVal+1 > vkList.size()){
                vkList.add(new HashSet<>());
            }
            vkList.get(kvMap.get(key)-1).remove(key);
            vkList.get(kvMap.get(key)).add(key);
            kvMap.put(key,keyVal+1);
            if(vkList.get(keyVal-1).size()==0 && vkList.get(minIndex-1).size() == 0){
                minIndex = Math.max(minIndex,kvMap.get(key));
            }
            maxIndex = Math.max(kvMap.get(key),maxIndex);
        }else{
            if(vkList.size() == 0){
                vkList.add(new HashSet<>());
            }
            vkList.get(0).add(key);
            kvMap.put(key,1);
            minIndex = Math.min(minIndex,1);
        }
        minTempIndex = maxIndex;
    }
    public static void dec(String key){
        int keyVal = kvMap.getOrDefault(key,0);
        if(keyVal!=0){//存在
            if(keyVal==1){
                vkList.get(0).remove(key);
                kvMap.remove(key);
                if(vkList.get(0).size()== 0 ){
                    minIndex = minTempIndex;
                }
            }else{
                vkList.get(keyVal-1).remove(key);
                if(vkList.get(keyVal-1).size() == 0 && vkList.get(maxIndex-1).size() == 0){
                    maxIndex = Math.min(maxIndex,keyVal-1);
                }else{
                    maxIndex = Math.max(maxIndex,keyVal);
                }
                vkList.get(keyVal-2).add(key);
                kvMap.put(key,keyVal-1);
                if(vkList.get(keyVal-2).size()>1){
                    minTempIndex = keyVal-1;
                }
                minIndex = Math.min(minIndex,keyVal-1);
            }
        }
    }
    public static String getMaxKey(){
        if(vkList.size()>0) {
            if (vkList.get(maxIndex-1).size() > 0) {
                return (String) vkList.get(maxIndex-1).toArray()[0];
            }
        }
        return "";
    }
    public static String getMinKey(){
        if(vkList.size()>0){
            if(vkList.get(minIndex-1).size()>0){
                return (String)vkList.get(minIndex-1).toArray()[0];
            }
        }
        return "";
    }
}

package MyArrays;

import org.junit.Test;

import java.util.*;

/**
 * @author dekai.kong
 * @difficult medium
 * @create 2020-07-26 17:03
 * @from 获得一个数组中的2个数,相加等于指定数
 **/
public class TwoSumEqualk {
    public TwoSumEqualk() {

    }

    /**
     * 双指针方式 O(nlogn)
     * @param a
     * @param k
     * @return
     */
    public List<String> getPart(int[] a,int k){
        List<String> list = new ArrayList<>();
        //是否排序,如果排序的,不用排序了
        Arrays.sort(a);
        int i = 0;
        int j = a.length-1;

        while(i<j){
            if(a[i]+a[j] == k){
                list.add(a[i]+","+a[j]);
                i++;
                j--;
            }else if(a[i] + a[j] > k){
                j--;
            }else{
                i++;
            }
        }
        return list;
    }

    /**
     * 使用hash o(n)
     * @param a
     * @param k
     * @return
     */
    public List<String> getPart2(int[] a,int k) {
        List<String> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            int val = k - a[i];
            if(map.get(val)!=null){
                list.add(a[i]+","+val);
            }else{
                map.put(a[i],i);
            }
        }

        return list;
    }

    @Test
    public void test() {
//        getPart(new int[]{1,2,3,4,5,6},7);
        getPart2(new int[]{1,2,3,4,5,6},7);
    }
}

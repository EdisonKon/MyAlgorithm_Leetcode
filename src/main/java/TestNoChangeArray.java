import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 描述
 * @author: dekai.kong (dekai.kong@luckincoffee.com)
 * @date: 2018-11-01 10:13
 */


public class TestNoChangeArray {
    static List<Integer> listArr ;
    public TestNoChangeArray() {
        listArr = new ArrayList<>();
    }

    public void initArray(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(i == 0){
                listArr.add(nums[i]);
            }else{
                listArr.add(listArr.get(i-1)+nums[i]);
            }
        }
    }

    public int sumRange(int i, int j) {
        int x = i==0?listArr.get(j):listArr.get(j)-listArr.get(i-1);
        System.out.println(x);
        return x;
    }

    @Test
    public void test (){
        int[] x = {-1};
        TestNoChangeArray t = new TestNoChangeArray();
        initArray(x);
        t.sumRange(0, 0);
    }
}

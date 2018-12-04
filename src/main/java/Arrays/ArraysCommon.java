package Arrays;

import org.junit.Test;

/**
 * @description: 描述 util
 * @author: dekai.kong
 * @date: 2018-12-04 18:07
 * @from
 */

public class ArraysCommon {
    public ArraysCommon() {

    }
    public int[] myReverse(int[] nums) {
        for(int i = 0; i < nums.length / 2; i++)
        {
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }
        return nums;
    }
    public int[] myReverse(int[] nums,int from,int end) {
        int len = from+end;
        for(int i = from; i < len / 2; i++)
        {
            int temp = nums[i];
            nums[i] = nums[len - i - 1];
            nums[len - i - 1] = temp;
        }
        return nums;
    }

    @Test
    public void test() {
//        myReverse(new int[]{1,2,3,4,5,6});
        myReverse(new int[]{1,2,3,4,5,6,7},3,7);
    }
}


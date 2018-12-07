package Arrays;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author dekai.kong
 * @difficult easy
 * @create 2018-12-03 20:30
 * @from https://leetcode.com/problems/remove-element/
 *
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 **/
public class RemoveElement {
    public RemoveElement() {

    }

    /**
     * leetcode 倒着复制去除
     */
    public int removeElement3(int[] A, int elem) {
        int len = A.length;
        for (int i = 0 ; i< len; ++i){
            while (A[i]==elem && i< len) {
                A[i]=A[--len];
            }
        }
        return len;
    }

    /**
     * Runtime: 5 ms, faster than 83.61% of Java online submissions for Remove Element.
     * @param nums
     * @param val
     * @return
     */
    public int removeElement2(int[] nums, int val) {
        int cur = 0;
        int len = 0;
        int i = 0;
        while(i<nums.length){
            if(nums[i] != val){
                nums[cur] = nums[i];
                len++;
                cur++;
            }else{
                nums[cur] = nums[i];
            }
            i++;
        }
        return len;
    }
    /**
     * Runtime: 6 ms, faster than 51.24% of Java online submissions for Remove Element.
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                len++;
            }else{
                nums[i] = Integer.MAX_VALUE;
            }
        }
        Arrays.sort(nums);
        return len;
    }

    @Test
    public void test(){
        removeElement2(new int[]{1,1,1,2,2,3,5,1,1,4},1);
    }
}

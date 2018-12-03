package Arrays;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author dekai.kong
 * @difficult Easy
 * @create 2018-12-03 20:26
 * @from https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * 要求返回的还是原数组，但是返回的值是该数组的长度
 **/
public class RemoveDuplicatesfromSortedArray {
    public RemoveDuplicatesfromSortedArray() {
    }

    /**
     * leetcode
     * Runtime: 6 ms, faster than 98.50% of Java online submissions for Remove Duplicates from Sorted Array.
     */
    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int end = 0, i = 0;
        while (i < nums.length) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                i++;
            } else {
                nums[end++] = nums[i++];
            }
        }
        return end;
    }

    /**
     * Runtime: 7 ms, faster than 87.45% of Java online submissions for Remove Duplicates from Sorted Array.
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int tem = 0;
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i == 0){
                tem = nums[i];
                len ++;
            }else{
                if(tem != nums[i]){
                    tem = nums[i];
                    len ++;
                }else{
                    nums[i] = Integer.MAX_VALUE;
                }
            }
        }
        Arrays.sort(nums);
        return len;
    }

    @Test
    public void test(){
        removeDuplicates(new int[]{1,1,2,2,3,3,4,5});
    }
}

package Integers;

import org.junit.Test;

/**
 * @description: 描述 Medium
 * @author: dekai.kong
 * @date: 2018-12-25 17:06
 * @from https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 * Given nums = [1,1,1,2,2,3],
 *
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 *
 * Given nums = [0,0,1,1,1,1,2,3,3],
 *
 * Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
 *
 * It doesn't matter what values are set beyond the returned length.
 * Clarification:
 *
 * Confused why the returned value is an integer but your answer is an array?
 *
 * Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
 *
 * Internally you can think of this:
 *
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 *
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 */

public class RemoveDuplicatesfromSortedArrayII {
    public RemoveDuplicatesfromSortedArrayII() {

    }

    /**
     * 未优化if条件
     * Runtime: 8 ms, faster than 56.77% of Java online submissions for Remove Duplicates from Sorted Array II.
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        int tem = 1;
        int times = 0;
        int idx = 0;
        int temv;
        //如果不到3个数那直接返回就ok
        if(nums.length<3){
            return nums.length;
        }
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]){
                tem++;
                if(tem == 3){
                    idx = i;
                }
            }else if(idx>0 && nums[i] == nums[idx-1]){
                tem++;
                if(tem < 3){
                    temv = nums[idx];
                    nums[idx] = nums[i];
                    nums[i]= temv;
                    idx++;
                }
            }else{
                if(idx>0){
                    temv = nums[idx];
                    nums[idx] = nums[i];
                    nums[i]= temv;
                    idx++;
                }
                while(tem>2){
                    times++;
                    tem--;
                }
                tem=1;
            }
        }
        while(tem>2){
            times++;
            tem--;
        }
        return nums.length - times;
    }

    /**
     * Runtime: 6 ms, faster than 94.13% of Java online submissions for Remove Duplicates from Sorted Array II.
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int tem = 1;
        int times = 0;
        int idx = 0;
        int temv;
        //如果不到3个数那直接返回就ok
        if(nums.length<3){
            return nums.length;
        }
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]){
                tem++;
                if(tem == 3){
                    idx = i;
                }
            }else{
                if(tem>2) {
                    times += tem - 2;
                    tem=0;
                }
                if(tem == 2 && idx==0){
                    tem=1;
                }
                if(idx>0){
                    if(nums[i] != nums[idx-1]){
                        tem = 1;
                    }else if(tem < 3){
                        tem++;
                    }
                    if(tem<3){
                        temv = nums[idx];
                        nums[idx] = nums[i];
                        nums[i]= temv;
                        idx++;
                    }
                }

            }
        }
        if(tem>2)
            times += tem - 2;
        return nums.length - times;
    }

    @Test
    public void test() {
//        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
//        System.out.println(removeDuplicates(new int[]{1,1,1,2,2,3}));
//        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
//        System.out.println(removeDuplicates(new int[]{1,1,1}));
//        System.out.println(removeDuplicates(new int[]{0,1,1,1,2,3,3,3,3,4,4}));
        System.out.println(removeDuplicates(new int[]{0,1,2,2,2,2,2,3,4,4,4}));
    }
}


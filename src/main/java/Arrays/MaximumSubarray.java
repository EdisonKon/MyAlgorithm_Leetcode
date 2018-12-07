package Arrays;

import org.junit.Test;

/**
 * @Author dekai.kong
 * @description: 难度 Easy
 * @create: 2018-12-06 21:53
 * @from: https://leetcode.com/problems/maximum-subarray/
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 **/

public class MaximumSubarray {
    public MaximumSubarray() {
    }

    /**
     * Runtime: 6 ms, faster than 99.94% of Java online submissions for Maximum Subarray.
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(sum < 0){
                sum = nums[i];
            }else{
                sum += nums[i];
            }
            if(max <sum){
                max = sum;
            }
        }
        return max;
    }
    /**
     * Runtime: 7 ms, faster than 90.91% of Java online submissions for Maximum Subarray.
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int curMAx = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(sum<0){
                sum = nums[i];
            }else{
                sum += nums[i];
            }
            curMAx = Math.max(sum,curMAx);
        }
        return curMAx;
    }

    @Test
    public void test(){
//        int[] a = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] a = new int[]{-5,-6,-7,7};
        maxSubArray(a);
        maxSubArray2(a);
    }
}

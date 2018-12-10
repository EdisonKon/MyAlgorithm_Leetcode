package Arrays;

import org.junit.Test;

/**
 * @description: 描述 Medium
 * @author: dekai.kong
 * @date: 2018-12-10 14:48
 * @from https://leetcode.com/problems/jump-game/
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 *
 * 解法:
 * 主要看必经之路上有没有0,如果有0 那就到不了,如果没有 那就肯定可以到
 */

public class JumpGame {
    public JumpGame() {

    }

    public boolean canJump(int[] nums) {
        return doRecursive(0,nums);
    }
    public boolean doRecursive(int index,int[] nums){
        for (int i = 0; i < nums.length; ) {
            int curinx = i+nums[i];
            if(curinx >= nums.length-1){
                return true;
            }else if(nums[curinx] == 0){
                for (int j = nums[i]-1; j > 0; j++) {
                    if(nums[curinx-1] > 0){
                        i = nums[j]-1+ nums[nums[j]-1];
                        doRecursive(i,nums);
                        i = i - (nums[j]-1+ nums[nums[j]-1]);
                    }
                }
                return false;
            }else{
                i = curinx;
            }
        }
        return false;
    }

    @Test
    public void test() {
//        System.out.println(canJump(new int[]{2,3,0,1,0,4}));
        System.out.println(canJump(new int[]{1,3,3,1,0,4}));
    }
}


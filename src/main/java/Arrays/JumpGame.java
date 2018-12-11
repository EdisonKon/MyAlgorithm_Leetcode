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

    /**
     * 递归法 未完成
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        return doRecursive(0,nums);
    }
    public boolean doRecursive(int index,int[] nums){
        for (int i = index; i < nums.length; ) {
            int curinx = i+nums[i];
            if(curinx >= nums.length-1){
                return true;
            }else if(nums[curinx] == 0){
                for (int j = nums[i]-1; j > 0; j--) {
                    if(nums[curinx-1] > 0){
                        i += j;
                        if(doRecursive(i,nums)){
                            return true;
                        }else{
                            i -= j;
                        }
                    }
                }
                return false;
            }else{
                i = curinx;
            }
        }
        return false;
    }

    /**
     * Runtime: 5 ms, faster than 74.77% of Java online submissions for Jump Game.
     * 去掉fill后
     * Runtime: 4 ms, faster than 95.26% of Java online submissions for Jump Game.
     * @param nums
     * @return
     */
    public boolean canJump23(int[] nums) {
        int[] myidex = new int[nums.length];
//        Arrays.fill(myidex,0);
        int curinx = 0;
        while(curinx<nums.length-1){
            curinx = curinx+nums[curinx];
            if(curinx == 0){
                return false;
            }
            if(curinx >= nums.length-1){
                return true;
            }else if(nums[curinx] == 0){
                myidex[curinx] = -1;
                int backint = 0;
                for (int i = curinx; i >= 0 ; i--) {
                    if(myidex[i] == -1) {
                        backint += -1;
                        continue;
                    }else if (myidex[i] == 1||myidex[i] == 0){
                        if(backint + nums[i] > 0){
                            myidex[i] = 1;
                            curinx = i + nums[i];
                            break;
                        }else{
                            myidex[i] = -1;
                            backint += -1;
                        }
                    }
                    curinx = i;
                }
                if(curinx == 0){
                    return false;
                }
            }else{
                myidex[curinx] = 1;
            }
        }
        return true;
    }

    /**
     * leetcode
     * @param arr
     * @return
     */
    public boolean canJump(int[] arr) {
        int maxindex=arr[0];
        int n=arr.length;
        for (int i = 1; i <n; i++) {
            if(i<=maxindex)
            {
                if(maxindex<i+arr[i])
                    maxindex=i+arr[i];
            }
        }
        if(maxindex>=n-1)
            return true;
        else
            return false;
    }
    @Test
    public void test() {
        System.out.println(canJump(new int[]{2,3,0,1,0,4}));
        System.out.println(canJump(new int[]{1,3,3,1,0,4}));
        System.out.println(canJump(new int[]{3,0,8,2,0,0,1}));
        System.out.println(canJump(new int[]{1,0,2}));
    }
}


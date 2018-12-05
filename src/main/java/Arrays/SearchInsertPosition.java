package Arrays;

import org.junit.Test;

/**
 * @Author dekai.kong
 * @description: 难度 Easy
 * @create: 2018-12-05 22:06
 * @from: https://leetcode.com/problems/search-insert-position/
 * Given a sorted array and a target value, return the index if the target is found. If not,
 * return the index where it would be if it were inserted in order.

    You may assume no duplicates in the array.

    Example 1:

    Input: [1,3,5,6], 5
    Output: 2
    Example 2:

    Input: [1,3,5,6], 2
    Output: 1
    Example 3:

    Input: [1,3,5,6], 7
    Output: 4
    Example 4:

    Input: [1,3,5,6], 0
    Output: 0
 **/

public class SearchInsertPosition {
    public SearchInsertPosition() {
    }

    /**
     * Runtime: 2 ms, faster than 100.00% of Java online submissions for Search Insert Position.
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int rst = -1;
        if(nums.length == 0 || nums[0] == target || nums[0] > target){
            return 0;
        }
        if(nums[nums.length-1]<target){
            return nums.length;
        }
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == target){
                rst =  i;
                break;
            }else if(nums[i-1]<target && nums[i] > target){
                rst =  i;
                break;
            }else{
                rst = i+1;
            }
        }
        return rst;
    }
    @Test
    public void test(){
//        System.out.println(searchInsert(new int[]{1,3,5,6},5));
//        System.out.println(searchInsert(new int[]{1,3,5,6},2));
//        System.out.println(searchInsert(new int[]{1,3,5,6},7));
//        System.out.println(searchInsert(new int[]{1,3,5,6},0));
        System.out.println(searchInsert(new int[]{1},2));
    }
}


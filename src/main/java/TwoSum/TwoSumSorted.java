package TwoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 描述
 * @author: dekai.kong (dekai.kong@luckincoffee.com)
 * @date: 2018-11-06 17:13
 */
/**
 * LeetCode
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 *
 * Note:
 *
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example:
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */


public class TwoSumSorted {
    //map形式
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> mapIv = new HashMap<>();
        for (int i = 0;i<nums.length ;i ++){
            if(mapIv.containsKey(target - nums[i])){
                result[0] = Math.min(i,mapIv.get(target - nums[i]))+1;
                result[1] = Math.max(i,mapIv.get(target - nums[i]))+1;
            }
            mapIv.put(nums[i],i);
        }
        return result;
    }
    //从左道到右搜索
    public int[] twoSum2(int[] numbers, int target) {
        if(numbers == null || numbers.length < 2){
            return numbers;
        }
        long sum = 0L;
        for(int l = 0, r = numbers.length-1; l < r;) {
            sum = numbers[l] + numbers[r];
            if(sum == target) {
                return new int[]{l+1, r+1};
            }
            if(sum < target){
                ++l;
            }else{
                --r;
            }
        }
        return null;
    }
}

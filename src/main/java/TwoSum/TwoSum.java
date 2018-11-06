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
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> mapIv = new HashMap<>();
        for (int i = 0;i<nums.length ;i ++){
            if(mapIv.containsKey(target - nums[i])){
                result[0]=i;
                result[1]=mapIv.get(target - nums[i]);
            }
            mapIv.put(nums[i],i);
        }
        return result;
    }
}

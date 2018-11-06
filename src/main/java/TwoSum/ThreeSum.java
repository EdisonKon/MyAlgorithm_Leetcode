package TwoSum;

import org.junit.Test;

import java.util.*;

/**
 * @description: 描述
 * @author: dekai.kong (dekai.kong@luckincoffee.com)
 * @date: 2018-11-06 17:13
 */

/**
 * LeetCode
 * https://leetcode.com/problems/3sum/
 *Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeSum {

    public ThreeSum(){

    }
    //把大于0的都放入map,小于0的相加在>0map查找看看有没有,消重使用set
    public List<List<Integer>> threeSumx(int[] nums) {
        Arrays.sort(nums);
        int[] numsLeft = new int[nums.length];
        Map<Integer,Integer> mapRigh = new HashMap();
        List<List<Integer>> resultList = new ArrayList<>();
//        Set<String> keySet = new HashSet<>();
//        String vals = "";
//        if(!keySet.contains(vals)){
//            keySet.add(vals);
//        }
        List<Integer> innerList = new ArrayList<>();
        for (int i = 0;i<nums.length;i++){
            if(nums[i]<= 0){
                numsLeft[i] = nums[i];
            }else{
                numsLeft = Arrays.copyOfRange(numsLeft, 0, i-1);
                mapRigh.put(nums[i],nums[i]);
            }
        }

        for(int i = 0;i<numsLeft.length-1;i++){
            for(int j = 1;j<numsLeft.length;i++){
                if(numsLeft[i] != numsLeft[j]){
                    if(mapRigh.containsKey(0-(numsLeft[i] + numsLeft[j]))){
                        resultList.add(Arrays.asList(nums[i], nums[j],mapRigh.get(0-(numsLeft[i] + numsLeft[j]))));
                    }
                }
            }
        }
        return resultList;
    }
    @Test
    public void testThreeSum(){
        int[] a = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> resultList = threeSumx(a);
        System.out.println(resultList);
    }
}

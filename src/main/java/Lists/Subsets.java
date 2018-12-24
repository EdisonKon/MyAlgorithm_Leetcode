package Lists;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 描述 Medium
 * @author: dekai.kong
 * @date: 2018-12-24 16:45
 * @from https://leetcode.com/problems/subsets/
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */

public class Subsets {
    public Subsets() {

    }

    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Subsets.
     * 递归解决
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for (int i = 1; i <= nums.length; i++) {
            helper(ans,i,0,new ArrayList<>(),nums);
        }
        return ans;
    }
    public void helper(List<List<Integer>> ans,int len,int start,List<Integer> curlist,int[] nums){
        if(len == 0){
            ans.add(new ArrayList<>(curlist));
        }else{
            for (int i = start; i < nums.length; i++) {
                curlist.add(nums[i]);
                helper(ans,len-1,i+1,curlist,nums);
                curlist.remove(curlist.size()-1);
            }
        }
    }


    @Test
    public void test() {
        System.out.println(subsets(new int[]{1,2,3}));
    }
}


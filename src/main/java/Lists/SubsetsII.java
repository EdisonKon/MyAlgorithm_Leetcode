package Lists;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 描述 Medium
 * @author: dekai.kong
 * @date: 2018-12-30 18:35
 * @from https://leetcode.com/problems/subsets-ii/
 *
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: [1,2,2]
 * Output:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */

public class SubsetsII {
    public SubsetsII() {

    }

    /**
     *
     * 递归解决
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
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
        System.out.println(subsetsWithDup(new int[]{1,2,2}));
    }
}


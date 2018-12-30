package Lists;

import org.junit.Test;

import java.util.*;

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
     * Runtime: 10 ms, faster than 12.57% of Java online submissions for Subsets II.
     * 递归解决
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        Arrays.sort(nums);
        Set<String> set = new HashSet<>();
        for (int i = 1; i <= nums.length; i++) {
            helper(ans,i,0,new ArrayList<>(),nums,set);
        }
        return ans;
    }
    public void helper(List<List<Integer>> ans,int len,int start,List<Integer> curlist,int[] nums,Set<String> set){
        if(len == 0){
            if(set.add(curlist.toString()))
            ans.add(new ArrayList<>(curlist));
        }else{
            for (int i = start; i < nums.length; i++) {
                curlist.add(nums[i]);
                helper(ans,len-1,i+1,curlist,nums,set);
                curlist.remove(curlist.size()-1);
            }
        }
    }

    /**
     * Runtime: 2 ms, faster than 98.79% of Java online submissions for Subsets II.
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        Arrays.sort(nums);
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
                if(i>start&&nums[i]==nums[i-1]) continue;//2ms
                curlist.add(nums[i]);
                helper(ans,len-1,i+1,curlist,nums);
                curlist.remove(curlist.size()-1);
//                while (i + 1 < nums.length && nums[i] == nums[i + 1]) ++i;  4ms
            }
        }
    }


    @Test
    public void test() {
        System.out.println(subsetsWithDup(new int[]{1,2,2}));
    }
}


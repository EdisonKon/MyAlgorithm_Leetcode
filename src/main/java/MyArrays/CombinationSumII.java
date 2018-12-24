package MyArrays;

import org.junit.Test;

import java.util.*;

/**
 * @description: 描述 Medium
 * @author: dekai.kong
 * @date: 2018-12-07 11:29
 * @from https://leetcode.com/problems/combination-sum-ii/
 *
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * 有重复的,需要进行消重,本index的值不能重复
 * 讲解
 * https://www.youtube.com/watch?v=aBL-aNWNmB4&t=23s
 * TODO 多刷(经典递归)
 */

public class CombinationSumII {
    public CombinationSumII() {

    }

    /**
     * Runtime: 8 ms, faster than 99.15% of Java online submissions for Combination Sum II.
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<>();
        if(candidates.length != 0){
            Arrays.sort(candidates);
            List<Integer> curList = new ArrayList<>();
            doRec(candidates,target,0,rst,curList);
        }
        return rst;
    }
    public List<List<Integer>> doRec(int[] candidates, int target,int index, List<List<Integer>> rst, List<Integer> curList){
        if(target == 0){
            rst.add(new ArrayList<>(curList));
        }else if(target>0){
            for (int i = index; i < candidates.length; i++) {
                if(candidates[i] > target) {continue;}
                if(index!=i && candidates[i] == candidates[i-1]) {continue;} //消重操作
                curList.add(candidates[i]);
                doRec(candidates,target-candidates[i],i+1,rst,curList);
                curList.remove(curList.size()-1);
            }
        }
        return rst;
    }


    @Test
    public void test() {
        int[] s = new int[]{10,1,2,7,6,1,5};int target = 8;
//        int[] s = new int[]{2,5,2,1,2};int target = 5;
        combinationSum2(s,target);
    }
}


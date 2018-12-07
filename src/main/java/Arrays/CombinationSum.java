package Arrays;

import org.junit.Test;

import java.util.*;

/**
 * @description: 描述 Medium
 * @author: dekai.kong
 * @date: 2018-12-07 11:29
 * @from https://leetcode.com/problems/combination-sum/
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */

public class CombinationSum {
    public CombinationSum() {

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<>();
        return rst;
    }


    /**
     * 做的不对,当出现target- 当前值或当前值的倍数不在set里,则 失效
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<Integer> set = new HashSet();
        Set<String> boo= new HashSet<>();
        for (int i = 0; i < candidates.length; i++) {
            set.add(candidates[i]);
        }
        List<List<Integer>> rst = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            int cur = candidates[i];
            List<Integer> add = new ArrayList<>();
            doCheck(cur,add,set,rst,target,boo,candidates);
        }
        return rst;

    }
    public void doCheck(int cur,List<Integer> add, Set<Integer> set,List<List<Integer>> rst,int selftar,Set<String> boo,int[] candidates){
        int val = 0;
        for (int j = 0; j < selftar / cur; j++) {
            val += cur;
            add.add(cur);
            int t_v = selftar-val;
            if(t_v<=0){
                break;
            }
            if(set.contains(t_v)){
                List<Integer> addin = new ArrayList<>();
                addin.addAll(add);
                addin.add(t_v);
                Collections.sort(addin);
                if(!boo.add(addin.toString())){
                    continue;
                }
                rst.add(addin);
            }else{
                if(t_v < candidates[0]){
                    break;
                }
                List x = new ArrayList<>();
                x.addAll(add);
                doCheck(cur,x,set,rst,t_v,boo,candidates);
                for (int i = 0; i < rst.size(); i++) {
                    rst.get(i).addAll(add);
                }
            }
        }
    }

    @Test
    public void test() {
//        int[] s = new int[]{2,3,6,7};int target = 7;
        int[] s = new int[]{2,3,7};int target = 18;
//        int[] s = new int[]{1,2,3,4,5};int target = 7;
        combinationSum2(s,target);
    }
}


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
 * 讲解
 * https://www.youtube.com/watch?v=aBL-aNWNmB4&t=23s
 * TODO 多刷(经典递归)
 */

public class CombinationSum {
    public CombinationSum() {

    }

    /**
     * Runtime: 10 ms, faster than 82.80% of Java online submissions for Combination Sum.
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
                if(candidates[i] > target) continue;
                curList.add(candidates[i]);
                doRec(candidates,target-candidates[i],i,rst,curList);
                curList.remove(curList.size()-1);
            }
        }
        return rst;
    }

    /**
     * fail
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum3(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<>();
        if(candidates.length != 0){
            Arrays.sort(candidates);
            for (int i = 0; i < candidates.length; i++) {
                rst.addAll(doRecursive(target,i,candidates));
            }
        }
        return rst;
    }
    public List<List<Integer>> doRecursive(int target,int curinex,int[] candidates){
        List<List<Integer>> inrst = new ArrayList<>();
        if (candidates[curinex] > target){
            return inrst;
        }
        List<Integer> lin = new ArrayList<>();//初始化一个-1的 用以记录每一个candidates[curinex],并且递减
        for (int i = 0; i < target/candidates[curinex] ; i++) {
            lin.add(candidates[curinex]);
        }
        while(lin.size()>0){
            int val = 0;
            for (int i = 0; i < lin.size(); i++) {
                val+= lin.get(i);
            }
            List<Integer> inlin = new ArrayList();
            int inval = val;
            inlin.addAll(lin);
            for (int i = curinex+1; i < candidates.length; i++) {
                while(inval < target){
                    inval += candidates[i];
                    inlin.add(candidates[i]);
                }
                if(inval == target){
                    inrst.add(inlin);
                    break;
                }
            }
            lin.remove(lin.size()-1);
        }
        return inrst;
    }



    /**
     * 做的不对,当出现target- 当前值或当前值的倍数不在set里,则 失效
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<Integer> set = new HashSet();
        for (int i = 0; i < candidates.length; i++) {
            set.add(candidates[i]);
        }
        Map<Integer,Integer> mapuse = new HashMap<>();
        List<List<Integer>> rst = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            int cur = candidates[i];
            List<Integer> add = new ArrayList<>();
            doCheck(target,cur,add,set,rst,target,mapuse);
        }
        return rst;

    }
    public void doCheck(int target,int cur,List<Integer> add, Set<Integer> set,List<List<Integer>> rst,int selftar,Map<Integer,Integer> mapuse){
        if(selftar % cur== 0 ){
            int val = 0;
            for (int j = 0; j < target / cur; j++) {
                val += cur;
                add.add(cur);
                int t_v = target-val;
                if(set.contains(t_v) && t_v!=cur){
                    List<Integer> addin = new ArrayList<>();
                    addin.addAll(add);
                    if(mapuse.getOrDefault(t_v,-1)!=-1){
                        continue;
                    }
                    addin.add(t_v);
                    if(addin.size() == 2){
                        mapuse.put(cur,1);
                    }
                    rst.add(addin);
                }
            }
            if(selftar==target){
                rst.add(add);
            }
        }else{
            doCheck(target,cur,add,set,rst,target - target%cur,mapuse);
        }
    }

    @Test
    public void test() {
//        int[] s = new int[]{2,3,5};int target = 7;
//        int[] s = new int[]{2,3,6,7};int target = 7;
        int[] s = new int[]{2,3,7};int target = 18;
//        int[] s = new int[]{1,2,3,4,5};int target = 7;
        combinationSum(s,target);
    }
}


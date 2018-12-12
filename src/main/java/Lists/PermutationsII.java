package Lists;

import org.junit.Test;

import java.util.*;

/**
 * @description: 描述 Medium
 * @author: dekai.kong
 * @date: 2018-12-10 11:20
 * @from https://leetcode.com/problems/permutations-ii/
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

    Example:

    Input: [1,1,2]
    Output:
    [
    [1,1,2],
    [1,2,1],
    [2,1,1]
    ]
 */

public class PermutationsII {
    public PermutationsII() {

    }

    /**
     * Runtime: 2 ms, faster than 99.96% of Java online submissions for Permutations.
     * @param nums
     * @return
     * 递归法+set消重
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        Set<String> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        doRecursive(0,nums,list,rst,set);
        return rst;
    }
    public void doRecursive(int curinx,int[] nums,List<Integer> list,List<List<Integer>> rst,Set<String> set){
        if(curinx == nums.length){
            if(set.add(list.toString())){
                rst.add(new ArrayList<>(list));
            }
        }else{
            for (int i = curinx; i < nums.length; i++) {
                int temp;
                if(i!=0){  //如果不是第一个
                    temp = nums[i];
                    nums[i] = nums[0];
                    nums[0] = temp;
                }
                list.add(nums[curinx]);
                doRecursive(0,Arrays.copyOfRange(nums,curinx+1,nums.length),list,rst,set);
                list.remove(list.size()-1);
            }
        }
    }

    /**
     * leetcode Runtime: 3 ms, faster than 98.67% of Java online submissions for Permutations II.
     * 在递归函数中要判断前面一个数和当前的数是否相等，如果相等，前面的数必须已经使用了，
     * 即对应的visited中的值为1，当前的数字才能使用，否则需要跳过，这样就不会产生重复排列了
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, result, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }

    private void helper(int[] nums, List<List<Integer>> result, List<Integer> tmpList, boolean[] used) {
        if (nums.length == tmpList.size()) {
            result.add(new ArrayList<>(tmpList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                tmpList.add(nums[i]);
                used[i] = true;
                helper(nums, result, tmpList, used);
                tmpList.remove(tmpList.size() - 1);
                used[i] = false;
            }
        }
    }



    @Test
    public void test() {
//        System.out.println(permute(new int[]{1,2,3,4}));
        System.out.println(permuteUnique2(new int[]{1,1,2}));
//        System.out.println(permuteUnique(new int[]{3,3,0,3}));
    }
}


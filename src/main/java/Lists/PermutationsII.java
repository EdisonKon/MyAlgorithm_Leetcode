package Lists;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
     * 递归法
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        doRecursive(0,nums,list,rst);
        return rst;
    }
    public void doRecursive(int curinx,int[] nums,List<Integer> list,List<List<Integer>> rst){
        if(curinx == nums.length){
            rst.add(new ArrayList<>(list));
        }else{
            for (int i = curinx; i < nums.length; i++) {
                int temp;
                if(i!=0){  //如果不是第一个
                    temp = nums[i];
                    nums[i] = nums[0];
                    nums[0] = temp;
                }
                list.add(nums[curinx]);
                doRecursive(0,Arrays.copyOfRange(nums,curinx+1,nums.length),list,rst);
                list.remove(list.size()-1);
            }
        }
    }



    @Test
    public void test() {
//        System.out.println(permute(new int[]{1,2,3,4}));
        System.out.println(permute(new int[]{1,1,2}));
    }
}


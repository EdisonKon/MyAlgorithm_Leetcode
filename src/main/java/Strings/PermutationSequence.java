package Strings;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dekai.kong
 * @difficult medium
 * @create 2018-12-15 19:49
 * @from https://leetcode.com/problems/permutation-sequence/
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Note:
 *
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * Example 1:
 *
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 *
 * Input: n = 4, k = 9
 * Output: "2314"
 **/
public class PermutationSequence {
    public PermutationSequence() {

    }

    /**
     * Runtime: 9 ms, faster than 69.85% of Java online submissions for Permutation Sequence.
     * TODO 待优化
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        int[] pal = new int[10];
        pal[0] = 1;
        for (int i = 1; i <= n; i++) {
            pal[i] = pal[i-1]*(i);
            list.add(i);
        }
        int curn = n;
        int curk = (k-1);
        String rs = "";
        while(rs.length()<n){
            int j = curk / pal[curn-1];
            rs += list.get(j);
            list.remove(j);
            curn -=1;
            curk = curk%pal[curn];
        }
        return rs;
    }

    /**
     * 超时，想新的方式
     * @param n
     * @param k
     * @return
     */
    public String getPermutation2(int n, int k) {
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i-1] = i;
        }
        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        doRecursive(0,nums,list,rst,k);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rst.get(k-1).size(); i++) {
            sb.append(rst.get(k-1).get(i));
        }
        return sb.toString();
    }
    public boolean doRecursive(int curinx, int[] nums, List<Integer> list, List<List<Integer>> rst,int k){
        if(curinx == nums.length){
            if(rst.size() < k){
                rst.add(new ArrayList<>(list));
                return false;
            }else{
                return true;
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
                if(doRecursive(0, Arrays.copyOfRange(nums,curinx+1,nums.length),list,rst,k)){
                    return true;
                }
                list.remove(list.size()-1);
            }
            return false;
        }
    }

    @Test
    public void test() {
//        System.out.println(getPermutation(3,3));
        System.out.println(getPermutation(1,1));
        System.out.println(getPermutation(4,17));
        System.out.println(getPermutation(5,120));
    }
}

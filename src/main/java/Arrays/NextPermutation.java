package Arrays;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 描述 Medium
 * @author: dekai.kong
 * @date: 2018-12-04 15:53
 * @from https://leetcode.com/problems/next-permutation/
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 通俗解释,就是求一个全排列中的下一个排列,比如1 2 3 三个数,按大小全排列后,排列为123 132 213 231 312 321 再下一个就还是123
 * 给出132 下一个排列是213
 */

public class NextPermutation {
    public NextPermutation() {

    }

    /***
     * Runtime: 9 ms, faster than 85.19% of Java online submissions for Next Permutation.
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int tem;
        int maxidex = 0;
        while(maxidex < nums.length-1 && nums[maxidex] < nums[maxidex+1]){
            maxidex++;
        }
        ff:
        for (int j = nums.length-1; j >= maxidex; j--) {
            if(j == 0){
                myReverse(nums,0,nums.length);
                break;
            }
            if(nums[j]>nums[j-1]){
                if(j < nums.length-1){
                    myReverse(nums,j,nums.length);
                }
                for (int i = j; i < nums.length; i++) {
                    if(nums[i]>nums[j-1]){
                        tem = nums[i];
                        nums[i] = nums[j-1];
                        nums[j-1] = tem;
                        break ff;
                    }
                }
            }
        }
    }
    public int[] myReverse(int[] nums,int from,int end) {
        int len = from+end;
        for(int i = from; i < len / 2; i++)
        {
            int temp = nums[i];
            nums[i] = nums[len - i - 1];
            nums[len - i - 1] = temp;
        }
        return nums;
    }

    /**
     * Runtime: 9 ms, faster than 85.19% of Java online submissions for Next Permutation.
     */
    public void nextPermutation2(int[] nums) {
        int tem;
        int maxidex = nums.length-1;
        while(maxidex > 0 && nums[maxidex] <= nums[maxidex-1]){
            maxidex -- ;
        }
        if(maxidex == 0){
            Arrays.sort(nums,0,nums.length);
        }
        ff:
        for (int j = maxidex; j > 0; j--) {
            if(nums[j]>nums[j-1]){
                if(j < nums.length-1){
                    Arrays.sort(nums, j, nums.length);
                }
                for (int i = j; i < nums.length; i++) {
                    if(nums[i]>nums[j-1]){
                        tem = nums[i];
                        nums[i] = nums[j-1];
                        nums[j-1] = tem;
                        break ff;
                    }
                }
            }
        }
    }


    @Test
    public void test() {
//        nextPermutation2(new int[]{1,2,3});
//        nextPermutation(new int[]{5,4,3,2,1});
//        int[] a = new int[]{1,2,1,3,4};
//        int[] a = new int[]{1,2,4,3,1};
        int[] a = new int[]{1,2,4,4,1};
//        int[] a = new int[]{5,1,1};
        nextPermutation2(a);
        System.out.println(a);
    }
}


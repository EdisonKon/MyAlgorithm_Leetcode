package MyArrays;

import org.junit.Test;

import java.util.*;

/**
 * @description: 描述 Hard
 * @author: dekai.kong
 * @date: 2018-12-08 16:11
 * @from https://leetcode.com/problems/first-missing-positive/
 *
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Example 1:
 *
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: [7,8,9,11,12]
 * Output: 1
 */

public class FirstMissingPositive {
    public FirstMissingPositive() {

    }
/**
 * leetcode 4ms
 */
public int firstMissingPositive3(int[] A) {
    int i = 0;
    while(i < A.length){
        if(A[i] == i+1 || A[i] <= 0 || A[i] > A.length) i++;
        else if(A[A[i]-1] != A[i]) swap(A, i, A[i]-1);
        else i++;
    }
    i = 0;
    while(i < A.length && A[i] == i+1) i++;
    return i+1;
}
    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    /**
     * Runtime: 9 ms, faster than 29.92% of Java online submissions for First Missing Positive.
     * 去掉排序后 //Arrays.sort(nums);
     * Runtime: 6 ms, faster than 76.94% of Java online submissions for First Missing Positive.
     * @param nums
     * @return
     */
    public int firstMissingPositive2(int[] nums) {
        if(nums.length == 0){
            return 1;
        }
//        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int val = 1;
        while(set.contains(val)){
            val++;
        }
        return val;
    }

    /**
     * Runtime: 6 ms, faster than 76.94% of Java online submissions for First Missing Positive.
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0){
            return 1;
        }
        Arrays.sort(nums);
        int val = 1;
        int i = 0;
        int last = 0;
        while (i < nums.length) {
            if(last == nums[i]){i++; continue;}
            if(nums[i]>0){
                if(nums[i] == val){
                    val++;
                }else{
                    return val;
                }
            }
            last = nums[i];
            i++;
        }

        return val;
    }

    @Test
    public void test() {
//        System.out.println(firstMissingPositive(new int[]{1,2,0}));
//        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
//        System.out.println(firstMissingPositive(new int[]{7,8,9,11,12}));
        System.out.println(firstMissingPositive3(new int[]{0,2,2,1,1}));
    }
}


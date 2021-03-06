package Void;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 描述 Easy
 * @author: dekai.kong
 * @date: 2018-12-28 16:20
 * @from 88. https://leetcode.com/problems/merge-sorted-array/
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 *
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 */

public class MergeSortedArray {
    public MergeSortedArray() {

    }

    /**
     * Runtime: 5 ms, faster than 16.24% of Java online submissions for Merge Sorted Array.
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
    }

    /**
     * leetcode 2ms
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        while (m > 0 && n > 0){
            if (nums1[m - 1 ] > nums2[n -1]){
                nums1[m + n - 1] = nums1[m - 1];
                m--;
            }

            else{
                nums1[m + n - 1] = nums2[n - 1];
                n--;
            }
        }
        while (n > 0){
            nums1[m + n - 1] = nums2[n - 1];
            n--;
        }
    }

    /**
     * 从后往前填充数组,且最后只处理n不为0的情况即可 0ms 100%
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void mergex(int[] nums1, int m, int[] nums2, int n) {
        while(m>0 && n>0){
            if(nums1[m-1]>nums2[n-1]){
                nums1[m+n-1] = nums1[m-1];
                m--;
            }else{
                nums1[m+n-1] = nums2[n-1];
                n--;
            }
        }

        while(n>0){
            nums1[m+n-1] = nums2[n-1];
            n--;
        }
    }

    @Test
    public void test() {
        mergex(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
    }
}


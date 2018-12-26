package Booleans;

import org.junit.Test;

/**
 * @description: 描述 Medium
 * @author: dekai.kong
 * @date: 2018-12-26 09:54
 * @from https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 *
 * You are given a target value to search. If found in the array return true, otherwise return false.
 *
 * Example 1:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * Example 2:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * Follow up:
 *
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 * 递归
 * 直接2分法搜索
 */

public class SearchinRotatedSortedArrayII {
    public SearchinRotatedSortedArrayII() {

    }

    /**
     * Runtime: 1 ms, faster than 48.76% of Java online submissions for Search in Rotated Sorted Array II.
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        if (nums==null||nums.length==0){
            return false;
        }
        return helper(0,nums.length-1,target,nums);
    }
    public boolean helper(int start,int end,int target,int[] nums){
        int mid = (start+end)/2;
        if(nums[mid] == target||nums[start] == target ||nums[end] == target){
            return true;
        }else if(mid <= start|| end - start == 2){
            return false;
        }
        if(nums[start] < nums[mid]  || nums[mid] > nums[end]){//左边是升序
            if(nums[start]<target && target<nums[mid]){
                return (helper(start+1,mid-1,target,nums));
            }else{
                return (helper(mid+1,end,target,nums));
            }
        }else if(nums[mid] < nums[end] || nums[mid] < nums[start]){//右边是升序
            if(nums[mid]<target && target<nums[end]){
                return (helper(mid+1,end-1,target,nums));
            }else{
                return (helper(start,mid-1,target,nums));
            }
        }else{//左中右相等,让最右-1
            return helper(start,end-1,target,nums);
        }
    }

    /**
     * leetcode
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array II.
     * @param nums
     * @param target
     * @return
     */
    public boolean search2(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = -1;
        while(start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }
            //If we know for sure right side is sorted or left side is unsorted
            if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
                //If we know for sure left side is sorted or right side is unsorted
            } else if (nums[mid] > nums[start] || nums[mid] > nums[end]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
                //If we get here, that means nums[start] == nums[mid] == nums[end], then shifting out
                //any of the two sides won't change the result but can help remove duplicate from
                //consideration, here we just use end-- but left++ works too
            } else {
                end--;
            }
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(search(new int[]{2,5,6,0,0,1,2},3));
        System.out.println(search(new int[]{1,2,2,3,3,4,5,6},4));
        System.out.println(search(new int[]{1,1,3,1},3));
        System.out.println(search(new int[]{4,5,6,7,0,1,2},1));
        System.out.println(search(new int[]{1,3,1,1},2));
        System.out.println(search(new int[]{2,5,6,0,1,2,2,2,2,2,2},0));
    }
}


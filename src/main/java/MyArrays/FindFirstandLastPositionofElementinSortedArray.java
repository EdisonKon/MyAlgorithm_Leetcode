package MyArrays;

import org.junit.Test;

/**
 * @description: 描述 Medium
 * @author: dekai.kong
 * @date: 2018-12-05 15:42
 * @from https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 *
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 *
 */

public class FindFirstandLastPositionofElementinSortedArray {
    public FindFirstandLastPositionofElementinSortedArray() {

    }

    /**
     * Runtime: 4 ms, faster than 82.04% of Java online submissions for Find First and Last Position of Element in Sorted Array.
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        if(nums.length == 0) {return res;}
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        if (nums[right] != target) return res;
        res[0] = right;
        right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) left = mid + 1;
            else right= mid;
        }
        res[1] = left - 1;
        return res;
    }
/*
    public int[] searchRange(int[] nums, int target) {
        int[] rst = {-1,-1};
        if(nums.length == 0) {return rst;}
        int mid = nums.length/2;
        rst[0] = find(nums,0,mid,target,rst[0],true,rst[0],rst[1]);
        rst[1] = find(nums,mid,nums.length-1,target,rst[1],false,rst[0],rst[1]);
        rst[0] =  rst[0] == -1 && rst[1] != -1 ? rst[1]:rst[0];
        rst[1] =  rst[1] == -1 && rst[0] != -1 ? rst[0]:rst[1];
        return rst;
    }
    public int find(int[] nums,int left,int right,int target,int cur,boolean lor,int lv,int rv){
        int val = cur;
        int mid = (right - left)/2 + left;
        int start = left;
        int end = right;
        if(target == nums[mid]){
            if(val== -1){
                val =mid;
            }else{
                if(lor && mid<val){
                    val =mid;
                }
                if(!lor && mid>val){
                    val =mid;
                }
            }
        }
        if(left == right){
            return val;
        }
        if(target < nums[mid]){
            return find(nums,start,mid,target,val,lor);
        }else{
            return find(nums,mid+1,end,target,val,lor);
        }
    }
    */
//    1,2,2,3,4,4,4  4
    /*
    public int[] searchRange(int[] nums, int target) {
        int[] rst = {-1,-1};
        if(nums.length == 0) {return rst;}
        rst = find(nums,0,nums.length,target,rst);
        return rst;
    }

    public int[] find(int[] nums,int left,int right,int target,int[] cur){
        int mid = (right - left)/2 + left;
        int start = left;
        int end = right;
        if(target == nums[mid]){
            cur[0] = cur[0]>mid || cur[0] == -1?mid:cur[0];
            cur[1] = cur[1]<mid || cur[1] == -1?mid:cur[1];
            if(nums[mid] == nums[end-1]){
                cur[1] = end-1;
                return cur;
            }
            if(nums[start] == nums[mid]){
                cur[0] = start;
                return cur;
            }
            if(left == right){
                return cur;
            }
        }
        if(target < nums[mid]){
            return find(nums,start,mid-1,target,cur);
        }
        else{
            return find(nums,mid+1,end,target,cur);
        }
    }
    /*
    public int[] find(int[] nums,int left,int right,int target,int[] cur){
        int mid = (right - left)/2 + left;
        int start = left;
        int end = right;
        if(nums[mid] == nums[end]){
            cur[0] = mid;
            if(left == right){
                return cur;
            }
            find(nums,start,mid,target,cur);
        }
        if(nums[mid] == nums[start]){
            cur[1] = mid;
            if(left == right){
                return cur;
            }
            find(nums,mid,end,target,cur);
        }
        if(nums[mid] == target){
            if (cur[0]> mid || cur[0] == -1){
                cur[0] = mid;
            }
            if(cur[1] < mid || cur[1] == -1){
                cur[1] = mid;
            }
            if(left == right){
                return cur;
            }
        }
        if(target < nums[mid]){
            find(nums,start,mid-1,target,cur);
        }
        if(target > nums[mid]){
            find(nums,mid+1,end,target,cur);
        }
        return cur;
    }
*/
    @Test
    public void test() {
        searchRange(new int[]{1,2,2,3,4,4,4},4);
        searchRange(new int[]{5,7,7,8,8,10},8);
        searchRange(new int[]{5,7,7,8,8,10},6);
        searchRange(new int[]{1},1);
        // 4 6, 3,4 -1,-1 0,0
    }
}


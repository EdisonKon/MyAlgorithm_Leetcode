package MyArrays;

import org.junit.Test;

/**
 * @description: 描述 medium
 * @author: dekai.kong
 * @date: 2018-12-05 13:52
 * @from https://leetcode.com/problems/search-in-rotated-sorted-array/
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 * 这道题让在旋转数组中搜索一个给定值，若存在返回坐标，若不存在返回-1。
 * 我们还是考虑二分搜索法，但是这道题的难点在于我们不知道原数组在哪旋转了，我们还是用题目中给的例子来分析，对于数组[0 1 2 4 5 6 7] 共有下列七种旋转方法：
 *                 ↓
 * 0　　1　　2　　 4　　5　　6　　7
 *                 -----------------
 * 7　　0　　1　　 2　　4　　5　　6
 *                 -----------------
 * 6　　7　　0　　 1　　2　　4　　5
 *                 -----------------
 * 5　　6　　7　　 0　　1　　2　　4
 *                 -----------------
 * 4　　5　　6　　7　　0　　1　　2
 * -----------------
 * 2　　4　　5　　6　　7　　0　　1
 * -----------------
 * 1　　2　　4　　5　　6　　7　　0
 * -----------------
 * 二分搜索法的关键在于获得了中间数后，判断下面要搜索左半段还是右半段，
 * 我们观察上面画线的数字都是升序的，由此我们可以观察出规律，
 * 如果中间的数小于最右边的数，则右半段是有序的，
 * 若中间数大于最右边数，则左半段是有序的，
 * 我们只要在有序的半段里用首尾两个数组来判断目标值是否在这一区域内，这样就可以确定保留哪半边了
 */

public class SearchinRotatedSortedArray {
    public SearchinRotatedSortedArray() {

    }

    /**
     * Runtime: 6 ms, faster than 96.55% of Java online submissions for Search in Rotated Sorted Array.
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if(nums.length==0) return -1;
        return find(0,nums.length,nums,target);

    }
    public int find(int start,int end,int[] nums,int target){
        int index = -1;
        int mid = (end-start)/2+start;
        int left = mid;
        int right = mid+1;
        if (nums[mid] == target ){
            index = mid;
            return index;
        }
        if(start == end){
            return index;
        }
        if(nums[mid] <= nums[end-1]){//右侧有序
            if(target<nums[mid] || target> nums[end-1]){
                return find(start,left,nums,target);
            }else{
                return find(right,end,nums,target);
            }
        }else{//左侧有序
            if(target< nums[start] || target > nums[mid]){
                return find(right,end,nums,target);
            }else{
                return find(start,left,nums,target);
            }
        }
    }

    /**
     * leetcode
     *  5ms
     */
    public int search2(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                if (target >= nums[start]) {
                    if (nums[mid] >= nums[start]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                } else {
                    start = mid + 1;
                }
            } else {
                if (target >= nums[start]) {
                    end = mid - 1;
                } else {
                    if (nums[mid] >= nums[start]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }
        }

        return nums[start] != target ? -1 : start;

    }

    @Test
    public void test() {
        search(new int[]{4,5,6,7,0,1,2},3);
    }
}


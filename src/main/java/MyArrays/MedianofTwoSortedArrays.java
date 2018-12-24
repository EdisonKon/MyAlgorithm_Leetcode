package MyArrays;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 描述 Hard
 * @author: dekai.kong (dekai.kong@luckincoffee.com)
 * @date: 2018-11-20 15:37
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 */


public class MedianofTwoSortedArrays {
    public MedianofTwoSortedArrays(){

    }
/**
 *  TODO 虽然ac了 但是不是最好的方法,多用了空间的O(m+n),
 *  Runtime: 30 ms, faster than 92.81% of Java online submissions for Median of Two Sorted Arrays.
 *  nb的解法 https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/
 */

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Double rst = 0D;
        int[] rstnum;
        rstnum = Arrays.copyOf(nums1,nums1.length+nums2.length);
        System.arraycopy(nums2,0,rstnum,nums1.length,nums2.length);
        Arrays.sort(rstnum);
        int x = rstnum.length/2;
        if(rstnum.length%2 == 0){
            rst = (double)(rstnum[x-1]+rstnum[x])/2;
            return rst;
        }
        return rstnum[x];
    }
    @Test
    public void test(){
        int[] a = {1,2};
        int[] b = {3,4};
        findMedianSortedArrays(a,b);
    }

}

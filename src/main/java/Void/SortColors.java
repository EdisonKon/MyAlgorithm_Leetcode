package Void;

import org.junit.Test;

/**
 * @description: 描述 Medium
 * @author: dekai.kong
 * @date: 2018-12-24 15:00
 * @from https://leetcode.com/problems/sort-colors/
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Follow up:
 *
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 * TODO 经典双指针
 */

public class SortColors {
    public SortColors() {

    }

    /**
     * Runtime: 4 ms, faster than 2.33% of Java online submissions for Sort Colors.
     * @param nums
     */
    public void sortColors2(int[] nums) {

        int eix = nums.length-1;
        int temp;
        int zix = 0;
        for (int i = zix; i <= eix; i++) {
            while (nums[i] != 0 && i < eix){
                if(nums[i] == 1){
                    zix = i+1;
                    while(nums[eix] == 2){
                        eix--;
                    }
                    for (int j = zix; j <= eix; j++) {
                        if(nums[j] == 0){
                            temp = nums[i];
                            nums[i] = nums[j];
                            nums[j] = temp;
                            break;
                        }
                    }
                    break;
                }
                temp = nums[i];
                nums[i] = nums[eix];
                nums[eix] = temp;
                eix --;
            }
        }
        System.out.println(nums);
    }

    /**
     * 计数排序 先计数每个数的个数
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort Colors.
     * @param nums
     */
    public void sortColors3(int[] nums) {
        int[] len = new int[3];
        int inx = 0;
        for (int i = 0; i < nums.length; i++) {
            len[nums[i]] += 1;
        }
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < len[i]; ++j) {
                nums[inx++] = i;
            }
        }
    }

    /**
     * 双指针遍历,st记录的是最后一个0之后的一位
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort Colors.
     * @param nums
     */
    public void sortColors(int[] nums) {
        int st = 0;
        int en = nums.length-1;
        int temp;
        for (int i = 0; i <= en; i++) {
            if(nums[i] == 0){
                temp = nums[i];
                nums[i] = nums[st];
                nums[st] = temp;
                st++;
            }else if(nums[i] == 2){
                temp = nums[i];
                nums[i] = nums[en];
                nums[en] = temp;
                en--;
                i--;
            }
        }
    }

    @Test
    public void test() {
        sortColors(new int[]{2,0,2,1,1,0});
        sortColors(new int[]{2,0,2,1,0,1,0});
        sortColors(new int[]{1,2,0});
        sortColors(new int[]{1,0,2});
        sortColors(new int[]{1,1,0,1,2});
    }
}


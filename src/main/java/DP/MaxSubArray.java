package DP;

import org.junit.Test;

/**
 * @author dekai.kong
 * @difficult Easy
 * @create 2020-07-24 12:27
 * @from 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路: 使用dp 记录每个数的前边的最大和,如果是负数 那就不加,如果正数 就加上,然后在和max对比
 **/
public class MaxSubArray {
    public MaxSubArray() {

    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int[] maxs = new int[nums.length];
        maxs[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int cur = maxs[i - 1] < 0 ? nums[i] : (nums[i] + maxs[i - 1]);
            maxs[i] = cur;
            max = Math.max(max, cur);
        }
        return max;
    }

    @Test
    public void test() {
        maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
}

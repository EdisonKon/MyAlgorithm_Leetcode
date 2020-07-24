package DP;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author dekai.kong
 * @difficult medium
 * @create 2020-07-24 12:30
 * @from 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路 : 同样利用DP
 **/
public class MaxProduct {
    public MaxProduct() {

    }


    /**
     * 虽然是结题办法 但是超出内存了
     * @param nums
     * @return
     */
    public int maxProductx(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int max = nums[0];
        int[][] maxno = new int[nums.length][nums.length];
        maxno[0] = nums;

        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max,maxno[0][i]);
            for (int j = 1; j < nums.length; j++) {
                maxno[j][i] = nums[i] * maxno[j-1][i-1];
                max = Math.max(max,maxno[j][i]);
            }
        }
        return max;
    }

    /**
     * https://leetcode-cn.com/problems/maximum-product-subarray/solution/hua-jie-suan-fa-152-cheng-ji-zui-da-zi-xu-lie-by-g/
     * 标签：动态规划
     *      * 遍历数组时计算当前最大值，不断更新
     *      * 令imax为当前最大值，则当前最大值为 imax = max(imax * nums[i], nums[i])
     *      * 由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin，imin = min(imin * nums[i], nums[i])
     *      * 当负数出现时则imax与imin进行交换再进行下一步计算
     *      * 时间复杂度：O(n)O(n)
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }

    @Test
    public void test() {
//        maxProduct(new int[]{-2,1,-3,4,-1,2,1,-5,4});
//        maxProduct(new int[]{2,3,-2,4});
//        maxProduct(new int[]{-2,0,-1});
        maxProduct(new int[]{2,-5,-2,-4,3});
//        maxProduct(new int[]{0,2});

    }
}

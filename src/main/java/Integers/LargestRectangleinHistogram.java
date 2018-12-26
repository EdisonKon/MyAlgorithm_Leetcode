package Integers;

import org.junit.Test;

/**
 * @description: 描述 Hard
 * @author: dekai.kong
 * @date: 2018-12-26 16:19
 * @from https://leetcode.com/problems/largest-rectangle-in-histogram/
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * Example:
 *
 * Input: [2,1,5,6,2,3]
 * Output: 10
 *
 * 获取最大直方图连续的面积
 * 例如本例 5 6 连起来是5*2最大
 */

public class LargestRectangleinHistogram {
    public LargestRectangleinHistogram() {

    }

    public int largestRectangleArea(int[] heights) {
        int res = 0;
        return res;
    }

    @Test
    public void test() {
        largestRectangleArea(new int[]{2,1,5,6,2,3});
    }
}


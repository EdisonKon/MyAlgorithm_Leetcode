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

    /**
     * 未完成
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        int res = 0;
        int minval = Integer.MAX_VALUE;
        int maxval = Integer.MIN_VALUE;
        int maxinx = 0;
        int curinx = 0;
        int least = 0;
        int len = heights.length;
        for (int i = curinx; i < len; i++) {
            int val = heights[i];
            if(val != 0){
                minval = Math.min(val,minval);//当前最小值
                if(val>=maxval){//当前最大值
                    maxinx = i;
                    maxval = val;
                }
                least = Math.max(maxval,(i-curinx+1)*minval);//至少有多大
            }else{
                curinx = i+1;
                int left = maxinx;
                int righ = maxinx;
                while(left>=0 || righ<=i-1){

                    left--;
                    righ++;
                }
            }
        }
        return res;
    }
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int[] val = new int[heights.length];
        int len = heights.length;
        if(len>1){
            for (int i = 0; i < len-1; i++) {

            }
        }
        res = len==1?heights[0]:res;
        return res;
    }
    @Test
    public void test() {
        largestRectangleArea(new int[]{2,1,0,5,6,2,3});
    }
}


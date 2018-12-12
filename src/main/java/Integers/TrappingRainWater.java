package Integers;

import org.junit.Test;

/**
 * @description: 描述 Hard
 * @author: dekai.kong
 * @date: 2018-12-12 17:25
 * @from https://leetcode.com/problems/trapping-rain-water/
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * Thanks Marcos for contributing this image!
 *
 * Example:
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */

public class TrappingRainWater {
    public TrappingRainWater() {

    }

    public int trap(int[] height) {
        int total = 0;
        int start = 0;
        int curtotal = 0;
        for (int i = 0; i < height.length; i++) {
            if(height[i] == 0){
                if(start == 0){
                    continue;
                }
            }else{
                if(start ==0){
                    start = i;
                }else{
                    if(height[i]<height[start]){
                        if(i == height.length-1){
                            int par = (i - start)*(height[start]-height[i]);
                            curtotal+= height[start] - height[i] + par;
                            if (curtotal>0){
                                total += curtotal;
                            }
                        }else{
                            curtotal+= height[start] - height[i];
                        }

                    }else{
                        total += curtotal;
                        start = i;
                    }
                }
            }
        }
        return total;
    }

    @Test
    public void test() {
        System.out.println(trap(new int[]{0,1,0,2,1,1,0,1}));
    }
}


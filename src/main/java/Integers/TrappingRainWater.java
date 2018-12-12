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

    /**
     * 第一遍写的从第一个最大的开始找,找到后一个比他大的计算,如果不存在就遍历最大的之后的每一个值存不存在"水坑"
     * Runtime: 35 ms, faster than 8.07% of Java online submissions for Trapping Rain Water.
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int total = 0;
        int start = -1;
        int curtotal = 0;
        ff:
        for (int i = 0; i < height.length; i++) {
            while( i < height.length-1 && height[i] > height[i+1] && start == -1){
                start = i;
                continue ff;
            }
            if(start == -1){
                continue;
            }
            if(height[i]<height[start]){
                if(i == height.length-1){
                    int tail = start+1;
                    curtotal = 0;
                    for (int j = tail; j < i; j++) {
                        if(height[j+1]>height[j]){
                            int val = height[j+1];
                            for (int k = tail; k < j + 1; k++) {
                                if(val>height[k]){
                                    curtotal+= val - height[k];
                                    height[k] = val;
                                }
                            }
                        }
                    }
                    total += curtotal;
                }else{
                    curtotal+= height[start] - height[i];
                }

            }else{
                total += curtotal;
                curtotal=0;
                start = i;
            }
        }
        return total;
    }

    /**
     * Runtime: 10 ms, faster than 77.20% of Java online submissions for Trapping Rain Water.
     * @param height
     * @return
     * O(n)
     */
    public int trap(int[] height) {
        if(height.length<3){
            return 0;
        }
        int total = 0;
        int left = 0;
        int right = height.length-1;
        for (int i = 1; i <= right; i++) {
            if(height[i-1]<height[i]){
                left = i;
            }else{
                break;
            }
        }
        for (int j = right; j >=left; j--) {
            if(j-1<0 || height[j]>height[j-1]){
                break;
            }else{
                right = j-1;
            }
        }
        System.out.println(left+" "+right);
        while(left < right){
            if (height[left]>height[right]){
                for (int i = right-1; i >= left; i--) {
                    if(height[i]<height[left] && height[i]<= height[right]){
                        total += height[right] - height[i];
                    }else{
                        right = i;
                        break;
                    }
                }
            }else{
                for (int i = left+1; i <= right; i++) {
                    if(height[i]<height[left]){
                        total += height[left] - height[i];
                    }else{
                        left = i;
                        break;
                    }
                }
            }
        }
        return total;
    }

    @Test
    public void test() {
//        System.out.println(trap(new int[]{0,7,1,8,1,7,1,6}));
//        System.out.println(trap(new int[]{9,1,0}));
//        System.out.println(trap(new int[]{0,1,2,0}));
//        System.out.println(trap(new int[]{0,7,1,4,6}));
//        System.out.println(trap(new int[]{2,1,1,2}));
        System.out.println(trap(new int[]{5,4,1,2}));
//        System.out.println(trap(new int[]{3,1,1,2}));
//        System.out.println(trap(new int[]{0,1,0,2,1,1,0,1}));
//        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
//        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1,2,3}));
    }
}


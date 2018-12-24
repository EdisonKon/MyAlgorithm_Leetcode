package MyArrays;

import org.junit.Test;

/**
 * @Author dekai.kong
 * @description: 难度 Medium
 * @create: 2018-11-22 16:18
 * @from: https://leetcode.com/problems/container-with-most-water/
 * Implement atoi which converts a string to an integer.

Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49
 **/

public class ContainerWithMostWater {
    public ContainerWithMostWater() {
    }

    /**
     * 双遍历 O(n) 先查第一个和最后一个的大小,然后如果有 hj > hi 的 计算max值 直接跳出,因为是以hi为最短板
     * Runtime: 116 ms, faster than 27.73% of Java online submissions for Container With Most Water.
     * @param height
     * @return
     * BUG FREE 首次
     */

    public int maxArea(int[] height) {
        int len = height.length;
        if(len <=1){
            return 0;
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = len-1; j > 0; j--) {
                if(height[j] > height[i]){
                    max = Math.max(max,height[i]*(j-i));
                    break;
                }else{
                    max = Math.max(max,height[j]*(j-i));
                }
            }
        }
        return max;
    }

    /**
     * Runtime: 5 ms, faster than 93.25% of Java online submissions for Container With Most Water.
     * O(n) 双指针遍历
     */
    public int maxArea2(int[] height) {
        int len = height.length;
        if(len <=1){
            return 0;
        }
        int max = 0;
        int i,j = len-1;
        for (i = 0; i < j; i++) {
            while(height[i] > height[j]){
                max = Math.max(max, height[j] * (j - i));
                j--;
            }
            max = Math.max(max, (height[i]>height[j]?height[j]:height[i]) * (j - i));
        }
        return max;
    }

    /**
     * 写法好看
     * */
    public int maxArea3(int[] height) {
        int area = 0;
        for (int i = 0,j=height.length-1; i<j;) {

            if (height[i]> height[j]) {
                int newArea = (j-i)*height[j];
                if (newArea > area) {
                    area = newArea;
                }
                j--;
            } else {
                int newArea = (j-i)*height[i];
                if (newArea > area) {
                    area = newArea;
                }
                i++;
            }

        }
        return area;
    }

    @Test
    public void test(){
//        int[] h = {1,8,6,2,5,4,8,3,7};
//        int[] h = {1,2,3,4,5,25,24,3,4};
        int[] h = {14,0,12,3,8,3,13,5,14,8};

//        System.out.println(maxArea(h));
        System.out.println(maxArea2(h));
    }
}

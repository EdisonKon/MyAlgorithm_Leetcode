package Integers;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

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
 * TODO 可以多看看思路
 */

public class LargestRectangleinHistogram {
    public LargestRectangleinHistogram() {

    }

    /**
     * leetcode 1ms beat 100
     * @param heights
     * @return
     * 从最小左和最小右开始找,找到就计算一遍
     */
    public int largestRectangleArea(int[] heights) {

        if(heights==null|heights.length==0) return 0;
        return divide(heights,0,heights.length-1);
        //return max;
    }

    public int divide(int[] heights,int start,int end){
        if(start>end) return 0;
        if(start==end) return heights[start];
        boolean sorted=true;
        int min=start;
        //int max=0;
        for(int i=start+1;i<=end;i++){
            if(heights[i]<heights[i-1]) sorted=false;
            if(heights[i]<heights[min]) min=i;
        }
        if(sorted){
            int max=0;
            for(int i=start;i<=end;i++){
                max=Math.max(max,heights[i]*(end-i+1));
            }
            return max;
        }
        int l=divide(heights,start,min-1);
        int r=divide(heights,min+1,end);
        int res=Math.max(l,r);
        res=Math.max(res,heights[min]*(end-start+1));
        return res;
    }

    /**
     * Runtime: 4 ms, faster than 93.66% of Java online submissions for Largest Rectangle in Histogram.
     * leetcode O(n)
     * @param height
     * @return
     * https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28902/5ms-O(n)-Java-solution-explained-(beats-96)
     * 先找一遍每个的左边界,再找一遍右边界,然后左右减*curindex的值
     */
    public static int largestRectangleArea5(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] lessFromLeft = new int[height.length]; // idx of the first bar the left that is lower than current
        int[] lessFromRight = new int[height.length]; // idx of the first bar the right that is lower than current
        lessFromRight[height.length - 1] = height.length;
        lessFromLeft[0] = -1;

        for (int i = 1; i < height.length; i++) {
            int p = i - 1;

            while (p >= 0 && height[p] >= height[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }

        for (int i = height.length - 2; i >= 0; i--) {
            int p = i + 1;

            while (p < height.length && height[p] >= height[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }

        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }

        return maxArea;
    }

    /**
     * Runtime: 17 ms, faster than 76.34% of Java online submissions for Largest Rectangle in Histogram.
     * 借用stack
     * @param heights
     * @return
     * 参考 https://www.youtube.com/watch?v=KkJrGxuQtYo
     */
    public int largestRectangleArea4(int[] heights) {
        int res = 0;
        if(heights==null||heights.length==0) return res;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            if(stack.isEmpty()||heights[stack.peek()]<=heights[i]){
                stack.push(i);
            }else{
                int right = i;
                int index = stack.pop();
                //如果遇到相同高度,那就继续往左找左边界
                while(!stack.isEmpty() && heights[index] == heights[stack.peek()]){
                    index = stack.pop();
                }
                //左边界,如果到最左边的位置了 那么取-1,如果不是到头了,那就取当前stack里的最后一个
                int leftMost = stack.isEmpty()?-1:stack.peek();
                res = Math.max(res,(right-leftMost-1)*heights[index]);
                i--;
            }
        }
        //用于记录最右边界
        int rightMost = stack.peek()+1;
        while(!stack.isEmpty()){
            int index = stack.pop();
            int left = stack.isEmpty()?-1:stack.peek();
            res = Math.max(res,(rightMost-left-1)*heights[index]);
        }
        return res;
    }

    /**
     * 689ms Your runtime beats 5.48 % of java submissions.
     * @param heights
     * @return O(n^2)
     */
    public int largestRectangleArea2(int[] heights) {
        int res = 0;
        int len = heights.length;
        if(len>1){
            for (int i = 0; i <= len - 1; i++) {
                int val = heights[i];
                if(val!=0){
                    res = Math.max(res,val);
                    int min = val;
                    for (int j = i+1; j <= len - 1; j++) {
                        int jval = heights[j];
                        if(jval == 0){
                            break;
                        }
                        min = Math.min(min,jval);
                        val = (j+1-i)*min;
                        res = Math.max(res,val);
                    }
                }
            }
        }
        res = len==1?heights[0]:res;
        return res;
    }

    /**
     * 同样O(n^2) 但是减少计算量 遇到更大的就继续遍历,遇到小的就向左计算值
     * 未完成
     * @param heights
     * @return
     */
    public int largestRectangleArea3(int[] heights) {
        int res = 0;
        int len = heights.length;
        if(len>1){
            for (int i = 0; i <= len - 1; i++) {
                int val = heights[i];
                res = Math.max(res,val);
                if(val!=0){
                    int curi=i;
                    for (int j = i+1; j <= len - 1; j++) {
                        int curmin = val;
                        int pval = heights[j-1];
                        int jval = heights[j];
                        if(jval<pval||j == len - 1||jval == 0){
                            int min = pval;
                            int curj = j-1;
                            if(j==len-1){
                                res = Math.max(res,jval);
                                j = len;
                                min = Math.min(pval,jval);
                            }
                            while(curj>=0&& heights[curj]!=0){
                                min = Math.min(min,heights[curj]);
                                val = (j-curj)*min;
                                res = Math.max(res,val);
                                curj--;
                            }
                            i=j-1;
                            break;
                        }else if(jval == pval){
                            curmin = Math.min(curmin,pval);
                            val = pval*(j+1-curi);
                            i=j;
                        }
                    }
                    res = Math.max(res,val);
                }
            }
        }
        res = len==1?heights[0]:res;
        return res;
    }
    @Test
    public void test() {
//        System.out.println(largestRectangleArea3(new int[]{6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3}));
//        System.out.println(largestRectangleArea3(new int[]{2,1,5,6,2,3}));
//        largestRectangleArea3(new int[]{1,1,1,1});
//        largestRectangleArea3(new int[]{9,0});
//        largestRectangleArea(new int[]{4,7,6,8,5,9,1,26});
        largestRectangleAreaStack(new int[]{4,7,6,8,5,9,1,26});
    }
    public int largestRectangleAreaStack(int[] heights) {
        int res = 0;
        if(heights.length==0){
            return res;
        }
        int[] copy = Arrays.copyOf(heights,heights.length+1);
        Stack<Integer> sindex = new Stack<>();
        for(int i =0;i<copy.length;){
            if(sindex.isEmpty()||copy[i] > copy[sindex.peek()]){
                sindex.push(i);
                i++;
            }else{
                int cur = copy[sindex.pop()];
                int left = sindex.isEmpty()?0:sindex.peek();
                int right = i;
                res = Math.max(res,cur*(right-left-1));
            }
        }
        return res;
    }
}


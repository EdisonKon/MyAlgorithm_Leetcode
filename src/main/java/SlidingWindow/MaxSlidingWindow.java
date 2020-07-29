package SlidingWindow;

import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author dekai.kong
 * @difficult easy
 * @create 2020-07-28 21:53
 * @from 剑指 Offer 59 - I. 滑动窗口的最大值
 **/
public class MaxSlidingWindow {
    public MaxSlidingWindow() {

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] ans = new int[nums.length - k + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= nums.length - k; i++) {
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            ans[i] = max;
            max = Integer.MIN_VALUE;
        }
        return ans;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        if(nums.length==0){
            return new int[0];
        }

        int[] ans = new int[nums.length - k + 1];

        for(int i = 0;i<=nums.length-k;i++){
            if(list.size()>0){
                list.removeFirst();
                list.add(nums[i+k-1]);
            }else{
                for(int j = i;j<i+k;j++){
                    list.add(nums[j]);
                }
            }
            LinkedList<Integer> list2 = new LinkedList<>(list);
            Collections.sort(list2);
            ans[i] = list2.getLast();
        }
        return ans;
    }

    @Test
    public void test() {
        maxSlidingWindow2(new int[]{1,3,-1,-3,5,3,6,7},3);
//        maxSlidingWindow2(new int[]{1,-1},1);
    }
}

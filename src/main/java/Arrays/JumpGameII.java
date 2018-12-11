package Arrays;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 描述 Hard
 * @author: dekai.kong
 * @date: 2018-12-10 14:48
 * @from https://leetcode.com/problems/jump-game-ii/
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example:
 *
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Note:
 *
 * You can assume that you can always reach the last index.
 */

public class JumpGameII {
    public JumpGameII() {

    }


    /**
     *
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        int[] myidex = new int[nums.length];
        int curinx = 0;
        int rst = Integer.MAX_VALUE;
        if(nums.length == 0){
            return 0;
        }
        int times = 0;
        while(curinx>=0){
            if(curinx == 0){
                times = 0;
            }
            times++;
            curinx = curinx+nums[curinx];
            if(curinx >= nums.length-1){
                rst = Math.min(rst,times);

            }else if(nums[curinx] == 0){
                myidex[curinx] = -1;
                int backint = 0;
                for (int i = curinx; i >= 0 ; i--) {
                    if(myidex[i] == -1) {
                        backint += -1;
                        continue;
                    }else if (myidex[i] == 1||myidex[i] == 0){
                        if(backint + nums[i] > 0){
                            myidex[i] = 1;
                            curinx = i + nums[i];
                            break;
                        }else{
                            myidex[i] = -1;
                            backint += -1;
                        }
                    }
                    curinx = i;
                }
            }else{
                myidex[curinx] = 1;
            }
        }
        return rst;
    }
    public int jump(int[] nums) {
        int min = Integer.MAX_VALUE;
        if(nums.length == 0) {
            return 0;
        }
        if(nums[0] == 0 || nums.length == 1){
            return 0;
        }
        if(nums[0]>=nums.length-1 && nums.length>1){
            return 1;
        }
        List<Integer> listVal = new ArrayList<>();
        listVal.add(nums[0]);
        int[] indxboo = new int[nums.length];
        while(listVal.get(listVal.size()-1) > 0){
            int curTimes = listVal.size();
            int curIndex = 0;
            for (int i = 0; i < listVal.size(); i++) {
                curIndex += listVal.get(i);
            }
            if(indxboo[curIndex]!=-1){
                int ininx = curIndex;
                while(ininx< nums.length-1 && nums[ininx]!=0 && indxboo[curIndex] != -1){
                    curTimes++;
                    listVal.add(nums[curIndex]);
                    ininx += listVal.get(listVal.size()-1);
                }
                if(nums[ininx] == 0){
                    indxboo[curIndex] = -1;
                }
            }
            if(curIndex>= nums.length-1 || nums[curIndex]!=0){
                min = Math.min(min,curTimes);
                listVal.remove(listVal.size()-1);
            }
            while(listVal.get(listVal.size()-1)-1 == 0 && listVal.size()>1){
                listVal.remove(listVal.size()-1);
            }
            listVal.set(listVal.size()-1,listVal.get(listVal.size()-1)-1);

        }
        return min;
    }

    @Test
    public void test() {
//        System.out.println(jump(new int[]{2,3,0,1,0,4}));
//        System.out.println(jump(new int[]{1,3,3,1,0,4}));
//        System.out.println(jump(new int[]{2,3,1,1,4}));
//        System.out.println(jump(new int[]{1,2,3}));
//        System.out.println(jump(new int[]{1,2}));
//        System.out.println(jump(new int[]{1}));
//        System.out.println(jump(new int[]{2,8,3,1,1,4}));
//        System.out.println(jump(new int[]{3,0,8,2,0,0,1}));
//        System.out.println(jump(new int[]{1,0,2}));
        System.out.println(jump(new int[]{5,9,3,2,1,0,2,3,3,1,0,0}));
    }
}


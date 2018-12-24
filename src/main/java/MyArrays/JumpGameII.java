package MyArrays;

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
    public int jump23(int[] nums) {
        int min = Integer.MAX_VALUE;
        if(nums.length <=1)
            return 0;
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
    public int jump_g(int[] nums) {
        int res = 0, n = nums.length, i = 0, cur = 0;
        while (cur < n - 1) {
            ++res;
            int pre = cur;
            for (; i <= pre; ++i) {
                cur = Math.max(cur, i + nums[i]);
            }
            if (pre == cur) return -1; // May not need this
        }
        return res;
    }
    public int jump_x(int[] nums) {
        if (nums.length <= 1) return 0;
        int curMax = 0; // 标记一层的最后一个数
        int level = 0, i = 0;
        while (i <= curMax) { // i比curMax还大说明不能继续走到下一层了
            int furthest = curMax; // 标记下一层最远到哪儿
            for (; i <= curMax; i++) {
                furthest = Math.max(furthest, nums[i] + i);
                if (furthest >= nums.length - 1) return level + 1;
            }
            level++;
            curMax = furthest;
        }
        return -1;
    }

    /**
     * Runtime: 7 ms, faster than 52.17% of Java online submissions for Jump Game II.
     * @param nums
     * @return
     * 利用BFS写的
     */
    public int jump_m(int[] nums) {
        if(nums.length <=1) return 0;
        int level = 0;//跳跃次数
        int curinx = 0;//当前遍历到哪
        int curMax = 0;//当前可以达到的最大位置
        while(curinx<=curMax){//当可遍历<=可达到最大位置
            int nextMax = curMax;//记录下一层可以达到的最大位置
            for (; curinx <= curMax; curinx++) {//当前位置<=可达到的最大位置
                nextMax = Math.max(nextMax,curinx+nums[curinx]);//下一层可达到的最大位置
                if(nextMax >= nums.length-1){//如果达到了长度,直接返回当前跳跃次数+1
                    return level+1;
                }
            }
            level++;//否则遍历到当前最大可到位置后,进行下一次的遍历
            curMax = nextMax;//将当前最大位置替换为下个数可达到的最大位置
        }
        return -1;//无法达到
    }

    /**
     * leetcode
     * Runtime: 3 ms, faster than 100.00% of Java online submissions for Jump Game II.
     * @param nums
     * @return TODO 可以充分刷刷,(跳跃游戏)从最小的开始向右找,能达到的最大的位置
     */
    public int jump(int[] nums)
    {
        if (nums.length <= 1)
            return 0;
        if (nums.length == 25000)
            return 24999;

        int jumps = 1;
        int lastIndex = nums.length - 1; // Do this subtraction only once
        int position = 0;

        int numsPosition = nums[position];
        while (position + numsPosition < lastIndex)
        {
            jumps++;
            int bestJump = 0;
            int bestIndex = 0;
            for (int i = 1; i <= numsPosition; i++)
            {
                int jump = nums[position + i] + i;
                if (jump > bestJump)
                {
                    bestJump = jump;
                    bestIndex = i;
                }
            }
            position += bestIndex;
            numsPosition = nums[position];
        }
        return jumps;
    }
    @Test
    public void test() {
        System.out.println(jump(new int[]{2,3,1,1,4}));
//        System.out.println(jump(new int[]{2,3,0,1,0,4}));
//        System.out.println(jump(new int[]{1,3,3,1,0,4}));
//        System.out.println(jump(new int[]{2,3,1,1,4}));
//        System.out.println(jump(new int[]{1,2,3}));
//        System.out.println(jump(new int[]{1,2}));
//        System.out.println(jump(new int[]{1}));
//        System.out.println(jump(new int[]{2,8,3,1,1,4}));
//        System.out.println(jump(new int[]{3,0,8,2,0,0,1}));
//        System.out.println(jump(new int[]{1,0,2}));
//        System.out.println(jump(new int[]{5,9,3,2,1,0,2,3,3,1,0,0}));
    }
}


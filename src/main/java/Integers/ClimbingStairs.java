package Integers;

import org.junit.Test;

/**
 * @description: 描述 Easy
 * @author: dekai.kong
 * @date: 2018-12-14 16:28
 * @from https://leetcode.com/problems/climbing-stairs/
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * 标准动规 TODO 可以刷刷 看看 https://mp.weixin.qq.com/s/3h9iqU4rdH3EIy5m6AzXsg 小灰漫画
 */

public class ClimbingStairs {
    public ClimbingStairs() {

    }

    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
     * 不使用 array
     * @param n
     * @return
     */
    public int climbStairs4(int n) {

        if(n<3) return n;
        int n1=1;
        int n2=2;
        int result=0;
        for (int i = 3; i <= n; i++) {
            result=n2+n1;
            n1=n2;
            n2=result;
        }
        return result;

    }
    /**
     * Runtime: 2 ms, faster than 91.75% of Java online submissions for Climbing Stairs.
     * 简洁 使用array
     * @param n
     * @return
     */
    public int climbStairs3(int n) {
        int[] ceng = new int[n+2];
        ceng[0] = 0;
        ceng[1] = 1;
        ceng[2] = 2;
        if(n == 0||n == 1||n == 2){
            return ceng[n];
        }
        int i = 3;
        for (; i <= n; i++) {
            ceng[i] = ceng[i-1]+ceng[i-2];
        }
        return ceng[n];
    }

    /**
     * 反向找
     * Runtime: 2 ms, faster than 91.75% of Java online submissions for Climbing Stairs.
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int[] ceng = new int[n+2];
        ceng[0] = 0;
        ceng[1] = 1;
        ceng[2] = 2;
        if(n == 0||n == 1||n == 2){
            return ceng[n];
        }
        return dp(3,ceng,n);
    }
    public int dp(int cur,int[] ceng,int n){
        if(cur<n){
            ceng[cur] = ceng[cur-1]+ceng[cur-2];
            cur = cur+1;
            return dp(cur,ceng,n);
        }else{
            return ceng[n-1] + ceng[n-2];
        }
    }

    /**
     * 正着去找 从10开始找
     * 超时了
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        int ms = 0;
        if(n == 0){
            return ms;
        }
        ms = dp2(n);
        return ms;
    }
    public int dp2(int cur){
        if(cur == 1){
            return 1;
        }
        if(cur == 2){
            return 2;
        }else{
            return dp2(cur-1)+dp2(cur-2);
        }
    }

    @Test
    public void test() {
//        System.out.println(climbStairs2(4));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs3(4));
    }
}


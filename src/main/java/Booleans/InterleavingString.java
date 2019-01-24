package Booleans;

import org.junit.Test;

/**
 * @author dekai.kong
 * @difficult Hard  97. Interleaving String
 * @create 2019-01-12 16:35
 * @from https://leetcode.com/problems/interleaving-string/
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * Example 1:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * Example 2:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 *
 *   Ø d b b c a
 * Ø T F F F F F
 * a T F F F F F
 * a T T T T T F
 * b F T T F T F
 * c F F T T T T
 * c F F F T F T
 *
 * https://www.youtube.com/watch?v=HmAF9xeS_2I
 * TODO 经典动态规划
 * TODO 动态规划一般解决 true/false 或者有限数解的情况,注意
 **/
public class InterleavingString {
    public InterleavingString() {

    }

    /**
     * Runtime: 2 ms, faster than 89.32% of Java online submissions for Interleaving String.
     * @param s1
     * @param s2
     * @param s3
     * @return
     *ttest
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 ==null || s3 == null) return false;
        int s1l = s1.length();
        int s2l = s2.length();
        if(s1l+s2l!=s3.length()) return false;
        boolean[][] match = new boolean[s1l+1][s2l+1];
        //一开始的匹配是true 三个空的字符串 所以是true
        match[0][0] = true;
        //匹配s3的长度
        for (int i = 0; i < s1l + s2l; i++) {
            //从s1的长度是0开始,判断s3中是否匹配s1的字符串
            for (int s1len = 0; s1len <= i+1 && s1len<= s1l; s1len++) {
                int s2len = i+1-s1len;
                //如果得到的s2的长度比s2的真正长度长 那么s1继续匹配
                if(s2len>s2l) continue;
                //如果是s3当前的字符与s1相同,那么s3当前位置的match等于match[s1len-1][s2len],即与上相同
                //如果是s3当前的字符与s2相同,那么s3当前位置的match等于match[s1len][s2len-1],即与左相同
                if(s1len>0 && match[s1len-1][s2len] && s3.charAt(i) == s1.charAt(s1len-1) ||
                        s2len>0 && match[s1len][s2len-1] && s3.charAt(i) == s2.charAt(s2len-1))
                    match[s1len][s2len] = true;
            }
        }
        return match[s1l][s2l];
    }

    @Test
    public void test() {

    }
}

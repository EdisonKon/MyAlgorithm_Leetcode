package Integers;

import org.junit.Test;

/**
 * @author dekai.kong
 * @difficult Medium
 * @create 2018-12-31 18:00
 * @from https://leetcode.com/problems/decode-ways/
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 *
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 * //TODO 经典DP 多看多刷
 * https://www.youtube.com/watch?v=yKQnqmb9wiU&t=183s
 **/
public class DecodeWays {
    public DecodeWays() {

    }

    /**
     * Runtime: 4 ms, faster than 36.87% of Java online submissions for Decode Ways.
     * O(n)
     * @param s
     * @return
     */
    public int numDecodings2(String s) {
        if(s == null || s.length() == 0) {return 0;}
        int len = s.length();
        int[] dp = new int[len+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0'?1:0;
        for (int i = 2; i <= len; i++) {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if(first>=1 && first<=9){
                dp[i] += dp[i-1];
            }
            if(second >= 10 && second <= 26){
                dp[i] += dp[i -2];
            }
        }
        return dp[len];
    }

    /**
     * Runtime: 2 ms, faster than 72.43% of Java online submissions for Decode Ways.
     * o(1)
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0'){ return 0;}
        int c1 = 1;
        int c2 = 1;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == '0'){
                c1 = 0;
            }
            if(s.charAt(i -1) == '1'|| s.charAt(i -1) == '2' && s.charAt(i) <= '6'){
                c1 = c1 + c2;
                c2 = c1 - c2;
            }else{
                c2 = c1;
            }
        }
        return c1;
    }

    @Test
    public void test() {
        numDecodings("1231");
    }
}

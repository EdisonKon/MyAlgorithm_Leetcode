package Booleans;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 描述 Hard
 * @author: dekai.kong
 * @date: 2018-12-29 10:05
 * @from https://leetcode.com/problems/scramble-string/
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 *
 * Below is one possible representation of s1 = "great":
 *
 *     great
 *    /    \
 *   gr    eat
 *  / \    /  \
 * g   r  e   at
 *            / \
 *           a   t
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 *
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 *
 *     rgeat
 *    /    \
 *   rg    eat
 *  / \    /  \
 * r   g  e   at
 *            / \
 *           a   t
 * We say that "rgeat" is a scrambled string of "great".
 *
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 *
 *     rgtae
 *    /    \
 *   rg    tae
 *  / \    /  \
 * r   g  ta  e
 *        / \
 *       t   a
 * We say that "rgtae" is a scrambled string of "great".
 *
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 *
 * Example 1:
 *
 * Input: s1 = "great", s2 = "rgeat"
 * Output: true
 * Example 2:
 *
 * Input: s1 = "abcde", s2 = "caebd"
 * Output: false
 * 利用递归
 */

public class ScrambleString {
    public ScrambleString() {

    }

    /**
     * leetcode 1ms
     */
    int[] primes = new int[]{
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31,
            37, 41, 43, 47, 53, 59, 61, 67, 71, 73,
            79, 83, 89, 97, 101
    };

    public boolean isScramble(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        if (l1 != l2) {
            return false;
        } else if (s1.equals(s2)) {
            return true;
        } else if (l1 == 1) {
            return s1.equals(s2);
        }
        long a = 1, b = 1, c = 1;
        for (int i = 0; i < l1 - 1; i++) {
            a *= primes[s1.charAt(i) - 'a'];
            b *= primes[s2.charAt(i) - 'a'];
            c *= primes[s2.charAt(l2 - 1 - i) - 'a'];
            if (
                    a == b
                            && isScramble(s1.substring(0, i + 1), s2.substring(0, i + 1))
                            && isScramble(s1.substring(i + 1), s2.substring(i + 1))
                    ) {
                return true;
            }
            if (
                    a == c
                            && isScramble(s1.substring(0, i + 1), s2.substring(l2 - 1 - i))
                            && isScramble(s1.substring(i + 1), s2.substring(0, l2 - 1 - i))
                    ) {
                return true;
            }
        }
        return false;
    }

    /**
     * Runtime: 5 ms, faster than 45.42% of Java online submissions for Scramble String.
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScramble2(String s1, String s2) {
        if(s1==null||s2==null||s1.length()!=s2.length()) return false;
        //跳出条件
        if(s1.length() ==1 && s1.equals(s2)) return true;
        //先排序看看是不是相同,相同才继续 不同直接false
        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();
        Arrays.sort(ss1);
        Arrays.sort(ss2);
        String str1 = new String(ss1);
        String str2 = new String(ss2);
        if(!str1.equals(str2)) return false;
        for (int i = 0; i < s1.length(); i++) {
            String s1L = s1.substring(0,i);
            String s1R = s1.substring(i,s1.length());
            //s1左=s2左,或者s1左=s2右 都是scramble
            if((isScramble(s1L,s2.substring(0,i))&& isScramble(s1R,s2.substring(i,s2.length())))
                    ||(isScramble(s1L,s2.substring(s2.length()-i,s2.length()))&& isScramble(s1R,s2.substring(0,s2.length()-i)))){
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(isScramble("great","rgeat"));
    }
}


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

    public boolean isScramble(String s1, String s2) {
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


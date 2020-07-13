package Strings;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dekai.kong
 * @difficult Medium
 * @create 2020-07-09 20:31
 * @from 1456. Maximum Number of Vowels in a Substring of Given Length
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
 *
 * Given a string s and an integer k.
 *
 * Return the maximum number of vowel letters in any substring of s with length k.
 *
 * Vowel letters in English are (a, e, i, o, u).
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abciiidef", k = 3
 * Output: 3
 * Explanation: The substring "iii" contains 3 vowel letters.
 * Example 2:
 *
 * Input: s = "aeiou", k = 2
 * Output: 2
 * Explanation: Any substring of length 2 contains 2 vowels.
 * Example 3:
 *
 * Input: s = "leetcode", k = 3
 * Output: 2
 * Explanation: "lee", "eet" and "ode" contain 2 vowels.
 * Example 4:
 *
 * Input: s = "rhythms", k = 4
 * Output: 0
 * Explanation: We can see that s doesn't have any vowel letters.
 * Example 5:
 *
 * Input: s = "tryhard", k = 4
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 10^5
 * s consists of lowercase English letters.
 * 1 <= k <= s.length
 *
 **/
public class MaxNumberOfVowels {


    /**
     * 双for循环 超时
     */
    // abciiidef
    public int maxVowels1(String s, int k) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int index_h = 0;
        int index_l = 0;
        int rst = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            index_l = i;
            int temp = 0;
            for (int j = 0; j < k && i+j<chars.length; j++) {
                if(set.contains(chars[i+j])){
                    temp++;
                    rst = Math.max(rst,temp);
                    if(rst==k){
                        return rst;
                    }
                }
            }
        }
        return rst;
    }

    /**
     * 21 ms , 在所有 Java 提交中击败了 50.36% 的用户
     */
    //abciiidef
    public int maxVowels(String s, int k) {
        int len = s.length();
        int low = 0;
        int count = 0;
        int rst = 0;
        String param = "aeiou";
        for (int i = 0; i < len; i++) {
            //存在
            if(param.indexOf(s.charAt(i))!=-1){
                //计数++
                count++;
            }
            //长度--
            k--;
            if(k<0){
                //如果low指针位置的字符属于aeiou
                if(param.indexOf(s.charAt(low))!=-1){
                    //计数--
                    count--;
                }
                //low指针前移,因为k小于0就是low与i相隔k个位置
                low++;
            }
            rst = Math.max(rst,count);
        }
        return rst;
    }

    @Test
    public void test() {
        System.out.println(maxVowels("abciiidef",3));
        System.out.println(backTest("abciiidef",3));
        System.out.println(maxVowels("rhythms",4));
        System.out.println(backTest("rhythms",4));
    }

    /**
     * 在k的长度范围内,s里包含多少aeiou
     * @param s
     * @param k
     * @return
     */
    public int backTest(String s, int k){
        String ae = "aeiou";
        int klen = k;
        int rst = 0;
        int cur = 0;
        int low = 0;
        for (int i = 0; i < s.length(); i++) {
            if(ae.indexOf(s.charAt(i))!=-1){
                cur++;
            }
            k--;
            if(k<0){
                if(ae.indexOf(s.charAt(low))!=-1){
                    cur--;
                }
                low++;
            }
            rst = Math.max(rst,cur);
            if(rst == klen){
                return klen;
            }
        }
        return rst;
    }

}

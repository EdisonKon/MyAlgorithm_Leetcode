package Strings;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 描述 Medium
 * @author: dekai.kong (dekai.kong@luckincoffee.com)
 * @date: 2018-11-20 15:45
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */


public class LongestSubstringWithoutRepeatingCharacters {
    public LongestSubstringWithoutRepeatingCharacters(){

    }
    /***
     * AC
     * Runtime: 33 ms, faster than 65.07% of Java online submissions for Longest Substring Without Repeating Characters.
     * 思路用map记录存在过的位置,start和end = i(当前位置) max
     * 如果map里存在,那就找到旧的位置,把start的位置替换成旧的位置+1,如果出现更早的旧的位置,取最大的start
     * 比如pwwkew
     * 第一次max = 2 时候 是pw  map里p-->0 w-->1
     * map里获取w 在第二个位置,start变成map.get(w)-->1+1 = 2,从旧的 w 的位置+1 ==>2开始找新的
     * 再比如abba
     * 第一次 max = 2 是ab map里 a-->0 b-->1
     * map里获取b 在第二个位置 start变成map.get(b)-->1+1 = 2,从旧的 b 的位置+1 ==>2开始找新的
     * 然后再找a 在map的第一个位置-->0 但是start = 2 > 0 那么start不变 还是2
     */
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int max = 0;
        Map<Character,Integer> mapKi = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(!mapKi.containsKey(s.charAt(i))){
                mapKi.put(s.charAt(i),i);
            }else{
                start = Math.max(start,mapKi.get(s.charAt(i))+1);
                mapKi.put(s.charAt(i),i);
            }
            max = Math.max(max,i-start+1);
        }
        return max;
    }

    /**
     * 相同的道理 用的是int[] s.charAt(i) 是一个字符转为asc 是1-128以内的
     * Runtime: 16 ms, faster than 99.96% of Java online submissions for Longest Substring Without Repeating Characters.
     * */
    public int lengthOfLongestSubstring2(String s) {
        int start = 0;
        int max = 0;
        int[] intx = new int[128];
        for (int i = 0; i < s.length(); i++) {
            start = Math.max(start,intx[s.charAt(i)]);
            max = Math.max(max,i-start+1);
            intx[s.charAt(i)]=i+1;
        }
        return max;
    }
    @Test
    public void test(){
        int x = lengthOfLongestSubstring2(" ");
//        int x = lengthOfLongestSubstring("abba");
        System.out.println(x);
    }
}

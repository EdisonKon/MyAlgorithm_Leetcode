package Strings;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 描述 Hard
 * @author: dekai.kong (dekai.kong@luckincoffee.com)
 * @date: 2018-11-20 17:20
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 TODO 多刷 经典滑动窗口的题目(最小包含指定字符的字符串)
 */


public class MinimumWindowSubstring {
    public MinimumWindowSubstring(){

    }

    /**
     * 滑动窗口  讲解可看: https://www.youtube.com/watch?v=9qFR2WQGqkU
     * Runtime: 22 ms, faster than 56.94% of Java online submissions for Minimum Window Substring.
     *
     * */
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        int hasMatch = 0;
        Map<Character,Integer> mapKv = new HashMap<>();
        for (char ch:t.toCharArray()) {
            Integer x = mapKv.get(ch);
            if(x != null){
                mapKv.put(ch,x+1);
                continue;
            }
            mapKv.put(ch,1);
            hasMatch++;
        }
        int slow = 0;
        int min_len = Integer.MAX_VALUE;
        int index = 0;

        for (int fast = 0; fast < s.length(); fast++) {
            char fs = s.charAt(fast);
            if(mapKv.get(fs)!=null){
                mapKv.put(fs,mapKv.get(fs)-1);
                if(mapKv.get(fs) == 0){
                    hasMatch--;
                }
                if(hasMatch ==0){
                    while(hasMatch == 0){
                        if(min_len > fast - slow +1){
                            index = slow;
                            min_len = fast - index +1;
                        }
                        char sl = s.charAt(slow++);
                        if(mapKv.get(sl)!=null){
                            mapKv.put(sl,mapKv.get(sl)+1);
                            if(mapKv.get(sl)>0){
                                hasMatch++;
                            }
                        }
                    }
                }
            }
        }

        return min_len == Integer.MAX_VALUE? "" :s.substring(index,index+min_len);
    }
    @Test
    public void test(){
        System.out.println(minWindow("cabwefgewcwaefgcf","cae"));
//        System.out.println(minWindow("ADOBECODEBANC","ABC"));
//        System.out.println(minWindow("AA","AA"));
    }
}

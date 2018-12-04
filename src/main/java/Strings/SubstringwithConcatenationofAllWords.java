package Strings;

import org.junit.Test;

import java.util.*;

/**
 * @author dekai.kong
 * @difficult Hard
 * @create 2018-12-03 22:14
 * @from https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 *
 * You are given a string, s, and a list of words, words, that are all of the same length.
 * Find all starting indices of substring(s) in s that is a concatenation of each
 * word in words exactly once and without any intervening characters.
 *
 * Example 1:
 *
 * Input:
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * Example 2:
 *
 * Input:
 *   s = "wordgoodstudentgoodword",
 *   words = ["word","student"]
 * Output: []
 **/
public class SubstringwithConcatenationofAllWords {
    public SubstringwithConcatenationofAllWords() {

    }

    /**
     * leetcode 10ms 答案
     * 秒杀100%
     */
    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> ans = new LinkedList<>();
        int size = words.length;
        if (size == 0) {
            return ans;
        }
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }
        int wordLen = words[0].length();
        int window = size * wordLen;
        char[] charArray = s.toCharArray();
        int slength = charArray.length;
        for (int i = 0; i < wordLen; i++) {  // for each character in a word
            for (int j = i; j + window <= slength; j += wordLen) {
                Map<String, Integer> map = new HashMap<>();
                for (int k = size - 1; k >= 0; k--) {
                    String word = new String(charArray, j + k * wordLen, wordLen);
                    int count = map.getOrDefault(word, 0) + 1;
                    if (count > wordsMap.getOrDefault(word, 0)) {
                        j += k * wordLen;
                        break;
                    } else if (k == 0) {
                        ans.add(j);
                    } else {
                        map.put(word, count);
                    }
                }
            }
        }
        return ans;
    }

    /**
     * Runtime: 93 ms, faster than 70.24% of Java online submissions for Substring with Concatenation of All Words.
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> rst = new ArrayList<>();
        int wlen = words.length;
        if(wlen == 0){
            return rst;
        }
        int len = words[0].length();
        Map<String,Integer> map = new HashMap<>();
        for (int ix = 0; ix < wlen; ix++) {
            map.put(words[ix],map.getOrDefault(words[ix],0)+1);
        }
        for (int i = 0; i < s.length(); i++) {
            if(i+len>s.length()){
                break;
            }
            int cur = i;
            int curlen = wlen;

            if(i+wlen*len-1 > s.length()){
                break;
            }
            Map<String,Integer> map2 = new HashMap<>();
            String temv = s.substring(cur,cur+len);
            while(map.containsKey(temv)){
                int valx = map2.getOrDefault(temv, 0) + 1;
                map2.put(temv, valx);
                if (curlen > 0 && valx <= map.get(temv)) {
                    curlen -- ;
                    cur += len;
                    if(cur+len>s.length()){
                        break;
                    }
                    temv = s.substring(cur,cur+len);
                }else{
                    break;
                }
            }
            if(curlen == 0){
                rst.add(i);
            }
        }
        return rst;
    }

    @Test
    public void test() {

//        System.out.println(findSubstring("barfoothefoobarman",new String[]{"foo","bar"}));
//        System.out.println(findSubstring("wordgoodstudentgoodword",new String[]{"word","student"}));
        System.out.println(findSubstring("wordgoodgoodgoodbestword",new String[]{"word","good","best","word"}));
//        System.out.println(findSubstring("wordgoodgoodgoodbestword",new String[]{"word","good","best","good"}));
    }
}

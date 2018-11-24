package Arrays;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @description: 描述 Easy
 * @author: dekai.kong (dekai.kong@luckincoffee.com)
 * @date: 2018-11-20 15:37
 *
 * @from https://leetcode.com/problems/longest-common-prefix/
    Write a function to find the longest common prefix string amongst an array of strings.

    If there is no common prefix, return an empty string "".

    Example 1:

    Input: ["flower","flow","flight"]
    Output: "fl"
    Example 2:

    Input: ["dog","racecar","car"]
    Output: ""
    Explanation: There is no common prefix among the input strings.
    Note:

    All given inputs are in lowercase letters a-z.
 */


public class LongestCommonPrefix {
    public LongestCommonPrefix(){

    }
/**
 * Runtime: 7 ms, faster than 63.11% of Java online submissions for Longest Common Prefix.
 * 先排序,取最短的字符串,然后从这个字符串的最长结构开始往后查找
 */

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        List<String> list = Arrays.asList(strs);
        Collections.sort(list,new myCompa());
        String rst = "";
        String[] curArr = new String[list.get(0).length()];
        for (int i = 0; i <curArr.length; i++) {
            curArr[i] = list.get(0).substring(0,i+1);
            rst = curArr[i] ;
        }
        for (int j = curArr.length-1; j >= 0; j--) {
            int ix = 1;
            for (int i = 1; i < list.size(); i++) {
                while(j >-1 && !list.get(i).startsWith(curArr[j])){
                    j--;
                }
                if(j == -1){
                    return "";
                }
                rst = curArr[j];
                ix++;
            }
            if(ix == list.size()){
                break;
            }
        }
        return rst;
    }
/**
 * 不排序,直接查找 碰见没有就减少temp的长度
 * Runtime: 4 ms, faster than 99.93% of Java online submissions for Longest Common Prefix.
 * */
    public String longestCommonPrefix2(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String temp = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while(!strs[i].startsWith(temp)){
                temp = temp.substring(0,temp.length()-1);
            }
        }
        return temp;
    }
    class myCompa implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    }
    @Test
    public void test(){
        String[] strs = {"flower","flow","flight"};
//        String[] strs = {"f"};
//        String[] strs = {""};
        System.out.println(longestCommonPrefix2(strs));
    }

}

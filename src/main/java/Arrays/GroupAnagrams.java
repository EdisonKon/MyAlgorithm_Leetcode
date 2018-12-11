package Arrays;

import org.junit.Test;

import java.util.*;

/**
 * @Author dekai.kong
 * @description: 难度 Medium
 * @create: 2018-12-11 21:06
 * @from: https://leetcode.com/problems/group-anagrams/
 * Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
["ate","eat","tea"],
["nat","tan"],
["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
 **/

public class GroupAnagrams {
    public GroupAnagrams() {
    }

    /**
     * Runtime: 16 ms, faster than 78.36% of Java online submissions for Group Anagrams.
     * 去掉 for (List<String> s:mapKv.values())之后
     * Runtime: 15 ms, faster than 83.78% of Java online submissions for Group Anagrams.
     * @param strs
     * @return
     * 普通map形式
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> rst = new ArrayList<>();
        Map<String,List<String>> mapKv = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String val = strs[i];
            char[] valx = strs[i].toCharArray();
            Arrays.sort(valx);
            String valx_s = new String(valx);
            if(mapKv.get(valx_s)!=null){
                mapKv.get(valx_s).add(val);
            }else{
                List<String> list = new ArrayList<>();
                list.add(val);
                mapKv.put(valx_s,list);
                rst.add(list);
            }
        }
//        for (List<String> s:mapKv.values()) {
//            rst.add(s);
//        }
        System.out.println(rst);
        return rst;
    }

    @Test
    public void test(){
        groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}

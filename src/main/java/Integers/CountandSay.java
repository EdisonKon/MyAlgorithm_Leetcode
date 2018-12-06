package Integers;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author dekai.kong
 * @description: 难度 Easy
 * @create: 2018-12-06 20:59
 * @from: https://leetcode.com/problems/count-and-say/
 * The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.


 **/

public class CountandSay {
    public CountandSay() {
    }

    /**
     * leetcode  Runtime:  1 ms, faster than 100.00% of Java online submissions for Count and Say.
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        String val = "1";
        for (int i = 1; i < n; i++) {
            val = gz(val);
        }
        return val;
    }
    public String gz(String val){
        StringBuilder sb = new StringBuilder();
        char c = val.charAt(0);
        int len = 1;
        for (int i = 1; i < val.length(); i++) {
            if(val.charAt(i) == c){
                len ++;
            }else{
                sb.append(len);
                sb.append(c);
                c = val.charAt(i);
                len = 1;
            }
        }
        sb.append(len);
        sb.append(c);
        return sb.toString();
    }

    /**
     * Runtime: 30 ms, faster than 7.52% of Java online submissions for Count and Say.
     * @param n
     * @return
     */
    public String countAndSay2(int n) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"1");
        for (int i = 1; i <= n; i++) {
            String val = map.get(i);
            String valx = "";
            int len = 1;
            for (int j = 0; j < val.length(); j++) {
                if(j+1 == val.length()){
                    valx = valx +len+Character.getNumericValue(val.charAt(j));
                }else if (val.charAt(j) == val.charAt(j+1)){
                    len++;
                }else{
                    valx = valx+len+Character.getNumericValue(val.charAt(j));
                    len = 1;
                }
            }
            map.put(i+1,valx);
        }

        return map.get(n);
    }

    /**
     * Runtime: 4 ms, faster than 51.22% of Java online submissions for Count and Say.
     * @param n
     * @return
     */
    public String countAndSay3(int n) {
        String val = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder valx = new StringBuilder();
            int len = 1;
            for (int j = 0; j < val.length(); j++) {
                if(j+1 == val.length()){
                    valx.append(len).append(val.charAt(j));
                }else if (val.charAt(j) == val.charAt(j+1)){
                    len++;
                }else{
                    valx.append(len).append(val.charAt(j));
                    len = 1;
                }
            }
            val = valx.toString();
        }
        return val;
    }

    @Test
    public void test(){
        System.out.println(countAndSay3(5));
    }
}

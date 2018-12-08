package Strings;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 描述 Medium
 * @author: dekai.kong
 * @date: 2018-12-08 16:53
 * @from https://leetcode.com/problems/multiply-strings/
 * //TODO 两个大整数相乘,美团面过.
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 *
 * Example 1:
 *
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 *
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * Note:
 *
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * 我的思路:利用小学学过的式子操作
 *     123
 * x   456
 * ---------
 *     738
 *    6150
 *   49200
 * ----------
 * 56088
 * 把每一次 6*123 的数组值存到key是6的map里,并且有个int记录当前去的是第几个位(6是第0位)取位*10补在后面
 */

public class MultiplyStrings {
    public MultiplyStrings() {

    }

    public String multiply(String num1, String num2) {
        Map<Character,List<Integer>> mapCi = new HashMap<>(10);
        List<Integer> nums = new ArrayList<>();//存结果
        int isUp = 0;
        for (int i = num2.length()-1; i > 0; i++) {
            for (int j = num1.length()-1; j > 0; j++) {
                num1[i]
            }
        }
    }

    @Test
    public void test() {

    }
}


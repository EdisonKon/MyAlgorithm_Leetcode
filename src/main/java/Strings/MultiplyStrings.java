package Strings;

import com.sun.deploy.util.StringUtils;
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
        for (int i = num2.length()-1; i >= 0; i--) {
            if(num2.charAt(i) == '0'){continue;}//排出0的情况
            List<Integer> mulend = new ArrayList<>();
            List<Integer> mulval = new ArrayList<>();
            if(mapCi.getOrDefault(num2.charAt(i),null) !=null){//map里有记录了
                mulval = mapCi.get(num2.charAt(i));
            }else{//map里没有记录,重新相乘
                for (int j = num1.length()-1; j >= 0; j--) {
                    int val = Character.getNumericValue(num2.charAt(i))*Character.getNumericValue(num1.charAt(j)) + isUp;
                    isUp = val/10;
                    mulval.add(0,val%10);
                }
                mapCi.put(num2.charAt(i),mulval);
            }
            mulend.addAll(mulval);
            for (int j = 0; j < num2.length()-1 - i; j++) {
                mulend.add(0);//给结果补0
            }
            int len = nums.size();
            int lenm = mulend.size();
            if (len >0){
                int addUp = 0;
                for (int j = lenm-1; j >= 0; j--) {
                    int index = j-(lenm - len);
                    if(index<0){
                        nums.add(0,mulend.get(j)+addUp);
                    }else {
                        int val = nums.get(j-(lenm - len)) + mulend.get(j)+addUp;
                        nums.set(j-(lenm - len),val%10);
                        addUp = val/10;
                    }
                }
            }else{
                nums.addAll(mulend);
            }
        }
        if(nums.size() == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.size(); i++) {
            sb.append(nums.get(i));
        }
        return sb.toString();
    }

    @Test
    public void test() {
//        System.out.println(multiply("123","456"));
        System.out.println(multiply("9","9"));
    }
}


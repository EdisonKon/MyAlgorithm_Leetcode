package Strings;

import org.junit.Test;

import java.util.Stack;

/**
 * @author dekai.kong
 * @difficult Medium
 * @create 2020-07-21 13:04
 * @from 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 *
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 *
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 *
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class DecodeString {
    public DecodeString() {

    }

    public String decodeString(String s) {
        if (s.length() == 0) {
            return s;
        }
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                stack.push(i);
            } else if (s.charAt(i) == ']') {
                int start = stack.pop();
                int countStrt = start-1;
                while(countStrt>0 && s.charAt(countStrt-1)>=48 && s.charAt(countStrt-1)<=57){
                    countStrt--;
                }
                for (int j = 0; j < Integer.parseInt(s.substring(countStrt,start)); j++) {
                    sb.append(s.substring(start + 1, i));
                }

                s = s.substring(0, countStrt) + sb.toString() + s.substring(i + 1, s.length());
                s = decodeString(s);
                break;
            }
        }
        return s;
    }

    public String decodeString2(String s) {
        if (s.length() == 0) {
            return s;
        }
        int point = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                point = i;
            } else if (s.charAt(i) == ']') {
                int start = point;
                int countStrt = start-1;
                while(countStrt>0 && s.charAt(countStrt-1)>='0' && s.charAt(countStrt-1)<='9'){
                    countStrt--;
                }
                for (int j = 0; j < Integer.parseInt(s.substring(countStrt,start)); j++) {
                    sb.append(s.substring(start + 1, i));
                }

                s = s.substring(0, countStrt) + sb.toString() + s.substring(i + 1, s.length());
                s = decodeString2(s);
                break;
            }
        }
        return s;
    }

    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 90.28%
     * 的用户
     作者：jyd
     链接：https://leetcode-cn.com/problems/decode-string/solution/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public String decodeString3(String s) {
        return dfs(s, 0)[0];
    }
    private String[] dfs(String s, int i) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        while(i < s.length()) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
                multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
            else if(s.charAt(i) == '[') {
                String[] tmp = dfs(s, i + 1);
                i = Integer.parseInt(tmp[0]);
                while(multi > 0) {
                    res.append(tmp[1]);
                    multi--;
                }
            }
            else if(s.charAt(i) == ']')
                return new String[] { String.valueOf(i), res.toString() };
            else
                res.append(String.valueOf(s.charAt(i)));
            i++;
        }
        return new String[] { res.toString() };
    }


    @Test
    public void test() {
//        decodeString("3[a2[c]]");
//        System.out.println(decodeString3("30[a]2[bc]"));
        System.out.println(decodeString3("3[a2[c]]"));
    }
}

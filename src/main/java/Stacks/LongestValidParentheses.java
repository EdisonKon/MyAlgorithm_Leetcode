package Stacks;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author dekai.kong
 * @difficult Hard
 * @create 2018-12-04 21:00
 * @from https://leetcode.com/problems/longest-valid-parentheses/
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * Example 1:
 *
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 *
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 **/
public class LongestValidParentheses {
    public LongestValidParentheses() {

    }

    /**
     * Runtime: 12 ms, faster than 80.14% of Java online submissions for Longest Valid Parentheses.
     * @param s
     * @return
     * 从头遍历取每一个()向两边扫描,如果左右形成(),那就当前的index是最右边的index(i),
     * 如果不能形成,判断左边index(j)值在map里有没有,如果有,那就加上该值len,将j-len继续向左搜索直道无法搜索,存入map(i,len)
     * i 取最后值的++值,继续遍历
     */
    public int longestValidParentheses(String s) {
        int rst = 0; int left = 0; int right = 0;
        Map<Integer,Integer> mapIL = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if('(' == s.charAt(i)){
                if (left==0){left = 1;}
            }else{
                if(left == 1){right = 1;}
            }
            if(left == right && left==1){
                int len = 1;
                left = right = 0;
                int j = i-2;//左边的左边
                while(j>=0 && i+1<=s.length()){
                    if(i+1!=s.length() && s.charAt(j)=='(' && s.charAt(i+1)==')'){
                        len++; j--; i++;
                    }else{
                        int val = mapIL.getOrDefault(j,-1);
                        if( val != -1){
                            j -= (val * 2);
                            len += val;
                        }else{ break; }
                    }
                }
                mapIL.put(i,len);
                rst = Math.max(rst,len);
            }
        }
        return rst*2;
    }

    /**
     * map 换成 array 的解法
     * Runtime: 12 ms, faster than 80.14% of Java online submissions for Longest Valid Parentheses.
     * @param s
     * @return
     */
    public int longestValidParentheses3(String s) {
        int rst = 0; int left = 0; int right = 0;
        int[] mapIL = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if('(' == s.charAt(i)){
                if (left==0){left = 1;}
            }else{
                if(left == 1){right = 1;}
            }
            if(left == right && left==1){
                int len = 1;
                left = right = 0;
                int j = i-2;
                while(j>=0 && i+1<=s.length()){
                    if(i+1!=s.length() && s.charAt(j)=='(' && s.charAt(i+1)==')'){
                        len++; j--; i++;
                    }else{
                        int val = mapIL[j];
                        if( val != 0){
                            j -= (val * 2);
                            len += val;
                        }else{ break; }
                    }
                }
                mapIL[i] = len;
                rst = Math.max(rst,len);
            }
        }
        return rst*2;
    }
/**
 * 8ms znm解法
 * 为每一个)去找前面完整的(),然后再往前找pre的index,如果有值就相加
 * 比如()(())
 * 从第一个开始是因为无论第0个是( 还是 ) 都不影响,如果第一个是 ( 继续跳过,如果是)则进入
 * 获取previndex,根据前一个的长度往前找,第一次是0,那就是前面还没有完整的()
 * 如果previndex超出左边范围或者它不是( 完成不了一个完整的() 那就跳出
 * 否则可以完成,肯定是( 所以这个index的值+2是一个完整的(),对比max
 * 第二次...推理
 */

    public int longestValidParentheses2(String s) {
        int dp[] = new int[s.length()];
        int result = 0;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                continue;
            }
            int prev = i - dp[i-1] -1;
            if(prev < 0 || s.charAt(prev)!='('){
                continue;
            }
            dp[i] = dp[i-1] + 2;
            if(prev > 0){
                dp[i] += dp[prev -1];
            }
            result = Math.max(result,dp[i]);
        }
        return result;
    }

    @Test
    public void test() {
//        longestValidParentheses2("(()");
//        longestValidParentheses("()(()");
//        longestValidParentheses(")()())");
//        longestValidParentheses(")((()())");
//        longestValidParentheses(")((())))))");
//        longestValidParentheses(")(()))()");
//        longestValidParentheses3("()(())");
//        longestValidParentheses(")()())()()(");
//        longestValidParentheses("(()(((()");
//        longestValidParentheses(")()(())()");
        // 1 1 2 3 3 2 3 2 1 3
        System.out.println(doCrack("())(()()"));
    }


    /**
     * 执行用时：
     * 3 ms
     * , 在所有 Java 提交中击败了
     * 51.60%
     * 的用户
     * 内存消耗：
     * 39.8 MB
     * , 在所有 Java 提交中击败了
     * 9.52%
     * 的用户
     * @param s
     * @return
     */
    public int newStack(String s){
        if(s==null||s.length()<2){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        //用于初始化计算
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    max = Math.max(max,i-stack.peek());
                }
            }
        }
        return max;
    }
    //指针解法
    //()(()
    public int doCrack(String s){
        if(s==null||s.length()<2) {
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    max = Math.max(max,i-stack.peek());
                }
            }
        }
        return max;
    }

    @Test
    public void test2() {
//        System.out.println(crackalg(")()())"));
        System.out.println(tsStack(")()())"));
//        System.out.println(doCrack("()(())"));
    }

    //)()())
    public int tsStack(String s){
        if(s.length() == 0){
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    max = Math.max(i - stack.peek(),max);
                }
            }
        }

        return max;
    }

}

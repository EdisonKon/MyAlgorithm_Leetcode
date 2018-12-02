package Lists;

import org.junit.Test;

import java.util.*;

/**
 *
 * Medium
 *
 * @from https://leetcode.com/problems/generate-parentheses/
 *
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */

public class GenerateParentheses {

    public GenerateParentheses() {
    }

    /**
     * Runtime: 6 ms, faster than 11.69% of Java online submissions for Generate Parentheses.
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List one = new ArrayList<>();
        one.add("()");
        if(n == 1){
            return one;
        }
        List<String> rst = new ArrayList<>();
        Map<Integer,List<String>> mapIK = new HashMap<>();
        Set<String> sets = new HashSet<>();
        mapIK.put(1,one);
        for(int i=2;i<=n;i++){
            if(mapIK.get(i) == null){
                List nl = new ArrayList<>();
                for(String s:mapIK.get(i-1)){
                    for (int j = -1; j <= s.length(); j++) {
                        String news = getChange(j,s);
                        if(!sets.contains(news)){
                            sets.add(news);
                            nl.add(news);
                            if(i == n){
                                rst.add(news);
                            }
                        }
                    }
                }
                mapIK.put(i,nl);
            }

        }
        return rst;
    }
    public String getChange(int index, String old){
        String news;
        StringBuilder sb = new StringBuilder(old);
        if(index == -1){
            sb.insert(index+1,"()");
        }else if(old.length() == index){
            sb.append("()");
        }else{
            sb.replace(index,index+1,"("+old.charAt(index)+")");
        }
        news = sb.toString();
        return news;
    }

    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Generate Parentheses.
     * @param n
     * @return
     */
    public List generateParenthesis2(int n) {
        List result = new ArrayList();
        combine("", 0, 0, result, n);
        return result;
    }
    public void combine(String s, int left, int right, List<String> result, int n) {
        if (left  == n && right == n) {
            result.add(s);
        }
        if (left >= right && left < n) {
            combine(s + "(", left + 1, right, result, n);
        }
        if (left > right ) {
            combine(s + ")", left, right + 1, result, n);
        }
    }

    @Test
    public void test(){
        int i = 0;
//        List<String> l = generateParenthesis(3);
        List<String> l = generateParenthesis2(3);
        for (String s :
                l) {
            i++;
            System.out.println(s);
        }
        System.out.println(i);
    }
}

package Stacks;

import org.junit.Test;

import java.util.Stack;

/**
 * @author dekai.kong
 * @difficult easy
 * @create 2020-07-28 11:34
 * @from 计算逆波兰表达式
 **/
public class EvalPRN {
    public EvalPRN() {

    }

    public int evalPrn(String[] s){
        int ans = 0;
        String op = "+-*/";
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<s.length;i++){
            if(op.indexOf(s[i])==-1){
                stack.push(Integer.parseInt(s[i]));
            }else{
                int count = 0;
                while(!stack.isEmpty() && ++count<2){
                    int b = stack.pop();
                    int a = stack.pop();
                    if(s[i] == "+") stack.push(a+b);
                    else if(s[i] == "-") stack.push(a-b);
                    else if(s[i] == "*") stack.push(a*b);
                    else if(s[i] == "/") stack.push(a/b);
                }
            }
        }
        ans = stack.pop();
        return ans;
    }

    @Test
    public void test() {
        evalPrn(new String[]{"2","3","1","-","4","*","+"});
    }
}

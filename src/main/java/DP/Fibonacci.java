package DP;

import org.junit.Test;

/**
 * @author dekai.kong
 * @difficult
 * @create 2020-07-19 17:13
 * @from
 **/
public class Fibonacci {
    public Fibonacci() {

    }

    public int Fibonacci(int n){
        int[] vals = new int[n+1];
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        vals[0] = 0;
        vals[1] = 1;
        for(int i=2;i<=n;i++){
            vals[i] = vals[i-1]+vals[i-2];
        }
        
        return vals[n];
    }

    @Test
    public void test() {
        Fibonacci(3);
    }
}

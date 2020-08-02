package DP;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author dekai.kong
 * @difficult medium
 * @create 2020-08-02 19:01
 * @from
 **/
public class LengthOfLIS {
    public LengthOfLIS() {

    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);

        for(int i =1;i<nums.length;i++){
            for(int j = 0;j<i;j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        
        int ans = 0;
        for (int i = 0; i < dp.length; i++) {
            ans = Math.max(dp[i],ans);
        }
        return ans;
    }

    @Test
    public void test() {
//        lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6});
        lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    }
}

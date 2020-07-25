package DP;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author dekai.kong
 * @difficult Medium
 * @create 2020-07-25 13:00
 * @from
 **/
public class LongestConSub {
    public LongestConSub() {

    }

    /**
     * 求最长公共子序列
     * m = ABCBDAB
     * n = BDCABA
     * v = BCBA
     * 最长公共子序列就是去掉一些字符后 不要求连续的最长子序列
     * @return
     * 先求长度
     */
    public int longestConSubLen(String m,String n){
        int mlen = m.length()+1;
        int nlen = n.length()+1;
        char[] mc = m.toCharArray();
        char[] nc = n.toCharArray();
        int[][] sublen = new int[mlen][nlen];

        for (int i = 0; i < mlen; i++) {
            Arrays.fill(sublen[i],0);
        }

        for (int i = 1; i < mlen; i++) {
            for (int j = 1; j < nlen; j++) {
                if(mc[i-1]==nc[j-1]){
                    sublen[i][j] = sublen[i-1][j-1] + 1;
                }else{
                    sublen[i][j] = Math.max(sublen[i][j-1],sublen[i-1][j]);
                }
            }
        }

        return sublen[mlen-1][nlen-1];
    }
    /**
     * 求最长公共子序列
     * m = ABCBDAB
     * n = BDCABA
     * v = BCBA
     * 最长公共子序列就是去掉一些字符后 不要求连续的最长子序列
     * @return
     * 求有哪些字母
     */
    public String longestConSubString(String m,String n){
        String s = "";
        int mlen = m.length()+1;
        int nlen = n.length()+1;
        char[] mc = m.toCharArray();
        char[] nc = n.toCharArray();
        int[][] sublen = new int[mlen][nlen];
        for (int i = 0; i < mlen; i++) {
            Arrays.fill(sublen[i],0);
        }

        for (int i = 1; i < mlen; i++) {
            for (int j = 1; j < nlen; j++) {
                if(mc[i-1] == nc[j-1]){
                    sublen[i][j] = sublen[i-1][j-1]+1;
                }else{
                    sublen[i][j] = Math.max(sublen[i-1][j],sublen[i][j-1]);
                }
            }
        }

        for (int i = 0; i < mlen; i++) {
            for (int j = 0; j < nlen; j++) {
                System.out.print(sublen[i][j]+" ");
            }
            System.out.println("");
        }

        int i = mlen-1;
        int j = nlen-1;
        while(sublen[i][j]>0){
            //向上匹配
            if(sublen[i][j] == sublen[i-1][j]){
                i--;
            }else if(sublen[i][j] == sublen[i][j-1]){
                j--;
            }else{
                i--;
                j--;
                s = nc[j]+s;
            }
        }

        return s;
    }

    @Test

    public void test() {
//        System.out.println(longestConSubLen("ABCBDAB","BDCABA"));
        System.out.println(longestConSubString("ABCBDAB","BDCABA"));
    }
}

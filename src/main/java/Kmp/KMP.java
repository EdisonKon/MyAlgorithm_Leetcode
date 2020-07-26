package Kmp;

import org.junit.Test;

/**
 * @author dekai.kong
 * @difficult Hard
 * @create 2020-07-26 13:08
 * @from kmp https://www.zhihu.com/question/21923021
 **/
public class KMP {
    public KMP() {

    }

    public String kmp(String s1,String s2){
        int[] next =  getNext(s2);
        int start = 0;
        int j = next[0];
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) == s2.charAt(j+1)){
                j++;
            }else{
                j = next[j]+1;
            }
            if(j==s2.length()-1){
                start = i - j;
                break;
            }
        }

        return s1.substring(start,start+s2.length());
    }

    public int[] getNext(String bs){
        char[] B = bs.toCharArray();
        int m = B.length;
        int[] next = new int[m];
        next[0] = -1;
        for (int i=1;i<m;i++)
        {
            int j=next[i-1];
            while ((B[j+1]!=B[i])&&(j>=0)){
                j=next[j];
            }
            if (B[j+1]==B[i]){
                next[i]=j+1;
            }else{
                next[i]=-1;
            }
        }
        return next;
    }


    @Test
    public void test() {
//        getNext("abcabcdabcabcd");
//        getNextT("abadaba");
        kmp("abadaba","adab");
    }

    public int[] getNextT(String s){
        char[] c = s.toCharArray();
        int[] next = new int[c.length];
        next[0] = -1;

        for (int i = 1; i < c.length; i++) {
            int j = next[i-1];
            while(j>0&&c[j+1]!=c[i]){
                j = next[j];
            }
            if(c[j+1] == c[i]){
                next[i] = j+1;
            }else{
                next[i] = -1;
            }
        }


        return next;
    }
}

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
        int i = 0;
        int j = 0;

        while (i < s1.length() && j < s2.length())
        {
            if (j == -1 || s1.charAt(i) == s2.charAt(j))
            {
                i++;
                j++;
            }
            else {
                j = next[j];
            }
        }

        if (j == s2.length()){
            start = i - j;
        }
        else {
            start =  -1;
        }

        return s1.substring(start,start+s2.length());
    }

    public int[] getNext(String bs){
        int[] next = new int[bs.length()];
        next[0] = -1;
        for (int i=1;i<bs.length();i++)
        {
            int j=next[i-1];
            while (bs.charAt(j+1)!=bs.charAt(i) && j>=0 ){
                j=next[j];
            }
            if (bs.charAt(j+1)==bs.charAt(i)){
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


    @Test
    public void test2() {
//        getNext("abcabcdabcabcd");
        getNextx("abadaba");
//        kmp("abadaba","adab");
    }
    public int[] getNextx(String s)
    {
        int[] next = new int[s.length()];
        next[0] = -1;
        int i = 0, j = -1;

        while (i < s.length()-1)
        {
            if (j == -1 || s.charAt(i) == s.charAt(j))
            {
                ++i;
                ++j;
                next[i] = j;
            }
            else{
                j = next[j];
            }
        }
        return next;
    }

}
